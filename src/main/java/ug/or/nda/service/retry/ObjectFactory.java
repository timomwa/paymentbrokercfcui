
package ug.or.nda.service.retry;

import javax.xml.bind.annotation.XmlRegistry;

import ug.or.nda.dto.PaymentNotificationResponse;
import ug.or.nda.dto.RequestHeader;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ug.or.nda.service package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ug.or.nda.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RequestHeader }
     * 
     */
    public RequestHeader createRequestHeader() {
        return new RequestHeader();
    }

    /**
     * Create an instance of {@link PaymentNotificationResponse }
     * 
     */
    public PaymentNotificationResponse createPaymentNotificationResponse() {
        return new PaymentNotificationResponse();
    }

}
