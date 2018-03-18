package com.zylear.service.impl;

import com.zylear.dao.*;
import com.zylear.model.*;
import com.zylear.service.CustomerService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/6/5.
 */

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private PhoneInfoMapper phoneInfoMapper;
    @Resource
    private PeopleProfilesMapper peopleProfilesMapper;
    @Resource
    private PhoneProfilesMapper phoneProfilesMapper;
    @Resource
    private PeopleLikeMapper peopleLikeMapper;
    @Resource
    private PeopleDislikeMapper peopleDislikeMapper;


    //以下这个基本上是旧的
    @Override
    public List<PhoneInfo> getPhoneInfo() {

        List<PhoneInfo> a=phoneInfoMapper.getPhoneInfo();
        return phoneInfoMapper.getPhoneInfo();
    }

    @Override
    public List<PhoneInfo> TestPage(int page) {
        JSONObject jsonObject=new JSONObject();
        return phoneInfoMapper.getPhoneInfoByPage((page-1)*10);
    }


    //旧
    @Override
    public JSONObject getPhoneInfoByPage(int page){
        JSONObject resultJson=new JSONObject();
        JSONArray jsonArray=new JSONArray();
        List<PhoneInfo> list=phoneInfoMapper.getPhoneInfoByPage((page-1)*20);
        for (PhoneInfo phoneInfo : list) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id",phoneInfo.getId());
            jsonObject.put("img",phoneInfo.getImg());
            jsonObject.put("link",phoneInfo.getLink());
            jsonObject.put("price",phoneInfo.getPrice());
            jsonObject.put("source",phoneInfo.getSource());
            jsonObject.put("title",phoneInfo.getTitle());
            jsonObject.put("brand", phoneInfo.getBrand());
            jsonObject.put("size", phoneInfo.getSize());
            jsonObject.put("ram", phoneInfo.getRam());
            jsonObject.put("pixel", phoneInfo.getPixel());
            jsonObject.put("rom", phoneInfo.getRom());
            jsonObject.put("cpu", phoneInfo.getCpu());

            jsonArray.add(jsonObject);
        }
        resultJson.put("phoneInfos", jsonArray);
        return resultJson;
    }



    @Override
    public void addPhoneCount(int phoneId) {
        phoneProfilesMapper.addPhoneCount(phoneId);
    }

    @Override
    public void changePeopleProfiles(int peopleId, int phoneId,int number,boolean isLike) {
        PeopleProfiles peopleProfiles = peopleProfilesMapper.selectByPrimaryKey(peopleId);
        PhoneProfiles phoneProfiles = phoneProfilesMapper.selectByPrimaryKey(phoneId);
        System.out.println("+11111"+peopleId+"   "+phoneId);
        long count=peopleProfiles.getCount();

        if (!isLike) {
            phoneProfiles.changeProfiles();
        }

        peopleProfiles.setBrandApple((count*peopleProfiles.getBrandApple()+number*phoneProfiles.getBrandApple())/(count+number));
        peopleProfiles.setBrandMi((count*peopleProfiles.getBrandMi()+number*phoneProfiles.getBrandMi())/(count+number));
        peopleProfiles.setBrandHonor((count*peopleProfiles.getBrandHonor()+number*phoneProfiles.getBrandHonor())/(count+number));
        peopleProfiles.setBrandSamsung((count*peopleProfiles.getBrandSamsung()+number*phoneProfiles.getBrandSamsung())/(count+number));
        peopleProfiles.setBrandMeizu((count*peopleProfiles.getBrandMeizu()+number*phoneProfiles.getBrandMeizu())/(count+number));
        peopleProfiles.setBrandHuawei((count*peopleProfiles.getBrandHuawei()+number*phoneProfiles.getBrandHuawei())/(count+number));
        peopleProfiles.setBrandOppo((count*peopleProfiles.getBrandOppo()+number*phoneProfiles.getBrandOppo())/(count+number));
        peopleProfiles.setBrandVivo((count*peopleProfiles.getBrandVivo()+number*phoneProfiles.getBrandVivo())/(count+number));
        peopleProfiles.setBrandNokia((count*peopleProfiles.getBrandNokia()+number*phoneProfiles.getBrandNokia())/(count+number));
        peopleProfiles.setBrandLetv((count*peopleProfiles.getBrandLetv()+number*phoneProfiles.getBrandLetv())/(count+number));
        peopleProfiles.setBrandOther((count*peopleProfiles.getBrandOther()+number*phoneProfiles.getBrandOther())/(count+number));

        peopleProfiles.setPriceLess400((count*peopleProfiles.getPriceLess400()+number*phoneProfiles.getPriceLess400())/(count+number));
        peopleProfiles.setPrice400to1000((count*peopleProfiles.getPrice400to1000()+number*phoneProfiles.getPrice400to1000())/(count+number));
        peopleProfiles.setPrice1001to1700((count*peopleProfiles.getPrice1001to1700()+number*phoneProfiles.getPrice1001to1700())/(count+number));
        peopleProfiles.setPrice1701to2800((count*peopleProfiles.getPrice1701to2800()+number*phoneProfiles.getPrice1701to2800())/(count+number));
        peopleProfiles.setPrice2801to4500((count*peopleProfiles.getPrice2801to4500()+number*phoneProfiles.getPrice2801to4500())/(count+number));
        peopleProfiles.setPriceGreater4500((count*peopleProfiles.getPriceGreater4500()+number*phoneProfiles.getPriceGreater4500())/(count+number));

        peopleProfiles.setSizeLess3p0((count*peopleProfiles.getSizeLess3p0()+number*phoneProfiles.getSizeLess3p0())/(count+number));
        peopleProfiles.setSize3p0to4p5((count*peopleProfiles.getSize3p0to4p5()+number*phoneProfiles.getSize3p0to4p5())/(count+number));
        peopleProfiles.setSize4p6to5p0((count*peopleProfiles.getSize4p6to5p0()+number*phoneProfiles.getSize4p6to5p0())/(count+number));
        peopleProfiles.setSize5p1to5p5((count*peopleProfiles.getSize5p1to5p5()+number*phoneProfiles.getSize5p1to5p5())/(count+number));
        peopleProfiles.setSizeGreater5p5((count*peopleProfiles.getSizeGreater5p5()+number*phoneProfiles.getSizeGreater5p5())/(count+number));
        peopleProfiles.setSizeOther((count*peopleProfiles.getSizeOther()+number*phoneProfiles.getSizeOther())/(count+number));

        peopleProfiles.setRam2((count*peopleProfiles.getRam2()+number*phoneProfiles.getRam2())/(count+number));
        peopleProfiles.setRam3((count*peopleProfiles.getRam3()+number*phoneProfiles.getRam3())/(count+number));
        peopleProfiles.setRam4((count*peopleProfiles.getRam4()+number*phoneProfiles.getRam4())/(count+number));
        peopleProfiles.setRam6((count*peopleProfiles.getRam6()+number*phoneProfiles.getRam6())/(count+number));
        peopleProfiles.setRamOther((count*peopleProfiles.getRamOther()+number*phoneProfiles.getRamOther())/(count+number));

        peopleProfiles.setPixelLess500((count*peopleProfiles.getPixelLess500()+number*phoneProfiles.getPixelLess500())/(count+number));
        peopleProfiles.setPixel500to1000((count*peopleProfiles.getPixel500to1000()+number*phoneProfiles.getPixel500to1000())/(count+number));
        peopleProfiles.setPixel1001to1600((count*peopleProfiles.getPixel1001to1600()+number*phoneProfiles.getPixel1001to1600())/(count+number));
        peopleProfiles.setPixelGreater1600((count*peopleProfiles.getPixelGreater1600()+number*phoneProfiles.getPixelGreater1600())/(count+number));
        peopleProfiles.setPixelOther((count*peopleProfiles.getPixelOther()+number*phoneProfiles.getPixelOther())/(count+number));

        peopleProfiles.setRom8((count*peopleProfiles.getRom8()+number*phoneProfiles.getRom8())/(count+number));
        peopleProfiles.setRom16((count*peopleProfiles.getRom16()+number*phoneProfiles.getRom16())/(count+number));
        peopleProfiles.setRom32((count*peopleProfiles.getRom32()+number*phoneProfiles.getRom32())/(count+number));
        peopleProfiles.setRom64((count*peopleProfiles.getRom64()+number*phoneProfiles.getRom64())/(count+number));
        peopleProfiles.setRom128((count*peopleProfiles.getRom128()+number*phoneProfiles.getRom128())/(count+number));
        peopleProfiles.setRomOther((count*peopleProfiles.getRomOther()+number*phoneProfiles.getRomOther())/(count+number));

        peopleProfiles.setCpu1((count*peopleProfiles.getCpu1()+number*phoneProfiles.getCpu1())/(count+number));
        peopleProfiles.setCpu2((count*peopleProfiles.getCpu2()+number*phoneProfiles.getCpu2())/(count+number));
        peopleProfiles.setCpu4((count*peopleProfiles.getCpu4()+number*phoneProfiles.getCpu4())/(count+number));
        peopleProfiles.setCpu6((count*peopleProfiles.getCpu6()+number*phoneProfiles.getCpu6())/(count+number));
        peopleProfiles.setCpu8((count*peopleProfiles.getCpu8()+number*phoneProfiles.getCpu8())/(count+number));
        peopleProfiles.setCpuOther((count*peopleProfiles.getCpuOther()+number*phoneProfiles.getCpuOther())/(count+number));

        peopleProfiles.setCount((count+number));

        peopleProfilesMapper.updateProfiles(peopleProfiles);
        System.out.println("look +++++++++++++++");
    }


    @Override
    public List<PhoneInfo> getRecommendPhoneInfos(int peopleId) {
        double time=System.currentTimeMillis();
        PeopleProfiles peopleProfiles = peopleProfilesMapper.selectByPrimaryKey(peopleId);
        peopleProfiles.setPage(0);
        List<PhoneInfo> phoneInfoList = phoneProfilesMapper.recommendation(peopleProfiles);
        System.out.println("用时："+(System.currentTimeMillis()-time)/1000.0+"秒");

//        List<PhoneInfo> recommendPhoneInfos = new ArrayList<>();
//        for (PhoneInfo phoneInfo : phoneInfoList) {
//            recommendPhoneInfos.add(phoneInfo);
//        }
        return phoneInfoList;
    }

    @Override
    public JSONObject getRecommendPhoneInfoByPage(int peopleId, int page) {
        JSONObject resultJson=new JSONObject();
        JSONArray jsonArray=new JSONArray();
        PeopleProfiles peopleProfiles = peopleProfilesMapper.selectByPrimaryKey(peopleId);
        peopleProfiles.setPage((page-1)*20);
        List<PhoneInfo> PhoneInfolist = phoneProfilesMapper.recommendation(peopleProfiles);

        for (PhoneInfo phoneInfo : PhoneInfolist) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id",phoneInfo.getId());
            jsonObject.put("img",phoneInfo.getImg());
            jsonObject.put("link",phoneInfo.getLink());
            jsonObject.put("price",phoneInfo.getPrice());
            jsonObject.put("source",phoneInfo.getSource());
            jsonObject.put("title",phoneInfo.getTitle());
            jsonObject.put("brand", phoneInfo.getBrand());
            jsonObject.put("size", phoneInfo.getSize());
            jsonObject.put("ram", phoneInfo.getRam());
            jsonObject.put("pixel", phoneInfo.getPixel());
            jsonObject.put("rom", phoneInfo.getRom());
            jsonObject.put("cpu", phoneInfo.getCpu());

            jsonArray.add(jsonObject);
        }
        resultJson.put("phoneInfos", jsonArray);
        return resultJson;
    }

    @Override
    public boolean like(int peopleId, int phoneId) {

        try {
            peopleLikeMapper.insert(new PeopleLike(peopleId, phoneId));
            System.out.println("插入收藏成功!+"+phoneId+"  "+peopleId);
            changePeopleProfiles(peopleId,phoneId,30,true);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("异常!");
            return false;
        }
        return true;
    }

    @Override
    public boolean dislike(int peopleId, int phoneId) {
        try {
            System.out.println("功!+"+phoneId+"  "+peopleId);
            PeopleDislike peopleDislike=new PeopleDislike();
            peopleDislike.setPeopleId(peopleId);
            peopleDislike.setPhoneId(phoneId);
            peopleDislikeMapper.insert(peopleDislike);
            changePeopleProfiles(peopleId,phoneId,70,false);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("异常!");
            return false;
        }
        return true;
    }

    @Override
    public boolean removeLike(int peopleId, int phoneId) {
        try {
            System.out.println("removeLike!+"+phoneId+"  "+peopleId);
            PeopleLike peopleLike=new PeopleLike();
            peopleLike.setPeopleId(peopleId);
            peopleLike.setPhoneId(phoneId);
            peopleLikeMapper.delete(peopleLike);
            changePeopleProfiles(peopleId,phoneId,30,false);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("异常!");
            return false;
        }
        return true;
    }

    @Override
    public List<PhoneInfo> peopleLike(int peopleId) {
        System.out.println(peopleId);
        System.out.println(peopleLikeMapper.getPhoneInfoByPeopleId(peopleId).size());
        return peopleLikeMapper.getPhoneInfoByPeopleId(peopleId);
    }



    @Override
    public JSONObject findPhoneInfoBySelect(JSONObject jsonObject) {
        JSONObject resultJson=new JSONObject();
        JSONArray jsonArray=new JSONArray();

        long time=System.currentTimeMillis();
        List<PhoneInfo> phoneInfoList = phoneProfilesMapper.searchPhoneInfo(jsonSwitchToPhoneProfiles(jsonObject));
        System.out.println("用时："+(System.currentTimeMillis()-time)/1000.0+"秒");

        for (PhoneInfo phoneInfo : phoneInfoList) {
            JSONObject resultJSON = new JSONObject();
            resultJSON.put("id",phoneInfo.getId());
            resultJSON.put("img",phoneInfo.getImg());
            resultJSON.put("link",phoneInfo.getLink());
            resultJSON.put("price",phoneInfo.getPrice());
            resultJSON.put("source",phoneInfo.getSource());
            resultJSON.put("title",phoneInfo.getTitle());
            resultJSON.put("brand", phoneInfo.getBrand());
            resultJSON.put("size", phoneInfo.getSize());
            resultJSON.put("ram", phoneInfo.getRam());
            resultJSON.put("pixel", phoneInfo.getPixel());
            resultJSON.put("rom", phoneInfo.getRom());
            resultJSON.put("cpu", phoneInfo.getCpu());

            jsonArray.add(resultJSON);
        }
        resultJson.put("phoneInfos", jsonArray);
        return resultJson;
    }




    PhoneProfiles jsonSwitchToPhoneProfiles(JSONObject jsonObject) {
        PhoneProfiles phoneProfiles=new PhoneProfiles();

        int endPrice=jsonObject.getInt("endPrice");
        if (endPrice == 0) {
            endPrice=200000;
        }
        String searchTitle = "%";
        for (String s : jsonObject.getString("searchTitle").split(" ")) {
            if (!"".equals(s)) {
                searchTitle += s + "%";
            }
        }
        System.out.println(searchTitle);
        phoneProfiles.setSearchTitle(searchTitle);
        phoneProfiles.setStartPrice(jsonObject.getInt("startPrice"));
        phoneProfiles.setEndPrice(endPrice);
        phoneProfiles.setCurrentPage((jsonObject.getInt("currentPage")-1)*20);


        phoneProfiles.setBrandApple(jsonObject.getInt("brandApple"));
        phoneProfiles.setBrandMi(jsonObject.getInt("brandMi"));
        phoneProfiles.setBrandHonor(jsonObject.getInt("brandHonor"));
        phoneProfiles.setBrandSamsung(jsonObject.getInt("brandSamsung"));
        phoneProfiles.setBrandMeizu(jsonObject.getInt("brandMeizu"));
        phoneProfiles.setBrandHuawei(jsonObject.getInt("brandHuawei"));
        phoneProfiles.setBrandOppo(jsonObject.getInt("brandOppo"));
        phoneProfiles.setBrandVivo(jsonObject.getInt("brandVivo"));
        phoneProfiles.setBrandNokia(jsonObject.getInt("brandNokia"));
        phoneProfiles.setBrandLetv(jsonObject.getInt("brandLetv"));
        phoneProfiles.setBrandOther(jsonObject.getInt("brandOther"));

        phoneProfiles.setSizeLess3p0(jsonObject.getInt("sizeLess3p0"));
        phoneProfiles.setSize3p0to4p5(jsonObject.getInt("size3p0to4p5"));
        phoneProfiles.setSize4p6to5p0(jsonObject.getInt("size4p6to5p0"));
        phoneProfiles.setSize5p1to5p5(jsonObject.getInt("size5p1to5p5"));
        phoneProfiles.setSizeGreater5p5(jsonObject.getInt("sizeGreater5p5"));
        phoneProfiles.setSizeOther(jsonObject.getInt("sizeOther"));

        phoneProfiles.setRam2(jsonObject.getInt("ram2"));
        phoneProfiles.setRam3(jsonObject.getInt("ram3"));
        phoneProfiles.setRam4(jsonObject.getInt("ram4"));
        phoneProfiles.setRam6(jsonObject.getInt("ram6"));
        phoneProfiles.setRamOther(jsonObject.getInt("ramOther"));

        phoneProfiles.setPixelLess500(jsonObject.getInt("pixelLess500"));
        phoneProfiles.setPixel500to1000(jsonObject.getInt("pixel500to1000"));
        phoneProfiles.setPixel1001to1600(jsonObject.getInt("pixel1001to1600"));
        phoneProfiles.setPixelGreater1600(jsonObject.getInt("pixelGreater1600"));
        phoneProfiles.setPixelOther(jsonObject.getInt("pixelOther"));

        phoneProfiles.setRom8(jsonObject.getInt("rom8"));
        phoneProfiles.setRom16(jsonObject.getInt("rom16"));
        phoneProfiles.setRom32(jsonObject.getInt("rom32"));
        phoneProfiles.setRom64(jsonObject.getInt("rom64"));
        phoneProfiles.setRom128(jsonObject.getInt("rom128"));
        phoneProfiles.setRomOther(jsonObject.getInt("romOther"));

        phoneProfiles.setCpu1(jsonObject.getInt("cpu1"));
        phoneProfiles.setCpu2(jsonObject.getInt("cpu2"));
        phoneProfiles.setCpu4(jsonObject.getInt("cpu4"));
        phoneProfiles.setCpu6(jsonObject.getInt("cpu6"));
        phoneProfiles.setCpu8(jsonObject.getInt("cpu8"));
        phoneProfiles.setCpuOther(jsonObject.getInt("cpuOther"));

        phoneProfiles.setSort(jsonObject.getInt("sort"));

        return phoneProfiles;
    }
}
