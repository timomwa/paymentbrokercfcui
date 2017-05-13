package ug.or.nda.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

@ManagedBean
@SessionScoped
public class PageBean implements Serializable {
	
	private Logger logger = Logger.getLogger(getClass());

	/**
	 * 
	 */
	private static final long serialVersionUID = 5302837590191L;
	
	private String page = "payments";
	private String loginPage = "broker";
	public static final String APPROOT = "/paymentbrokerui";
	private String approot = APPROOT;
	private String currentTheme = "";
	
	public String getLoginPage() {
		return loginPage;
	}

	public void setLoginPage(String loginPage) {
		this.loginPage = loginPage;
	}
	
	public void payments(){
		page = "payments";
	}

	public void home() {
		page = "home";
	}
	
	public void portfolio() {
		page = "portfolio";
	}

	public void contactus() {
		page = "contactus";
	}
	
	public void perMsisdnTransactionReport(){
		page = "perMsisdnTransactionReport";
	}
	public void detailedMobileMoneyInflow(){
		page = "detailedMobileMoneyInflow";
	}
	
	public void detailedMobileMoneyOutflow(){
		page = "detailedMobileMoneyOutflow";
	}
	

	public void sameHourComparisonInflow(){
		page = "sameHourComparisonInflow";
	}
	public void sameHourComparisonOutflow(){
		page = "sameHourComparisonOutflow";
	}
	public void perMsisdnTransactionCount(){
		page = "perMsisdnTransactionCount";
	}
	public void perAccountTransactionCount(){
		page = "perAccountTransactionCount";
	}
	public void sameHourPaybillTransactionComparison(){
		page = "sameHourPaybillTransactionComparison";
	}
	
	public void reportSubscription(){
		page = "reportSubscription";
	}
	
	public void profileInfo(){
		page = "profileInfo";
	}
	public void changePassword(){
		page = "changepassword";
	}
	
	public void userManagement(){
		page = "userManagement";
	}
	public void emailSettings(){
		page = "emailSettings";
	}
	public void auditTrailReport(){
		page = "auditTrailReport";
	}
	public void bussinessShortcodeInfo(){
		page = "bussinessShortcodeInfo";
	}
	public void initiatorAccount(){
		page = "initiatorAccount";
	}
	public void periodicReportingSchedule(){
		page = "periodicReportingSchedule";
	}
	public void lotteryWinners(){
		page = "lotteryWinners";
	}
	
	public void smsConfig(){
		page = "smsConfig";
	}
	
	//TODO store this in a session
	public String getPage() {
		return page==null || page.isEmpty() ? "broker" : page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getApproot() {
		return approot;
	}

	public void setApproot(String approot) {
		this.approot = approot;
	}

	public String getCurrentTheme() {
		return currentTheme!=null ? currentTheme : "paper";
	}

	public void setCurrentTheme(String currentTheme) {
		logger.info("\n\n\t\t  ----> currentTheme --> "+currentTheme+"\n\n" );
		this.currentTheme = currentTheme;
	}
	
	

}
