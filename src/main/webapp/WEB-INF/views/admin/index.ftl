<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Title</title>
	<link href="/public-resources/css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/public-resources/css/main.css">
	<link href="/public-resources/css/admin.css" rel="stylesheet">
	<script type="text/javascript" src="/public-resources/js/jquery/jquery-3.3.1.min.js"></script>
	<script src="/public-resources/js/index.js" type="text/javascript"></script>
    <script type="text/javascript" src="/public-resources/js/util.js"></script>

</head>
<body>
<div>
	<nav class="navbar navbar-inverse" style="border-radius: 0;">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header" style="margin-left: 227px;">
				<a class="navbar-brand" style="font-size: 20px;
    color: white;" href="#">证件招领网站后台管理系统</a>
			</div>
		</div><!-- /.container-fluid -->
	</nav>
</div>
<div class="row">
	<div class="left-menu col-md-3">
		<ul id="accordion" class="accordion">
			<li>
				<div class="link"><i class="fa fa-paint-brush"></i><span class="glyphicon glyphicon-credit-card">
            </span><label style="padding-left: 20px;">证件管理</label><i class="fa fa-chevron-down"></i></div>
				<ul class="submenu">
					<li><a href="#">证件审核</a></li>
				</ul>
			</li>
			<li>
				<div class="link"><i class="fa fa-code"></i><span class="glyphicon glyphicon-user"></span>
					<label style="padding-left: 20px;">用户管理</label><i class="fa fa-chevron-down"></i></div>
				<ul class="submenu">
					<li><a href="#">账号管理</a></li>
				</ul>
			</li>
		</ul>
	</div>

	<div class="col-md-9">
        <div onclick="clickListUser(9, 1);" class="function-card">
	        <div class="admin-card-span">
		        <span>显示所有用户</span>
	        </div>

        </div>

		<div onclick="clickListCred(9, 1);" class="function-card">
			<div class="admin-card-span">
				<span>待审核证件信息</span>
			</div>
		</div>

        <hr class="function-hr">

        <div id="list-table" class="function-list">
            <span>点击上面卡片显示内容</span>
        </div>
	</div>
</div>
<div style="margin-top: 20px;">
	<div class="admin-footer well well-lg">Copyright All rights reserved. 版权所有</div>
</div>
</body>
</html>