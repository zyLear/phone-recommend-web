package com.zylear.dao;

import com.zylear.model.PeopleLike;
import com.zylear.model.PhoneInfo;

import java.util.List;

public interface PeopleLikeMapper {
    int insert(PeopleLike record);

    List<PhoneInfo> getPhoneInfoByPeopleId(int peopleId);

    int delete(PeopleLike PeopleLike);
}