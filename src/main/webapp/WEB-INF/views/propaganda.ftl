<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">    
    <title>关于我们</title>
	<link href="/public-resources/css/bootstrap/bootstrap.css" rel="stylesheet"/>
	<link href="/public-resources/css/main.css" rel="stylesheet">
	<script type="text/javascript" src="/public-resources/js/jquery/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="/public-resources/js/bootstrap/bootstrap.min.js"></script>
	<script type="text/javascript" src="/public-resources/js/main.js"></script>
    <link rel="stylesheet" type="text/css" href="/public-resources/css/index.css" />
</head>
<body>
<#include "header.ftl">
<div id="content">
    <!-- 头部图片区,图片需要替换-->
    <div class="top_title">
        <div class="top_name">findIt</div>

        <div class="top_name_right">我们致力于——让您丢失的证件回到您的身边！</div>
        <img src="/public-resources/image/aboutus.jpg" />
    </div>

    <!-- 我们是做什么的-->
    <div class="content_com">
        <div class="title_line">如何使用我们</div>
        <div class="content_do">
            <h4>如果您：</h4>                
            <div class="user1">
                <span>捡到东西</span>
                <p>1、登录系统，如果您没有账号请注册账号。</p>
                <p>2、点击我丢失列表了，根据您所捡到证件信息搜索，如果找到失主，则联系失主。</p>
                <p>3、如果第2部未找到失主，则点击我捡到了，发布信息等待失主联系。</p>   
            </div>
            <div class="user2">
                <span>遗失东西</span>
                <p>1、登录系统，如果您没有账号请注册账号。</p>
                <p>2、点击我丢失列表了，根据您丢失证件信息搜索，如果找到物品，则联系捡到者。</p>
                <p>3、如果第2部未找到物品，则点击我丢失了，发布信息。</p> 
            </div>
        </div>
    </div>

    <!-- 联系我们-->
    <div>
            
    </div>
</div>
<#include "footer.ftl">
</body>
</html>