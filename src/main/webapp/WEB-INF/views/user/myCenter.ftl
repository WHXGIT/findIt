<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>我的中心</title>
	<link href="/public-resources/css/bootstrap/bootstrap.css" rel="stylesheet"/>
	<link href="/public-resources/css/main.css" rel="stylesheet">
	<script type="text/javascript" src="/public-resources/js/jquery/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="/public-resources/js/bootstrap/bootstrap.min.js"></script>
	<script type="text/javascript" src="/public-resources/js/main.js"></script>
    <script type="text/javascript" src="/public-resources/js/letter.js"></script>

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
                        <a href="javascript:;" style="width: 82px;margin-left: -8px;" class="a-upload"><input type="file" name="img">选择头像</a>
						<a href="javascript:;" style=" margin-top: -46px;width: 52px" class="a-upload"><input type="submit" value="上传头像"/>上传</a>
					</form>
				</div>
                <div class="col-md-6">
	                <input id="myCenterNickname" style="font-size: 28px;margin-left: -60px;" class="my-center-input" name="nickname" value="${userVO.nickname}" readonly>
                    <p class="welcome">欢迎您来到，我的中心</p>
                </div>

			</div>
		</div>
		<div class="col-md-3 col-md-offset-4">
            <div class="userVO">${userVO.username}</div>
			<p id="duringDays"></p>
			陪伴您

		</div>
	</div>
	<hr class="my-center-hr"/>

	<div style="display: inline-block;" id="operator_my" class="col-md-12">

		<div>电话：<input id="myCenterPhone" name="phone" value="${userVO.phone}" class="my-center-input" readonly></div>

		<div>其他联系信息：<input id="myCenterOtherConnect" class="my-center-input" readonly name="otherConnect"
                           value="${userVO.otherConnect!'无'}"></div>

		<div>性别：<select id="myCenterSex" class="my-center-input" disabled="disabled">
		<option value="2">未知</option>
		<option value="1">男</option>
		<option value="0">女</option>
        </select></div>
		<div>年龄：<input id="myCenterAge" name="age" value="${userVO.age}" class="my-center-input" readonly>
        </div>
		<div><span><a id="myCenterUSId" onclick="update();">修改</a></span><br></div>
	</div>
	<hr class="my-center-hr"/>

	<div class="row">
		<div class="col-xs-4">
			<div class="my-center-flow">
				<div class="row">
					<div onclick="clickSearchSelfCred('unInit', '2');" class="col-md-6 my-center-flow-single1">
						<span id="allPublishCred"></span>
						<p class="lable_p">件发布的所有证件</p>
					</div>
					<div onclick="clickSearchSelfCred('unInit', '1');" class="col-md-6 my-center-flow-single2">
                        <span id="allFinishCred">

                        </span>
						<p class="lable_p">件完结的所有证件</p>
					</div>
				</div>
			</div>
		</div>
		<div class="col-xs-4">
			<div class="my-center-flow">
				<div class="row">
					<div onclick="clickSelfCommentCred('UnInitComment', null)" class="col-md-6 my-center-flow-single3">
                        <span id="allCommentCred">

                        </span>
						<p class="lable_p">件我评论过的证件</p>
					</div>
					<div onclick="clickSearchSelfCred('unInit', '1');" class="col-md-6 my-center-flow-single4">
                        <span id="allMocriReward">

                        </span>
						<p class="lable_p">元微报酬总额</p>
					</div>
				</div>
			</div>
		</div>
		<div class="col-xs-4">
			<div class="my-center-flow">
				<div class="row">
					<div onclick="clickSelfGetLetter();" class="col-md-6 my-center-flow-single5">
                        <span id="allGetLetter">

                        </span>
						<p class="lable_p">封收到感谢信</p>
					</div>
					<div onclick="clickSelfSentLetter();" class="col-md-6 my-center-flow-single6">
						<span id="allSentLetter"></span>
						<p class="lable_p">
                            封发送的感谢信
                        </p>
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