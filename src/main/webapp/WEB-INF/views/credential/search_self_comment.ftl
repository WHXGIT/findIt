<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>FindIt</title>
	<link href="/public-resources/css/bootstrap/bootstrap.css" rel="stylesheet"/>
	<link href="/public-resources/css/main.css" rel="stylesheet">
	<link href="/public-resources/css/kkpager/kkpager_blue.css" rel="stylesheet">
	<link href="/public-resources/css/kkpager/kkpager_orange.css" rel="stylesheet">
	<script type="text/javascript" src="/public-resources/js/jquery/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="/public-resources/js/bootstrap/bootstrap.min.js"></script>
	<script type="text/javascript" src="/public-resources/js/kkpager/kkpager.min.js"></script>
	<script type="text/javascript" src="/public-resources/js/main.js"></script>
</head>
<body>
<#include "../header.ftl">
<div class="main">
	<div class=" input-group search-input-group">
		<input id="searchCredNo" type="text" class="form-control search-input" placeholder="证件编号">
		<input id="searchCredName" type="text" class="form-control search-input" placeholder="证件名">
		<input id="searchCredHoldName" type="text" class="form-control search-input" placeholder="证件持有人姓名">
		<span class="input-group-btn">
        <button class="btn btn-default" onclick="('Init', null);">搜索</button>
      </span>
	</div>
</div>
<div class="main">
	<div class="row" id="showList">

	</div>
	<div id="kkpager" class="page-kkpager">
	</div>
</div>
<#include "../footer.ftl">
</body>
<script>
	searchSelfCommentCred(9, 1, '${exType}', '${type}');
</script>
</html>