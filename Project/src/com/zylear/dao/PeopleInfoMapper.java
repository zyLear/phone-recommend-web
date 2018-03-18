package com.zylear.dao;

import com.zylear.model.PeopleInfo;

public interface PeopleInfoMapper {
 //   int deleteByPrimaryKey(Integer id);

    int insert(PeopleInfo record);

  //  int insertSelective(PeopleInfo record);

    PeopleInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PeopleInfo record);

    int updateByPrimaryKey(PeopleInfo record);

    PeopleInfo login(PeopleInfo peopleInfo);

}