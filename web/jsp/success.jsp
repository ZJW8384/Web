<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<% String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath %>">
		<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
		<title>首页</title>
        <script src="../js/jquery-3.4.1.js"></script>
        <link rel="stylesheet" href="../css/success.css">
        <script src="../js/success.js"></script>
        <script>
            var th;
            $(document).ready(function () {
                $("#search").hide();
                $("#sear").click(function () {
                    $("#search").html("");

                    send();
                    $("#div-table").hide();
                    $("#search").show();
                })
            })
            function send(){
                $(document).ready(function admin() {
                    $.ajax({
                        type: "POST",
                        url: "search",
                        dateType:"text",
                        async:true,
                        data: {"bookname":$("#bookname").val(),"writer":$("#writer").val(),"indexs":$("#indexs").val(),"subject":$("#subject").val()},
                        success: function(data){
                            var id;
                            var bkname;
                            var writer;
                            var subject;
                            var language;
                            var press;
                            var price;
                            var indexs;
                            var date;
                            var tr;
                                for(var i=0;i<data.length;i++){
                                    id=data[i].id;
                                    bkname=data[i].bkname;
                                    writer=data[i].writer;
                                    subject=data[i].subject;
                                    language=data[i].language;
                                    press=data[i].press;
                                    price=data[i].price;
                                    indexs=data[i].indexs;
                                    date=data[i].date;
                                    th='<th>图书id</th><th>书名</th><th>作者</th><th>主题</th><th>语言</th><th>出版社</th><th>价格</th><th>索引</th><th>出版日期</th>';
                                    tr='<td>'+id+'&nbsp;&nbsp;&nbsp;&nbsp;</td>&nbsp;&nbsp;'+'<td>'+bkname+'&nbsp;&nbsp;</td>&nbsp;&nbsp;'+'<td>'+writer+'&nbsp;&nbsp;</td>&nbsp;&nbsp;'+'<td>'+subject+'&nbsp;&nbsp;</td>&nbsp;&nbsp;'+
                                        '<td>'+language+'&nbsp;&nbsp;</td>&nbsp;&nbsp;'+'<td>'+press+'&nbsp;&nbsp;</td>&nbsp;&nbsp;'+'<td>'+price+'&nbsp;&nbsp;</td>&nbsp;&nbsp;'+'<td>'+indexs+'&nbsp;&nbsp;</td>&nbsp;&nbsp;'+'<td>'+date+'</td>'
                                    +'<td><a href=search?id='+id+'>操作</a></td>';
                                    $("#search").append(th);
                                    $("#search").append('<tr>'+tr+'</tr>');
                                }
                            console.log(id);
                                // alert(id);
                        },
                        error: function(){
                            console.log("数据返回失败！");
                        }
                    });
                });
            }
        </script>
	</head>
	<body >
    <div class="container" id="container">
        <div id="btn-prev" class="btn-ctrl">&lt;</div>
        <div id="btn-next" class="btn-ctrl">&gt;</div>
        <ul id="inner-list">
            <a href="search?id=1"><li><img src="../png/index3.jpg" alt=""/></li></a>
            <a href="search?id=1"><li><img src="../png/index4.jpg" alt=""/></li></a>
            <a href="search?id=1"><li><img src="../png/index7.jpg" alt=""/></li></a>
<%--            <a href="search?id=1"><li><img src="../png/index7.jpg" alt=""/></li></a>--%>
        </ul>
        <ul id="dot-list">
        </ul>
    </div>
    <div id="div-input">

        书名：<input type="text" id="bookname" name="bookname">&nbsp;&nbsp;作者：<input type="text" name="writer" id="writer">&nbsp;&nbsp;索引：<input
            type="text" id="indexs" name="indexs">&nbsp;&nbsp;主题：<input type="text" name="subject" id="subject">&nbsp;<button type="submit" id="sear">查询</button>
    </div>

     <div id="div-table" >
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
                <c:forEach items="${list}" var="list">
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
                    <td><a href="search?id=${list.id}&uid=<%=session.getAttribute("uid")%>">操作</a></td>
                </tr>
                </c:forEach>
            </table>
        </div>
        <div id="search">
        </div>
	</body>
</html>