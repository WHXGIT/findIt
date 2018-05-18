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
<#include "../header.ftl">
    <div class="main">
	    <div class=" input-group search-input-group">
		    <input id="letterName" type="text" class="form-control search-input" placeholder="姓名">
		    <span class="input-group-btn">
                <button class="btn btn-default" onclick="clickSearchCred();">搜索</button>
            </span>
	    </div>
        <div class="letter-add" onclick="addLetter()">
            +添加
        </div>
        <div class="letter-content">
            <div class="letter-title">标题名称</div>
            <div class="letter-date">2018-09-09</div>
        </div>
	    <div class="letter-content">
		    <div class="letter-title">标题名称</div>
		    <div class="letter-date">2018-09-09</div>
	    </div>
	    <div class="letter-content">
		    <div class="letter-title">标题名称</div>
		    <div class="letter-date">2018-09-09</div>
	    </div>
	    <div class="letter-content">
		    <div class="letter-title">标题名称</div>
		    <div class="letter-date">2018-09-09</div>
	    </div>
	    <div class="letter-content">
		    <div class="letter-title">标题名称</div>
		    <div class="letter-date">2018-09-09</div>
	    </div>

	    <div id="kkpager" class="page-kkpager">
	    </div>
    </div>
<#include "../footer.ftl">
</body>
<script>
	searchLetter(5, 1);
</script>
</html>