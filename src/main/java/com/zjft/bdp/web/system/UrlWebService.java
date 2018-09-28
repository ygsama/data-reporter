package com.zjft.bdp.web.system;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.zjft.bdp.service.url.UrlService;


@RestController
@RequestMapping("/url")
public class UrlWebService {
    private static Log log = LogFactory.getLog(UrlWebService.class);
    
    @Autowired
    private HttpServletRequest request;
    
    @Autowired
    private UrlService urlService;
    
    
    @RequestMapping(value="/{uid}",method = RequestMethod.GET)
    public Object qryUser(@PathVariable(value = "uid") String uid) {
        try {
        	JSONObject obj = new JSONObject();
        	obj.put("a", "b");
        	return obj;
        } catch (Exception e) {
            log.error("查询用户失败", e);
        }
        return "ok";
    }
    
}
