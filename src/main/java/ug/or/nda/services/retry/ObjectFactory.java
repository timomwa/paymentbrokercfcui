
package ug.or.nda.services.retry;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import ug.or.nda.dto.QueryDTO;


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

    private final static QName _RetryResponse_QNAME = new QName("http://services.nda.or.ug", "retryResponse");
    private final static QName _Retry_QNAME = new QName("http://services.nda.or.ug", "retry");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ug.or.nda.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link QueryDTO }
     * 
     */
    public QueryDTO createQueryDTO() {
        return new QueryDTO();
    }

    /**
     * Create an instance of {@link RetryResponse }
     * 
     */
    public RetryResponse createRetryResponse() {
        return new RetryResponse();
    }

    /**
     * Create an instance of {@link Retry }
     * 
     */
    public Retry createRetry() {
        return new Retry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.nda.or.ug", name = "retryResponse")
    public JAXBElement<RetryResponse> createRetryResponse(RetryResponse value) {
        return new JAXBElement<RetryResponse>(_RetryResponse_QNAME, RetryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Retry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.nda.or.ug", name = "retry")
    public JAXBElement<Retry> createRetry(Retry value) {
        return new JAXBElement<Retry>(_Retry_QNAME, Retry.class, null, value);
    }

}
