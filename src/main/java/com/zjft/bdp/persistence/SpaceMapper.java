package com.zjft.bdp.persistence;

import com.zjft.bdp.pojo.Space;
import com.zjft.bdp.pojo.SpaceWithBLOBs;

public interface SpaceMapper {
    int deleteByPrimaryKey(String id);

    int insert(SpaceWithBLOBs record);

    int insertSelective(SpaceWithBLOBs record);

    SpaceWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SpaceWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SpaceWithBLOBs record);

    int updateByPrimaryKey(Space record);
}