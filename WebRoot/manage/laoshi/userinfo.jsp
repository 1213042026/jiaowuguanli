<%@page import="cn.jiaowu.util.Const"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>个人资料修改</title>
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="<%=Const.ROOT%>assets/i/favicon.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="<%=Const.ROOT%>assets/css/amazeui.min.css" />
<link rel="stylesheet" href="<%=Const.ROOT%>assets/css/admin.css">

</head>
<body>
	<%@include file="../top.jsp"%>

	<div class="am-cf admin-main">
		<!-- sidebar start -->
		<%@include file="../sidebar.jsp"%>
		<!-- sidebar end -->

		<!-- content start -->
		<div class="admin-content">
			<div class="admin-content-body">
				<div class="am-cf am-padding am-padding-bottom-0">
					<div class="am-fl am-cf">
						<strong class="am-text-primary am-text-lg">首页</strong> / <small>个人资料查看</small>
					</div>
				</div>
				<hr>

				<div class="am-g">
					<div class="am-u-sm-12">
						<form action="" id="myForm" method="post">
						<input type="hidden" name="id" id="id" value="${sessionScope.currentUser.id}"/>
							<table class="am-table am-table-striped am-table-hover table-main">
								<tr>
									<td>姓名：</td>
									<td><input type="text" name="xingming" id="xingming" value="${sessionScope.currentUser.xingming}" readonly/></td>
								</tr>
								<tr>
									<td>性别：</td>
									<td>
									<input type="radio" name="xingbie" value="男" <c:if test="${sessionScope.currentUser.xingbie=='男'}">checked</c:if>/> 男
									<input type="radio" name="xingbie" value="女" <c:if test="${sessionScope.currentUser.xingbie=='女'}">checked</c:if>/> 女
									</td>
								</tr>
								<tr>
									<td>年龄：</td>
									<td><input type="number" name="nianling" id="nianling" value="${sessionScope.currentUser.nianling}" min="0" max="120" readonly/></td>
								</tr>
								<tr>
									<td>专业名称：</td>
									<td>
									<select name="zhuanyeid" class="am-input-sm" id="zhuanye1" readonly></select>	
									</td>
								</tr>		
								<tr>
									<td colspan="2">
										<div class="am-btn-toolbar">
											<div class="am-btn-group am-btn-group-xs" >
												<button type="button"
													class="am-btn am-btn-default am-btn-xs am-text-secondary"
													onclick="history.go(-1)">
													<span class="am-btn-default"></span> 返回
												</button>
											</div>
										</div>
									</td>
								</tr>
							</table>
						</form>
					</div>
				</div>
			</div>
			<%@include file="../footer.jsp"%>
		</div>
		<!-- content end -->
	</div>

	<!--<![endif]-->
	<script src="<%=Const.ROOT%>assets/js/jquery.min.js"></script>
	<script src="<%=Const.ROOT%>assets/js/amazeui.min.js"></script>
	<script src="<%=Const.ROOT%>assets/js/app.js"></script>
	<script>
function update(){
	var xingming=$("#xingming").val();	
	if(xingming==""){
		alert("用户名不能为空");
		return false;
	}
	var zhuanyeid=$("#zhuanye1").val();	
	if(zhuanyeid=="-1"){
		alert("请选择专业");
		return false;
	}

	$.post("<%=Const.ROOT%>laoshi/update_info",$("#myForm").serializeForm(),function(data){
		alert(data.msg);
		if(data.status==0){
			location.href="<%=Const.ROOT%>manage/index.jsp";
		}
	});
}
$(function(){
	loadZhuanye("zhuanye1",'${sessionScope.currentUser.zhuanyeid}');
});
//加载专业列表
function loadZhuanye(domid,zhuanyeid){
	$.getJSON("<%=Const.ROOT%>zhuanye/listJson",function(data){
		if(data.status==0){
			$("#"+domid).html("<option value='-1'>请选择专业</option>");
			$.each(data.data,function(index,zhuanye){
				if(zhuanye.id==zhuanyeid){
					$("#"+domid).append("<option value='"+zhuanye.id+"' selected>"+zhuanye.mingcheng+"</option>");
				}else{
					$("#"+domid).append("<option value='"+zhuanye.id+"'>"+zhuanye.mingcheng+"</option>");
				}
			});
		}
	});
}
</script>
</body>
</html>
