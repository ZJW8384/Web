<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/9
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>表单重复提交测试</title>
    <script src="../js/jquery-3.4.1.js"></script>
    <script>
        // $(document).ready(function () {
        //     var flag=true;
        //     $("#sub").click(function () {
        //        if (flag){
        //            flag=false
        //            // $("#sub").attr('disabled',true);
        //            var  name=document.getElementById("name").value;
        //            alert(name)
        //            return true;
        //        }else {
        //            alert("请勿重复提交！");
        //            return false;
        //        }
        //
        //     })
        // })
        // $(document).ready(function () {
        //     $("#alt").click(function () {
        //         var inputf=$("#file");
        //         inputf.addEventListener("change",function () {
        //             var reader = new FileReader();
        //             reader.readAsDataURL(inputf.file[0]);
        //             reader.onload=function () {  console.log(this.result)}
        //
        //         })
        //     })
        //
        // })
    </script>
    <style type="text/css">
        img{
            display: block;
            width: 200px;
            margin: 50px;
            background: #eee;
        }
    </style>
</head>
<body>
<%--<form action="#">--%>
<%--    用户名：<input type="text" id="name" autocomplete="off"><br><br>--%>
<%--    密  码：<input type="password" id="pass"><br><br>--%>
<%--    <button type="submit" id="sub">提交</button>--%>
<%--</form>--%>
<%--<input type="file" id="selectFiles" onchange="dealSelectFiles()" multiple webkitdirectory>--%>
<%--<canvas id="myCanvas" width=1440 height=900></canvas>--%>

<%--<script type="text/javascript">--%>
<%--    var imgPosX = 0;--%>
<%--    var imgWidth = 256;--%>
<%--    function dealSelectFiles(){--%>
<%--        /// get select files.--%>
<%--        var selectFiles = document.getElementById("selectFiles").files;--%>
<%--        for(var file of selectFiles){--%>
<%--            console.log(file.webkitRelativePath);--%>
<%--            /// read file content.--%>
<%--            var reader = new FileReader();--%>
<%--            reader.readAsDataURL(file);--%>
<%--            reader.onloadend = function(){--%>
<%--                /// deal data.--%>
<%--                var img = new Image();--%>
<%--                /// after loader, result storage the file content result.--%>
<%--                img.src = this.result;--%>
<%--                alert(this.result);--%>
<%--                img.onload = function(){--%>
<%--                    var myCanvas = document.getElementById("myCanvas");--%>
<%--                    var cxt = myCanvas.getContext('2d');--%>
<%--                    cxt.drawImage(img, imgPosX, 0);--%>
<%--                    imgPosX += imgWidth;--%>
<%--                }--%>
<%--            }--%>
<%--        }--%>
<%--    }--%>
<%--</script>--%>
</body>
<%--<input type="file" id="fileBtn">--%>
<%--<img id="img" src="" alt="">--%>
<%--<input type="button" id="show" value="显示图片" />--%>


<%--<script src="http://s9.qhimg.com/lib/jquery/1102.js"></script>--%>
<%--<script type="text/javascript">--%>
<%--    var $file = $('#fileBtn'),--%>
<%--        $img = $('#img'),--%>
<%--        $show = $('#show');--%>
<%--    /**--%>
<%--     * 获取本地文件路径--%>
<%--     * @param  {[type]} node HTML元素--%>
<%--     * @param  {[type]} callback 回调函数--%>
<%--     */--%>
<%--    function handleFilePath(node, callback){--%>
<%--        var path = '',--%>
<%--            file = null;--%>
<%--        if (node) {--%>
<%--            var ua = window.navigator.userAgent;--%>
<%--            //IE--%>
<%--            if (ua.indexOf('MSIE') > -1) {--%>
<%--                node.select();--%>
<%--                path =  document.selection.createRange().text;--%>
<%--            }else{--%>
<%--                try{--%>
<%--                    //支持html5的浏览器,比如高版本的firefox、chrome、ie10--%>
<%--                    if (FileReader && node.files && node.files[0]) {--%>
<%--                        //异步处理--%>
<%--                        var reader = new FileReader();--%>
<%--                        reader.onload = function (e) {--%>
<%--                            path = e.target.result;--%>
<%--                            console.log('filePath:' + path);--%>
<%--                            callback && callback(path);--%>
<%--                        };--%>
<%--                        reader.readAsDataURL(node.files[0]);--%>
<%--                        return;--%>
<%--                    }else{--%>
<%--                        if(node.files && node.files[0] ){--%>
<%--                            file = node.files[0];--%>
<%--                        }else if(node.files && node.files.item(0)) {--%>
<%--                            file = node.files.item(0);--%>
<%--                        }--%>
<%--                        try{--%>
<%--                            //Firefox7.0--%>
<%--                            path =  file.getAsDataURL();--%>
<%--                        }catch(e){--%>
<%--                            //Firefox8.0以上--%>
<%--                            path = window.URL.createObjectURL(file);--%>
<%--                        }--%>
<%--                    }--%>
<%--                }catch(e){--%>
<%--                    console.log('无法获取！');--%>
<%--                }--%>
<%--            }--%>

<%--            console.log('filePath:' + path);--%>
<%--        }else{--%>
<%--            console.log('node为空！');--%>
<%--        }--%>
<%--        callback && callback(path);--%>
<%--    }--%>

<%--    //获取按钮--%>
<%--    $show.on('click',function(e){--%>
<%--        if ($file.val()) {--%>
<%--            //获取本地文件路径--%>
<%--            handleFilePath($file[0], function(imgPath){--%>
<%--                if (imgPath) {--%>
<%--                    $img.attr('src', imgPath);--%>
<%--                    console.log('success!');--%>
<%--                }else{--%>
<%--                    console.log('failure!');--%>
<%--                }--%>
<%--            });--%>
<%--        }else{--%>
<%--            console.log('请先选择本地图片！');--%>
<%--        }--%>
<%--        return false;--%>
<%--    });--%>
<%--</script>--%>
</html>
