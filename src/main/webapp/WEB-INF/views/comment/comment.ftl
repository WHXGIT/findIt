<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>FindIt</title>
	<link href="/public-resources/css/bootstrap/bootstrap.css" rel="stylesheet"/>
	<link href="/public-resources/css/main.css" rel="stylesheet">

	<script type="text/javascript" src="/public-resources/js/jquery/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="/public-resources/js/bootstrap/bootstrap.min.js"></script>
	<script type="text/javascript" src="/public-resources/js/kkpager/kkpager.min.js"></script>
	<script type="text/javascript" src="/public-resources/js/wangEditor/wangEditor.min.js"></script>
    <script type="text/javascript" src="/public-resources/js/main.js"></script>
	<script type="text/javascript" src="/public-resources/js/util.js"></script>
</head>
<body>
<#include "../header.ftl">
<div class="letter-write">
	<div class="main">
		<div class="search-detail">
			<div class="search-detail-card">
				<ul class="search-detail-card-content">
                    <li><label>证件编号:</label>${credentialDO.credNo!'无'}</li>
					<li><label>证件名:</label>${credentialDO.credName!'无'}</li>
					<li><label>持有人姓名:</label>${credentialDO.credHoldName!'无'}</li>
					<li><label>证件含有地址:</label>${credentialDO.address!'无'}</li>
					<li><label>拾取时间:</label>${credentialDO.pickTime!'无'}</li>
					<li><label>拾取地点:</label>${credentialDO.pickAddress!'无'}</li>
					<li><label>丢失时间:</label>${credentialDO.lostTime!'无'}</li>
					<li><label>丢失地点:</label>${credentialDO.lostAddress!'无'}</li>
                    <li><label>证件照片:</label><img class="comment-img" src="${credentialDO.photoPath!'无'}"></li>
					<li><label>微报酬:</label>${credentialDO.microReward!'无'}</li>
					<li><label>描述:</label>${credentialDO.description!'无'}</li>
				</ul>
			</div>
		</div>

        <#if Session["userVO"]?exists>
            <#if '${Session["userVO"].userId}' == '${userCredentialDO.userId!"unMatch"}'>
                <#if '${credentialDO.credType}' == '1'>
		            <input type="submit" value="已完结" disabled="disabled" class="main-lost-button" style="margin: 14px 40%;">
                <#else>
		            <form action="/comment/shutdown" method="post">
			            <input name="id" value="${credentialDO.credId}" style="display: none;">
			            <input type="submit" value="完结发布" class="main-lost-button" style="margin: 14px 40%;">
		            </form>
                </#if>
            </#if>
        </#if>
        <br />
        <span class="pinlun"><b>留言</b></span><br>

        <form action="/comment/insert" method="post">
            <input name="toUserId" value="${credentialDO.credId}" style="display: none;">
	        <div id="div1" style="width: 100%; margin: 0" class="letter-write-editor">
		        <p>在此处输入评论留言。。。</p>
	        </div>
	        <textarea required name="comment" id="text1" style="display: none;"></textarea>
            <input type="submit" value="发表" class="main-lost-button" style="margin: 14px 20px;">
        </form>
        <div style="border-bottom: 1px solid #01C2AF">
            <label class="firentd">大家说：</label>
        </div>
        <div style="margin-bottom: 59px;">
        <#list commentDOList as comment>
            <div style="color: #e74851;padding: 15px;font-size: 15px">${comment.commentName}</div>
            <div style="padding-left: 15px;">
            ${comment.comment}
            </div>
	        <hr>
        </#list>
        </div>

	</div>
</div>
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