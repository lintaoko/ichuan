
<!DOCTYPE html>
<html lang="en" >

<head>
    <%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
    <title>登陆后台管理系统</title>

    <%--<link rel="stylesheet" type="text/css" href="css/style.css">--%>


</head>


<body>
<div class="login">
    <div class="login-screen">
        <div class="app-title">
            <h1>登陆</h1>
        </div>

        <form action="/loginProcessingUrl" method="post">
                <input type="text" placeholder="username" id="username" name="username">
                <input type="password" placeholder="password" id="password" name="password">
            <input type="submit" name="submit" value="提交">
        </form>
    </div>
</div>
</body>




</html>
