package com.test.base.dao;

import com.test.base.model.UserDTO;

public interface UserDTOMapper {
    int deleteByPrimaryKey(String hxuuid);

    int insert(UserDTO record);

    int insertSelective(UserDTO record);

    UserDTO selectByPrimaryKey(String hxuuid);

    int updateByPrimaryKeySelective(UserDTO record);

    int updateByPrimaryKey(UserDTO record);

	String selectNameByPrimaryKey(String hxuuid);
}