package com.zylear.service;

import com.zylear.model.PeopleInfo;
import net.sf.json.JSONObject;

/**
 * Created by Administrator on 2017/8/8.
 */
public interface PersonalService {

    boolean login(int account, String password);

    boolean register(PeopleInfo peopleInfo);

    JSONObject getPersonalInfo(int account);

    boolean changePassword(int account, String oldPassword, String newPassword);

    boolean changeInfo(PeopleInfo peopleInfo);

    boolean changePreference(JSONObject jsonObject);

    JSONObject getPreference(int account);
}
