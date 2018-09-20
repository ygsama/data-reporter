package com.zjft.bdp.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zjft.bdp.common.CalendarUtil;
import com.zjft.bdp.common.CfgProperty;

public class AuthInterceptor implements HandlerInterceptor {

	private static Log log = LogFactory.getLog(AuthInterceptor.class);
	
	//在处理器调用之前被调用
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		log.debug("------preHandle------" + CalendarUtil.getSysTimeYMDHMS11());
		log.info("auth httpSession id=" + request.getSession().getId() + ",	requestMethod=" + request.getMethod());
		
		String servletPath = request.getServletPath();
		log.info("servletPath=" + servletPath);
		if ("/login".equals(servletPath)) {
			return true;
		}
		
		if(request.getSession().getAttribute("Available") !=null &&  !((Boolean)request.getSession().getAttribute("Available"))){
			response.setStatus(901);
			log.error("intercityLogin!,session is not available!");
			return false;
		}
		
		if("123".length()>1){
			try {
//				String sessionId = request.getSession().getId();
//				sessionId跟redis比较
				return true;
			} catch (Exception e) {
				log.error("请求验证Token异常:",e);
			} finally{
//				
			}
		}
		
		response.setStatus(900);
		log.error("Fail to be authorized, response 900");
		return false;
	}

	//在处理器调用之后执行
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	}

	//在请求结束之后调用
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	}

}