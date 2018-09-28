package com.zjft.bdp.service.url.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjft.bdp.persistence.UrlMapper;
import com.zjft.bdp.pojo.Url;
import com.zjft.bdp.service.login.impl.LoginServiceImpl;
import com.zjft.bdp.service.url.UrlService;

@Service("urlService")
public class UrlServiceImpl implements UrlService {

	private static Log log = LogFactory.getLog(LoginServiceImpl.class);
	
	@Autowired
	private UrlMapper urlMapper;
	
	@Override
	public void addUrl(Url url) {
		int insert = urlMapper.insert(url);
		log.info("addUrl " + insert + " " + url.getUid() + " " + url.getUrl());
	}

	@Override
	public void updateUrl(Url url) {
		int update = urlMapper.updateByPrimaryKeyWithBLOBs(url);
		log.info("updateUrl " + update + " " + url.getUid() + " " + url.getUrl());
	}

	@Override
	public List<Url> selectUrl(String uid) {
		List<Url> list = urlMapper.selectByUid(uid);
		log.info("selectUrl " + uid + " size:" + list.size());
		return list;
	}

	@Override
	public void deleteUrl(String id) {
		int delete = urlMapper.deleteByPrimaryKey(id);
		log.info("deleteUrl " + delete + " " + id);
	}

}
