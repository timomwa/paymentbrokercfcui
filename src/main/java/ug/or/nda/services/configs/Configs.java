
package ug.or.nda.services.configs;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.3-b02-
 * Generated source version: 2.0
 * 
 */
@WebService(name = "Configs", targetNamespace = "http://services.nda.or.ug")
public interface Configs {


    /**
     * 
     * @param arg0
     * @return
     *     returns ug.or.nda.services.ConfigurationResponseDTO
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "processRequest", targetNamespace = "http://services.nda.or.ug", className = "ug.or.nda.services.ProcessRequest")
    @ResponseWrapper(localName = "processRequestResponse", targetNamespace = "http://services.nda.or.ug", className = "ug.or.nda.services.ProcessRequestResponse")
    public ConfigurationResponseDTO processRequest(
        @WebParam(name = "arg0", targetNamespace = "")
        ConfigurationRequest arg0);

}
