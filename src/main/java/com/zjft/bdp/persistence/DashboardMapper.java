package com.zjft.bdp.persistence;

import com.zjft.bdp.pojo.Dashboard;
import com.zjft.bdp.pojo.DashboardWithBLOBs;

public interface DashboardMapper {
    int deleteByPrimaryKey(String id);

    int insert(DashboardWithBLOBs record);

    int insertSelective(DashboardWithBLOBs record);

    DashboardWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DashboardWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DashboardWithBLOBs record);

    int updateByPrimaryKey(Dashboard record);
}