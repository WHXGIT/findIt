<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>我的中心</title>
	<link href="/public-resources/css/bootstrap/bootstrap.css" rel="stylesheet"/>
	<link href="/public-resources/css/main.css" rel="stylesheet">
	<script type="text/javascript" src="/public-resources/js/jquery/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="/public-resources/js/bootstrap/bootstrap.min.js"></script>
	<script type="text/javascript" src="/public-resources/js/main.js"></script>

</head>
<body>
<#include "../header.ftl">
<div class="my-center-container">
	<div class="row" style="margin-top: 65px;">
		<div class="col-md-5 ">
			<div class="row">
				<div class="col-md-6">
                    <div id="head-img"></div>
					<form method="post" action="/user/upload" enctype="multipart/form-data">
						<input type="file" name="img">
						<input type="submit" value="上传头像"/>
					</form>
                </div>
				<div style="display: inline-block;" class="col-md-6">
                    昵称：<input id="myCenterNickname" class="my-center-input" name="nickname" value="${userVO.nickname}" readonly>
                    <br>
					电话：<input id="myCenterPhone" name="phone" value="${userVO.phone}" class="my-center-input" readonly>
                    <br>
					其他联系信息：<input id="myCenterOtherConnect" class="my-center-input" readonly name="otherConnect"
					              value="${userVO.otherConnect!'无'}">
					<br>
					性别：<select id="myCenterSex" class="my-center-input" disabled="disabled">
                            <option value="2">未知</option>
                            <option value="1">男</option>
                            <option value="0">女</option>
                        </select>
				    <br>
                    年龄：<input id="myCenterAge" name="age" value="${userVO.age}" class="my-center-input" readonly>
				    <br>
                    <span><a id="myCenterUSId" onclick="update();">修改</a></span><br>
                </div>
            </div>
        </div>
		<div class="col-md-3 col-md-offset-4">
			${userVO.username}<br>
                <span>用户名</span><br>
                陪伴您：
            <span id="duringDays"></span>
        </div>
	</div>

    <hr class="my-center-hr"/>

	<div class="row">
		<div class="col-xs-4">
            <div class="my-center-flow">
	            <div class="row">
		            <div class="col-md-6 my-center-flow-single1">
                        <span id="allPublishCred"></span>
                        <span>发布的所有证件</span>
                    </div>
		            <div class="col-md-6 my-center-flow-single2">
                        <span id="allFinishCred">

                        </span>
                        <span>完结的所有证件</span>
                    </div>
	            </div>
            </div>
        </div>
		<div class="col-xs-4">
            <div class="my-center-flow">
	            <div class="row">
		            <div class="col-md-6 my-center-flow-single3">
                        <span id="allCommentCred">

                        </span>
                        <span>我评论过的证件</span>
                    </div>
		            <div class="col-md-6 my-center-flow-single4">
                        <span id="allMocriReward">

                        </span>
                        <span>微报酬总额</span>
                    </div>
	            </div>
		    </div>
        </div>
		<div class="col-xs-4">
			<div class="my-center-flow">
				<div class="row">
					<div class="col-md-6 my-center-flow-single5">
                        <span id="allGetLetter">

                        </span>
                        <span>收到感谢信</span>
                    </div>
					<div class="col-md-6 my-center-flow-single6">
                        <span id="allSentLetter"></span>
                        <span>
                            发送的感谢信
                        </span>
                    </div>
				</div>
			</div>
        </div>
	</div>
</div>
<#include "../footer.ftl">
<script>
    initUserCenter();
</script>
</body>