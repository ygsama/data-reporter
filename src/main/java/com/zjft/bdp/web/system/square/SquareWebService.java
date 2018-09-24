package com.zjft.bdp.web.system.square;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zjft.bdp.common.RetCodeEnum;

@RestController
@RequestMapping("/api/square")
public class SquareWebService {
    private static Log log = LogFactory.getLog(SquareWebService.class);
    
    
    @RequestMapping(value="/list",method = RequestMethod.GET)
    public Object qryUser(@RequestParam Map<String, Object> paramMap) {
    	JSONObject obj = new JSONObject();
        try {
        	
        	JSONArray array = new JSONArray();
        	JSONObject jsonObject = new JSONObject();
        	JSONObject jsonObject2 = new JSONObject();
        	JSONObject jsonObject3 = new JSONObject();
        	
        	jsonObject.put("group_name", "公共空间");
        	jsonObject3.put("group_name", "测试空间");
        	jsonObject2.put("group_name", "普通空间");
        	
        	array.add(jsonObject);
        	array.add(jsonObject2);
        	array.add(jsonObject3);
        	
        	obj.put("data", array);
        	obj.put("msg", RetCodeEnum.SUCCEED.getTip());
        	obj.put("code", RetCodeEnum.SUCCEED.getCode());
        	return obj;
        } catch (Exception e) {
            log.error("查询用户失败", e);
        }
        return obj;
    }



}
