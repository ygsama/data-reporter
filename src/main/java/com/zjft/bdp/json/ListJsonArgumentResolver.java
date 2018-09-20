package com.zjft.bdp.json;

import java.io.BufferedReader;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.alibaba.fastjson.JSON;

public class ListJsonArgumentResolver implements HandlerMethodArgumentResolver {
	
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(ListJson.class) != null;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, 
    		NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        // content-type不是json的不处理
        if (!request.getContentType().contains("application/json")) {
            return null;
        }

        // 把reqeust的body读取到StringBuilder
        BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();

        char[] buf = new char[1024];
        int rd;
        while((rd = reader.read(buf)) != -1) {
            sb.append(buf, 0, rd);
        }
      
        Class<?> parameterType = parameter.getParameterType();
        if (List.class.isAssignableFrom(parameterType) && !parameterType.equals(parameter.getGenericParameterType())) {
        	ParameterizedType type = (ParameterizedType) parameter.getGenericParameterType();
        	Class<?> cl = (Class<?>)(type.getActualTypeArguments()[0]);
        	if (cl != null) {
        		return JSON.parseArray(sb.toString(), cl);
        	}
        }

        return JSON.parseObject(sb.toString(), parameterType);
    }
}
