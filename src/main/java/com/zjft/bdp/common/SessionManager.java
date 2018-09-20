package com.zjft.bdp.common;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Session Manager
 * 
 */

public class SessionManager {
	
	public static HashMap<String ,Object> sessionMap = new HashMap<String ,Object>();
	private static Log log= LogFactory.getLog(SessionManager.class);
	
	/**
	 * 用户登陆，同名用户已登录，签退前一用户，否则session记录中添加用户
	 * @param request
	 * @param response
	 */
	public static synchronized void addSession(HttpServletRequest request){
		try{
			HttpSession session=request.getSession();
			String userAccount=((UserSession)session.getAttribute("userSession")).getAccount();
			log.info("userAccount: ["+userAccount+"] ");
			if(sessionMap.get(userAccount)==null){
				sessionMap.put(userAccount, session);
			}
			else{     //用户已登录，签退前一登陆
				HttpSession oldSession=(HttpSession)sessionMap.get(userAccount);
				try{
					oldSession.setAttribute("Available", false);
					oldSession.setAttribute("IP_Available", session.getAttribute("IP_Available"));
					oldSession.setAttribute("Time_Available", session.getAttribute("Time_Available"));
				}catch(Exception e){
					log.info("The session is already invalidated");
				}finally{
					sessionMap.remove(userAccount);
					
					sessionMap.put(userAccount, session);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户退出，释放session记录中此用户
	 * @param request
	 */
	public static synchronized void delSession(HttpServletRequest request){
		try{
			UserSession userSession=(UserSession)request.getSession().getAttribute("userSession");
			if(userSession==null){}
			else{
				String userName=userSession.getName();
				sessionMap.remove(userName);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static HttpSession queSession(String account)
	{
		return (HttpSession)sessionMap.get(account);
	}
	
	public static synchronized void removeSession(String account)
	{
		if(sessionMap.containsKey(account))
			sessionMap.remove(account);
	}
}
