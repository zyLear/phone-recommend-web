package com.zylear.dao;


import com.zylear.model.PeopleProfiles;
import com.zylear.model.PhoneInfo;
import com.zylear.model.PhoneProfiles;

import java.util.List;

public interface PhoneProfilesMapper {

    PhoneProfiles selectByPrimaryKey(Integer id);

    List<PhoneInfo> recommendation(PeopleProfiles peopleProfiles);

    List<PhoneInfo> searchPhoneInfo(PhoneProfiles phoneProfiles);

    void addPhoneCount(int phoneId);


}