
<!DOCTYPE html>
<html lang="en" >

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Login Form</title>



    <link rel="stylesheet" type="text/css" href="/css/style.css">


</head>

<body>

<body>
<div class="login">
    <div class="login-screen">
        <div class="app-title">
            <h1>登陆</h1>
        </div>

        <form action="/user/loginVerify">
        <div class="login-form">
            <div class="control-group">
                <input type="text" class="login-field" value="" placeholder="username" id="login-name" name="userName">
                <label class="login-field-icon fui-user" for="login-name"></label>
            </div>

            <div class="control-group">
                <input type="password" class="login-field" value="" placeholder="password" id="login-pass" name="userPass">
                <label class="login-field-icon fui-lock" for="login-pass"></label>
            </div>

            <input type="submit" class="btn btn-primary btn-large btn-block" value="login" href="/user/loginVerify">
            <a class="login-link" href="#">Lost your password?</a>
        </div>
        </form>
    </div>
</div>
</body>



</body>

</html>
