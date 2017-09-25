package ug.or.nda.beans;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.xml.namespace.QName;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import ug.or.nda.dto.PaymentNotificationResponse;
import ug.or.nda.dto.QueryDTO;
import ug.or.nda.dto.RequestHeader;
import ug.or.nda.dto.RequestHeaderDTO;
import ug.or.nda.services.retry.PaymentNotificationRetryService;
import ug.or.nda.services.retry.PaymentRetryService;
import ug.or.nda.ws.client.payment.PaymentQueryService;
import ug.or.nda.ws.client.payment.PaymentQueryServiceService;


@ManagedBean(name="paymentNotificationRetryBean")
@RequestScoped
public class PaymentNotificationRetryBean implements Serializable {
	
	private Logger logger = Logger.getLogger(getClass());
	private PaymentNotificationRetryService service1 = null;
	private PaymentRetryService retryService = null;

	/**
	 * 
	 */
	private static final long serialVersionUID = -1559726638171241975L;
	
	public void reTryInvoiceProcessing(){
		String invoiceNoToRetry = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("invoiceNoToRetry");
		logger.info("\n\n\t\t ---> at reTryInvoiceProcessing() invoiceNoToRetry : "+invoiceNoToRetry+"\n\n");
        try{
			QueryDTO queryDto = new QueryDTO();
			queryDto.setQuery( invoiceNoToRetry );
			queryDto.setRequestHeader( createHeader() );
			PaymentNotificationResponse response = getPaymentRetryServicePort().retry( queryDto );
			logger.info(response+" <<< resp \n");
			
			if(response!=null){
				int statuscode = response.getStatusCode();
				String message = response.getStatusMessage();
				
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "searchForm:searchbtn", message);
				FacesContext.getCurrentInstance().addMessage("", msg);
			}else{
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "searchForm:searchbtn", "Failed : ");
				FacesContext.getCurrentInstance().addMessage("", msg);
			}
			
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
	}
	
	

	private RequestHeaderDTO createHeader() {
		RequestHeaderDTO rh = new RequestHeaderDTO();
		rh.setSystemID(  "GMSE" );
		rh.setPassword("GMSE");
		rh.setSystemToken("GMSE");
		
		try{
			Subject currentUser = SecurityUtils.getSubject();
			String user_ = (String) currentUser.getPrincipal();
			rh.setUsername(user_);
			
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		
		return rh;
	}
	
	private PaymentRetryService getPaymentRetryServicePort() {
		if(service1==null){
			try {
				URL url = new URL("http://"+PaymentNotificationBean.WS_HOST+"/broker/payment/retry/v1.0?wsdl");
				QName qname = new QName("http://services.nda.or.ug", "PaymentNotificationRetryService");
				service1 = new PaymentNotificationRetryService(url,qname);
			} catch (MalformedURLException e) {
				logger.error(e.getMessage(), e);
			}
		}
		if(retryService==null){
			retryService = service1.getPaymentRetryServicePort();
		}
		return retryService;
	}

}
