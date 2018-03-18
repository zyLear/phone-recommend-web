package com.zylear.controller;

import com.zylear.model.PeopleInfo;
import com.zylear.service.PersonalService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2017/8/8.
 */
@Controller
public class PersonalController {

    @Resource
    private PersonalService personalService;

    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        System.out.println("login");
        try {
            int account=Integer.parseInt(request.getParameter("account"));
            String password = request.getParameter("password");
            if (personalService.login(account, password)) {
                out.print("ok");
            }else {
                out.print("error");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.print("error");
        } finally{
            out.flush();
            out.close();
        }
    }

    @RequestMapping("register")
    public void register(HttpServletRequest request,HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        try {
            int account=Integer.parseInt(request.getParameter("account"));
            String password = request.getParameter("password");
            String status = request.getParameter("status");
            int age=Integer.parseInt(request.getParameter("age"));
            String gender = request.getParameter("gender");
            if (personalService.register(new PeopleInfo(account, password,gender,age,status))) {
                out.print("ok");
            }else {
                out.print("error");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.print("error");
        } finally{
            out.flush();
            out.close();
        }
    }


    @RequestMapping("getPersonalInfo")
    public void getPersonalInfo(HttpServletRequest request,HttpServletResponse response)throws IOException {
        try {
            int account = Integer.parseInt(request.getParameter("account"));
            JSONObject result=personalService.getPersonalInfo(account);
            response.getWriter().print(result);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().print("error");
        }
    }

    @RequestMapping("changePassword")
    public void changePassword(HttpServletRequest request,HttpServletResponse response)throws IOException {
        PrintWriter out = response.getWriter();
        try {
            int account = Integer.parseInt(request.getParameter("account"));
            String oldPassword = request.getParameter("oldPassword");
            String newPassword = request.getParameter("newPassword");
            System.out.println(account+"   "+oldPassword+"   "+newPassword);
            if(personalService.changePassword(account,oldPassword,newPassword)){
                out.print("ok");
            }else{
                out.print("failure");
            }
            // System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
            out.print("failure");
        }
    }

    @RequestMapping("changeInfo")
    public void changeInfo(HttpServletRequest request,HttpServletResponse response)throws IOException {
        PrintWriter out = response.getWriter();
        try {
            int account = Integer.parseInt(request.getParameter("account"));
            int age = Integer.parseInt(request.getParameter("age"));
            String gender = request.getParameter("gender");
            String status = request.getParameter("status");
            //System.out.println("info"+"   "+gender+"   "+status);
            if(personalService.changeInfo(new PeopleInfo(account,age,gender,status))){
                out.print("ok");
            }else{
                out.print("failure");
            }
            // System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
            out.print("failure");
        }
    }

    @RequestMapping("getPreference")
    public void getPreference(HttpServletRequest request,HttpServletResponse response)throws IOException {
        try {
            int account = Integer.parseInt(request.getParameter("account"));
            JSONObject result=personalService.getPreference(account);
            response.getWriter().print(result);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().print("error");
        }
    }

    @RequestMapping("changePreference")
    public void changePreference(HttpServletRequest request,HttpServletResponse response)throws IOException {
        PrintWriter out = response.getWriter();
        System.out.println("changechange  "+request.getParameter("preference"));
        try {
            JSONObject jsonObject = JSONObject.fromObject(request.getParameter("preference"));
            if(personalService.changePreference(jsonObject)){
                out.print("ok");
            }else{
                out.print("failure");
            }
            // System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
            out.print("failure");
        }
    }
}
