<%@page import="cn.jiaowu.util.Const"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.jiaowu.util.Const"%>
<!DOCTYPE html>
<html>
<head lang="cn">
  <meta charset="UTF-8">
  <title>教务管理系统登录</title>
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="format-detection" content="telephone=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="alternate icon" type="image/png" href="<%=Const.ROOT %>assets/i/favicon.png">
  <link rel="stylesheet" href="<%=Const.ROOT %>assets/css/amazeui.min.css"/>
  
  <style>
    .header {
      text-align: center;
    }
    .header h1 {
      font-size: 200%;
      color: #333;
      margin-top: 30px;
    }
  </style>
</head>
<body>
<div class="header">
  <div class="am-g">
    <h1>教务管理系统登录</h1>
  </div>
  <hr />
</div>
<div class="am-g">
  <div class="am-u-lg-6 am-u-md-8 am-u-sm-centered"> 
    <form action="" method="post" class="am-form">
      <label for="username">用户名:</label>
      <input type="text" name="username" id="username" value="">
      <br>
      <label for="password">密码:</label>
      <input type="password" name="password" id="password" value="">
      <br>
      <label for="role">身份:</label>
      <select name="role" id="role">
      	<option value="0">管理员</option>
      	<option value="1">老师</option>
      	<option value="2">学生</option>
      </select>
      <br>
      <div class="am-cf">
        <input type="button" name="" value="登 录" class="am-btn am-btn-primary am-btn-sm am-fl"> 
      </div>
       <div class="am-cf">
      </div>
    </form>
    <hr>
    <p>© 2017 教务管理系统登录</p>
  </div>
</div>
<script src="<%=Const.ROOT %>assets/js/jquery.min.js"></script>
<script src="<%=Const.ROOT %>assets/js/amazeui.min.js"></script>
<script src="<%=Const.ROOT %>assets/js/app.js"></script>
<script>
  $(function(){
	  $(".am-btn").click(function(){
		  var username=$("#username").val();
		  var password=$("#password").val();
		  var role=$("#role").val();
		  if(username==""){
			  alert("请输入用户名");
			  return false;
		  }
		  if(password==""){
			  alert("请输入密码");
			  return false;
		  }
		  $.post("<%=Const.ROOT %>login",{"username":username,"password":password,"role":role},function(data){
			  if(data.status==1){
				  alert(data.msg);
			  }else{
				  location.href="<%=Const.ROOT %>manage/index.jsp";
			  }
		  },"json");
	  });
  });
  </script>
</body>
</html>
