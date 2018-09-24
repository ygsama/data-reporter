package com.zjft.bdp.persistence;

import com.zjft.bdp.pojo.Resource;
import com.zjft.bdp.pojo.ResourceWithBLOBs;

public interface ResourceMapper {
    int deleteByPrimaryKey(String id);

    int insert(ResourceWithBLOBs record);

    int insertSelective(ResourceWithBLOBs record);

    ResourceWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ResourceWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ResourceWithBLOBs record);

    int updateByPrimaryKey(Resource record);
}