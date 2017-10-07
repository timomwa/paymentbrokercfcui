package ug.or.nda.beans;


import javax.faces.bean.ManagedBean;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.log4j.Logger;

import ug.or.nda.constant.AppPropertyHolder;

@ManagedBean(name="configsEJB")
public class ConfigsBean {
	
	private Logger logger = Logger.getLogger(getClass());
	
	private Configuration config = null;
	
	public String getProperty(String key){
		
		if(config==null){
			 try {
				Configurations configs = new Configurations();
				config = configs.properties(AppPropertyHolder.CONFIGS_LOCATION);
			} catch (ConfigurationException e) {
				logger.error(e.getMessage(), e);
			}
		}
		return  config.getString(key);
		
	}

}
