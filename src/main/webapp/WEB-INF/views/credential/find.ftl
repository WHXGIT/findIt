<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>FindIt</title>
	<link href="/public-resources/css/bootstrap/bootstrap.css" rel="stylesheet"/>
	<link href="/public-resources/css/layDate/theme/default/laydate.css" rel="stylesheet" />
	<link href="/public-resources/css/main.css" rel="stylesheet">
	<script type="text/javascript" src="/public-resources/js/jquery/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="/public-resources/js/laydate/laydate.js"></script>
	<script type="text/javascript" src="/public-resources/js/bootstrap/bootstrap.min.js"></script>
	<script type="text/javascript" src="/public-resources/js/main.js"></script>
</head>
<body>
<#include "../header.ftl">
<div class="main main-lost-title">
	<span><a onclick="changeMode(0);">身份证</a></span><span> | </span><span><a onclick="changeMode(1);">其他证件信息</a></span>
    <hr>
</div>

<form class="main-find" method="post" action="/credential/lost">
	<div class="input-group main-lost-group">
		<span class="input-group-addon main-lost-name" id="basic-addon1">证件持有人姓名：</span>
		<input required="required" name="credHoldName" type="text" class="form-control main-lost-input" placeholder="证件持有人姓名" aria-describedby="basic-addon1">
	</div>
	<div class="input-group main-lost-group">
		<span class="input-group-addon main-lost-name" id="basic-addon1">证件名称：</span>
		<input required="required" name="credName" type="text" class="form-control main-lost-input" placeholder="证件名称" aria-describedby="basic-addon1">
	</div>
	<div class="input-group main-lost-group">
		<span class="input-group-addon main-lost-name" id="basic-addon1">证件编号：</span>
		<input required="required" name="credNo" type="text" class="form-control main-lost-input" placeholder="证件编号" aria-describedby="basic-addon1">
	</div>
	<div class="input-group main-lost-group">
		<span class="input-group-addon main-lost-name" id="basic-addon1">证件持有人地址：</span>
		<input required="required" name="address" type="text" class="form-control main-lost-input" placeholder="证件持有人地址" aria-describedby="basic-addon1">
	</div>
	<div class="input-group main-lost-group">
		<span class="input-group-addon main-lost-name" id="basic-addon1">捡到大概时间：</span>
		<input id="findTime" required="required" name="lostTimeA" type="text" class="form-control main-lost-input" placeholder="捡到大概时间" aria-describedby="basic-addon1">
	</div>
	<div class="input-group main-lost-group">
		<span class="input-group-addon main-lost-name" id="basic-addon1">捡到大概地点：</span>
		<input required="required" name="pickAddress" type="text" class="form-control main-lost-input" placeholder="丢失大概地点" aria-describedby="basic-addon1">
	</div>
	<div class="input-group main-lost-group">
		<span class="input-group-addon main-lost-name" id="basic-addon1">微报酬：</span>
		<input required="required" name="microReward" type="number" class="form-control main-lost-input" placeholder="微报酬" aria-describedby="basic-addon1">
	</div>
	<div class="input-group main-lost-group">
		<span class="input-group-addon main-lost-name" id="basic-addon1">描述：</span>
		<input required="required" name="description" type="text" class="form-control" placeholder="描述" aria-describedby="basic-addon1">
	</div>
	<div style="width: 100%;">
		<input required="required" class="main-lost-button" type="submit" value="发布"/>
	</div>
</form>

<form class="main-identify" method="post" action="/credential/upload" enctype="multipart/form-data">
    <div style="margin-left: 65px">
        <span>请确保您上传的照片是 <b>身份证</b>，否则请选择 <b>其他证件信息</b></span>
	    <a href="javascript:;" class="a-upload"><input type="file" name="img">点击请选择上传文件</a>
    </div>
	<div class="input-group main-lost-group">
		<span class="input-group-addon main-lost-name" id="basic-addon1">微报酬：</span>
		<input required="required" name="microReward" type="text" class="form-control main-lost-input" placeholder="微报酬" aria-describedby="basic-addon1">
	</div>
	<input type="submit" value="提交" class="main-lost-button">
</form>

<#include "../footer.ftl">
</body>
<script>
	//执行一个laydate实例
	laydate.render({
		elem: '#findTime'
		,type: 'datetime'
	});
</script>
</html> 