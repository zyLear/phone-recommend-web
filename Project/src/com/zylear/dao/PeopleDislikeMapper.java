package com.zylear.dao;

import com.zylear.model.PeopleDislike;

public interface PeopleDislikeMapper {
    int insert(PeopleDislike record);

    int insertSelective(PeopleDislike record);
}