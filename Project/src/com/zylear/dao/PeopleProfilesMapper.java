package com.zylear.dao;

import com.zylear.model.PeopleProfiles;

public interface PeopleProfilesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PeopleProfiles record);

    int insertSelective(PeopleProfiles record);

    PeopleProfiles selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PeopleProfiles record);

    int updateProfiles(PeopleProfiles record);

    int updatePreference(PeopleProfiles peopleProfiles);
}