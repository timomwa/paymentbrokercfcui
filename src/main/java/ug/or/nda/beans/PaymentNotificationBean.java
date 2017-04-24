package ug.or.nda.beans;

import java.io.Serializable;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ug.or.nda.dto.PaymentNotificationDTO;
import ug.or.nda.dto.QueryDTO;
import ug.or.nda.ejb.PaymentQueryServiceEJBI;


public class PaymentNotificationBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4627110854172372523L;

	private List<PaymentNotificationDTO> payments;
	
	private PaymentQueryServiceEJBI paymentQueryEJB;
	
	public List<PaymentNotificationDTO> getPayments() {
		Context ctx = null;
		try {
			ctx = getContext();
			paymentQueryEJB = (PaymentQueryServiceEJBI) ctx.lookup( "paymentbroker/PaymentQueryServiceEJBImpl/remote-ug.or.nda.ejb.PaymentQueryServiceEJBI");
			QueryDTO queryDTO = new QueryDTO();
			queryDTO.setStart(0);
			queryDTO.setLimit(100);
			payments =  paymentQueryEJB.listPayments(queryDTO);
		} catch (NamingException e) {
			e.printStackTrace();
		}finally{
			try{
				if(ctx!=null)
					ctx.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return payments;
	}

	private Context getContext() throws NamingException {
		Properties env = new Properties();
		env.put(Context.INITIAL_CONTEXT_FACTORY,"org.jboss.naming.NamingContextFactory");
		env.put(Context.URL_PKG_PREFIXES,"org.jboss.naming:org.jnp.interfaces");
		env.put(Context.PROVIDER_URL, "jnp://127.0.0.1:1099");
		return new InitialContext(env);
	}

	public void setPayments(List<PaymentNotificationDTO> payments) {
		this.payments = payments;
	}
	

}
