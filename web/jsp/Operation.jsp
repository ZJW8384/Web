<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<% String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath %>">
		<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
		<title>借阅界面</title>
        <link rel="stylesheet" href="/css/operation.css">
        <script src="/js/jquery-3.4.1.js"></script>
        <script>
            $(document).ready(function () {
                var bower=$("#bower"); var res=$("#res");
                var del=$("#del");var bksadd=$("#bksadd");
                var whom="<%=session.getAttribute("user")%>";
                var userNmae="<%=session.getAttribute("uid")%>";
                var less=<%=session.getAttribute("less")%>;
                var number=<%=session.getAttribute("number")%>;
                var  ids=$("#id");
                var deletes=$("#delete");
                var  tes=$("#texts");
                var send=$("#send");
                var evaluate=$("#evaluate");
                del.hide();
                res.hide();
                bksadd.hide();
                ids.hide();
                deletes.hide();
                bower.click(function () {
                    if(whom==="2"){
                        if(less>=3){
                            alert("借书数量已达上限");
                            return false;
                        }else {
                            return true;
                        }
                    }else if(whom==="3"){
                        if(less>5){
                            return false;
                        }else {
                            return true;
                        }
                    }
                });
                if(number===0){
                    bower.attr(disabled);
                }
                if(whom==="1"){
                    del.show();
                    res.show();
                    bower.hide();
                    evaluate.hide();
                }
                res.click(function () {
                    bksadd.show();
                    });
                $(".close").click(function () {
                    bksadd.hide();
                    deletes.hide();
                });
                del.click(function () {
                    deletes.show();
                });
                send.click(function () {
                    if(tes.val()===""){
                        alert(userNmae);
                        alert("内容不能为空！");
                        return false;
                    }else {
                        return true;
                    }
                })
            })

        </script>
	</head>
	<body>
        <div id="bkinfo">
           <c:forEach items="${list2}" var="list2">
               <div id="div-left">
                   <span >书名：<span class="color-red">${list2.bkname}</span></span><br>
                   <span >责任者：${list2.writer}</span><br>
                   <span >ISBN：${list2.ISBN}</span><br>
                   <span >中图分类：${list2.classify}</span><br>
                   <span >出版地：${list2.place}</span><br>
                   <span >文献类型：<span class="color-red">${list2.type}</span></span><br>
                   <span >出版社：${list2.press}</span>
               </div>

               <div id="div-right">
                    <span>索书号：<span class="color-red">${list2.indexs}</span></span><br>
                   <span >价格：${list2.price}</span><br>
                   <span >主题词：${list2.subject}</span><br>
                   <span >出版时间：${list2.date}</span><br>
                   <span >语种：${list2.language}</span>
               </div>
               <div id="div-img">

               </div>
           </c:forEach>
            <span id="hr">操作</span>
            <div id="but">
                <c:forEach items="${list2}" var="list2">
                <button  type="button" id="bower"><a href="borrowBook?bkid=${list2.bkid}&bkname=${list2.bkname}&id=${list2.id}&uid=<%=session.getAttribute("uid")%>&flag=<%=session.getAttribute("user")%>">借书</a></button>
                <button type="button" id="res">修改</button>
                <button type="button" id="del">删除</button>
                </c:forEach>
            </div>
        </div>
        <div id="bksadd">
            <c:forEach items="${list2}" var="list2">
            id:${list2.bkid}
            <form action="upBook?bkid=${list2.bkid}" method="post">
                <span><button class="close" type="reset">X</button></span>
                <input type="text" id="id" name="id" value="${list2.id}">
                图书名称：<input type="text" id="bkname" name="bkname" value="${list2.bkname}">&nbsp;作者：<input type="text" id="writer" name="writer" value="${list2.writer}">&nbsp;ISBN：<input type="text" id="ISBN" name="ISBN" value="${list2.ISBN}"><br><br><br>
                中图分类：<input type="text" id="classify" name="classify" value="${list2.classify}">&nbsp;出版地：<input type="text" id="place" name="place" value="${list2.place}">&nbsp;出版社：<input type="text" id="press" name="press" value="${list2.press}"><br><br><br>
                索书号：<input type="text" id="indexs" name="indexs" value="${list2.indexs}">&nbsp;价格：<input type="text" id="price" name="price" value="${list2.price}">&nbsp;主题词：<input type="text" id="subject" name="subject" value="${list2.subject}"><br><br><br>
                出版时间：<input type="text" id="date" name="date" value="${list2.date}">&nbsp;语种：<input type="text" id="language" name="language" value="${list2.language}">&nbsp;数量：<input type="text" id="number" name="number" value="${list2.number}"><br><br>
                <button type="submit">提交</button><button type="reset">重置</button>
            </c:forEach>
            </form>
        </div>
        <div id="delete">
            <c:forEach items="${list2}" var="list2">
            <form action="upBook?bkid=${list2.bkid}" method="get">
                <span><button class="close" type="reset" style="position: relative;top: 10px">X</button></span>
                图书编号：<input type="text" id="bkid" name="bkid" value="${list2.bkid}" readonly>
                <button type="submit">删除</button>
            </form>
            </c:forEach>
        </div>
    <div id="more-message">
        <table border="1" cellspacing="0" cellpadding="0">
            <c:forEach items="${list2}" var="list2">
            <th>馆藏地</th>
            <th>馆藏号</th>
            <th>条纹码</th>
            <th>状态("1"可借，"0"不可借)</th>
            <tr>
                <td>${list2.collection}</td>
                <td>${list2.collections}</td>
                <td>${list2.barcode}</td>
                <td >${list2.state}</td>
            </tr>
            </c:forEach>
        </table>
    </div>
    <div id="evaluate">
        <fieldset>
            <legend>书评：</legend>
            <c:forEach items="${list2}" var="list2">
        <form action="evaluate?bkid=${list2.bkname}&user=<%=session.getAttribute("uid")%>" method="post">
            </c:forEach>
        <textarea name="texts" id="texts" cols="30" rows="10" placeholder="输入你评价"></textarea><br>
        <button id="send" type="submit">评价</button>
        <button id="rs" type="reset">重置</button>
        </form>
        </fieldset>
    </div>
	</body>
</html>