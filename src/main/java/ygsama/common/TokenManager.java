package ygsama.common;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Session Manager
 * 
 */

public class TokenManager {
	
	public static HashMap<String ,UserToken> sessionMap = new HashMap<String ,UserToken>();
	private static Log log= LogFactory.getLog(TokenManager.class);
	
	/**
	 * 用户登录维护一个Token在Map中
	 * 用户重复登录，销毁前一个Token
	 * @param request
	 * @param response
	 */
	public static synchronized void addSession(UserToken uToken){
		try{
			String userId = uToken.getUserId();
			for(String key :sessionMap.keySet()){
				if(key.split("$")[0]==userId){
					sessionMap.remove(key);
					log.info("[TokenManager] remove: "+key);
				}
			}
			sessionMap.put(userId+"$"+uToken.getWebToken(), uToken);
			log.info("[TokenManager] add: "+ userId);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户退出，删除session
	 * @param request
	 */
	public static synchronized void delSession(String token){
		try{
			for(String key :sessionMap.keySet()){
				if(key.split("$")[1]==token){
					sessionMap.remove(key);
					log.info("[TokenManager] remove: "+key);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static UserToken queSession(String account){
		for(String key :sessionMap.keySet()){
			if(key.split("$")[0]==account){
				return sessionMap.get(key);
			}
		}
		return null;
	}
}
