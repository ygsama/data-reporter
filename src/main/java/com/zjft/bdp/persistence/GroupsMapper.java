package com.zjft.bdp.persistence;

import com.zjft.bdp.pojo.Groups;
import com.zjft.bdp.pojo.GroupsWithBLOBs;

public interface GroupsMapper {
    int deleteByPrimaryKey(String id);

    int insert(GroupsWithBLOBs record);

    int insertSelective(GroupsWithBLOBs record);

    GroupsWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GroupsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(GroupsWithBLOBs record);

    int updateByPrimaryKey(Groups record);
}