<%@page import="cn.jiaowu.util.Const"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>学生信息管理</title>
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
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">首页</strong> / <small>学生信息管理</small></div>
      </div>
      <hr>
      <div class="am-g">
        <div class="am-u-sm-12 am-u-md-12">
            	<form class="am-form-inline" action="<%=Const.ROOT%>xuesheng/list" method="post" id="searchForm">
           			<span style="margin-right:10px;">学号:</span><input type="text" name="xuehao" style="width:80px;"/>
					<span style="margin-right:10px;">专业名称:</span><select name="zhuanyeid" id="zhuanye2" style="width:150px;">
					</select>	
					<button type="submit" class="am-btn am-btn-default am-btn-sm">
		              	<span class="am-icon-search"></span> 查询
		            </button>
	              	<button type="button" class="am-btn am-btn-default am-btn-sm" onclick="doAdd()">
	              		<span class="am-icon-plus"></span> 新增
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
                <th class="table-title">学号</th>
                <th class="table-title">姓名</th>
                <th class="table-title">性别</th>
                <th class="table-title">年龄</th>
                <th class="table-title">专业</th>
                <th class="table-set">操作</th>
              </tr>
              </thead>
              <tbody>
              <c:forEach items="${requestScope.list}" var="xuesheng" varStatus="st">
              <!-- 循环开始 -->
              <tr>
                <td>${st.count}</td>
                <td>${xuesheng.xuehao}</td>
                <td>${xuesheng.xingming}</td>
                <td>${xuesheng.xingbie}</td>
                <td>${xuesheng.nianling}</td>
                <td>${xuesheng.zymc}</td>
                <td>
                  <div class="am-btn-toolbar">
                    <div class="am-btn-group am-btn-group-xs">                 	
                      <%--
                      <button type="button" class="am-btn am-btn-default am-btn-xs am-text-secondary" onclick="doShenhe('${xuesheng.id}')"><span class="am-icon-pencil-square-o"></span> 审核通过</button>
                      --%>
                      <button type="button" class="am-btn am-btn-default am-btn-xs am-text-secondary" onclick="toUpdate('${xuesheng.id}')"><span class="am-icon-pencil-square-o"></span> 编辑</button>
                      <button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" onclick="doDelete('${xuesheng.id}')"><span class="am-icon-trash-o"></span> 删除</button>
                    </div>
                  </div>
                </td>
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
<!-- 删除对话框begin -->
<div class="am-modal am-modal-confirm" tabindex="-1" id="delete_modal">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">你，确定要删除这条记录吗？</div>
    <div class="am-modal-footer">
      <span class="am-modal-btn" data-am-modal-cancel>取消</span>
      <span class="am-modal-btn" data-am-modal-confirm>确定</span>
    </div>
  </div>
</div>
<!-- 删除对话框end  -->
<!-- 新增对话框begin -->
<div class="am-modal am-modal-no-btn" tabindex="-1" id="add-modal" data-am-validator>
  <div class="am-modal-dialog">
    <div class="am-modal-hd">新增学生
      <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
    </div>
    <div class="am-modal-bd">
      	<!-- 新增表单开始 -->
		 <form class="am-form am-form-horizontal" id="addForm" data-am-validator action="add" method="post">
		 	<input type="hidden" name="type" value="1"/>
				<div class="am-g am-margin-top"><!--  style="margin-top:4px;" -->
				  <div class="am-u-sm-3 am-u-md-3 am-text-right">
					学号
				  </div>
				  <div class="am-u-sm-9 am-u-md-9 am-u-end col-end">
					<input type="text" id="xuehao" name="xuehao" required placeholder="学号" onblur="checkExists()">	
				  </div>
				</div>
				<div class="am-g am-margin-top"><!--  style="margin-top:4px;" -->
				  <div class="am-u-sm-3 am-u-md-3 am-text-right">
					密码
				  </div>
				  <div class="am-u-sm-9 am-u-md-9 am-u-end col-end">
					 <input type="password" id="loginpw" name="loginpw" required placeholder="密码">	
				  </div>
				</div>
				<div class="am-g am-margin-top"><!--  style="margin-top:4px;" -->
				  <div class="am-u-sm-3 am-u-md-3 am-text-right">
					确认密码
				  </div>
				  <div class="am-u-sm-9 am-u-md-9 am-u-end col-end">
					<input type="password" id="confirmPassword" name="confirmPassword" data-equal-to="#loginpw" required placeholder="确认密码">	
				  </div>
				</div>
				<div class="am-g am-margin-top"><!--  style="margin-top:4px;" -->
				  <div class="am-u-sm-3 am-u-md-3 am-text-right">
					姓名
				  </div>
				  <div class="am-u-sm-9 am-u-md-9 am-u-end col-end">
					<input type="text" id="xingming" name="xingming" required placeholder="姓名">	
				  </div>
				</div>
				
				<div class="am-g am-margin-top"><!--  style="margin-top:4px;" -->
				  <div class="am-u-sm-3 am-u-md-3 am-text-right">
					性别
				  </div>
				  <div class="am-u-sm-9 am-u-md-9 am-u-end col-end">
					<input type="radio" name="xingbie" required value="男" checked/> 男 
                <input type="radio" name="xingbie" value="女"/> 女 	
				  </div>
				</div>
				
				<div class="am-g am-margin-top"><!--  style="margin-top:4px;" -->
				  <div class="am-u-sm-3 am-u-md-3 am-text-right">
					年龄
				  </div>
				  <div class="am-u-sm-9 am-u-md-9 am-u-end col-end">
					 <input type="number" id="nianling" name="nianling" required placeholder="年龄" min="0" max="120"/> 
				  </div>
				</div>
				
				<div class="am-g am-margin-top">
				  <div class="am-u-sm-3 am-u-md-3 am-text-right">
					专业
				  </div>
				  <div class="am-u-sm-9 am-u-md-9 am-u-end col-end">
					<select name="zhuanyeid" class="am-input-sm" id="zhuanye1" required>
					</select>	
				  </div>
				 </div>
			<div class="am-margin-top">
		       <button type="submit" class="am-btn am-btn-primary am-btn-xs">提交保存</button>
		      <button type="reset" class="am-btn am-btn-primary am-btn-xs">放弃保存</button>
		    </div>
          </form>
          <!-- 新增表单结束 -->
    </div>
  </div>
