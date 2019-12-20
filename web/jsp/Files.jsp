<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<% String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath %>">
		<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
		<title>title</title>
		<script src="/js/jquery-3.4.1.js"></script>
	</head>
	<body>
<%--    <form action=""  enctype="multipart/form-data">--%>
<%--        <table>--%>
<%--                   <tr>--%>
<%--                      <td></td>--%>
<%--                       <td><h1>文件上传</h1></td>--%>
<%--                   </tr>--%>
<%--                  <tr>--%>
<%--                      <td>文件描述:</td>--%>
<%--                    <td><input type="text" name="desc"/></td>--%>
<%--                 </tr>--%>
<%--                   <tr>--%>
<%--                        <td>上传文件:</td>--%>
<%--                        <td><input type="file" name="file"/></td>--%>
<%--                     </tr>--%>
<%--                     <tr>--%>
<%--                         <td></td>--%>
<%--                         <td><input type="submit" value="上传文件"/></td>--%>
<%--                     </tr>--%>
<%--                 </table>--%>
<%--        <div>--%>
<%--                <h2>下载文件</h2>--%>
<%--                 <c:forEach items="${files }" var="name">--%>
<%--                    <a href="upload/${name }">${name }</a><br/>--%>
<%--                 </c:forEach>--%>
<%--             </div>--%>
<%--    </form>--%>
<script>
	function send(){
		$(document).ready(function () {
			var formData = new FormData();
			var file = document.getElementById('file').files[0];
			formData.append("file", file);
			$.ajax({
						url: "png",
						type: "post",
						data: formData,
						dataType: "json",
						// cache: false,//上传文件无需缓存
						processData: false,//用于对data参数进行序列化处理 这里必须false
						contentType: false, //必须*/
						success: function (data) {
							console.log(data);
						}
					}
			)
		})
	}
	$("#tj").click(function () {
		send();
	})

</script>
<form enctype="multipart/form-data">
	选择图片：<input type="file" name="file" id="file"><br>
	<button id="tj">提交</button>
</form>
	</body>

</html>