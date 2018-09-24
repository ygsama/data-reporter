package com.zjft.bdp.persistence;

import com.zjft.bdp.pojo.Role;
import com.zjft.bdp.pojo.RoleWithBLOBs;

public interface RoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(RoleWithBLOBs record);

    int insertSelective(RoleWithBLOBs record);

    RoleWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RoleWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(RoleWithBLOBs record);

    int updateByPrimaryKey(Role record);
}