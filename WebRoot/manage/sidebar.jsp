<%@page import="cn.jiaowu.util.Const"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
    <div class="am-offcanvas-bar admin-offcanvas-bar">
      <ul class="am-list admin-sidebar-list">
        <li><a href="<%=Const.ROOT%>manage/index.jsp"><span class="am-icon-home"></span> 首页</a></li>
        <!-- 管理员的菜单开始 -->
     	<c:if test="${sessionScope.currentRole==0}">
        <li class="admin-parent">
          <a class="am-cf" data-am-collapse="{target: '#collapse-nav1'}"><span class="am-icon-file"></span> 专业信息管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
          <ul class="am-list am-collapse admin-sidebar-sub" id="collapse-nav1">
            <li><a href="<%=Const.ROOT%>zhuanye/list"><span class="am-icon-puzzle-piece"></span>专业信息管理</a></li>
          </ul>
        </li>
         <li class="admin-parent">
          <a class="am-cf" data-am-collapse="{target: '#collapse-nav2'}"><span class="am-icon-file"></span> 课程信息管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
          <ul class="am-list am-collapse admin-sidebar-sub" id="collapse-nav2">
            <li><a href="<%=Const.ROOT%>kecheng/list"><span class="am-icon-puzzle-piece"></span>课程信息管理</a></li>
          </ul>
        </li>
         <li class="admin-parent">
          <a class="am-cf" data-am-collapse="{target: '#collapse-nav3'}"><span class="am-icon-file"></span> 教师信息管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
          <ul class="am-list am-collapse admin-sidebar-sub" id="collapse-nav3">
            <li><a href="<%=Const.ROOT%>laoshi/list"><span class="am-icon-puzzle-piece"></span>教师信息管理</a></li>
          </ul>
        </li>
         <li class="admin-parent">
          <a class="am-cf" data-am-collapse="{target: '#collapse-nav4'}"><span class="am-icon-file"></span> 学生信息管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
          <ul class="am-list am-collapse admin-sidebar-sub" id="collapse-nav4">
            <li><a href="<%=Const.ROOT%>xuesheng/list"><span class="am-icon-puzzle-piece"></span>学生信息管理</a></li>
          </ul>
        </li>
         <li class="admin-parent">
          <a class="am-cf" data-am-collapse="{target: '#collapse-nav5'}"><span class="am-icon-file"></span> 公告管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
          <ul class="am-list am-collapse admin-sidebar-sub" id="collapse-nav5">
            <li><a href="<%=Const.ROOT%>gonggao/list"><span class="am-icon-puzzle-piece"></span>公告管理</a></li>
          </ul>
        </li>
        <li class="admin-parent">
          <a class="am-cf" data-am-collapse="{target: '#collapse-nav6'}"><span class="am-icon-file"></span> 系统管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
          <ul class="am-list am-collapse admin-sidebar-sub" id="collapse-nav6">
            <li><a href="<%=Const.ROOT%>manage/admin/userinfo.jsp"><span class="am-icon-puzzle-piece"></span>个人资料修改</a></li>
            <li><a href="<%=Const.ROOT%>manage/admin/updatepwd.jsp"><span class="am-icon-puzzle-piece"></span>密码修改</a></li>
            <li><a href="<%=Const.ROOT%>logout"><span class="am-icon-puzzle-piece"></span>安全退出</a></li>
          </ul>
        </li>
        </c:if>
		<!-- 管理员的菜单结束 -->
       	<!-- 老师的菜单开始 -->
     	<c:if test="${sessionScope.currentRole==1}">
     	<li class="admin-parent">
          <a class="am-cf" data-am-collapse="{target: '#collapse-nav1'}"><span class="am-icon-file"></span> 成绩管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
          <ul class="am-list am-collapse admin-sidebar-sub" id="collapse-nav1">
            <li><a href="<%=Const.ROOT%>chengji/list"><span class="am-icon-puzzle-piece"></span>成绩管理</a></li>
          </ul>
        </li>
        
        <li class="admin-parent">
          <a class="am-cf" data-am-collapse="{target: '#collapse-nav2'}"><span class="am-icon-file"></span> 系统管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
          <ul class="am-list am-collapse admin-sidebar-sub" id="collapse-nav2">
            <li><a href="<%=Const.ROOT%>manage/laoshi/userinfo.jsp"><span class="am-icon-puzzle-piece"></span>个人资料查看</a></li>
            <li><a href="<%=Const.ROOT%>manage/laoshi/updatepwd.jsp"><span class="am-icon-puzzle-piece"></span>密码修改</a></li>
            <li><a href="<%=Const.ROOT%>logout"><span class="am-icon-puzzle-piece"></span>安全退出</a></li>
          </ul>
        </li>
        
     	</c:if>
     	<!-- 老师的菜单结束 -->
     	
     	<!-- 学生的菜单开始 -->
     	<c:if test="${sessionScope.currentRole==2}">
     	<li class="admin-parent">
          <a class="am-cf" data-am-collapse="{target: '#collapse-nav1'}"><span class="am-icon-file"></span> 查看成绩 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
          <ul class="am-list am-collapse admin-sidebar-sub" id="collapse-nav1">
            <li><a href="<%=Const.ROOT%>chengji/list"><span class="am-icon-puzzle-piece"></span>查看成绩</a></li>
          </ul>
        </li>
        
        <li class="admin-parent">
          <a class="am-cf" data-am-collapse="{target: '#collapse-nav2'}"><span class="am-icon-file"></span> 系统管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
          <ul class="am-list am-collapse admin-sidebar-sub" id="collapse-nav2">
            <li><a href="<%=Const.ROOT%>manage/xuesheng/userinfo.jsp"><span class="am-icon-puzzle-piece"></span>个人资料查看</a></li>
            <li><a href="<%=Const.ROOT%>manage/xuesheng/updatepwd.jsp"><span class="am-icon-puzzle-piece"></span>密码修改</a></li>
            <li><a href="<%=Const.ROOT%>logout"><span class="am-icon-puzzle-piece"></span>安全退出</a></li>
          </ul>
        </li>
        
     	</c:if>
     	<!-- 学生的菜单结束 -->
      </ul>
    </div>
  </div>