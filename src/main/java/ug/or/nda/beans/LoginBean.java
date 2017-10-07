package ug.or.nda.beans;

import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.validation.constraints.Size;
import javax.xml.namespace.QName;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import ug.or.nda.constant.AppPropertyHolder;
import ug.or.nda.ws.client.encryption.EncryptionService;
import ug.or.nda.ws.client.encryption.EncryptionServiceService;
import ug.or.nda.ws.client.user.UserDTO;
import ug.or.nda.ws.client.user.UserService;
import ug.or.nda.ws.client.user.UserServiceService;


@ManagedBean(name="loginBean")
@RequestScoped
public class LoginBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6396745725316157590L;

	private Logger logger = Logger.getLogger(getClass());

	@Size(min = 4, max = 100)
	private String loginUsername;

	@Size(min = 4, max = 100)
	private String loginPassword;
	
	private UserServiceService service1 = null;
    private UserService userService = null;
    
    private EncryptionServiceService encryptionService = null;
    private EncryptionService encryptionport = null;
    
    @Inject
	private ConfigsBean configsEJB;

	public void login() {

		Subject currentUser = SecurityUtils.getSubject();
		String user_ = (String) currentUser.getPrincipal();

		logger.info("\n\n user_ -> " + user_ + " \n\n ");

		if (!currentUser.isAuthenticated()) {

			logger.info("\n\n USER IS NOT LOGGED IN! ["+loginUsername+"] \n\n ");

			String receivedhash = LocalEncryptor.decrypt( getEncryptionPort().hashPassword(loginPassword, loginUsername) );
			logger.info("\n\n receivedhash -> " + receivedhash + " \n\n ");
			UsernamePasswordToken token = new UsernamePasswordToken(loginUsername, receivedhash);
			boolean loginsuccess = false;
			try {

				token.setRememberMe(true);
				currentUser.login(token);
				UserDTO user = getUserService().findUserByUsername(loginUsername);
				currentUser.getSession().setAttribute("user", user);
				loginsuccess = true;

			} catch (UnknownAccountException uae) {
				logger.error(uae.getMessage());
			} catch (IncorrectCredentialsException ice) {
				logger.error(ice.getMessage());
			} catch (LockedAccountException lae) {
				logger.error(lae.getMessage());
			} catch (AuthenticationException ae) {
				logger.error(ae.getMessage());
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
			logger.info("\n\t\tLogin Success :: " + loginsuccess);

			if (loginsuccess) {

				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Successfully logged in.");
				FacesContext.getCurrentInstance().addMessage("loginForm:login", msg);

				try {
					redirect("broker.jsf");
				} catch (Exception e) {
					logger.error(e.getMessage(), e);
				}
			} else {

				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Incorrect credentials");
				FacesContext.getCurrentInstance().addMessage("loginForm:login", msg);

			}

		} else {
			logger.info("\n\n USER IS CURRENTLY LOGGED IN! \n\n ");
			try {
				redirect("broker.jsf");
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		}

	}

	private EncryptionService getEncryptionPort() {
		if(encryptionService==null){
			try {
				URL url = new URL("http://"+configsEJB.getProperty(AppPropertyHolder.WS_HOST_KEY)+"/broker/encryption/v1.0?wsdl");
				QName qname = new QName("http://services.nda.or.ug", "EncryptionServiceService");
				encryptionService = new EncryptionServiceService(url,qname);
			} catch (MalformedURLException e) {
				logger.error(e.getMessage(), e);
			}
		}
		if(encryptionport==null){
		 encryptionport = encryptionService.getEncryptionServicePort();
		}
		return encryptionport;
	}

	private UserService getUserService() {
		if(service1==null){
			try {
				URL url = new URL("http://"+configsEJB.getProperty(AppPropertyHolder.WS_HOST_KEY)+"/broker/user/v1.0?wsdl");
				QName qname = new QName("http://services.nda.or.ug", "UserServiceService");
				service1 = new UserServiceService(url,qname);
			} catch (MalformedURLException e) {
				logger.error(e.getMessage(), e);
			}
			
		}
	    if(userService==null){
	    	userService = service1.getUserServicePort();
	    }
	    
	    return userService;
	}

	private void redirect(String url) throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect(url);
	}

	public void forgotPassword() {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Default user name: BootsFaces");
		FacesContext.getCurrentInstance().addMessage("loginForm:username", msg);
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Default password: rocks!");
		FacesContext.getCurrentInstance().addMessage("loginForm:password", msg);
	}

	public String getLoginUsername() {
		return loginUsername;
	}

	public void setLoginUsername(String loginUsername) {
		this.loginUsername = loginUsername;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

}
