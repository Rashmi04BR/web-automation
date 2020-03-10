package com.proquest.core;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.proquest.managers.ConfigFileReader;

public class CommonUtils extends BasePage {

	private String sFileLoc = "src/test/resources/files/";

	private String sTimeZone = ConfigFileReader.getInstance().getTimeZone();

	public void captureScreenshot(String sFileName) {
		TakesScreenshot scrShot = ((TakesScreenshot) getWebDriver());
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(sFileLoc.concat(sFileName).concat(".png"));
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public String getLastUpdatedOn() {
		String sDateTimeFormat = "dd.mm.yyyy HH:mm:ss";
		TimeZone tz = TimeZone.getTimeZone(sTimeZone);
		LocalDateTime dt = LocalDateTime.now(tz.toZoneId());
		return dt.format(DateTimeFormatter.ofPattern(sDateTimeFormat));
	}

}
