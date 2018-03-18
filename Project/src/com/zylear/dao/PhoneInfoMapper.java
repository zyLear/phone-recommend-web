package com.zylear.dao;

import com.zylear.model.PhoneInfo;

import java.util.List;

public interface PhoneInfoMapper {
//    int deleteByPrimaryKey(Integer id);
//
//
//
//    int insertSelective(PhoneInfo record);
//
//    PhoneInfo selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(PhoneInfo record);
//
//    int updateByPrimaryKey(PhoneInfo record);





    //   int insertDetail(PhoneInfo detail);

    List<PhoneInfo> getPhoneInfo();

    List<PhoneInfo> getPhoneInfoByPage(int page);

    //List<PhoneInfo> selectBySelective(PhoneInfo phoneInfo);




 //   List<PhoneInfo> getPhoneInfoBySource(String source);


 //   List<PhoneInfo> getAllDetailInfo(String source);



}