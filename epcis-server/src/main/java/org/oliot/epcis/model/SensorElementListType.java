//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.01.05 at 11:33:26 AM KST 
//

package org.oliot.epcis.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for SensorElementListType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="SensorElementListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sensorElement" type="{urn:epcglobal:epcis:xsd:2}SensorElementType" maxOccurs="unbounded"/>
 *         &lt;element name="extension" type="{urn:epcglobal:epcis:xsd:2}SensorElementListExtensionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SensorElementListType", propOrder = { "sensorElement", "extension" })
public class SensorElementListType {

	@XmlElement(required = true)
	protected List<SensorElementType> sensorElement;
	protected SensorElementListExtensionType extension;

	public SensorElementListType() {
	}

	public SensorElementListType(List<SensorElementType> sensorElement) {
		this.sensorElement = sensorElement;
	}

	/**
	 * Gets the value of the sensorElement property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the sensorElement property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getSensorElement().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link SensorElementType }
	 * 
	 * 
	 */
	public List<SensorElementType> getSensorElement() {
		if (sensorElement == null) {
			sensorElement = new ArrayList<SensorElementType>();
		}
		return this.sensorElement;
	}

	/**
	 * Gets the value of the extension property.
	 * 
	 * @return possible object is {@link SensorElementListExtensionType }
	 * 
	 */
	public SensorElementListExtensionType getExtension() {
		return extension;
	}

	/**
	 * Sets the value of the extension property.
	 * 
	 * @param value allowed object is {@link SensorElementListExtensionType }
	 * 
	 */
	public void setExtension(SensorElementListExtensionType value) {
		this.extension = value;
	}

}
