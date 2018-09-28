package ygsama.web.login;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONObject;

import ygsama.common.CalendarUtil;
import ygsama.common.HttpRequestUtil;
import ygsama.common.RetCodeEnum;
import ygsama.common.ServletRequestUtil;
import ygsama.common.StringUtil;
import ygsama.common.TokenManager;
import ygsama.common.UserToken;
import ygsama.domain.User;
import ygsama.service.login.LoginService;


@RestController
public class LoginWebService {
	private static Log log = LogFactory.getLog(LoginWebService.class);

	@Autowired
	private LoginService loginService;
	
	private boolean isSysBusy(String userOnLineStr,String maxUserOnLineStr) {
		boolean ret = false;
		log.info("UserOnLineNum==" + userOnLineStr);
		if(userOnLineStr != null) {
			int userOnLineNum = Integer.parseInt(userOnLineStr);
			if (maxUserOnLineStr == null || maxUserOnLineStr.equals(""))
				maxUserOnLineStr = "100";
			int maxUserOnLineNum = Integer.parseInt(maxUserOnLineStr);
			log.info("max=[" + maxUserOnLineNum + "] now=[" + userOnLineNum + "]");
			if (userOnLineNum >= maxUserOnLineNum) {
				ret = true;
			}
		}
		return ret;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Object login(@RequestBody  Map<String, Object> params) throws Exception {
		JSONObject obj = new JSONObject();// 返回JSON对象
		try {
			HttpServletRequest request = ServletRequestUtil.getHttpRequest();
			// 人数过多，停止登录
			if(isSysBusy(request.getSession().getServletContext().getAttribute("UserOnLineNum").toString(),request.getSession().getServletContext().getInitParameter("MaxUserOnLineNum"))) {
				obj.put("code", RetCodeEnum.BUSY.getCode());
				obj.put("msg",RetCodeEnum.BUSY.getTip());
				return obj;
			}
			
			String loginIp = request.getRemoteAddr();
			String loginTime = CalendarUtil.getSysTimeYMDHMS();
			String loginTerm = HttpRequestUtil.getBrowserInfo(request);
			String strLang = StringUtil.parseString(params.get("language"));
			Locale lang;
			if ("tw".equals(strLang)) {
				lang = Locale.TRADITIONAL_CHINESE;
			} else if ("en".equals(strLang)) {
				lang = Locale.US;
			} else {
				lang = Locale.CHINA;
			}
			
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("uid", params.get("uid"));
			paramsMap.put("pwd", params.get("pwd"));
			paramsMap.put("loginIp", loginIp);          //本次登录IP
			paramsMap.put("loginTime", loginTime);      //本次登录时间
			paramsMap.put("loginTerm", loginTerm);      //本次登录终端
			User auser  = loginService.login(paramsMap);
			
			if (!RetCodeEnum.SUCCEED.getCode().equals(auser.getCode())) {
				obj.put("msg", RetCodeEnum.FAIL.getTip());
				obj.put("code", RetCodeEnum.FAIL.getCode());
			}
			HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
			String webToken = "";
			String cookies = response.getHeader("Set-Cookie");
			if (cookies != null) {
				String temp = (cookies.length() >= 10) ? temp = cookies.substring(cookies.indexOf("JSESSIONID") + 11) : "";
				temp = temp.contains(";") ? temp.substring(0, temp.indexOf(";")) : temp;
				if (temp.trim() != "") {
					webToken = temp.trim();
				}
			}else{
				webToken = UUID.randomUUID().toString().replace("-", "");
			}
			obj.put("token",webToken);
			
			UserToken utoken = new UserToken();
			utoken.setUserId(auser.getNo());
			utoken.setUserName(auser.getName());
			utoken.setLoginIp(auser.getLoginIp() == null ? "" : auser.getLoginIp());           //上次登录IP
			utoken.setLoginTime(auser.getLoginTime() == null ? "" : auser.getLoginTime());     //上次登录时间
			utoken.setLang(lang);
			utoken.setLoginIp(loginIp);          //本次登录IP
			utoken.setLoginTime(loginTime);     //本次登录时间
			utoken.setWebToken(webToken);     //本次登录时间
			TokenManager.addSession(utoken);
			
			ServletContext context = ServletRequestUtil.getServletContext();
			context.setAttribute("countListener", auser.getNo());
			obj.put("msg", RetCodeEnum.SUCCEED.getTip());
			obj.put("code", RetCodeEnum.SUCCEED.getCode());
		} catch (Exception e) {
			log.error("登录失败", e);
			obj.put("msg", RetCodeEnum.EXCEPTION.getTip());
			obj.put("code", RetCodeEnum.EXCEPTION.getCode());
		}
		
		log.info("[LoginController-login]返回码=[" + obj.get("code") + "] 返回信息=[" + obj.get("msg") + "]");
		return obj;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public Object logout(@RequestBody  Map<String, Object> params) throws Exception {
		JSONObject obj= new JSONObject();
		try {
			HttpServletRequest request = ServletRequestUtil.getHttpRequest();
			String token = request.getHeader("Token");
			TokenManager.delSession(token);
			obj.put("msg", RetCodeEnum.SUCCEED.getTip());
			obj.put("code", RetCodeEnum.SUCCEED.getCode());
		} catch(Exception e) {
			log.error("用户退出失败: ", e);
			obj.put("msg", RetCodeEnum.FAIL.getTip());
			obj.put("code", RetCodeEnum.FAIL.getCode());
		}
		return obj;
	}
}
