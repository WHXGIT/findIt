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
<#include "../header.ftl">
    <form class="letter-write" action="/letter/create" method="post">
        <div class="main">

	        <div class="input-group">
		        <span class="input-group-addon" id="basic-addon1">标&nbsp;&nbsp;&nbsp;&nbsp;题</span>
		        <input name="title" type="text" class="form-control" placeholder="标&nbsp;&nbsp;&nbsp;&nbsp;题" aria-describedby="basic-addon1">
	        </div>
	        <div class="input-group">
		        <span class="input-group-addon" id="basic-addon1">收信人</span>
		        <input name="toName" type="text" class="form-control" placeholder="收信人" aria-describedby="basic-addon1">
	        </div>
	        <div class="input-group">
		        <span class="input-group-addon" id="basic-addon1">写信人</span>
		        <input name="createName" type="text" class="form-control" placeholder="写信人" aria-describedby="basic-addon1">
	        </div>

            <textarea name="content">

            </textarea>

            <input type="submit" value="发布">
        </div>
    </form>
<#include "../footer.ftl">
</body>
<script>
	searchLetter(5, 1);
</script>
</html>