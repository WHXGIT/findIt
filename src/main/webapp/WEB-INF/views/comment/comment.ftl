<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>FindIt</title>
	<link href="/public-resources/css/bootstrap/bootstrap.css" rel="stylesheet"/>
	<link href="/public-resources/css/main.css" rel="stylesheet">

	<script type="text/javascript" src="/public-resources/js/jquery/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="/public-resources/js/bootstrap/bootstrap.min.js"></script>
	<script type="text/javascript" src="/public-resources/js/kkpager/kkpager.min.js"></script>
    <script type="text/javascript" src="/public-resources/js/main.js"></script>
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
					<li><label>证件照片:</label>${credentialDO.photoPath!'无'}</li>
					<li><label>微报酬:</label>${credentialDO.microReward!'无'}</li>
					<li><label>描述:</label>${credentialDO.description!'无'}</li>
				</ul>
			</div>
		</div>

        <span>评论</span><br>

        <form action="/comment/insert" method="post">
            <input name="toUserId" value="${credentialDO.credId}" style="display: none;">
            <textarea name="comment">

            </textarea>
            <input type="submit" value="发表">
        </form>
        <div>
        <#list commentDOList as comment>
            ${comment.commentName}<br>
            ${comment.comment}
	        <hr>
        </#list>
        </div>

	</div>
</div>
<#include "../footer.ftl">
</body>
</html>