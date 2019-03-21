<%--
  Created by IntelliJ IDEA.
  User: 12442
  Date: 2019/3/11
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/aes.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/pad-zeropadding.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/security.js"></script>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <title>dads</title>
</head>
<body>
<h1>登陆成功</h1>
<button id="select" onclick="sendData()">aa</button>
</body>
<script>
    function sendData(){
        alert("发送的数据:"+Encrypt(JSON.stringify({userLoginId:1})) )
        $.ajax({
            type: "GET",
            url:"api/userinf/userloginid",
            data:Encrypt(JSON.stringify({userLoginId:1})),
            dataType:'json',
            contentType:"application/json",
            success:function (resData) {
                alert(resData);
                alert(Decrypt(resData));
                alert(JSON.parse(Decrypt(resData)));
            }
            });
    }
</script>
</html>
