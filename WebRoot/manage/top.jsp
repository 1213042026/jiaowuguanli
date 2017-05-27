<%@page import="cn.jiaowu.util.Const"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${sessionScope.currentUser==null}">
<script>
	alert("请先登录！");
	location.href="<%=Const.ROOT%>login.jsp";
</script>
</c:if>
<header class="am-topbar am-topbar-inverse admin-header">
<div class="am-topbar-brand">
	<strong><a href="<%=Const.ROOT%>index.jsp">教务管理系统</a>
	</strong>
	<small>后台管理</small>
</div>

<button
	class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
	data-am-collapse="{target: '#topbar-collapse'}">
	<span class="am-sr-only">导航切换</span>
	<span class="am-icon-bars"></span>
</button>

<div class="am-collapse am-topbar-collapse" id="topbar-collapse">

	<ul
		class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
		<li class="am-dropdown" data-am-dropdown>
			<a class="am-dropdown-toggle" data-am-dropdown-toggle
				href="javascript:;"> <span class="am-icon-users"></span>${sessionScope.currentUser.xingming}<span
				class="am-icon-caret-down"></span> </a>
			<ul class="am-dropdown-content">
				<li>
					<a href="<%=Const.ROOT %>login.jsp"><span
						class="am-icon-power-off"></span> 退出</a>
				</li>
			</ul>
		</li>
		<li class="am-hide-sm-only">
			<a href="javascript:;" id="admin-fullscreen"><span
				class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span>
			</a>
		</li>
	</ul>
</div>
</header>