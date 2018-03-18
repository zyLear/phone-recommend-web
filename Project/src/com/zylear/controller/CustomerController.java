package com.zylear.controller;

import com.zylear.service.CustomerService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2017/6/5.
 */

@Controller
public class CustomerController {



    //private String translation;

    @Resource
    private CustomerService customerService;



    @RequestMapping("/show_phone_info")
    public ModelAndView showPhoneInfo() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("show_phone_info");

//        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
//        ac.getBean("customer");
//        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
//        ac.getBean("customerService");
//        List<PhoneInfo> phoneInfos= customerService.getPhoneInfo();
        mav.addObject("phoneInfos", customerService.getPhoneInfo());
        return mav;
    }

    @RequestMapping("findPhoneInfoBySelect")
    public void findPhoneInfoBySelect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out=response.getWriter();
        String translation = null;
        try {
            translation = request.getParameter("translation");
            JSONObject resultJSON=customerService.findPhoneInfoBySelect(JSONObject.fromObject(translation));
            out.print(resultJSON);
        } catch (Exception e) {
            e.printStackTrace();
            out.print("failure");
        } finally{
            out.close();
        }
    }


    @RequestMapping("getPhoneInfoByPage")
    public void getPhoneInfoByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        try {
            int page = Integer.parseInt(request.getParameter("page"));
            System.out.println("页面的的的的的：" + page);
            JSONObject resultJSON = customerService.getPhoneInfoByPage(page);
            out.print(resultJSON);
        } catch (Exception e) {
            out.print("fail");
        } finally {
            out.close();
        }
    }


    @RequestMapping("recommend")
    public ModelAndView recommend(HttpServletRequest request) {
        int peopleId=1;
        try {
            peopleId = Integer.parseInt(request.getParameter("peopleId"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        ModelAndView mav = new ModelAndView();
        mav.setViewName("recommend");
        mav.addObject("phoneInfos",customerService.getRecommendPhoneInfos(peopleId));
        return mav;
    }

    @RequestMapping("getRecommendPhoneInfoByPage")
    public void getRecommendPhoneInfoByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        try {
            int peopleId = Integer.parseInt(request.getParameter("peopleId"));
            int page = Integer.parseInt(request.getParameter("page"));
            System.out.println("recommend"+peopleId+"  page  "+page);
            JSONObject resultJSON = customerService.getRecommendPhoneInfoByPage(peopleId,page);
            out.print(resultJSON);
        } catch (Exception e) {
            out.print("fail");
        } finally {
            out.close();
        }
    }

    @RequestMapping("changePeopleProfiles")
    public void changePeopleProfiles(HttpServletRequest request,HttpServletResponse response) throws IOException {
        try {
            int peopleId = Integer.parseInt(request.getParameter("peopleId"));
            int phoneId = Integer.parseInt(request.getParameter("phoneId"));
            customerService.changePeopleProfiles(peopleId,phoneId,1,true);
            System.out.println("即将进入改变phoneCount");
            customerService.addPhoneCount(phoneId);
            System.out.println("改变phoneCount结束");
            response.getWriter().print("succeed");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().print("fail");
        }
    }

    @RequestMapping("like")
    public void like(HttpServletRequest request,HttpServletResponse response)throws IOException {
        PrintWriter out=response.getWriter();
        try {
            int peopleId = Integer.parseInt(request.getParameter("peopleId"));
            int phoneId = Integer.parseInt(request.getParameter("phoneId"));
            System.out.println("ppppppppppppppppp"+peopleId+"   " + phoneId);
            if(customerService.like(peopleId,phoneId)){
                out.print("success");
            }else{
                out.print("fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.print("fail");
        }finally{
            out.close();
        }
    }

    @RequestMapping("dislike")
    public void disLike(HttpServletRequest request,HttpServletResponse response)throws IOException {
        try {
            int peopleId = Integer.parseInt(request.getParameter("peopleId"));
            int phoneId = Integer.parseInt(request.getParameter("phoneId"));
            customerService.dislike(peopleId,phoneId);
            response.getWriter().print("success");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().print("failure");
        }
    }

    @RequestMapping("removeLike")
    public void removeLike(HttpServletRequest request,HttpServletResponse response)throws IOException {
        try {
            int peopleId = Integer.parseInt(request.getParameter("peopleId"));
            int phoneId = Integer.parseInt(request.getParameter("phoneId"));
            if(customerService.removeLike(peopleId,phoneId)) {
                response.getWriter().print("success");
            }else {
                response.getWriter().print("failure");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().print("failure");
        }
    }

    @RequestMapping("/people_like")
    public ModelAndView peopleLike(HttpServletRequest request) {
        int peopleId=1;
        try {
            peopleId = Integer.parseInt(request.getParameter("peopleId"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        ModelAndView mav = new ModelAndView();
        mav.setViewName("people_like");
        mav.addObject("phoneInfos",customerService.peopleLike(peopleId));
        return mav;
    }




    //getPersonalInfo


    //
//    public String getTranslation() {
//        return translation;
//    }
}
