package ygsama.persistence;

import ygsama.pojo.Users;
import ygsama.pojo.UsersWithBLOBs;

public interface UsersMapper {
    int deleteByPrimaryKey(String id);

    int insert(UsersWithBLOBs record);

    int insertSelective(UsersWithBLOBs record);

    UsersWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UsersWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(UsersWithBLOBs record);

    int updateByPrimaryKey(Users record);
}