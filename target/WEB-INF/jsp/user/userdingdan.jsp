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
		<div>我的订单</div>
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
				<div style="width: 90%; margin-left: 5%;">
					<br>订单编号：<br> 生成时间：<br> 订单状态：<br> 总价：<br>
					<br>商品列表：<br>
					名称 x 数量<br><br>

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