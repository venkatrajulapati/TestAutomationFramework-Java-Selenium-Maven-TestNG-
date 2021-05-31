 package com.application.libs.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import com.application.libs.common.Excelutils;
import com.application.libs.common.Reporter;
import com.application.libs.common.common_utilities;
import com.application.libs.common.dateUtils;

public class test_base {
	
	public static WebDriver driver;
	public String workbookPath="";
	public String datasheetName="";
	public String keyName="";
	public static Logger log;
	public static String tcName;
	public static String repFolder="";
	public static String screenShotFolder="";
	public static String confilePropertiesFile="";
	public static FileWriter fwt;
	public static int scren_cnt=1;
	//public static ExtentReports extentReporter;
	//public static ExtentTest eTest;
	
	@BeforeMethod
	public static WebDriver getDriver(Method m) {
		log.info("Initiate Webdriver .......");
		String browser="";
		
		try {
			browser = common_utilities.get_property_value("./config/application.properties", "browser");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./server/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--disable-web-security");
			options.addArguments("--allow-insecure-localhost");
			options.addArguments("--ignore-urlfetcher-cert-requests");
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			options.setExperimentalOption("useAutomationExtension", false);
			driver = new ChromeDriver(options);
		}
		//driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("end configuration");
		return driver;
	}
	
	@DataProvider(name = "ReadTestdata")
	public Iterator<Object[]> readTestdata(Method m) throws IOException {
		//Start key
		int reqRownum=Excelutils.getRowNumberByKeyName(workbookPath, datasheetName, keyName);
		//End Key
		keyName=keyName+"End";
		int endreqRownum=Excelutils.getRowNumberByKeyName(workbookPath, datasheetName, keyName);
		
		List<String> columns = new ArrayList<String>();
		List<Map<String,String>> xlData = new ArrayList<Map<String,String>>();
		File f= new File(workbookPath);
		FileInputStream iStream = new FileInputStream(f);
		HSSFWorkbook oWb = new HSSFWorkbook(iStream);
		HSSFSheet oSheet = oWb.getSheet(datasheetName);
		Row header = oSheet.getRow(reqRownum);
		//Fetch Column names
		for(int h=1;h<header.getLastCellNum();h++) {
			columns.add(header.getCell(h).getStringCellValue().trim());
		}
		//Read data and store to Map
		for(int i=reqRownum+1;i<=endreqRownum;i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			Row r = oSheet.getRow(i);
			int noofcells = r.getLastCellNum();
			if(i!=endreqRownum) {
				for(int j=1;j<noofcells;j++) {
					try {
						map.put(columns.get(j-1), r.getCell(j).getStringCellValue());
					}catch(NullPointerException e) {
						map.put(columns.get(j-1), "");
					}
					
				}
			}else if(i==endreqRownum) {
				for(int j=1;j<noofcells-1;j++) {
					try {
						map.put(columns.get(j-1), r.getCell(j).getStringCellValue());
					}catch(NullPointerException e) {
						map.put(columns.get(j-1), "");
					}
					
				}
			}
			
			xlData.add(map);
		}
		oWb.close();
		Collection<Object[]> dp = new ArrayList<Object[]>();
		for(Map<String,String> map : xlData) {
			dp.add(new Object[] {map});
		}
		return dp.iterator();
	}
	public static String captureScreenShot() {
		TakesScreenshot scrnShot = (TakesScreenshot) driver;
		File scrShot= scrnShot.getScreenshotAs(OutputType.FILE);
		String scrnFilename = screenShotFolder + "/" + tcName + "_" + scren_cnt  + ".png";
		File destFile = new File(scrnFilename);
		try {
			FileUtils.copyFile(scrShot, destFile);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scren_cnt = scren_cnt+1;
		return destFile.getAbsolutePath();
	}
	
	/*public static void createExtentReport() {
		extentReporter = new ExtentReports("./results/extent.html", true);
		eTest = extentReporter.startTest(tcName);
		
	}*/
	
	public void initVariables(String tdSheetName,String datakeyName) throws IOException {
		log = Logger.getLogger(datakeyName);
		log.info("Initializing Global Variables ........");
		workbookPath = "./resources/" + common_utilities.get_property_value("./config/application.properties", "environment") + "/Testdata/testdata.xls";
		datasheetName = tdSheetName;
		keyName = datakeyName;
		LocalDateTime dt = dateUtils.getDate(0);//LocalDateTime.now();
		String todaysDt1 = dateUtils.getFormattedDate(dt, "dd-MM-yyyy-HHmmss");//dt.format(formatter);
		String todaysDt2 = dateUtils.getFormattedDate(dt, "dd-MM-yyyy");//dt.format(formatter1);
		screenShotFolder = "./results/screenshots/" + todaysDt1;
		repFolder = "./results/reports/" + todaysDt2;
		confilePropertiesFile = "./config/application.properties";
	}
	
	@AfterMethod
	public void cleanup() throws IOException {
		fwt.close();
		//log.shutdown();
		/*extentReporter.endTest(eTest);
		extentReporter.flush();*/
		driver.quit();
	}

	
	
}
