package ug.or.nda.beans;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Init;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.xml.namespace.QName;

import org.apache.log4j.Logger;

import ug.or.nda.dto.PaymentNotificationDTO;
import ug.or.nda.dto.QueryDTO;
import ug.or.nda.ws.client.payment.PaymentQueryService;
import ug.or.nda.ws.client.payment.PaymentQueryServiceService;

@ManagedBean(name="paymentNotificationBean")
@RequestScoped
public class PaymentNotificationBean implements Serializable {
	
	private Logger logger = Logger.getLogger(getClass());
	
	
	public final static String WS_HOST = "localhost:8080";//"212.22.169.19";
	
	private static final long serialVersionUID = 4627110854172372523L;

	private List<PaymentNotificationDTO> payments;
	
	private QueryDTO queryDTO;
	private PaymentQueryServiceService service1 = null;
	private PaymentQueryService queryService = null;
	
	@Init
	@PostConstruct
	public void init() {
		queryDTO = new QueryDTO();
		queryDTO.setLimit(100);
		
		QueryDTO queryDTO = new QueryDTO();
		queryDTO.setStart(0);
		queryDTO.setLimit(100);
		payments = getQueryService().listPayments(queryDTO);
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
	
	public List<PaymentNotificationDTO> getPayments() {
		return payments;
	}

		
	public void query(){
		logger.info("AT query ..."+queryDTO);
		try {
			queryService = getQueryService();
			queryDTO.setLimit(1000);
			
			payments =  queryService.listPayments(queryDTO);
			
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Fetched "+payments.size()+" record"+(payments.size()>1 ? "s":"")+"");
			FacesContext.getCurrentInstance().addMessage("searchForm:searchbtn", msg);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}finally{
			
		}
		
	}

	public void setPayments(List<PaymentNotificationDTO> payments) {
		this.payments = payments;
	}

	public QueryDTO getQueryDTO() {
		return queryDTO;
	}

	public void setQueryDTO(QueryDTO queryDTO) {
		this.queryDTO = queryDTO;
	}

	
}
