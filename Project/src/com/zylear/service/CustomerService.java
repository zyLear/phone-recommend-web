package com.zylear.service;

import com.zylear.model.PhoneInfo;
import net.sf.json.JSONObject;
import java.util.List;

/**
 * Created by Administrator on 2017/6/5.
 */
public interface CustomerService {

    List<PhoneInfo> getPhoneInfo();
    List<PhoneInfo> TestPage(int page);
    JSONObject getPhoneInfoByPage(int page);
    void changePeopleProfiles(int peopleId, int phoneId,int number,boolean isLike);
    List<PhoneInfo> getRecommendPhoneInfos(int peopleId);
    JSONObject getRecommendPhoneInfoByPage(int peopleId, int page);
    boolean like(int peopleId, int phoneId);
    boolean dislike(int peopleId, int phoneId);

    boolean removeLike(int peopleId, int phoneId);

    Object peopleLike(int peopleId);

    JSONObject findPhoneInfoBySelect(JSONObject jsonObject);


    void addPhoneCount(int phoneId);
}
