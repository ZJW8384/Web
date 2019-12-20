<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<% String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath %>">
		<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
		<title>修改教师信息</title>
        <link rel="stylesheet" href="../css/teacher.css">
	</head>
	<body>
    <div id="upt">
        <form action="upuser" method="post">
        <c:forEach items="${listff}" var="list">
            用户名：<input type="text" id="uid" name="uid" value="${list.tid}" readonly>密码：<input type="text" name="pass" id="pass" value="${list.pass}"><br><br>
            姓名：<input type="text" id="name" name="name" value="${list.name}">性别：<input type="text" id="sex" name="sex" value="${list.sex}"><br><br>
            年龄：<input type="text" id="age" name="age" value="${list.age}">单位：<input type="text" name="units" id="units" value="${list.units}"><br><br>
            联系方式：<input type="text" id="phone" name="phone" value="${list.phone}"><br><br><br>
            <button type="submit">提交</button><button type="reset">重置</button>
        </c:forEach>
        </form>
    </div>
	</body>
</html>
