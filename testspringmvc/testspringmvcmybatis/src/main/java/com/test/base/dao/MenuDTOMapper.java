package com.test.base.dao;

import com.test.base.model.MenuDTO;

public interface MenuDTOMapper {
    int deleteByPrimaryKey(String hxuuid);

    int insert(MenuDTO record);

    int insertSelective(MenuDTO record);

    MenuDTO selectByPrimaryKey(String hxuuid);

    int updateByPrimaryKeySelective(MenuDTO record);

    int updateByPrimaryKey(MenuDTO record);
}