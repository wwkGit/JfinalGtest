package com.demo.index;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.core.Controller;



/**
 * 本 demo 仅表达最为粗浅的 jfinal 用法，更为有价值的实用的企业级用法
 * 详见 JFinal 俱乐部: http://jfinal.com/club
 * 
 * IndexController
 */
public class IndexController extends Controller {
	public void index() throws IOException {		
		String url = "https://api.github.com/search/repositories?q=user:FIRHQ";   
		com.demo.utils.Gdemo g=new com.demo.utils.Gdemo();
	    JSONObject json = g.readJsonFromUrl(url); 
	    Map<String, Object> map = new HashMap<String,Object>();
	    JSONArray js=(JSONArray) json.get("items");		    
	    if(js.size()>0){
		    for(int i=0;i<js.size();i++){
		    	JSONObject job = js.getJSONObject(i); // 遍历 jsonarray 数组，把每一个对象转成 json 对象
		    	
		    	map.put(job.get("name").toString(), job.get("stargazers_count").toString());
		    	}
	    }
	    JSONObject result = new JSONObject(map);
	    renderJson(result);
	}
}





