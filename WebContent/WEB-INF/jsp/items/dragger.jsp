<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>犯罪贫困人口</title>
<link
	href="${pageContext.request.contextPath}/resource/style/amazeui.min.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/resource/style/highcharts.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resource/style/style.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/resource/style/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resource/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resource/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resource/js/highcharts.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resource/js/amazeui.min.js"></script>
</head>
<body>
	<header class="am-topbar am-topbar-inverse">
		<h1 class="am-topbar-brand">
			<a href="#" class="am-text-ir"></a>
		</h1>
		<div class="am-collapse am-topbar-collapse" id="doc-topbar-collapse">
			<ul class="am-nav am-nav-pills am-topbar-nav">
				<li class="am-active"><a href="#">首页</a></li>
				<li><a href="#">#</a></li>
			</ul>
			<div class="am-topbar-right">
				<button class="am-btn am-btn-secondary am-topbar-btn am-btn-sm ">注册
				</button>
			</div>
			<div class="am-topbar-right">
				<button class="am-btn am-btn-primary am-topbar-btn am-btn-sm">登录</button>
			</div>
		</div>
	</header>

	<div class="container">
		<div class="title">
			<p class="p1">涉毒贫困人口查询</p>
		</div>
		<div class="content">
			<form class="am-form-inline" role="search">
				<div class="group">
					<input type="text" class="field" id="field" placeholder="搜索">
				</div>
			</form>
			<hr data-am-widget="divider" style=""
				class="am-divider am-divider-default" />
			<div class="am-g">
				<div class="am-u-sm-3"></div>
				<div class="am-u-sm-6"></div>
				<div class="am-u-sm-3"></div>
			</div>
		</div>

		<footer data-am-widget="footer" class="am-footer am-footer-default"
			data-am-footer="{  }">
			<div class="am-footer-switch">
				<span class="am-footer-ysp" data-rel="mobile"
					data-am-modal="{target: '#am-switch-mode'}"> 初级版 </span> <span
					class="am-footer-divider"> | </span> <a id="godesktop"
					data-rel="desktop" class="am-footer-desktop" href="javascript:">
					电脑版 </a>
			</div>
			<div class="am-footer-miscs ">

				<p>
					由 <a href="http://www.yunshipei.com/" title="" target="_blank"
						class="">大数据中心</a> 提供技术支持
				</p>
				<p>CopyRight©2018 AllMobilize Inc.</p>
				<p>云ICP备13033158</p>
			</div>
		</footer>

	</div>



</body>
</html>