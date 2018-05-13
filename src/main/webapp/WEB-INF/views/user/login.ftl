<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>登录</title>
	<link href="/public-resources/css/bootstrap/bootstrap.css" rel="stylesheet"/>
	<link href="/public-resources/css/main.css" rel="stylesheet">

	<script type="text/javascript" src="/public-resources/js/jquery/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="/public-resources/js/bootstrap/bootstrap.min.js"></script>

</head>
<#include "../header.ftl">
<div class="login">
<div class="login-card">
	<div class="u-a-p-login">账号密码登录</div>
	<hr class="login-hr"/>
	<form action="/user/login" method="post">
		<div class="form-group">
			<input type="text" class="form-control" placeholder="example@exm.com" name="username" id="username">
		</div>
		<div class="form-group">
			<input type="password" class="form-control" placeholder="密码" name="password" id="password">
		</div>
		<br>
		<input type="submit" class="login-button" value="登录">
	</form>
</div>
</div>
<#include "../footer.ftl">
</body>
</html>