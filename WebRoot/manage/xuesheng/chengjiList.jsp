<%@page import="cn.jiaowu.util.Const"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>成绩管理</title>
  <meta name="description" content="">
  <meta name="keywords" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="<%=Const.ROOT%>assets/i/favicon.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="<%=Const.ROOT%>assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="<%=Const.ROOT%>assets/css/admin.css">
  <script src="<%=Const.ROOT%>My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<%@include file="../top.jsp" %>

<div class="am-cf admin-main">
  <!-- sidebar start -->
  <%@include file="../sidebar.jsp" %>
  <!-- sidebar end -->

  <!-- content start -->
  <div class="admin-content">
    <div class="admin-content-body">
      <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">首页</strong> / <small>成绩管理</small></div>
      </div>
      <hr>
      <div class="am-g">
        <div class="am-u-sm-12 am-u-md-12">
            	<form class="am-form-inline" action="<%=Const.ROOT%>chengji/list" method="post" id="searchForm">
					课程名称:<select name="kechengid" id="kechengid1" required>
					</select>	
					<button type="submit" class="am-btn am-btn-default am-btn-sm">
		              	<span class="am-icon-search"></span> 查询
		            </button>
	             </form>
            </div>
         
      </div>

      <div class="am-g">
        <div class="am-u-sm-12">
            <table class="am-table am-table-striped am-table-hover table-main">
              <thead>
              <tr>
                <th class="table-id">编号</th>
                <th class="table-title">学生名称</th>
                <th class="table-title">课程名称</th>
                <th class="table-title">考试时间</th>
                <th class="table-title">考试成绩</th>
              </tr>
              </thead>
              <tbody>
              <c:forEach items="${requestScope.list}" var="chengji" varStatus="st">
              <!-- 循环开始 -->
              <tr>
                <td>${st.count}</td>
                <td>${chengji.xsxm}</td>
                <td>${chengji.kcmc}</td>
                <td>${chengji.kaoshishi}</td>
                <td>${chengji.fenshu}</td>
              </tr>
              <!-- 循环结束 -->
              </c:forEach> 
              </tbody>
            </table>
        </div>
      </div>
    </div>
    <%@include file="../footer.jsp" %>
  </div>
  <!-- content end -->
</div>

<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->
<!--<![endif]-->
	<script src="<%=Const.ROOT%>assets/js/jquery.min.js"></script>
	<script src="<%=Const.ROOT%>assets/js/amazeui.min.js"></script>
	<script src="<%=Const.ROOT%>assets/js/app.js"></script>
<script>
$(function(){
	loadKecheng("kechengid1");
});
//加载课程列表
function loadKecheng(domid){
	$.getJSON("<%=Const.ROOT%>kecheng/listJson",{"zhuanyeid":'${sessionScope.currentUser.zhuanyeid}'},function(data){
		if(data.status==0){
			$("#"+domid).html("<option value='0'>请选择课程</option>");
			$.each(data.data,function(index,kecheng){
				$("#"+domid).append("<option value='"+kecheng.id+"'>"+kecheng.mingcheng+"</option>");
			});
		}
	});
}
</script>
</body>
</html>
