package com.zjft.bdp.web.login;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.zjft.bdp.common.CalendarUtil;
import com.zjft.bdp.common.HttpRequestUtil;
import com.zjft.bdp.common.RetCodeEnum;
import com.zjft.bdp.common.ServletRequestUtil;
import com.zjft.bdp.common.SessionManager;
import com.zjft.bdp.common.StringUtil;
import com.zjft.bdp.common.UserSession;
import com.zjft.bdp.domain.User;
import com.zjft.bdp.service.login.LoginService;


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
		
		JSONObject obj = new JSONObject();
		try {
			HttpServletRequest request = ServletRequestUtil.getHttpRequest();
			if(isSysBusy(request.getSession().getServletContext().getAttribute("UserOnLineNum").toString(),request.getSession().getServletContext().getInitParameter("MaxUserOnLineNum"))) {
				obj.put("code", RetCodeEnum.BUSY.getCode());
				obj.put("msg",RetCodeEnum.BUSY.getTip());
				return obj;
			}
			
			String strLang = StringUtil.parseString(params.get("language"));
			Locale lang;
			if ("tw".equals(strLang)) {
				lang = Locale.TRADITIONAL_CHINESE;
			} else if ("en".equals(strLang)) {
				lang = Locale.US;
			} else {
				lang = Locale.CHINA;
			}
			request.getSession().setAttribute("locale", lang);
			
			String loginIp = request.getRemoteAddr();
			String loginTime = CalendarUtil.getSysTimeYMDHMS();
			String loginTerm = HttpRequestUtil.getBrowserInfo(request);
			
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("uid", params.get("uid"));
			paramsMap.put("pwd", params.get("pwd"));
			paramsMap.put("loginIp", loginIp);          //本次登录IP
			paramsMap.put("loginTime", loginTime);      //本次登录时间
			paramsMap.put("loginTerm", loginTerm);      //本次登录终端

			User auser  = loginService.login(paramsMap);
			
			if (RetCodeEnum.SUCCEED.getCode().equals(auser.getCode())) {
				UserSession aUserSession = new UserSession();
//				aUserSession.setLoginIp_curr(loginIp);
//				aUserSession.setLoginTime_curr(loginTime);
				
//				aUserSession.setAccount(auser.getNo());
//				aUserSession.setName(auser.getName());
//				aUserSession.setLoginIp(auser.getLoginIp() == null ? "" : auser.getLoginIp());           //上次登录IP
//				aUserSession.setLoginTime(auser.getLoginTime() == null ? "" : auser.getLoginTime());     //上次登录时间
				
//				aUserSession.setOnline_flag(Integer.valueOf(auser.getOnline_flag()));
//				aUserSession.setMenuList(new ArrayList(auser.getRole().getMenus()));

				request.getSession().setAttribute("Available", true);
				request.getSession().setAttribute("IP_Available", loginIp);          //本次登录IP
				request.getSession().setAttribute("Time_Available", loginTime);      //本次登录时间
				request.getSession().setAttribute("userSession", aUserSession);
				SessionManager.addSession(request);
				
				HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
				String webToken = "suijizifuchuan";
				String cookies = response.getHeader("Set-Cookie");
				if (cookies != null) {
					String temp = (cookies.length() >= 10) ? temp = cookies.substring(cookies.indexOf("JSESSIONID") + 11) : "";
					temp = temp.contains(";") ? temp.substring(0, temp.indexOf(";")) : temp;
					if (temp.trim() != "") {
						webToken = temp.trim();
					}
				}
				obj.put("token",webToken);
			}
			
		} catch (Exception e) {
			log.error("登录失败", e);
			obj.put("msg", RetCodeEnum.EXCEPTION.getTip());
			obj.put("code", RetCodeEnum.EXCEPTION.getCode());
		}
		obj.put("msg", RetCodeEnum.SUCCEED.getTip());
		obj.put("code", RetCodeEnum.SUCCEED.getCode());
		
		log.info("[LoginController-login]返回码=[" + obj.get("code") + "] 返回信息=[" + obj.get("msg") + "]");
		return obj;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public Object logout() throws Exception {
		JSONObject obj= new JSONObject();
		try {
			HttpServletRequest request = ServletRequestUtil.getHttpRequest();
			HttpSession httpSession = request.getSession();
			httpSession.removeAttribute("userSession");
			httpSession.removeAttribute("locale");
			httpSession.invalidate();// 销毁session
			
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
