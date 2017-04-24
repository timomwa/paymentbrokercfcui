package ug.or.nda.beans;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ug.or.nda.dto.QueryDTO;
import ug.or.nda.ejb.PaymentQueryServiceEJBI;


public class PaymentNotificationBean {
	
	private PaymentQueryServiceEJBI paymentQueryEJB;
	
	public String getNotificationEJB(){
		Context ctx = null;
		try {
			Properties env = new Properties();
			env.put(Context.INITIAL_CONTEXT_FACTORY,"org.jboss.naming.NamingContextFactory");
			env.put(Context.URL_PKG_PREFIXES,"org.jboss.naming:org.jnp.interfaces");
			env.put(Context.PROVIDER_URL, "jnp://127.0.0.1:1099");
			 
			
			ctx = new InitialContext(env);
			paymentQueryEJB = (PaymentQueryServiceEJBI) ctx.lookup( "paymentbroker/PaymentQueryServiceEJBImpl/remote-ug.or.nda.ejb.PaymentQueryServiceEJBI");
			QueryDTO queryDTO = new QueryDTO();
			queryDTO.setStart(0);
			queryDTO.setLimit(100);
			return " --> paymentNotificationEJB "+paymentQueryEJB.listPayments(queryDTO);
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
		return "Nothing!";
		
	}

}
