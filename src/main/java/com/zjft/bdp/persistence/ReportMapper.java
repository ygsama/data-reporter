package com.zjft.bdp.persistence;

import com.zjft.bdp.pojo.Report;
import com.zjft.bdp.pojo.ReportWithBLOBs;

public interface ReportMapper {
    int deleteByPrimaryKey(String id);

    int insert(ReportWithBLOBs record);

    int insertSelective(ReportWithBLOBs record);

    ReportWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ReportWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ReportWithBLOBs record);

    int updateByPrimaryKey(Report record);
}