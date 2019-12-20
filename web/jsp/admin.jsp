<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<% String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath %>">
		<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
		<title>管理员界面</title>
		<link rel="stylesheet" href="../css/admin.css">
		<script src="../js/jquery-3.4.1.js"></script>

		<script>
			$(document).ready(function () {
				var table=$("#div-table");
				var bookmager=$("#bookmager");
				var stumager=$("#stumager");
				var teamager=$("#teamager");
				var daymager=$("#daymager");
				var mesmager=$("#megmager");
				var stuadd=$("#div-stuadd");
				var div= $("#div-add"); var stu=$("#div-stu");
				var myadd=$("#myadd");		var tea=$("#div-tea");
				var tadd=$("#div-teaadd");
				var teacher=$("#teacher_add");
				var sadd=$("#sadd");
				var teadd=$("#pos");
				var message=$("#message");
				var schedule=$("#schedule");
				var news=$("#new-schedule");
				var	schadd=$("#schedule-add");
				div.hide();
				stuadd.hide();
				tadd.hide();
				stu.hide();
				tea.hide();
				message.hide();
				schedule.hide();
				news.hide();
				$("#adds").click(function () {
					div.show();
					div.animate({height: '550px', opacity: '0.4'}, "slow");
					div.animate({width: '850px', opacity: '1'}, "slow");
				});
				$(".close").click(function () {
					div.hide();
					stuadd.hide();
					tadd.hide();
					news.hide();
				});
				$("#subs").click(function () {
					if($("#bkid").val()==""){
						alert("数据不能为空！");
					}else {
						$.ajax({
							type: "POST",
							url: "bookAdd",
							dateType:"text",
							async:false,
							data:{"bkid":$("#bkid").val(),"bkname":$("#bkname").val(),"ISBN":$("#ISBN").val(),"price":$("#price").val(),"writer":$("#writer").val(),"subject":$("#subject").val(),"press":$("#press").val(),
								"language":$("#language").val(),"place":$("#place").val(),"date":$("#date").val(),"indexs":$("#indexs").val(),"classify":$("#classify").val(),"type":$("#type").val(),"barcode":$("#barcode").val(),
								"collection":$("#collection").val(),"collections":$("#collections").val(),"number":$("#number").val()
							},
							success:function (date) {
								if(date===1){
									alert("添加成功！");
								}
							},
							error:function x() {
								alert("数据添加失败！");
							}
						});
					}
					div.hide();
				});
				myadd.click(function () {
					stuadd.show();
				});
				teacher.click(function () {
					tadd.show();
				});
				sadd.click(function () {
					if($("#user").val()==""){
						alert("数据不能为空！");
						return false;
					}
					stuadd.hide();
				});
				teadd.click(function () {
					if($("#tuser").val()==""){
						alert("数据不能为空！");
						return false;
					}
					tadd.hide();
				});
				bookmager.click(function () {
					stu.hide();
					tea.hide();
					schedule.hide();
					message.hide();
					news.hide();
					table.show();
				});
				stumager.click(function () {
					stu.show();
					schedule.hide();
					tea.hide();
					message.hide();
					table.hide();
					news.hide();
				});
				teamager.click(function () {
					table.hide();
					stu.hide();
					schedule.hide();
					message.hide();
					news.hide();
					tea.show();
				});
				mesmager.click(function () {
					table.hide();
					stu.hide();
					schedule.hide();
					message.show();
					tea.hide();
					news.hide();
				});
				daymager.click(function () {
					table.hide();
					news.hide();
					stu.hide();
					message.hide();
					tea.hide();
					schedule.show();
				});
				schadd.click(function () {
					news.show();
				})
			});
		</script>
	</head>
	<body>
			<div id="div-table" >
				<fieldset>
					<legend>图书管理：</legend>
				<table border="1" cellspacing="0" cellpadding="0">
					<th>图书id</th>
					<th>书名</th>
					<th>作者</th>
					<th>主题</th>
					<th>语言</th>
					<th>出版社</th>
					<th>价格</th>
					<th>索引</th>
					<th>出版日期</th>
					<c:forEach items="${list2}" var="list">
						<tr>
							<td>${list.id}</td>
							<td>${list.bkname}</td>
							<td>${list.writer}</td>
							<td>${list.subject}</td>
							<td>${list.language}</td>
							<td>${list.press}</td>
							<td>${list.price}</td>
							<td>${list.indexs}</td>
							<td>${list.date}</td>
							<td><a href="search?id=${list.id}">操作</a></td>
						</tr>
					</c:forEach>
				</table>
					<button id="adds">新增</button>
				</fieldset>
			</div>
			<div id="div-add">
				<form action="">
					<span><button class="close" type="reset">X</button></span>
					<br><br>
					图书id：<input type="text" id="bkid" name="bkid">书名：<input type="text" id="bkname" name="bkname">ISBN：<input type="text" id="ISBN"><br><br><br>
					价格：<input type="text" id="price" name="price ">作者：<input type="text" id="writer" name="writer">出版社：<input type="text" id="press" name="press"><br><br><br>
					语言：<input type="text" id="language" name="language">主题：<input type="text" id="subject" name="subject">出版地：<input type="text" name="place" id="place"><br><br><br>
					出版日期：<input type="text" id="date" name="date">索书号：<input type="text" id="indexs" name="indexs">中图分类：<input type="text" id="classify" name="classify"><br><br><br>
					图书类型：<input type="text" name="type" id="type">条形码：<input type="text" id="barcode" name="barcode">馆藏地：<input type="text" id="collection" name="collection"><br><br><br>
					馆藏号：<input type="text" id="collections" name="collections">数量：<input type="text" id="number" name="number">封面上传：<input type="file" id="file" name="file"><br><br>
					<button type="button" id="subs">添加</button><button type="reset">重置</button>
				</form>
			</div>

			<div id="div-stu">
				<fieldset>
					<legend>学生信息：</legend>
					<table border="1" cellspacing="0" cellpadding="0">
						<th>序号</th>
						<th>学生id</th>
						<th>姓名</th>
						<th>年龄</th>
						<th>性别</th>
						<th>院系</th>
						<th>班级</th>
						<th>联系方式</th>
						<th>最大借书数量</th>
						<th>余额</th>
						<c:forEach items="${slist}" var="list">
							<tr>
								<td>${list.id}</td>
								<td>${list.sid}</td>
								<td>${list.name}</td>
								<td>${list.age}</td>
								<td>${list.sex}</td>
								<td>${list.units}</td>
								<td>${list.classes}</td>
								<td>${list.phone}</td>
								<td>${list.max}</td>
								<td>${list.balance}</td>
								<td><a href="userController?sid=${list.sid}">删除</a></td>
								<td><a href="upuser?sid=${list.sid}">修改</a></td>
							</tr>
						</c:forEach>
					</table>
					<button type="button" id="myadd">添加用户</button>
				</fieldset>
			</div>
			<div id="div-stuadd">
				<form action="userController" method="post">
					<span><button class="close" type="reset">X</button></span>
					用户名：<input type="text" id="user" name="user">密码：<input type="text" id="pass" name="pass">标志：<input type="text" id="sflag" name="flag" value="2" readonly><br><br>
					姓名：<input type="text" id="name" name="name">年龄：<input type="text" id="age" name="age">性别：<input type="text" id="sex" name="sex"><br><br>
					院系：<input type="text" name="units" id="units">班级：<input type="text" id="class" name="class">联系方式：<input type="text" id="phone" name="phone"><br><br>
					<button type="submit" id="sadd">提交</button>
					<button type="reset">重置</button>
				</form>
			</div>

			<div id="div-tea">
		<fieldset>
			<legend>教师信息：</legend>
			<table border="1" cellspacing="0" cellpadding="0">
				<th>编号</th>
				<th>账号</th>
				<th>姓名</th>
				<th>年龄</th>
				<th>性别</th>
				<th>单位</th>
				<th>联系方式</th>
				<th>最大借书数量</th>
				<th>余额</th>
				<c:forEach items="${tlist}" var="list">
				<tr>
					<td>${list.id}</td>
					<td>${list.tid}</td>
					<td>${list.name}</td>
					<td>${list.age}</td>
					<td>${list.sex}</td>
					<td>${list.units}</td>
					<td>${list.phone}</td>
					<td>${list.max}</td>
					<td>${list.balance}</td>
					<td><a href="userController?tid=${list.id}">删除</a></td>
					<td><a href="upuser?tid=${list.tid}">修改</a></td>
				</tr>
				</c:forEach>
			</table>
			<button type="button" id="teacher_add">添加用户</button>
		</fieldset>
	</div>
			<div id="div-teaadd">
				<form action="userController" method="post">
					<span><button class="close" type="reset">X</button></span>
					用户名：<input type="text" id="tuser" name="user">密码：<input type="text" id="upass" name="pass">标志：<input type="text" id="tflag" name="flag" value="3" readonly><br><br>
					年龄：<input type="text" id="tage" name="age">性别：<input type="text" id="tsex" name="sex">单位：<input type="text" id="tunits" name="units"><br><br>
					联系方式：<input type="text" id="tphone" name="phone">姓名：<input type="text" id="tname" name="name"><br>
					<button type="submit" id="pos">添加</button>
					<button type="reset" >重置</button>
				</form>
			</div>
			<script src="../js/Timer.js"></script>
	<div id="times" onload="getTime()" >
		<p id="new" style="margin-top: 20px"> </p><br><br>
	</div>
	<div id="navbar">
		<ul>
			<li id="bookmager" style="cursor : pointer;">图书管理</li>
			<li id="stumager" style="cursor : pointer;">学生信息管理</li>
			<li id="teamager" style="cursor : pointer;">教师信息管理</li>
			<li id="daymager" style="cursor : pointer;">查看日程</li>
			<li id="megmager" style="cursor : pointer;">查看留言</li>
		</ul>
	</div>
	<div id="schedule">
		<fieldset>
			<legend>日程管理：</legend>
			<table border="1" cellspacing="0" cellpadding="0">
				<th>编号</th>
				<th>日程</th>
				<th>添加时间</th>
				<th>操作</th>
				<c:forEach items="${sdlist}" var="list">
				<tr>
					<td>${list.id}</td>
					<td>${list.msg}</td>
					<td>${list.time}</td>
					<td><a href="scheduleController?id=${list.id}">删除</a></td>
				</tr>
				</c:forEach>
			</table>
			<button id="schedule-add">新建日程</button>
		</fieldset>
	</div>
	<div id="new-schedule">
	<form action="scheduleController" method="post">
		<span><button class="close" type="reset" style="position: relative;top: -21px;">X</button></span>
		日程：<br><br><textarea id="msg" name="msg" cols="80" rows="5"></textarea><br><br>
		<button id="add" type="submit">添加</button><button type="reset">重置</button>
	</form>
	</div>
	<div id="message">
		<fieldset>
			<legend>留言管理：</legend>
			<table border="1" cellspacing="0" cellpadding="0">
				<th>编号</th>
				<th>用户名</th>
				<th>图书名称</th>
				<th>内容</th>
				<th>评论时间</th>
				<th>操作</th>
				<c:forEach items="${mlist}" var="list">
					<tr>
						<td>${list.id}</td>
						<td>${list.uid}</td>
						<td>${list.bkname}</td>
						<td>${list.mes}</td>
						<td>${list.time}</td>
						<td><a href="delMessage?id=${list.id}">删除</a></td>
					</tr>
				</c:forEach>
			</table>
		</fieldset>
	</div>
	</body>
</html>
