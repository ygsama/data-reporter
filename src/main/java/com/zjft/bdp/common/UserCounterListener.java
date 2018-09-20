package com.zjft.bdp.common;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UserCounterListener implements ServletContextListener,HttpSessionAttributeListener, HttpSessionListener {
	public static final String COUNT_KEY = "UserOnLineNum";
	private static Log log = LogFactory.getLog(UserCounterListener.class);
	private static ServletContext servletContext;
	private int counter;

	public synchronized void contextInitialized(ServletContextEvent sce) {
		log.debug("-------------contextInitialized-------------------");
		servletContext = sce.getServletContext();
		servletContext.setAttribute((COUNT_KEY), Integer.toString(counter));
	}

	public synchronized void contextDestroyed(ServletContextEvent event) {
		servletContext = null;
		counter = 0;
	}

	synchronized void incrementUserCounter() {
		counter = Integer.parseInt((String) servletContext.getAttribute(COUNT_KEY));
		counter++;
		servletContext.setAttribute(COUNT_KEY, Integer.toString(counter));

		log.info("User Count: " + counter);
	}

	synchronized void decrementUserCounter() {
		int counter = Integer.parseInt((String) servletContext.getAttribute(COUNT_KEY));
		counter--;

		if (counter < 0) {
			counter = 0;
		}

		servletContext.setAttribute(COUNT_KEY, Integer.toString(counter));

		log.info("User Count: " + counter);
	}

	/**
	 * This method is designed to catch when user's login and record their name
	 * 
	 * @see javax.servlet.http.HttpSessionAttributeListener#attributeAdded(javax.servlet.http.HttpSessionBindingEvent)
	 */
	public void attributeAdded(HttpSessionBindingEvent event) {
		if (event.getName().equals("userSession")) {
			incrementUserCounter();
		}
	}

	/**
	 * When user's logout, remove their name from the hashMap
	 * 
	 * @see javax.servlet.http.HttpSessionAttributeListener#attributeRemoved(javax.servlet.http.HttpSessionBindingEvent)
	 */
	public void attributeRemoved(HttpSessionBindingEvent event) {
		if (event.getName().equals("userSession")) {
			UserSession user_Client = (UserSession) event.getValue();
			if (user_Client == null) {
				return;
			}
			HttpSession session = SessionManager.queSession(user_Client.getAccount());
			if (session != null) {
				try {
					if (((session.getAttribute("IP_Available")).equals(user_Client.getLoginIp_curr())) && ((session.getAttribute("Time_Available")).equals(user_Client.getLoginTime_curr())))
						SessionManager.removeSession(user_Client.getAccount());
				} catch (IllegalStateException e) {
					SessionManager.removeSession(user_Client.getAccount());
				}
			}
			decrementUserCounter();
		}
	}

	/**
	 * @see javax.servlet.http.HttpSessionAttributeListener#attributeReplaced(javax.servlet.http.HttpSessionBindingEvent)
	 */
	public void attributeReplaced(HttpSessionBindingEvent event) {
		
	}

	public void sessionCreated(HttpSessionEvent arg0) {
		
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		if (arg0.getSession().getAttribute("userSession") != null) {
			arg0.getSession().removeAttribute("userSession");
		}
	}
}
