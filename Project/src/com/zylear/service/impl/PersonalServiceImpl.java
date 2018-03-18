package com.zylear.service.impl;

import com.zylear.dao.PeopleInfoMapper;
import com.zylear.dao.PeopleProfilesMapper;
import com.zylear.model.PeopleInfo;
import com.zylear.model.PeopleProfiles;
import com.zylear.service.PersonalService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/8/8.
 */
@Service("personalService")
public class PersonalServiceImpl implements PersonalService {

    @Resource
    private PeopleInfoMapper peopleInfoMapper;
    @Resource
    private PeopleProfilesMapper peopleProfilesMapper;



    @Override
    public boolean login(int account, String password) {
        PeopleInfo peopleInfo = new PeopleInfo();
        peopleInfo.setId(account);
        peopleInfo.setPassword(password);
        System.out.println(account + "  " + password);
        if (peopleInfoMapper.login(peopleInfo) != null) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean register(PeopleInfo peopleInfo) {
        //Transaction should begin.But I don't know how to use it
        int insertInfo=peopleInfoMapper.insert(peopleInfo);
        PeopleProfiles peopleProfiles = new PeopleProfiles();
        peopleProfiles.setId(peopleInfo.getId());
        //peopleProfiles.setCount(0);
        int insertProfiles = peopleProfilesMapper.insert(peopleProfiles);
        //end

        if ( insertInfo> 0 &&insertProfiles>0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public JSONObject getPersonalInfo(int account) {
        JSONObject result = new JSONObject();
        PeopleInfo peopleInfo = peopleInfoMapper.selectByPrimaryKey(account);
        result.put("account", peopleInfo.getId());
        result.put("gender", peopleInfo.getGender());
        result.put("status", peopleInfo.getStatus());
        result.put("age", peopleInfo.getAge());
        return result;
    }

    @Override
    public boolean changePassword(int account, String oldPassword, String newPassword) {
        PeopleInfo peopleInfo=peopleInfoMapper.selectByPrimaryKey(account);
        if (peopleInfo.getPassword().equals(oldPassword)) {
            peopleInfo.setPassword(newPassword);
            peopleInfoMapper.updateByPrimaryKey(peopleInfo);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean changeInfo(PeopleInfo peopleInfo) {
        peopleInfoMapper.updateByPrimaryKeySelective(peopleInfo);
        return true;

    }

    @Override
    public boolean changePreference(JSONObject jsonObject) {
        try {
            PeopleProfiles peopleProfiles = new PeopleProfiles();
            peopleProfiles.setId(jsonObject.getInt("account"));
            peopleProfiles.setBrand(jsonObject.getInt("brand")+1);
            peopleProfiles.setPrice(jsonObject.getInt("price")+1);
            peopleProfiles.setSize(jsonObject.getInt("size")+1);
            peopleProfiles.setRam(jsonObject.getInt("ram")+1);
            peopleProfiles.setPixel(jsonObject.getInt("pixel")+1);
            peopleProfiles.setRom(jsonObject.getInt("rom")+1);
            peopleProfiles.setCpu(jsonObject.getInt("cpu")+1);
            peopleProfiles.setTotal(jsonObject.getInt("total")+7);
            peopleProfilesMapper.updatePreference(peopleProfiles);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public JSONObject getPreference(int account) {
        JSONObject result = new JSONObject();
        PeopleProfiles peopleProfiles = peopleProfilesMapper.selectByPrimaryKey(account);
        result.put("brand", peopleProfiles.getBrand()-1);
        result.put("price", peopleProfiles.getPrice()-1);
        result.put("size", peopleProfiles.getSize()-1);
        result.put("ram", peopleProfiles.getRam()-1);
        result.put("pixel", peopleProfiles.getPixel()-1);
        result.put("rom", peopleProfiles.getRom()-1);
        result.put("cpu", peopleProfiles.getCpu()-1);
        return result;
    }
}
