
package ug.or.nda.services.retry;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import ug.or.nda.dto.PaymentNotificationResponse;
import ug.or.nda.dto.QueryDTO;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.3-b02-
 * Generated source version: 2.0
 * 
 */
@WebService(name = "paymentRetryService", targetNamespace = "http://services.nda.or.ug")
public interface PaymentRetryService {


    /**
     * 
     * @param arg0
     * @return
     *     returns ug.or.nda.service.PaymentNotificationResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "retry", targetNamespace = "http://services.nda.or.ug", className = "ug.or.nda.services.Retry")
    @ResponseWrapper(localName = "retryResponse", targetNamespace = "http://services.nda.or.ug", className = "ug.or.nda.services.RetryResponse")
    public PaymentNotificationResponse retry(
        @WebParam(name = "arg0", targetNamespace = "")
        QueryDTO arg0);

}
