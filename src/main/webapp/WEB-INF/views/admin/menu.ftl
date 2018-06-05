<!DOCTYPE html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="css/htmleaf-demo.css">
	<link href="dist/canvi.css" rel="stylesheet" type="text/css">
</head>
<body>
<aside class="myCanvasNav canvi-navbar">
	<div class="canvi-user-info">
		<div class="canvi-user-info__image">
			<img src="pine-logo.jpg">
		</div>
		<div class="canvi-user-info__data">
			<span class="canvi-user-info__title">Title</span>
			<a href="#" class="canvi-user-info__meta">View site</a>
			<div class="canvi-user-info__close" onclick="t.close();"></div>
		</div>
	</div>
	<ul class="canvi-navigation">
		<li>
			<a href="#" class="canvi-navigation__item">
	<span class="canvi-navigation__icon-wrapper" style="background: #00adff;">
	<span class="canvi-navigation__icon icon-iconmonstr-code-2"></span>
	</span>
				<span class="canvi-navigation__text">Laravel</span>
			</a>
		</li>
		<li>
			<a href="#" class="canvi-navigation__item">
	<span class="canvi-navigation__icon-wrapper" style="background: #0082BF;">
	<span class="canvi-navigation__icon icon-iconmonstr-code-5"></span>
	</span>
				<span class="canvi-navigation__text">CSS</span>
			</a>
		</li>
		<li>
			<a href="#" class="canvi-navigation__item">
	<span class="canvi-navigation__icon-wrapper" style="background: #00567F;">
	<span class="canvi-navigation__icon icon-iconmonstr-code-9"></span>
	</span>
				<span class="canvi-navigation__text">HTML</span>
			</a>
		</li>
		<li>
			<a href="#" class="canvi-navigation__item">
	<span class="canvi-navigation__icon-wrapper" style="background: #002B40;">
	<span class="canvi-navigation__icon icon-iconmonstr-code-11"></span>
	</span>
				<span class="canvi-navigation__text">JavaScript</span>
			</a>
		</li>
		<li>
			<a href="#" class="canvi-navigation__item">
	<span class="canvi-navigation__icon-wrapper" style="background: #009CE5;">
	<span class="canvi-navigation__icon icon-iconmonstr-code-13"></span>
	</span>
				<span class="canvi-navigation__text">Vue.js</span>
			</a>
		</li>
	</ul>
</aside>
<aside class="js-canvi-navbar--right canvi-navbar">
	<div class="canvi-header">
		<img class="canvi-header__image" src="pine-logo.jpg">
	</div>
	<ul class="canvi-navigation">
		<li>
			<a href="#introduction" class="js-close-on-click-right-menu canvi-navigation__item">
				<span class="canvi-navigation__text">Introduction</span>
			</a>
		</li>

		<li>
			<a href="#options" class="js-close-on-click-right-menu canvi-navigation__item">
				<span class="canvi-navigation__text">Options</span>
			</a>
		</li>

		<li>
			<a href="#methods" class="js-close-on-click-right-menu canvi-navigation__item">
				<span class="canvi-navigation__text">Methods</span>
			</a>
		</li>

		<li>
			<a href="#events" class="js-close-on-click-right-menu canvi-navigation__item">
				<span class="canvi-navigation__text">Events</span>
			</a>
		</li>
	</ul>
</aside>
<main class="js-canvi-content canvi-content">
	<div class="htmleaf-container">
		<header class="htmleaf-header">
			<h1>js侧边栏菜单插件canvi <span>A simple vanilla JavaScript off-canvas menu</span></h1>
			<div class="htmleaf-links">
				<a class="htmleaf-icon icon-htmleaf-home-outline" href="http://www.htmleaf.com/" title="jQuery之家" target="_blank"><span> jQuery之家</span></a>
				<a class="htmleaf-icon icon-htmleaf-arrow-forward-outline" href="http://www.htmleaf.com/jQuery/Menu-Navigation/201710174783.html" title="返回下载页" target="_blank"><span> 返回下载页</span></a>
			</div>
		</header>
		<div class="htmleaf-demo center" >
			<button class="js-canvi-open-button--left btn">打开左侧侧边栏菜单</button>
			<button class="js-canvi-open-button--right btn">打开右侧侧边栏菜单</button>
		</div>
		<div class="related">
			<h3>如果你喜欢这个插件，那么你可能也喜欢:</h3>
			<a href="http://www.htmleaf.com/jQuery/Menu-Navigation/201610124098.html">
				<img src="related/1.jpg" width="300" alt="超酷Bootstrap 3 隐藏滑动侧边栏菜单"/>
				<h3>超酷Bootstrap 3 隐藏滑动侧边栏菜单</h3>
			</a>
			<a href="http://www.htmleaf.com/jQuery/Menu-Navigation/201611044168.html">
				<img src="related/2.jpg" width="300" alt="简洁时尚的jQuery和CSS3侧边栏菜单插件"/>
				<h3>简洁时尚的jQuery和CSS3侧边栏菜单插件</h3>
			</a>
		</div>
	</div>
</main>

<script src="dist/canvi.js"></script>
<script>
	var t = new Canvi({
		content: ".js-canvi-content",
		isDebug: !1,
		navbar: ".myCanvasNav",
		openButton: ".js-canvi-open-button--left",
		position: "left",
		pushContent: !1,
		speed: "0.2s",
		width: "100vw",
		responsiveWidths: [ {
			breakpoint: "600px",
			width: "280px"
		}, {
			breakpoint: "1280px",
			width: "320px"
		}, {
			breakpoint: "1600px",
			width: "380px"
		} ]
	})
</script>
<script type="text/javascript">
	var canviRight = new Canvi({
		content: '.js-canvi-content',
		navbar: '.js-canvi-navbar--right',
		openButton: '.js-canvi-open-button--right',
		position: "right"
	});
</script>
</body>
</html>