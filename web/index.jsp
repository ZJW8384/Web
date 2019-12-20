<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<% String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath %>">
		<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
		<title>用户登入界面</title>
        <link rel="stylesheet" href="css/login.css">
        <script src="js/jquery-3.4.1.js"></script>
        <style>
        </style>
       <script>
           var arr;
           $(document).ready(function () {
               $("#ss").hide();
               $("#aa").hide();
               var user=$("#user");
               var pass=$("#pass");
               $("#pass").mouseleave(function () {
                   send();
               });
               $("#sub").click(function () {
                   if(user.val()==""){
                       alert("用户名不能为空！");
                       return  false;
                   }else if(pass.val()==""){
                       alert("密码不能为空！");
                       return false;
                   }
                   send();
                   if(arr==null){
                       alert("用户名或密码错误！");
                       return false;
                   }
                   return true;
               })
           });
           function send(){
               $(document).ready(function admin() {
                       $.ajax({
                           type: "GET",
                           url: "login",
                           dateType:"text",
                           async:false,
                           data: {"user":$("#user").val(),"pass":$("#pass").val()},
                           success: function(data){
                               var name;
                               var pass;
                               for(var i=0;i<data.length;i++){
                                   name=data[i].id;
                                   pass=data[i].pass;
                                   arr=name;
                               }
                               if(name==null||pass==null){
                                   return sing ;
                               }else {
                                   $("#ss").hide();
                                   return true;
                               }
                           },
                           error: function(){
                               console.log("数据返回失败！");
                           }
                       });
               });
           }
       </script>
	</head>
	<body>
      <form action="login" class="forms" method="post">
        用户名：<input type="text" id="user" name="user" autocomplete="off" required="required"/><br><br>
        密&nbsp;&nbsp;码：&nbsp;<input type="password" id="pass" name="pass" required="required"/><span id="aa"></span><br><br>
          <span id="ss">用户名或密码错误！</span>
        <button type="submit" class="button1" id="sub">登录</button><button type="reset" class="button2">重置</button>
      </form>
    <div>
        
    </div>
	</body>
</html>