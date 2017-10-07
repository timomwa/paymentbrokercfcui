package ug.or.nda.constant;

import java.io.File;

public interface AppPropertyHolder {

	public final static String WS_HOST = "192.168.0.10";//"localhost:8080";//
	public final static String WS_HOST_KEY = "BROKER_HOST_OR_IP";//"localhost:8080";//
	public final static String CONFIGS_LOCATION = System.getProperty("user.home").concat( File.separator ).concat(".cfcbrokerconfigs/config.properties");
}
