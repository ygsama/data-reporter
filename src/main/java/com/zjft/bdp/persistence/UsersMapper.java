package com.zjft.bdp.persistence;

import com.zjft.bdp.pojo.Users;
import com.zjft.bdp.pojo.UsersWithBLOBs;

public interface UsersMapper {
    int deleteByPrimaryKey(String id);

    int insert(UsersWithBLOBs record);

    int insertSelective(UsersWithBLOBs record);

    UsersWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UsersWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(UsersWithBLOBs record);

    int updateByPrimaryKey(Users record);
}