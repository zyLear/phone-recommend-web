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
    <title>phone info</title>
    <script src="${pageContext.request.contextPath}/Bootstrap3/js/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Bootstrap3/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Bootstrap3/css/bootstrap-theme.min.css"/>
    <script src="${pageContext.request.contextPath}/Bootstrap3/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/javascript/myJavaScript.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container-fluid">


    <div class="row">

        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <%-- <span class="navbar-brand" style="padding:20px;">
                         Search   btn btn-success
                     </span>--%>
                    <span class="navbar-brand" style="padding-top:10px; width: 80%;">
                        <table style="margin-left: 30px; padding: 0px;">
                            <tr>
                                <td><input id="searchText" type="text" class="form-control" placeholder="Input Something..."/></td>
                                <td><button id="search" class="label label-default" style="font-size: 22px; ">Search</button></td>
                            </tr>
                        </table>
                    </span>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <div class="nav navbar-nav" >
                        <table style="margin-left: 20px;">
                            <tr>
                                <th >价格区间：</th>
                                <td width="50px;">
                                    <input id="startPrice" type="text" class="form-control" style="padding:5px 6px;height: 100%;" placeholder="￥"/>
                                </td>
                                <td>
                                    --
                                </td>
                                <td width="50px;">
                                    <input id="endPrice" type="text" class="form-control" style="padding:5px 6px;height: 100%;" placeholder="￥"/>
                                </td>
                                
                            </tr>
                        </table>
                    </div>

                    <div class="nav navbar-nav" >
                        <table style="margin-left: 20px;">
                            <tr>
                                <th>手机品牌：</th>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border">苹果</div>
                                </td>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border">小米</div>
                                </td>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border">荣耀</div>
                                </td>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border">三星</div>
                                </td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border">魅族</div>
                                </td>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border">华为</div>
                                </td>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border">OPPO</div>
                                </td>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border">VIVO</div>
                                </td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border">诺基亚</div>
                                </td>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border">乐视</div>
                                </td>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border">其他</div>
                                </td>
                            </tr>
                        </table>
                    </div>


                    <div class="nav navbar-nav" >
                        <table style="margin-left: 20px;">
                            <tr>
                                <th>屏幕尺寸：</th>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border">3.0以下</div>
                                </td>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border">3.0-4.5</div>
                                </td>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border">4.6-5.0</div>
                                </td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border">5.1-5.5</div>
                                </td>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border">5.5以上</div>
                                </td>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border">其他</div>
                                </td>
                            </tr>
                        </table>
                    </div>

                    <div class="nav navbar-nav">
                        <table style="margin-left: 20px;">
                            <tr>
                                <th>运行内存：</th>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border">2G</div>
                                </td>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border">3G</div>
                                </td>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border">4G</div>
                                </td>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border">6G</div>
                                </td>
                                <%--<td>--%>
                                    <%--<div name="myBtn"  class="my-button btn-sm btn-old-border">8G</div>--%>
                                <%--</td>--%>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border">其他</div>
                                </td>
                            </tr>
                        </table>
                    </div>

                    <div class="nav navbar-nav">
                        <table style="margin-left: 20px;">
                            <tr>
                                <th>相机像素：</th>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border">小于500</div>
                                </td>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border">500-1000</div>
                                </td>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border">1001-1600</div>
                                </td>

                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border">1600以上</div>
                                </td>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border">其他</div>
                                </td>
                            </tr>
                        </table>
                    </div>

                    <div class="nav navbar-nav">
                        <table style="margin-left: 20px;">
                            <tr>
                                <th>机身内存：</th>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border">8G</div>
                                </td>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border">16G</div>
                                </td>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border">32G</div>
                                </td>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border">64G</div>
                                </td>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border">128G</div>
                                </td>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border">其他</div>
                                </td>
                            </tr>
                        </table>
                    </div>

                    <div class="nav navbar-nav">
                        <table style="margin-left: 20px;">
                            <tr>
                                <th>CPU核数：</th>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border" >单核</div>
                                </td>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border">双核</div>
                                </td>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border">四核</div>
                                </td>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border">八核</div>
                                </td>
                                <td>
                                    <div name="myBtn"  class="my-button btn-sm btn-old-border">其他</div>
                                </td>
                                <%--<td>--%>
                                    <%--<div name="myBtn"  class="my-button btn-sm btn-old-border">其他</div>--%>
                                <%--</td>--%>
                            </tr>
                        </table>
                    </div>

                    <div class="nav navbar-nav">
                        <table style="margin-left: 20px;">
                            <tr>
                                <th>排序方式：</th>
                                <td>
                                    <div id="count"  class="my-button btn-sm btn-border" >点击量</div>
                                </td>
                                <td>
                                    <div id="priceAsc"  class="my-button btn-sm btn-old-border">价格低到高</div>
                                </td>
                                <td>
                                    <div id="priceDesc" class="my-button btn-sm btn-old-border">价格高到低</div>
                                </td>
                                <%--<td>--%>
                                    <%--<div id="costPerformance"  class="my-button btn-sm btn-old-border">性价比</div>--%>
                                <%--</td>--%>
                            </tr>
                        </table>
                    </div>


                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
    </div>


    <div id="myId" myId="${param.peopleId}" class="row" style="height: 55px;">
        <div class="col-xs-3 c">sdf</div>
        <div class="col-xs-6 c">
            IntelliJ IDEA 可以
        </div>
        <div class="col-xs-3 c">sdf</div>
    </div>

    <div class="row">
        <div class="col-xs-12">
            <div class="list-group" id="phoneInfoItems">
                <%--class="list-group-item-text"  --%>
                <c:forEach var="phoneInfo" items="${ phoneInfos }">
                    <a class="list-group-item myItem" href="${ phoneInfo.link}" phoneId="${phoneInfo.id}">
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
                <button id="allPhoneLoadMore" type="button" class="btn btn-info btn-lg btn-block">加载更多...</button>
            </div>


        </div>
    </div>
</div>

<!-- Small modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-sm"
        style=" display: none;">Small modal
</button>

<%--<div class="modal bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">--%>
    <%--<div class="modal-dialog modal-sm" role="document">--%>
        <%--<div class="modal-content">--%>
            <%--正在加载.........--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>


<div id="modal" class="modal bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
    <div class="modal-dialog modal-sm" role="document">

        <div class="modal-content" style="width: 75%; text-align: center; margin: 0 auto; width: 300px;">
            <div class="modal-header" style="font-size: 17px;">你是否想要</div>
            <div class="modal-body">
                <button id="like" type="button" class="btn btn-info" style="width: 45%; font-size: 20px; margin-right: 5px;">\^o^/<br>添加收藏</button>

                <!-- Indicates caution should be taken with this action -->

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
