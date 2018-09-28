package com.zjft.bdp.persistence;

import java.util.List;

import com.zjft.bdp.pojo.Url;

public interface UrlMapper {
    int deleteByPrimaryKey(String url);

    int insert(Url record);

    int insertSelective(Url record);

    Url selectByPrimaryKey(String url);

    List<Url> selectByUid(String uid);
    
    List<Url> selectAll();

    int updateByPrimaryKeySelective(Url record);

    int updateByPrimaryKeyWithBLOBs(Url record);

    int updateByPrimaryKey(Url record);
}