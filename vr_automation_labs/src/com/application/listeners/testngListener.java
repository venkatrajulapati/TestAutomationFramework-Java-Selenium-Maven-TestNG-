package com.application.listeners;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import com.application.libs.web.test_base;

public class testngListener extends test_base implements ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onStart(suite);
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		String [] arr = repFolder.split("/");
		String resfolder = "./results/reports/" + arr[arr.length-1];
		String mfpath = "./results/reports/" +  suite.getName() + ".html"; 
		File ofile = new File(mfpath);
		int ch=0;
		if(ofile.exists()) {
			ofile.delete();
		}
		//PrintWriter pw = new PrintWriter(new File(mfpath));
		FileWriter fr = null;
		try {
			fr = new FileWriter(ofile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//BufferedWriter bw = new BufferedWriter(fr);
		FileReader br=null;
		File f1 = new File(resfolder);
		String [] files=null;
		if(f1.isDirectory()) {
			files = f1.list();
			for(String f:files) {
				File fi = new File(resfolder + "/" + f);
				//FileReader br;
				try {
					br = new FileReader(fi.getAbsolutePath());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					while((ch= br.read())!= -1 ) {
						try {
							fr.append((char)ch);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					fr.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		try {
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
