<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>FindIt</title>
	<link href="/public-resources/css/bootstrap/bootstrap.css" rel="stylesheet"/>
	<link href="/public-resources/css/main.css" rel="stylesheet">

	<script type="text/javascript" src="/public-resources/js/jquery/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="/public-resources/js/bootstrap/bootstrap.min.js"></script>
	<script type="text/javascript" src="/public-resources/js/wangEditor/wangEditor.min.js"></script>
	<script type="text/javascript" src="/public-resources/js/main.js"></script>
    <script type="text/javascript" src="/public-resources/js/util.js"></script>
</head>
<body>
<#include "../header.ftl">
<form class="letter-write" action="/letter/create" method="post" id="letter-wri">
	<div class="main" style="text-align: center;">
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1" style="float: left;background: no-repeat;border: none;">标&nbsp;&nbsp;&nbsp;&nbsp;题</span>
			<input required name="title" type="text" class="form-control" placeholder="标&nbsp;&nbsp;&nbsp;&nbsp;题"
			       aria-describedby="basic-addon1">
		</div>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1" style="float: left;background: no-repeat;border: none;">收信人</span>
			<input required name="toName" list="users" type="text" class="form-control" placeholder="收信人"
			       aria-describedby="basic-addon1">
			<datalist id="users">

			</datalist>

		</div>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1" style="float: left;background: no-repeat;border: none;">写信人</span>
			<input required name="createName" value='${Session["userVO"].nickname}' type="text" class="form-control"
			       placeholder="写信人" aria-describedby="basic-addon1">
		</div>

		<div id="div1" class="letter-write-editor">
			<p>在此处输入信件内容。。。</p>
		</div>
		<textarea name="content" id="text1" style="display: none;"></textarea>
		<input type="submit" value="发布" class="main-lost-button">
	</div>
</form>
<#include "../footer.ftl">
</body>
<script type="text/javascript">
	var E = window.wangEditor
	var editor = new E('#div1')
	var $text1 = $('#text1')
	editor.customConfig.onchange = function (html) {
		// 监控变化，同步更新到 textarea
		$text1.val(html)
	};

	editor.customConfig.emotions = [
		{
			// tab 的标题
			title: '默认',
			// type -> 'emoji' / 'image'
			type: 'image',
			// content -> 数组
			content: configEmoji()
		},
		{
			// tab 的标题
			title: 'emoji',
			// type -> 'emoji' / 'image'
			type: 'emoji',
			// content -> 数组
			content: ['😀', '😃', '😄', '😁', '😆']
		}
	];

	editor.create();
	// 初始化 textarea 的值
	$text1.val(editor.txt.html())
</script>
</html>