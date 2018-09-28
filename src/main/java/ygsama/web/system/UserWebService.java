package ygsama.web.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import ygsama.common.RetCodeEnum;


@RestController
@RequestMapping("/api")
public class UserWebService {
    private static Log log = LogFactory.getLog(UserWebService.class);
    
    @Autowired
    private HttpServletRequest request;
    
    @RequestMapping(value="/user",method = RequestMethod.GET)
    public Object qryUser(@RequestParam Map<String, Object> paramMap) {
        try {
        	JSONObject obj = new JSONObject();
        	obj.put("a", "b");
        	return obj;
        } catch (Exception e) {
            log.error("查询用户失败", e);
        }
        return "ok";
    }
    @RequestMapping(value="/list",method = RequestMethod.POST)
    public Object qrySpaceList(@RequestParam Map<String, Object> paramMap) {
    	try {
    		JSONObject obj = new JSONObject();
    		JSONObject kv = new JSONObject();
    		JSONObject kv1 = new JSONObject();
    		JSONObject kv2 = new JSONObject();
    		JSONObject kv3 = new JSONObject();
    		JSONObject kv4 = new JSONObject();
    		JSONObject kv5 = new JSONObject();
    		JSONObject kv6 = new JSONObject();
    		JSONObject kv7 = new JSONObject();
    		JSONArray arr = new JSONArray();
    		
    		kv.put("id", "aa");
    		kv.put("name", "紫金空间");
    		kv.put("avatar", "./assets/tmp/img/icon.png");
    		kv.put("remark", "紫金空间的描述，开发大屏、修改、展示大屏");
    		kv1.put("id", "bb");
    		kv1.put("name", "Demo空间");
    		kv1.put("avatar", "./assets/tmp/img/icon.png");
    		kv1.put("remark", "Demo空间的描述，开发报表、修改报表、展示报表");
    		
    		kv2.put("id", "bb");
    		kv2.put("name", "Demo空间");
    		kv2.put("avatar", "./assets/tmp/img/icon.png");
    		kv2.put("remark", "Demo空间的描述，开发报表、修改报表、展示报表");
    		
    		kv3.put("id", "bb");
    		kv3.put("name", "Demo空间");
    		kv3.put("avatar", "./assets/tmp/img/icon.png");
    		kv3.put("remark", "Demo空间的描述，开发报表、修改报表、展示报表");
    		
    		kv4.put("id", "bb");
    		kv4.put("name", "Demo空间");
    		kv4.put("avatar", "./assets/tmp/img/icon.png");
    		kv4.put("remark", "Demo空间的描述，开发报表、修改报表、展示报表");
    		
    		kv5.put("id", "bb");
    		kv5.put("name", "Demo空间");
    		kv5.put("avatar", "./assets/tmp/img/icon.png");
    		kv5.put("remark", "Demo空间的描述，开发报表、修改报表、展示报表");
    		
    		kv6.put("id", "bb");
    		kv6.put("name", "Demo空间");
    		kv6.put("avatar", "./assets/tmp/img/icon.png");
    		kv6.put("remark", "Demo空间的描述，开发报表、修改报表、展示报表");
    		
    		kv7.put("id", "bb");
    		kv7.put("name", "Demo空间");
    		kv7.put("avatar", "./assets/tmp/img/icon.png");
    		kv7.put("remark", "Demo空间的描述，开发报表、修改报表、展示报表");
    		
    		arr.add(kv);
    		arr.add(kv1);
    		arr.add(kv2);
    		arr.add(kv3);
    		arr.add(kv4);
    		arr.add(kv5);
    		arr.add(kv6);
    		arr.add(kv7);
    		obj.put("retList", arr);
    		obj.put("retMsg", RetCodeEnum.SUCCEED.getTip());
			obj.put("retCode", RetCodeEnum.SUCCEED.getCode());
    		
    		
    		
    		return obj;
    	} catch (Exception e) {
    		log.error("查询用户失败", e);
    	}
    	return "ok";
    }
    
    @RequestMapping(value="/test/{id}",method = RequestMethod.GET)
    public Object test(@RequestParam Map<String, Object> paramMap,@PathVariable(value = "id") String id) {
        try {
        	String path = request.getServletPath();
        	JSONObject obj = new JSONObject();
        	obj.put("a", path);
        	obj.put("b", id);
        	return obj;
        } catch (Exception e) {
            log.error("查询用户失败", e);
        }
        return "ok";
    }
}
