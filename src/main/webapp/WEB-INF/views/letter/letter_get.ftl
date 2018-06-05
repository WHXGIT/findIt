<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>FindIt</title>
	<link href="/public-resources/css/bootstrap/bootstrap.css" rel="stylesheet"/>
	<link href="/public-resources/css/kkpager/kkpager_blue.css" rel="stylesheet">
	<link href="/public-resources/css/kkpager/kkpager_orange.css" rel="stylesheet">
	<link href="/public-resources/css/main.css" rel="stylesheet">

	<script type="text/javascript" src="/public-resources/js/jquery/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="/public-resources/js/bootstrap/bootstrap.min.js"></script>
	<script type="text/javascript" src="/public-resources/js/kkpager/kkpager.min.js"></script>
	<script type="text/javascript" src="/public-resources/js/wangEditor/wangEditor.min.js"></script>
    <script type="text/javascript" src="/public-resources/js/main.js"></script>
    <script type="text/javascript" src="/public-resources/js/letter.js"></script>
    <script type="text/javascript" src="/public-resources/js/util.js"></script>
</head>
<body>
<#include "../header.ftl">
    <div class="main">
        <div class="letter-add" onclick="addLetter();">
            +添加
        </div>
        <div id="showList">

        </div>
	    <div id="kkpager">
	    </div>
    </div>
<div id="letter-detail" class="main letter-detail-style">
	<div>
		<label>标题</label><span id="letter-title"></span>
	</div>
	<div>
		<label>收信人</label><span id="letter-get-user"></span>
	</div>
	<div>
		<label>写信人</label><span id="letter-sent-user"></span>
	</div>
	<div>
		<label>写信时间</label><span id="letter-sent-time"></span>
	</div>
	<div>
		<label>信件内容</label>
        <div id="letter-content" class="letter-background"></div>
	</div>
	<div class="main">
		<button onclick="letterDetailHide();" class="button">确定</button>
	</div>

</div>
<#include "../footer.ftl">
</body>
<script>
	searchGetLetter(9, 1);
</script>
</html>