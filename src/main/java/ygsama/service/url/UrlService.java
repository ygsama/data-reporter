package ygsama.service.url;

import java.util.List;

import ygsama.pojo.Url;


public interface UrlService {
	
	public void addUrl(Url url);
	public void updateUrl(Url url);
	public List<Url> selectUrls(String uid);
	public List<Url> selectAll();
	public Url selectByUrl(String url);
	public void deleteUrl(String uid);
	
}
