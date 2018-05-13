<div class="header">
	<nav class="navbar navbar-inverse header-nav">
		<div class="container-fluid row">
			<div role="presentation" class="active col-md-2">
				<div class="glyphicon glyphicon-globe logo">
					<span class="logo-font">FindIt</span>
				</div>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse col-md-8" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a class="header-nav-but" href="/">首页</a></li>
					<li><a class="header-nav-but" href="#">发布信息</a></li>
					<li><a class="header-nav-but" href="#">找回证件</a></li>
					<li><a class="header-nav-but" href="#">感谢信</a></li>
					<li><a class="header-nav-but" href="#">宣传墙</a></li>
					<li><a class="header-nav-but" href="#">责任声明</a></li>
					<li><a class="header-nav-but" href="/user/readMe">我的中心</a></li>
				</ul>
			</div><!-- /.navbar-collapse -->

			<div class="col-md-2 login_and_reg">
            <#if Session["userVO"]?exists>
	            <span>欢迎您：${Session["userVO"].nickname}</span>
	            <span><a href="/logout"> 退出</a></span>
                <#else>
	                <span><a href="/login">登录</a></span>
	                <span><a href="/register">注册</a></span>
            </#if>

			</div>
		</div><!-- /.container-fluid -->
	</nav>
</div>