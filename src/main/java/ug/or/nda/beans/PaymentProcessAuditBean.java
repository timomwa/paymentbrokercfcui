package ug.or.nda.beans;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.xml.namespace.QName;

import org.apache.log4j.Logger;

import ug.or.nda.dto.PaymentNotificationRawLogDTO;
import ug.or.nda.dto.QueryDTO;
import ug.or.nda.ws.client.payment.PaymentQueryService;
import ug.or.nda.ws.client.payment.PaymentQueryServiceService;

@ManagedBean(name="paymentProcessAuditBean")
@RequestScoped
public class PaymentProcessAuditBean implements Serializable {
	
	private static final long serialVersionUID = -3139514871541760742L;
	private Logger logger = Logger.getLogger(getClass());
	private PaymentQueryServiceService service1 = null;
	private PaymentQueryService queryService = null;
	private List<PaymentNotificationRawLogDTO> paymentNotificationRawLog;
	private String invoiceNo;
	
	
	
	public String getInvoiceNo() {
		return invoiceNo;
	}



	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}


	public void getMoreInfo(){
		String invoiceNo_ = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("invoiceNo");
        if(invoiceNo_!=null && !invoiceNo_.trim().isEmpty())
        	setInvoiceNo( invoiceNo_ );
		logger.info("\n\n\t\t ---> at getMoreInfo() invoiceNo : "+invoiceNo+"\n\n");
		try{
			QueryDTO queryDto = new QueryDTO();
			queryDto.setQuery( invoiceNo );
			paymentNotificationRawLog =  getQueryService().listPaymentRawLogs( queryDto );
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		logger.info("\n\n\t\t ---> paymentNotificationRawLog : "+(paymentNotificationRawLog!=null && !paymentNotificationRawLog.isEmpty() ? paymentNotificationRawLog.size() : "empty or null")+"\n\n");
	}
	
	
	
	private PaymentQueryService getQueryService() {
		if(service1==null){
			try {
				URL url = new URL("http://"+PaymentNotificationBean.WS_HOST+"/broker/payment/query/v1.0?wsdl");
				QName qname = new QName("http://services.nda.or.ug", "PaymentQueryServiceService");
				service1 = new PaymentQueryServiceService(url,qname);
			} catch (MalformedURLException e) {
				logger.error(e.getMessage(), e);
			}
		}
		if(queryService==null){
			queryService = service1.getPaymentQueryServicePort();
		}
		return queryService;
	}



	public List<PaymentNotificationRawLogDTO> getPaymentNotificationRawLog() {
		return paymentNotificationRawLog;
	}



	public void setPaymentNotificationRawLog(List<PaymentNotificationRawLogDTO> paymentNotificationRawLog) {
		this.paymentNotificationRawLog = paymentNotificationRawLog;
	}
	
}
