package com.zjft.bdp.service.url;

import java.util.List;

import com.zjft.bdp.pojo.Url;


public interface UrlService {
	
	public void addUrl(Url url);
	public void updateUrl(Url url);
	public List<Url> selectUrl(String uid);
	public void deleteUrl(String uid);
	
}
