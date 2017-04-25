
package ug.or.nda.ws.client.user;

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

    private final static QName _FindUserByUsername_QNAME = new QName("http://services.nda.or.ug", "findUserByUsername");
    private final static QName _FindUserByUsernameResponse_QNAME = new QName("http://services.nda.or.ug", "findUserByUsernameResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ug.or.nda.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UserDTO }
     * 
     */
    public UserDTO createUserDTO() {
        return new UserDTO();
    }

    /**
     * Create an instance of {@link FindUserByUsernameResponse }
     * 
     */
    public FindUserByUsernameResponse createFindUserByUsernameResponse() {
        return new FindUserByUsernameResponse();
    }

    /**
     * Create an instance of {@link FindUserByUsername }
     * 
     */
    public FindUserByUsername createFindUserByUsername() {
        return new FindUserByUsername();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindUserByUsername }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.nda.or.ug", name = "findUserByUsername")
    public JAXBElement<FindUserByUsername> createFindUserByUsername(FindUserByUsername value) {
        return new JAXBElement<FindUserByUsername>(_FindUserByUsername_QNAME, FindUserByUsername.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindUserByUsernameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.nda.or.ug", name = "findUserByUsernameResponse")
    public JAXBElement<FindUserByUsernameResponse> createFindUserByUsernameResponse(FindUserByUsernameResponse value) {
        return new JAXBElement<FindUserByUsernameResponse>(_FindUserByUsernameResponse_QNAME, FindUserByUsernameResponse.class, null, value);
    }

}
