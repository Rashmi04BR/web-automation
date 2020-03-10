package com.proquest.managers;

public class ConfigFileReader extends FilePropertiesReader {

	private static ConfigFileReader configFileReader = new ConfigFileReader();

	private final String configFileLoc = "src/test/resources/config.properties";

	private String sBrowser = null;
	private String sChromeDriverLoc = null;
	private String sTimeZone = null;

	public static ConfigFileReader getInstance() {
		return configFileReader;
	}

	public String getBrowser() {
		return (sBrowser == null) ? sBrowser = getFileProperties("BROWSER", loadFileProperties(configFileLoc))
				: sBrowser;
	}

	public String getChromeDriverLoc() {
		return (sChromeDriverLoc == null)
				? sChromeDriverLoc = getFileProperties("CHROME_DRIVER_LOCATION", loadFileProperties(configFileLoc))
				: sChromeDriverLoc;
	}

	public String getTimeZone() {
		return (sTimeZone == null) ? sTimeZone = getFileProperties("TIMEZONE", loadFileProperties(configFileLoc))
				: sTimeZone;
	}

}