</div>
<!-- 审核对话框begin -->
<div class="am-modal am-modal-confirm" tabindex="-1" id="shenhe_modal">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">是否审核通过？</div>
    <div class="am-modal-footer">
      <span class="am-modal-btn" data-am-modal-cancel>取消</span>
      <span class="am-modal-btn" data-am-modal-confirm>确定</span>
    </div>
  </div>
</div>
<!-- 审核对话框 end-->
<!-- 删除对话框end -->
<!-- 修改对话框begin -->
<div class="am-modal am-modal-no-btn" tabindex="-1" id="update-modal">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">修改学生
      <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
    </div>
    <div class="am-modal-bd">
      	<!-- 修改表单begin -->
		<form class="am-form" name="updateForm" action="update" method="post">
			  	<div class="am-g am-margin-top">
				  <input type="hidden" name="id"/>
				  <div class="am-u-sm-3 am-u-md-3 am-text-right">
					学生姓名
				  </div>
				  <div class="am-u-sm-9 am-u-md-9 am-u-end col-end">
					<input type="text" name="xingming" class="am-input-sm" placeholder="请输入课程名称" required>
				  </div>
				</div>
				<div class="am-g am-margin-top">
				  <input type="hidden" name="id"/>
				  <div class="am-u-sm-3 am-u-md-3 am-text-right">
					学生性别
				  </div>
				  <div class="am-u-sm-9 am-u-md-9 am-text-left">
					<input type="radio" name="xingbie" value="男" required>男
					<input type="radio" name="xingbie" value="女">女
				  </div>
				</div>
				<div class="am-g am-margin-top">
				  <input type="hidden" name="id"/>
				  <div class="am-u-sm-3 am-u-md-3 am-text-right">
					学生年龄
				  </div>
				  <div class="am-u-sm-9 am-u-md-9 am-u-end col-end">
					<input type="text" name="nianling" class="am-input-sm" placeholder="请输入学生年龄" min="0" max="120" required>
				  </div>
				</div>
				<div class="am-g am-margin-top">
				  <div class="am-u-sm-3 am-u-md-3 am-text-right">
					专业
				  </div>
				  <div class="am-u-sm-9 am-u-md-9 am-u-end col-end">
					<select name="zhuanyeid" class="am-input-sm" id="zhuanye" required>
					</select>	
				  </div>
				 </div>
			<div class="am-margin-top">
		      <button type="submit" class="am-btn am-btn-primary am-btn-xs">提交保存</button>
		      <button type="reset" class="am-btn am-btn-primary am-btn-xs">放弃保存</button>
		    </div>
          </form>
    </div>
  </div>
</div>
<!-- 修改对话框end -->
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
	loadZhuanye("zhuanye1","");
	loadZhuanye("zhuanye2","");
});
function doAdd(){
	$("#add-modal").modal({width:500,height:500});
}
//加载专业列表
function loadZhuanye(domid,zhuanyeid){
	$.getJSON("<%=Const.ROOT%>zhuanye/listJson",function(data){
		if(data.status==0){
			$("#"+domid).html("<option value=''>请选择专业</option>");
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
function doShenhe(id){
	$("#shenhe_modal").modal({
        relatedTarget: this,
        onConfirm: function(options) {
        	//执行审核
        	location.href="shenhe"+id;
        },
        onCancel: function() {
        }
      });
}
function doDelete(id){
	$("#delete_modal").modal({
        relatedTarget: this,
        onConfirm: function(options) {
        	//执行删除
        	location.href="del"+id;
        },
        onCancel: function() {
        }
      });
}
function toUpdate(id){
	$.getJSON("detail"+id,function(data){
		if(data.status==0){
			$("#update-modal form").setForm(data.data);
			loadZhuanye("zhuanye",data.data.zhuanyeid);
			$("#update-modal").modal({width:500,height:340});
		}
	})
}
function checkExists(){
	var xuehao=$("#xuehao").val();
	$.getJSON("<%=Const.ROOT%>xuesheng/isExists",{"xuehao":xuehao},function(data){
		if(data.status!=0){
			alert(data.msg);
			return false;
		}
	});
}
</script>
</body>
</html>
