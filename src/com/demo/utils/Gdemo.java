package com.demo.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

import com.alibaba.fastjson.JSONObject;







public class Gdemo {
	
	 public  com.alibaba.fastjson.JSONObject readJsonFromUrl(String url) throws IOException {
		    InputStream is = new URL(url).openStream();
		    try {
		      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		      StringBuilder sb = new StringBuilder();
			  int cp;
			  while ((cp = rd.read()) != -1) {
			    sb.append((char) cp);
			  }
		      String jsonText = sb.toString();
		      JSONObject json = JSONObject.parseObject(jsonText);  
		      return json;
		    } finally {
		      is.close();
		    }
		  }

	

}
