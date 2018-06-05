<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>FindIt</title>
	<link href="/public-resources/css/bootstrap/bootstrap.css" rel="stylesheet"/>
	<link href="/public-resources/css/main.css" rel="stylesheet">
	<script type="text/javascript" src="/public-resources/js/jquery/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="/public-resources/js/bootstrap/bootstrap.min.js"></script>
	<script type="text/javascript" src="/public-resources/js/main.js"></script>
</head>
<body>
<#include "header.ftl">
<div class="main">
	<div class="row main-all-card-group">
		<div class="col-md-3 main-all-card">
			<div class="main-all-card-content">
					<span class="index-card-title">
						总发布证件
                        <span style="color: #A8A693;float: right;" class="glyphicon glyphicon-info-sign"></span>
					</span>
                    <br/>
                    <span id="all-cred-no" class="index-card-number">
                            133 件
                    </span>
                    <hr class="index-card-hr"/>
                    <span id="all-user-no" class="index-card-span">用户数量:11</span>
			</div>
		</div>
		<div class="col-md-3 col-md-offset-1 main-all-card">
			<div class="main-all-card-content">
					<span class="index-card-title">
						证件已寻找
                        <span style="color: #A8A693;float: right;" class="glyphicon glyphicon-info-sign"></span>
					</span>
                    <br/>
                    <span id="get-cred" class="index-card-number">
                                166003 件
                    </span>
				<hr class="index-card-hr"/>
                    <span id="unfind-cred" class="index-card-span">未被寻找证件:</span>
			</div>
		</div>
		<div class="col-md-3 col-md-offset-1 main-all-card">
			<div class="main-all-card-content">
					<span class="index-card-title">
						收到感谢信
                        <span style="color: #A8A693;float: right;" class="glyphicon glyphicon-info-sign"></span>
					</span>
                    <br/>
                    <span id="get-letter" class="index-card-number">
                                166003 封
                    </span>
				<hr class="index-card-hr"/>
				<span id="involve-user" class="index-card-span">涉及使用人数:</span>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="panel panel-default col-md-7 main-activity-card">
			<div class="panel-heading" style="border-left: 1px solid #dddddd">
				<h3 class="panel-title"><b>动态</b></h3>
			</div>
			<div class="panel-body">
				<div id="index-activity">

                </div>
			</div>
		</div>
		<div class="col-md-4 main-connectandquick-card">
			<div class="panel panel-default main-connect-card">
				<div class="panel-heading">
					<h3 class="panel-title"><b>快速开始/便捷导航</b></h3>
				</div>
				<div class="panel-body">
					<div>
                        <a class="index-quick-a" href="/find">发布物品</a><a class="index-quick-a" href="/search">寻找物品</a><a class="index-quick-a" href="/letter">感谢信</a>
                    </div>
				</div>
			</div>
			<div class="panel panel-default main-quick-card">
				<div class="panel-heading">
					<h3 class="panel-title"><b>联系我们</b></h3>
				</div>
				<div class="panel-body">
					<img class="index-connect-img" src="/public-resources/image/wechat-code.png">
                    <span style="text-align: center">如果您有问题或者有好的建议请用微信扫描二维码联系我们！！！</span>
				</div>
			</div>
		</div>
	</div>

</div>
<#include "footer.ftl">
</body>
<script>
    onloadInit();
</script>
</html> 