<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js fixed-layout">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>后台管理系统</title>
  <meta name="description" content="这是一个 index 页面">
  <meta name="keywords" content="index">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="<%=Const.ROOT %>assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="<%=Const.ROOT %>assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="<%=Const.ROOT %>assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="<%=Const.ROOT %>assets/css/admin.css">
</head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

<%@include file="top.jsp" %>

<div class="am-cf admin-main">
  <!-- sidebar start -->
 <%@include file="sidebar.jsp" %>
  <!-- sidebar end -->

  <!-- content start -->
  <div class="admin-content">
    <div class="admin-content-body">
      <div class="am-cf am-padding">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">首页</strong></div>
      </div>
      	<div class="am-g">
		  <div class="am-u-sm-8 am-u-lg-centered"><h2>欢迎使用教务管理系统</h2></div>
		</div>
		  <div class="am-u-sm-8 am-u-lg-centered" style="text-align:center;"><h3>最新公告</h3></div>
		<!-- 公告折叠开始 -->
		<div class="am-panel-group  am-u-sm-8 am-u-lg-centered" id="accordion">
		  <c:forEach items="${sessionScope.gonggaos}" var="gonggao" varStatus="st">
		  <div class="am-panel am-panel-default">
		    <div class="am-panel-hd">
		      <h4 class="am-panel-title am-g" data-am-collapse="{parent: '#accordion', target: '#do-not-say-${st.count}'}">
			    <div class="am-u-sm-8">${st.count}.${gonggao.title}</div>
			    <div class="am-u-sm-4">${gonggao.addtime}</div>
		      </h4>
		    </div>
		    <div id="do-not-say-${st.count}" class="am-panel-collapse am-collapse <c:if test="${st.count==1}">am-in</c:if>">
		      <div class="am-panel-bd">
		        ${gonggao.content }
		      </div>
		    </div>
		  </div>		
		</c:forEach>
		</div>
	<!-- 公告折叠结束 -->
    </div>

    <%@include file="footer.jsp" %>
  </div>
  <!-- content end -->
</div>

<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="<%=Const.ROOT %>assets/js/jquery.min.js"></script>
<!--<![endif]-->
<script src="<%=Const.ROOT %>assets/js/amazeui.min.js"></script>
<script src="<%=Const.ROOT %>assets/js/app.js"></script>
</body>
</html>
