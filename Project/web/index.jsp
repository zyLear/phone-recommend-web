<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/5
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <script>
        function changePeopleProfiles(peopleId, phoneId) {
            $.post("changePeopleProfiles.do", {"peopleId": peopleId, "phoneId": phoneId}, function (data,status) {
                alert(data);
            })
        }
    </script>

    <title>手机信息</title>
    <script src="${pageContext.request.contextPath}/Bootstrap3/js/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Bootstrap3/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Bootstrap3/css/bootstrap-theme.min.css"/>
    <script src="${pageContext.request.contextPath}/Bootstrap3/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body style="text-align: center">
<div style="margin-top: 200px; font-size: 20px;">
<a href="show_phone_info.do?peopleId=1">all</a><br>
<%--<a href="getPhoneInfoByPage.do?page=2">分页</a><br>--%>
<a href="recommend.do?peopleId=1">recommend</a><br>
<a href="people_like.do?peopleId=1">like</a>

<%--<button  onclick="changePeopleProfiles(1,17980)"> changePeopleProfiles </button>--%>
</div>


<%--

Java -jar mybatis-generator-core-1.3.2.jar -configfile generatorConfig.xml -overwrite

--%>

</body>
</html>
