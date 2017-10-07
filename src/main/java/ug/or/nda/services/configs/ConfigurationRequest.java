
package ug.or.nda.services.configs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for configurationRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="configurationRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="action" type="{http://services.nda.or.ug}action" minOccurs="0"/>
 *         &lt;element name="configKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="configValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "configurationRequest", propOrder = {
    "action",
    "configKey",
    "configValue"
})
public class ConfigurationRequest {

    protected Action action;
    protected String configKey;
    protected String configValue;

    /**
     * Gets the value of the action property.
     * 
     * @return
     *     possible object is
     *     {@link Action }
     *     
     */
    public Action getAction() {
        return action;
    }

    /**
     * Sets the value of the action property.
     * 
     * @param value
     *     allowed object is
     *     {@link Action }
     *     
     */
    public void setAction(Action value) {
        this.action = value;
    }

    /**
     * Gets the value of the configKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfigKey() {
        return configKey;
    }

    /**
     * Sets the value of the configKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfigKey(String value) {
        this.configKey = value;
    }

    /**
     * Gets the value of the configValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfigValue() {
        return configValue;
    }

    /**
     * Sets the value of the configValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfigValue(String value) {
        this.configValue = value;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ConfigurationRequest [\n\taction=");
		builder.append(action);
		builder.append(",\n\tconfigKey=");
		builder.append(configKey);
		builder.append(",\n\tconfigValue=");
		builder.append(configValue);
		builder.append("\n]");
		return builder.toString();
	}
    
    

}
