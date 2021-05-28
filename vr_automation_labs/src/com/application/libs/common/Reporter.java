package com.application.libs.common;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.application.libs.web.test_base;

public class Reporter extends test_base {
	
	public static FileWriter create_html_report() throws IOException {
		
		File resfile = new File(reportFilePath);
		FileWriter report = new FileWriter(resfile);
		
		//Write header
		report.append("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		String Test_Automation_Test_Report_Logo = "E:\\actitimeAutomation\\Logo.png";
		LocalDateTime dttime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
		String dtString = dttime.format(formatter);
		//Write Report - Header
		report.append("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		report.append("<TR COLS=2><TD BGCOLOR=WHITE WIDTH=6%><IMG SRC='" + Test_Automation_Test_Report_Logo + "'></TD><TD WIDTH=100% BGCOLOR=WHITE><FONT FACE=VERDANA COLOR=NAVY SIZE=4><B>&nbspTest Automation Results - [" + dtString + "] </B></FONT></TD></TR></TABLE>");
		report.append("<TABLE BORDER=1 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		report.append("</TABLE></BODY></HTML>");

		//Write Report - Test-Set Name OR Test-Script Name
		report.append("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		report.append("<TR COLS=1>"+
		                    "<TD ALIGN=LEFT BGCOLOR=#66699><FONT FACE=VERDANA COLOR=WHITE SIZE=3><B>" + tcName + "</BR>" + "</B></FONT></TD>"+
		                 "</TR>");
		report.append("</TABLE></BODY></HTML>");

		//Write Report - Column Headers
		report.append("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		report.append("<TR COLS=4>"+
		                        "<TH ALIGN=MIDDLE BGCOLOR=#FFCC99 WIDTH=20%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Test Step</B></FONT></TD>"+
		                        "<TH ALIGN=MIDDLE BGCOLOR=#FFCC99 WIDTH=30%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Expected Result</B></FONT></TD>"+
		                        "<TH ALIGN=MIDDLE BGCOLOR=#FFCC99 WIDTH=30%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Actual Result</B></FONT></TD>"+
		                        "<TH ALIGN=MIDDLE BGCOLOR=#FFCC99   WIDTH=7%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Step-Result</B></FONT></TD>"+
		                 "</TR>");
		//report.close();
		
		return report;
	}
	
	public static void update_Report_step(FileWriter fw,String stepDesc,String expResult,String actResult,String strResult) throws IOException {
		String strImagePath="";
		String strActualHREF="";
		String captureImageOnPass="";
		String capturImageOnFail="";
		String captureImage="";
		String strResultColor="";
		String strResultSign="";
		captureImageOnPass = common_utilities.get_property_value(confilePropertiesFile,"captureScreenShotOnPass");
		capturImageOnFail = common_utilities.get_property_value(confilePropertiesFile, "captureScreenShotOnFail");
		
		//Set Result parameters
		if(StringUtils.equals(strResult.toUpperCase(), "PASS")) {
			strResultColor = "GREEN";
			strResultSign = "P";
			captureImage = captureImageOnPass;
			
		}else if(StringUtils.equals(strResult.toUpperCase(), "FAIL")) {
			strResultColor = "RED";
			strResultSign = "O";
			captureImage = capturImageOnFail;
		}else if(StringUtils.equals(strResult.toUpperCase(), "WARN")) {
			strResultColor = "ORANGE";
			strResultSign = "!";
			captureImage = "no";
		}else if(StringUtils.equals(strResult.toUpperCase(), "INFO")) {
			strResultColor = "BLUE";
			strResultSign = "i";
			captureImage = "no";
		}
		
		
		
		//Set Image Path and capture image
	    if (StringUtils.equals(captureImage.toLowerCase(), "yes")) {
	    	 //Capture Image
	    	 strImagePath = captureScreenShot();
	    	 System.out.println(strImagePath);
	    	 //System.out.println(strImagePath);
	    	 strActualHREF = "<A HREF='" + strImagePath + "'>" + actResult + "</A>";
	    }else if(StringUtils.equals(captureImage.toLowerCase(), "no")) {
	        strActualHREF = "<A>" + actResult + "</A>";
	    }
	    
	    
	   //Update HTML Report

	   if(!StringUtils.isNullOrEmpty(expResult)) {
	        fw.append(
	        "<TR COLS=4>"+
	        "<TD BGCOLOR=#EEEEEE WIDTH=20%><FONT FACE=VERDANA SIZE=2>" + stepDesc + "</FONT></TD>"+
	        "<TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2>" + expResult + "</FONT></TD>"+
	        "<TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=WINGDINGS SIZE=4>2</FONT><FONT FACE=VERDANA SIZE=2>" + strActualHREF + "</FONT></TD>"+
	        "<TD ALIGN=MIDDLE BGCOLOR=#EEEEEE WIDTH=7%><FONT FACE='WINGDINGS 2' SIZE=5 COLOR=" + strResultColor + ">" + strResultSign + "</FONT><FONT FACE=VERDANA SIZE=2 COLOR=" + strResultColor + "><B>" + strResult + "</B></FONT></TD>"+
	        "</TR>");
	   }
	   if(StringUtils.isNullOrEmpty(expResult)){
	        fw.append(
	        "<TR COLS=4>"+
	        "<TD BGCOLOR=#EEEEEE WIDTH=20%><FONT FACE=VERDANA SIZE=5 COLOR=GREEN>" + stepDesc + "</FONT></TD>"+
	        "</TR>");
	   }
	   
	   //fw.close();

    
		
	}

}
