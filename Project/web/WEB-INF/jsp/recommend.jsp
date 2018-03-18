<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/5
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>phone recommend</title>
    <script src="${pageContext.request.contextPath}/Bootstrap3/js/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Bootstrap3/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Bootstrap3/css/bootstrap-theme.min.css"/>
    <script src="${pageContext.request.contextPath}/Bootstrap3/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/javascript/recommend.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container-fluid">


    <div id="myId" myId="${param.peopleId}" class="row my-top"  style="font-size: 30px; text-align: center; background-color: #2aabd2;padding: 7px;">
        猜你喜欢♥
    </div>
    <div class="row" style="height: 55px;">

    </div>


    <%--<div class="row" style="height: 60px;">--%>
        <%--<div class="col-xs-3 c">sdf</div>--%>
        <%--<div class="col-xs-6 c">--%>
            <%--IntelliJ IDEA 可以--%>
        <%--</div>--%>
        <%--<div class="col-xs-3 c">sdf</div>--%>
    <%--</div>--%>

    <div class="row">
        <div class="col-xs-12">
            <div class="list-group" id="phoneInfoItems">
                <%--class="list-group-item-text"  --%>
                <c:forEach var="phoneInfo" items="${ phoneInfos }">
                    <a class="list-group-item myItem" href="${ phoneInfo.link}" phoneId="${ phoneInfo.id }">
                        <div class="row">
                            <div class="col-xs-3">
                                <div style="margin-top: 15px;margin-bottom: 15px;">
                                    <img src="${ phoneInfo.img }"
                                         alt="<%--${ phoneInfo.title }--%>" class="img-rounded">
                                </div>
                            </div>
                            <div class="col-xs-9">
                                <h5 class="list-group-item-heading">${ phoneInfo.title }</h5>

                                <h5 style="color: red;margin: 3px;">${ phoneInfo.price }￥</h5>
                                <table class="show-table" style=" width: 100%;table-layout: fixed; font-size: 12px;">
                                    <tr>
                                        <th>品牌:</th>
                                        <td>${ phoneInfo.brand }</td>
                                        <th>尺寸:</th>
                                        <td>${ phoneInfo.size }</td>
                                    </tr>
                                    <tr>
                                        <th>运行内存:</th>
                                        <td>${ phoneInfo.ram }</td>
                                        <th>像素:</th>
                                        <td>${ phoneInfo.pixel }</td>
                                    </tr>
                                    <tr>
                                        <th>机身内存:</th>
                                        <td>${ phoneInfo.ram }</td>
                                        <th>CPU核数:</th>
                                        <td>${ phoneInfo.cpu }</td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </a>

                </c:forEach>


            </div>
            <div>
                <button id="recommendLoadMore" type="button" class="btn btn-info btn-lg btn-block">加载更多...</button>
            </div>

        </div>
    </div>
</div>

<!-- Small modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-sm"
        style=" display: none;">Small modal
</button>

<div id="modal" class="modal bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
    <div class="modal-dialog modal-sm" role="document">

        <div class="modal-content" style="width: 75%; text-align: center; margin: 0 auto; width: 300px;">
            <div class="modal-header" style="font-size: 17px;">你是否想要</div>
            <div class="modal-body">
                <button<%-- data-dismiss="modal"--%> id="like" type="button" class="btn btn-info" style="width: 45%; font-size: 20px; margin-right: 5px;">\^o^/<br>添加收藏</button>

                <!-- Indicates caution should be taken with this action -->
                <button data-dismiss="modal" id="dislike" type="button" class="btn btn-warning" style="width: 45%; font-size: 20px; margin-left: 5px;">＞﹏＜<br>不看这个</button>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal" >返回</button>
            </div>
        </div>

    </div>
</div>

<div id="message" class="modal bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
    <div class="modal-dialog modal-sm" role="document">

        <div class="modal-content" style="width: 75%; text-align: center; margin: 0 auto; width: 300px;">
            <div class="modal-header" style="font-size: 17px;">通知</div>
            <div class="modal-body" style="padding: 20px;">
                <div id="info" style="margin: 0 auto;  font-size: 25px;  ">\^o^/</div>


            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal" >返回</button>
            </div>
        </div>

    </div>
</div>

</body>
</html>
