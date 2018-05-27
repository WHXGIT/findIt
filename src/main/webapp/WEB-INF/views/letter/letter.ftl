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
    <script type="text/javascript" src="/public-resources/js/main.js"></script>
</head>
<body>
<#include "../header.ftl">
    <div class="main">
        <div class="letter-add" onclick="addLetter()">
            +添加
        </div>
        <div id="showList">

        </div>
	    <div id="kkpager">
	    </div>
    </div>
<#include "../footer.ftl">
</body>
<script>
	searchLetter(5, 1);
</script>
</html>