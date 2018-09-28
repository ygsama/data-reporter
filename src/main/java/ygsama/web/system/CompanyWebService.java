package ygsama.web.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import scala.util.parsing.json.JSON;

@RestController
@RequestMapping("/api/company")
public class CompanyWebService {
    private static Log log = LogFactory.getLog(CompanyWebService.class);
    

    @RequestMapping(method = RequestMethod.GET)
    public Object qryUser(@RequestParam Map<String, Object> paramMap) {
    	JSONObject obj = new JSONObject();
        try {
        	obj.put("a", "b");
        	return "aaa";
        } catch (Exception e) {
            log.error("查询用户失败", e);
        }
        return "aaa";
    }



}
