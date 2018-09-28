package ygsama.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * ServletContextAttributeListener 	监听对ServletContext属性的操作，比如增加、删除、修改属性
 * ServletContextListener 			监听对ServletContext属性的操作，比如增加、删除、修改属性
 * HttpSessionAttributeListener		监听HttpSession的属性变化，监听增加、移除和修改事件
 * HttpSessionListener				当创建或销毁ServletContext时触发事件
 * 
 * page域:    只能在当前jsp页面使用              (当前页面)
 * request域: 只能在同一个请求中使用               (转发)
 * session域: 只能在同一个会话(session对象)中使用  (私有的)
 * context域: 只能在同一个web应用中使用   
 * 
 *
 */
public class UserCounterListener implements ServletContextListener,ServletContextAttributeListener {
	public static final String COUNT_KEY = "UserOnLineNum";
	private static Log log = LogFactory.getLog(UserCounterListener.class);
	private static ServletContext servletContext;
	private int counter;

	public synchronized void contextInitialized(ServletContextEvent sce) {
		log.debug("-------------[ServletContextInitialized]-------------------");
		servletContext = sce.getServletContext();
		servletContext.setAttribute(COUNT_KEY, Integer.toString(counter));
	}

	public synchronized void contextDestroyed(ServletContextEvent event) {
		servletContext = null;
		counter = 0;
	}

	synchronized void incrementUserCounter() {
		counter = Integer.parseInt((String)servletContext.getAttribute(COUNT_KEY));
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

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		if (event.getName().equals("countListener")) {
			incrementUserCounter();
		}
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		if (event.getName().equals("countListener")) {
			decrementUserCounter();
		}
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		if (event.getName().equals("countListener")) {
			decrementUserCounter();
		}
	}
}
