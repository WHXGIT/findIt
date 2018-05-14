<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>FindIt</title>
	<link href="/public-resources/css/bootstrap/bootstrap.css" rel="stylesheet"/>
	<link href="/public-resources/css/main.css" rel="stylesheet">
	<script type="text/javascript" src="/public-resources/js/main.js"></script>
	<script type="text/javascript" src="/public-resources/js/jquery/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="/public-resources/js/bootstrap/bootstrap.min.js"></script>
</head>
<body>
<#include "../header.ftl">
<form class="main-lost">
	<div class="main-lost-title">
		<span>捡到证件信息</span>
	</div>
	<div class="input-group main-lost-group">
		<span class="input-group-addon main-lost-name" id="basic-addon1">证件持有人姓名：</span>
		<input type="text" class="form-control main-lost-input" placeholder="证件持有人姓名" aria-describedby="basic-addon1">
	</div>
	<div class="input-group main-lost-group">
		<span class="input-group-addon main-lost-name" id="basic-addon1">证件名称：</span>
		<input type="text" class="form-control main-lost-input" placeholder="证件名称" aria-describedby="basic-addon1">
	</div>
	<div class="input-group main-lost-group">
		<span class="input-group-addon main-lost-name" id="basic-addon1">证件编号：</span>
		<input type="text" class="form-control main-lost-input" placeholder="证件编号" aria-describedby="basic-addon1">
	</div>
	<div class="input-group main-lost-group">
		<span class="input-group-addon main-lost-name" id="basic-addon1">捡到大概时间：</span>
		<input type="text" class="form-control main-lost-input" placeholder="丢失大概时间" aria-describedby="basic-addon1">
	</div>
	<div class="input-group main-lost-group">
		<span class="input-group-addon main-lost-name" id="basic-addon1">捡到大概地点：</span>
		<input type="text" class="form-control main-lost-input" placeholder="丢失大概地点" aria-describedby="basic-addon1">
	</div>
	<div class="input-group main-lost-group">
		<span class="input-group-addon main-lost-name" id="basic-addon1">微报酬：</span>
		<input type="text" class="form-control main-lost-input" placeholder="微报酬" aria-describedby="basic-addon1">
	</div>
	<div class="input-group main-lost-group">
		<span class="input-group-addon main-lost-name" id="basic-addon1">描述：</span>
		<input type="text" class="form-control" placeholder="描述" aria-describedby="basic-addon1">
	</div>
	<div style="width: 100%;">
		<input class="main-lost-button" type="submit" value="发布"/>
	</div>
</form>
<#include "../footer.ftl">
</body>
</html> 