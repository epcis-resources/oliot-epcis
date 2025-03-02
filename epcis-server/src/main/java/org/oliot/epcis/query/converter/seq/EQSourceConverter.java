package org.oliot.epcis.query.converter.seq;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.oliot.epcis.model.QueryParameterException;
import org.oliot.epcis.model.ValidationException;
import org.oliot.epcis.query.converter.BaseConverter;
import org.oliot.epcis.query.converter.QueryConverter;
import org.oliot.epcis.resource.StaticResource;
import org.oliot.epcis.validation.IdentifierValidator;

/**
 * This is not a single parameter, but a family of parameters. If a parameter of
 * this form is specified, the result will only include events that (a) include
 * a sourceList; (b) where the source list includes an entry whose type subfield
 * is equal to type extracted from the name of this parameter; and (c) where the
 * source subfield of that entry is equal to one of the values specified in this
 * parameter.
 * 
 * List of URIs
 * 
 */
public class EQSourceConverter extends BaseConverter implements QueryConverter {

	@Override
	public Document convert(String key, Object value) throws QueryParameterException {
		List<String> valueList = getListOfString(value);
		String type = retrieveParameterType(key, 10);
		if (!StaticResource.sourceDestinationTypes.contains(type))
			throw new QueryParameterException(
					"the value of a parameter should be one of " + StaticResource.sourceDestinationTypes);

		List<Document> docList = new ArrayList<Document>();
		for (String v : valueList) {
			try {
				IdentifierValidator.checkSourceDestinationEPCPureIdentity(StaticResource.gcpLength, v);
				docList.add(new Document("sourceList",
						new Document("$elemMatch", new Document().append("type", type).append("value", v))));
			} catch (ValidationException e) {
				throw new QueryParameterException(e.getReason());
			}
		}

		return new Document("$or", docList);
	}
}
