<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>注册</title>
	<link href="/public-resources/css/bootstrap/bootstrap.css" rel="stylesheet"/>
	<link href="/public-resources/css/main.css" rel="stylesheet">

	<script type="text/javascript" src="/public-resources/js/jquery/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="/public-resources/js/bootstrap/bootstrap.min.js"></script>
	<script type="text/javascript" src="/public-resources/js/main.js"></script>

</head>
<body>
<#include "../header.ftl">
<div class="container">
	<h3>欢迎注册</h3>
	<span class="login-error-message">${errorMessage!""}</span>
	<form action="/user/reg" method="post">
		<div class="form-group">
			<label for="exampleInputEmail1">昵称</label>
			<input type="text" class="form-control" placeholder="4到16位（字母，数字，下划线，减号）" name="nickname" id="nickname">
		</div>
		<div class="alert alert-warning alert-dismissible err1" role="alert">
			<button type="button" class="close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong></strong>
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">邮箱</label>
			<input type="text" class="form-control" placeholder="请输入邮箱地址" name="username" id="email">
		</div>
		<div class="alert alert-warning alert-dismissible err2" role="alert">
			<button type="button" class="close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong></strong>
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">电话</label>
			<input type="text" class="form-control" placeholder="请输入电话号码" name="phone" id="phone">
		</div>
		<div class="alert alert-warning alert-dismissible err3" role="alert">
			<button type="button" class="close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong></strong>
		</div>

		<div class="form-group">
			<label for="exampleInputPassword1">密码</label>
			<input type="password" class="form-control" id="password1" placeholder="请输入密码" name="password">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">确认密码</label>
			<input type="password" class="form-control" placeholder="再次输入密码" id="password2">
		</div>

		<div class="alert alert-warning alert-dismissible err4" role="alert">
			<button type="button" class="close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong></strong>
		</div>
		<div class="form-group" id="yanzheng">
			<label for="exampleInputEmail1">验证码</label><br>
			<input style="display: inline-block;" type="text" name="code" class="form-control" placeholder="请输入验证码" id="shuru">
			<img style="height:33px;" id="kaptchaImage" alt="点击更换" title="点击更换" src="/captcha-image"/>
			<a style="font-size: 13px;" href="javascript:chageCode()">看不清？换一张</a>
		</div>

		<button id=registerBtn>注册</button>
		<a class="already_login" href="/login">使用已有账号登录</a>
	</form>
</div>



<script>





	//---------------jquery----------------
	$(function () {

		var flag1=flag2=flag3=flag4=flag5=flag6 = false;

		var userName = /^[a-zA-Z0-9_-]{4,30}$/ //用户名正则，4到30位（字母，数字，下划线，减号）
		var phoneNum = /^1[34578]\d{9}$/; //手机号验证
		var Email = /^\w+@\w+.\w+$/; //邮箱验证

		$('.close').on('click', function () {
			$(this).parent().css({
				'display': 'none'
			});
		})
		$('#username').on('blur', function () {
			console.log($(this).val());
			var username = $(this).val();
			if (!userName.test(username)) {
				$('.err1').css({
					'display': 'block'
				});
				$('.err1 strong').html('请输入正确的昵称格式')
				flag1=false;


			} else {
				console.log('昵称输入正确');

				flag1=true;

			}


		})
		$('#username').on('focus', function () {
			$('.err1').css({
				'display': 'none'
			});


		})



		//邮箱
		$('#email').on('blur', function () {
			console.log($(this).val());
			var email = $(this).val();
			if (!Email.test(email)) {
				$('.err2').css({
					'display': 'block'
				});
				$('.err2 strong').html('请输入正确的邮箱格式');
				flag2=false;

			} else {
				console.log('邮箱格式正确');
				flag2=true;

			}


		})

		$('#email').on('focus', function () {
			$('.err2').css({
				'display': 'none'
			});


		})

		//手机
		$('#phone').on('blur', function () {
			console.log($(this).val());
			var phonenum = $(this).val();
			if (!phoneNum.test(phonenum)) {
				$('.err3').css({
					'display': 'block',
				})
				$('.err3 strong').html('请输入正确的手机号码')
				flag3=false;


			} else {
				console.log('手机格式正确');
				flag3=true;


			}


		})

		$('#phone').on('focus', function () {
			$('.err3').css({
				'display': 'none'
			});


		})

		//密码验证
		$('#password1').on('blur', function () {
			var password1 = $(this).val();

			return password1;
			flag4=true;
		})
		$('#password2').on('blur', function () {
			var password1 = $('#password1').val();
			var password2 = $(this).val();
			console.log(password1, password2)
			if (password1 == password2) {
				console.log('输入一致');
				flag5=true;


			} else {
				$('.err4').css({
					'display': 'block',
				})
				$('.err4 strong').html('密码不一致，请重新检查')
				flag5=false;


			}
		})

		$('#password2').on('focus', function () {
			$('.err4').css({
				'display': 'none'
			});


		})
		//验证码

		$('#huoqu').on('click', function () {

			var string = randomRange(5);
			console.log(string);
			$('#shuru').val(string);
			flag6=true;
		})


		//-------------------false--
		$('#registerBtn').on('click',function(){
			if (flag1 && flag2 && flag3 && flag4 && flag5 && flag6 ) {
				$.ajax()// 发送请求

			} else {
				location.href('reisster.html');
			}
		})


	})
</script>
<#--<form method="post" action="/user/reg">
	<label>用户名：</label>
	<input type="text" name="username" placeholder="example@ex.com"/>
	<br>
	<label>密 码：</label>
	<input type="text" name="password" placeholder="请输入密码"/>
	<br>
	<label>昵 称：</label>
	<input type="text" name="nickname" placeholder="请输入昵称"/>
	<br>
	<label>电 话：</label>
	<input type="text" name="phone" placeholder="请输入电话号码"/>
	<br>
	<span><a>取消</a></span>
	<input type="submit" value="注册">
</form>-->
</body>