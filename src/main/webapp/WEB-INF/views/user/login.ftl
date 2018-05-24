<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>登录</title>
	<link href="/public-resources/css/bootstrap/bootstrap.css" rel="stylesheet"/>
	<link href="/public-resources/css/main.css" rel="stylesheet">
    <link href="/public-resources/css/layDate/theme/default/laydate.css" rel="stylesheet" />
	<script type="text/javascript" src="/public-resources/js/jquery/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="/public-resources/js/laydate/laydate.js"></script>
	<script type="text/javascript" src="/public-resources/js/bootstrap/bootstrap.min.js"></script>
	<script type="text/javascript" src="/public-resources/js/main.js"></script>
</head>
<body>
<#include "../header.ftl">
<div class="login">
	<div class="login-card">
        <div class="login-card-content">
		<div class="u-a-p-login">账号密码登录</div>
		<hr class="login-hr"/>
            <span class="login-error-message">${errorMessage!""}</span>
		<form action="/user/login" method="post">
			<div class="form-group">
				<input required="required" type="email" class="form-control" placeholder="example@exm.com" name="username" id="username">
			</div>
			<div class="form-group">
				<input required="required" type="password" class="form-control" placeholder="密码" name="password" id="password">
			</div>
			<div class="row form-group">
				<input style="width: 201px;" required="required" type="text" class="col-md-8 form-control" placeholder="验证码" name="code">
				<i><img onclick="changeCode();" style="height:33px;" id="codeImg" alt="点击更换" title="点击更换" src="/captcha-image"/></i>
			</div>
			<input type="submit" class="login-button" value="登录">
		</form>
        </div>
	</div>
</div>
<#include "../footer.ftl">
</body>
</html>