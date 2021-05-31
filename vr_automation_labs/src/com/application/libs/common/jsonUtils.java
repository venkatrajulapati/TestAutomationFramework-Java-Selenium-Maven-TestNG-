package com.application.libs.common;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsonUtils {
	
	public static boolean isJsonArray(String jsonStr) throws ParseException {
		boolean result=false;
		JSONParser parser = new JSONParser();
		JSONArray jsonArray=null;
		try {
			Object obj = parser.parse(jsonStr);
			jsonArray = (JSONArray)obj;
			result=true;
		}catch (Exception e) {
			// TODO: handle exception
			result=false;
		}
		
		return result;
	}
	
	public static JSONArray getJsonArray(String jsonStr) throws ParseException {
		JSONParser parser = new JSONParser();
		JSONArray jsonArray=null;
		try {
			Object obj = parser.parse(jsonStr);
			jsonArray = (JSONArray)obj;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return jsonArray;
	}
	
	public static JSONObject getJsonObject(String jsonStr) throws ParseException {
		JSONParser parser = new JSONParser();
		JSONObject jsonObj=null;
		try {
			Object obj = parser.parse(jsonStr);
			jsonObj = (JSONObject)obj;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return jsonObj;
	}
	
	public static String getJsonValue(String jsonstr,String key) throws ParseException {
		JSONObject obj = getJsonObject(jsonstr);
		return obj.get(key).toString();
	}

}
