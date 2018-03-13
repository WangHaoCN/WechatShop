<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>青年校园</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="shortcut icon" type="image/x-icon"
	href="javascript:void(0)http://s1.tthunbohui.cn/static/favicon.ico">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/jiehun.m.min.1f8f2b3d.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/hh.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/my.6bf9ede3.css">
</head>
<body>

	<!--社区和问答的主页面用下面的头部样式-->
	<header class="new_hd">
		<a class="back" href="javascript:void(0)javascript:history.go(-1)">返回</a>
		<div>我的资料</div>
		<a class="hd_search" style="right: 15px;" href="">&nbsp;</a>
	</header>

	<article id="bd">
		<div class="center">
			<div class="userme">
				<span class="img"><a href=""><img src=""></a></span>
				<dl class="ctn">
					<dt>名称</dt>
					<dd>账号</dd>
				</dl>
			</div>
	</article>

	<hr>
	<div
		style="width: 90%; margin-left: 5%; background-color: white; padding: 0; margin-top: 20px">
		<ul>
			<li>
				<div style="width: 80%; margin-left: 10%;"><br>
					<p>昵称：${sessionScope.user.nickname }</p>
					<p>性别：${sessionScope.user.sex }</p>
					<p>国家：${sessionScope.user.country }</p>
					<p>省份：${sessionScope.user.province }</p>
					<p>城市：${sessionScope.user.city }</p>
					<br><br>
					<div style="color: #E2E2E2;width:100%;text-align:center">
						(以上信息均由微信提供)
					</div>
					<br>
				</div>
			</li>

		</ul>
	</div>


	<footer id="fk">
		<a href="index.action">
			<div id="fkk">
				<img src="${pageContext.request.contextPath}/images/sy2.png">
				<p>首页</p>
			</div>
		</a> <a href="usermoregoods.action">
			<div id="fkk">
				<img src="${pageContext.request.contextPath}/images/sp2.png">
				<p>更多商品</p>
			</div>
		</a> <a href="usergwc.action">
			<div id="fkk">
				<img src="${pageContext.request.contextPath}/images/gwc2.png">
				<p>购物车</p>
			</div>
		</a> <a href="usermain.action">
			<div id="fkk">
				<img src="${pageContext.request.contextPath}/images/gr1.png">
				<p class="red">个人中心</p>
			</div>
		</a>
	</footer>



</body>
</html>