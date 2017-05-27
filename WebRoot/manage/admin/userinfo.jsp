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
<script>
function update(){
	var xingming=$("#xingming").val();	
	if(xingming==""){
		alert("用户名不能为空");
		return false;
	}
	$.post("<%=Const.ROOT%>admin/update_info",{"xingming":xingming},function(data){
		alert(data.msg);
		if(data.status==0){
			location.href="<%=Const.ROOT%>manage/index.jsp";
		}
	});
}
</script>
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
						<strong class="am-text-primary am-text-lg">首页</strong> / <small>个人资料修改</small>
					</div>
				</div>
				<hr>

				<div class="am-g">
					<div class="am-u-sm-12">
						<form action="" method="post">
							<table class="am-table am-table-striped am-table-hover table-main">
								<!-- 循环开始 -->
								<tr>
									<td>姓名：</td>
									<td><input type="text" id="xingming" value="${sessionScope.currentUser.xingming}"/></td>
								</tr>		
								<tr>
									<td colspan="2">
										<div class="am-btn-toolbar">
											<div class="am-btn-group am-btn-group-xs" >
												<button type="button"
													class="am-btn am-btn-default am-btn-xs am-text-secondary"
													onclick="update()">
													<span class="am-btn-default"></span> 修改
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
</body>
</html>
