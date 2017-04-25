
package ug.or.nda.ws.client.encryption;

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

    private final static QName _HashPasswordResponse_QNAME = new QName("http://services.nda.or.ug", "hashPasswordResponse");
    private final static QName _HashPassword_QNAME = new QName("http://services.nda.or.ug", "hashPassword");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ug.or.nda.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HashPassword }
     * 
     */
    public HashPassword createHashPassword() {
        return new HashPassword();
    }

    /**
     * Create an instance of {@link HashPasswordResponse }
     * 
     */
    public HashPasswordResponse createHashPasswordResponse() {
        return new HashPasswordResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HashPasswordResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.nda.or.ug", name = "hashPasswordResponse")
    public JAXBElement<HashPasswordResponse> createHashPasswordResponse(HashPasswordResponse value) {
        return new JAXBElement<HashPasswordResponse>(_HashPasswordResponse_QNAME, HashPasswordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HashPassword }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.nda.or.ug", name = "hashPassword")
    public JAXBElement<HashPassword> createHashPassword(HashPassword value) {
        return new JAXBElement<HashPassword>(_HashPassword_QNAME, HashPassword.class, null, value);
    }

}
