<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>FindIt</title>
	<link href="/public-resources/css/bootstrap/bootstrap.css" rel="stylesheet"/>
	<link href="/public-resources/css/main.css" rel="stylesheet">
    <link href="/public-resources/css/kkpager/kkpager_blue.css" rel="stylesheet">
	<link href="/public-resources/css/kkpager/kkpager_orange.css" rel="stylesheet">
	<script type="text/javascript" src="/public-resources/js/main.js"></script>
	<script type="text/javascript" src="/public-resources/js/jquery/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="/public-resources/js/bootstrap/bootstrap.min.js"></script>
    <script type="text/javascript" src="/public-resources/js/kkpager/kkpager.min.js"></script>
</head>
<body>
<#include "../header.ftl">
<form class="main" method="post" action="">
	<div class="input-group">
		<input name="getCredNo" type="text" class="form-control" placeholder="Search for...">
		<input name="credName" type="text" class="form-control" placeholder="Search for...">
		<input name="credHoldName" type="text" class="form-control" placeholder="Search for...">
		<span class="input-group-btn">
        <button class="btn btn-default" type="submit">Go!</button>
      </span>
	</div>
</form>
<div class="main">
	<div class="row">
		<div class="col-md-3 col-md-offset-1">

        </div>
		<div class="col-md-3 col-md-offset-1">

        </div>
		<div class="col-md-3 col-md-offset-1">

        </div>
	</div>
	<div id="kkpager"></div>
</div>
<#include "../footer.ftl">
</body>

</html>