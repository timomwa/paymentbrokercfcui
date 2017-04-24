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
			Properties prop = new Properties();
			prop.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			prop.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8080");
			//prop.put(Context.SECURITY_PRINCIPAL, "username");
			//prop.put(Context.SECURITY_CREDENTIALS, "password");
			prop.put("jboss.naming.client.ejb.context", true);
			ctx = new InitialContext();
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
