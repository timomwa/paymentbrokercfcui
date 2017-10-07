
package ug.or.nda.services.configs;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ug.or.nda.services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ProcessRequest_QNAME = new QName("http://services.nda.or.ug", "processRequest");
    private final static QName _ProcessRequestResponse_QNAME = new QName("http://services.nda.or.ug", "processRequestResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ug.or.nda.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ProcessRequestResponse }
     * 
     */
    public ProcessRequestResponse createProcessRequestResponse() {
        return new ProcessRequestResponse();
    }

    /**
     * Create an instance of {@link ConfigurationRequest }
     * 
     */
    public ConfigurationRequest createConfigurationRequest() {
        return new ConfigurationRequest();
    }

    /**
     * Create an instance of {@link ConfigurationResponseDTO }
     * 
     */
    public ConfigurationResponseDTO createConfigurationResponseDTO() {
        return new ConfigurationResponseDTO();
    }

    /**
     * Create an instance of {@link ProcessRequest }
     * 
     */
    public ProcessRequest createProcessRequest() {
        return new ProcessRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcessRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.nda.or.ug", name = "processRequest")
    public JAXBElement<ProcessRequest> createProcessRequest(ProcessRequest value) {
        return new JAXBElement<ProcessRequest>(_ProcessRequest_QNAME, ProcessRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcessRequestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.nda.or.ug", name = "processRequestResponse")
    public JAXBElement<ProcessRequestResponse> createProcessRequestResponse(ProcessRequestResponse value) {
        return new JAXBElement<ProcessRequestResponse>(_ProcessRequestResponse_QNAME, ProcessRequestResponse.class, null, value);
    }

}
