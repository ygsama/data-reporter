package ygsama.web.system;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import ygsama.pojo.Url;
import ygsama.service.url.UrlService;


@RestController
@RequestMapping("/ipa")
public class UrlWebService {
    private static Log log = LogFactory.getLog(UrlWebService.class);
    
    @Autowired
    private HttpServletRequest request;
    
    @Autowired
    private UrlService urlService;
    
    
    @RequestMapping(value="/{uid}/{url}",method = RequestMethod.GET)
    public Object qryUrl(@PathVariable(value = "url") String url,@PathVariable(value = "uid") String uid) {
        try {
        	Url urlObj = urlService.selectByUrl("/"+uid+"/"+url);
        	return JSONObject.parse(urlObj.getUjson());
        } catch (Exception e) {
            log.error("获取Json失败", e);
        }
        return "o my god , what's wrong?";
    }
    
    @RequestMapping(value="all",method = RequestMethod.GET)
    public Object qryAll(String url) {
        try {
        	List<Url> list = urlService.selectAll();
        	JSONArray array = new JSONArray();
        	for (Url u : list) {
        		array.add(u);
			}
        	return array;
        } catch (Exception e) {
            log.error("获取全部列表失败", e);
        }
        return "o my god , what's wrong?";
    }
    
}
