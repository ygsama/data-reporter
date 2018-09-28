package ygsama.service.url.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ygsama.persistence.UrlMapper;
import ygsama.pojo.Url;
import ygsama.service.login.impl.LoginServiceImpl;
import ygsama.service.url.UrlService;

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
	public List<Url> selectUrls(String uid) {
		List<Url> list = urlMapper.selectByUid(uid);
		log.info("selectUrl " + uid + " size:" + list.size());
		return list;
	}

	@Override
	public Url selectByUrl(String url) {
		Url u = urlMapper.selectByPrimaryKey(url);
		log.info("selectByUrl " + url );
		return u;
	}
	
	@Override
	public List<Url> selectAll() {
		List<Url> list = urlMapper.selectAll();
		log.info("selectAll  size:" + list.size());
		return list;
	}
	
	@Override
	public void deleteUrl(String id) {
		int delete = urlMapper.deleteByPrimaryKey(id);
		log.info("deleteUrl " + delete + " " + id);
	}


}
