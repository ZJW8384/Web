<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<% String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath %>">
		<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
		<title>个人中心</title>
        <link rel="stylesheet" href="../css/home.css">
        <script src="../js/jquery-3.4.1.js"></script>
        <script>
            $(document).ready(function () {
                var rp=$("#rest_pass");
                var clase=$("#close");
                var us=$("#user");
                var pass=$("#pass");
                var spass=$("#spass");
                var xugai=$("#xugai");
                var  bu=$("#bu");
                var all=$("#all");
                var not=$("#not");
                var huan=$("#huan");
                var select=$("input[name='bk']:checked");
                var checkID = [];
                var a=0;
                rp.hide();
                not.hide();
                    // alert(a);
                function sleep(n) {    //模拟线程休眠
                    var start = new Date().getTime();
                    //  console.log('休眠前：' + start);
                    while (true) {
                        if (new Date().getTime() - start > n) {
                            break;
                        }
                    }
                    // console.log('休眠后：' + new Date().getTime());
                }
                $("#resets").click(function () {
                    rp.show();
                });
                clase.click(function () {
                    rp.hide();
                });
                xugai.click(function () {
                    if(pass.val()!==spass.val()){
                        alert("密码不一致!");
                        return false;
                    }else if((spass.val()|| pass.val())==""){
                        alert("密码不能为空!");
                        return  false;
                    }
                });
                bu.click(function () {
                    a=1;
                    if(a===0){
                        return false;
                    }else {
                        return  true;
                    }
                });
                <%--if(sign){--%>
                <%--    sleep(500);--%>
                <%--    var time='<%=session.getAttribute("time")%>';--%>
                <%--    var  subm='<%=session.getAttribute("subm")%>';--%>
                <%--    alert("借书"+time+"天，扣费"+subm+"元！");--%>
                <%--}--%>
                all.click(function () {
                    alert(checkID);

                });
                function send() {
                    select.each(function(i){//把所有被选中的复选框的值存入数组
                        checkID[i] =$(this).val();
                    });
                    $.ajax({
                        type: "POST",
                        url: "backBook",
                        dateType:"text",
                        traditional:true,
                        async:false,
                        data: {"id":checkID,"flag":'<%=session.getAttribute("user")%>',"uid":'<%=session.getAttribute("uid")%>'},
                        success:function (data) {
                                alert("借书"+data[0]+"天，扣费"+data[1]+"元！");
                        },
                        error:function () {
                            alert("还书失败，请刷新重试！");
                        },
                    });

                }
                huan.click(function () {
                    var balance=<%=session.getAttribute("fff")%>;
                    if(balance<0){
                        var word = prompt("账户已欠费，请输入密码","");
                        if(word){
                            send();
                        }
                    }else {
                        send();
                    }


                })
            })
        </script>
	</head>
	<body>
    <header id="header">
        <a href="home">首页</a><a href="/jsp/homepage.jsp">个人中心</a>
    </header>
    <div id="money">
        <span >账户余额：<%=session.getAttribute("money")%></span>
    </div>
    <div id="div-table" >
        <fieldset>
            <legend>待还图书：</legend>
<%--            <form action="backBook?flag=<%=session.getAttribute("user")%>&uid=<%=session.getAttribute("uid")%>" method="post">--%>
        <table border="1" cellspacing="0" cellpadding="0" id="message">
            <th>图书id</th>
            <th>书名</th>
            <th>借阅日期</th>
            <th>应还日期</th>
            <th>数量</th>
            <th id="select"><button type="button" id="all">批量</button></th>
            <c:forEach items="${list}" var="list">
                <tr>
                    <td>${list.bkid}</td>
                    <td>${list.bkname}</td>
                    <td>${list.time}</td>
                    <td>${list.bktime}</td>
                    <td>${list.number}</td>
<%--                    <td><button id="bu"><a href="backBook?id=${list.bkid}&flag=<%=session.getAttribute("user")%>&uid=<%=session.getAttribute("uid")%>">还书</a></button></td>--%>
                    <td><input type="checkbox" name="bk" id="bk" value="${list.bkid}"/></td>
                </tr>
            </c:forEach>
        </table>
                <button type="button" id="huan">还书</button>
<%--            </form>--%>
        </fieldset>
    </div>
    <div><button id="resets">修改密码</button></div>
    <div id="rest_pass">
        <form action="upDataPass" method="post">
        <span><button id="close" type="reset">X</button></span>
        用户编号：<input type="password" value="<%=session.getAttribute("user")%>" id="user" name="user"><br><br><br>新密码：<input type="password" id="pass" name="pass"/><br><br><br>
        确定密码：<input type="password" id="spass" name="spass"/><br><br><br>
        <button type="submit" id="xugai" class="up">修改</button><button type="reset" class="up">重置</button>
        </form>
    </div>
	</body>
</html>