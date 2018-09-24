package com.zjft.bdp.persistence;

import com.zjft.bdp.pojo.Company;
import com.zjft.bdp.pojo.CompanyWithBLOBs;

public interface CompanyMapper {
    int deleteByPrimaryKey(String id);

    int insert(CompanyWithBLOBs record);

    int insertSelective(CompanyWithBLOBs record);

    CompanyWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CompanyWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CompanyWithBLOBs record);

    int updateByPrimaryKey(Company record);
}