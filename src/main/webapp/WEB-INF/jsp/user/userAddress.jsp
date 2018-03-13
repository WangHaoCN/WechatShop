<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<style type="text/css">
.btn {
	display: inline-block;
	padding: 6px 12px;
	margin-bottom: 0;
	font-size: 14px;
	font-weight: 400;
	line-height: 1.42857143;
	text-align: center;
	white-space: nowrap;
	vertical-align: middle;
	-ms-touch-action: manipulation;
	touch-action: manipulation;
	cursor: pointer;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
	background-image: none;
	border: 1px solid transparent;
	border-radius: 4px
}

.btn:focus, .btn:active:focus, .btn.active:focus, .btn.focus, .btn:active.focus,
	.btn.active.focus {
	outline: thin dotted;
	outline: 5px auto -webkit-focus-ring-color;
	outline-offset: -2px
}

.btn:hover, .btn:focus, .btn.focus {
	color: #333;
	text-decoration: none
}

.btn:active, .btn.active {
	background-image: none;
	outline: 0;
	-webkit-box-shadow: inset 0 3px 5px rgba(0, 0, 0, .125);
	box-shadow: inset 0 3px 5px rgba(0, 0, 0, .125)
}

.btn-danger {
	color: #fff;
	background-color: #d9534f;
	border-color: #d43f3a
}
</style>
<script src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
</head>
<body>

	<!--社区和问答的主页面用下面的头部样式-->
	<header class="new_hd">
		<a class="back" href="javascript:void(0)javascript:history.go(-1)">返回</a>
		<div>收货地址管理</div>
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

	<hr />

	<div
		style="width: 90%; margin-left: 5%; background-color: white; padding: 0; margin-top: 20px">
		<ul>
			<c:forEach var="addr" items="${address}">
				<li id="${addr.id }">
					<div style="width: 80%; margin-left: 10%">
						<br> ${addr.name }&nbsp;&nbsp;${addr.phone }<br>
						${addr.school }&nbsp;&nbsp;${addr.buildingNo }&nbsp;&nbsp;${addr.roomNo}<br> <br> <br>
						<div style="width: 100%; text-align: center" class="moren"></div>
						<div style="width: 100%; text-align: center">
							<button class="xuanzhong btn btn-danger">设为默认收货地址</button>
							<button class="xiugai btn btn-danger">修 改</button>
							<button class="shanchu btn btn-danger">删 除</button>
							<br>
							<br>
						</div>
					</div>
				</li>
				<hr>
			</c:forEach>
		</ul>
	</div>
	
	<div style="height:100px"></div>


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
	<script>
		$(function() {

			//设置默认收货地址
			$.ajax({
				type : "post",
				url : "morendizhi.action",
				success : function(data) {
					$('li').each(function() {
						$(this).children().find('.moren').text('');
						if ($(this).attr('id') == data)
							$(this).children().find('.moren').text('（默认收货地址）');
					})
				}
			});

			$('.xuanzhong').click(
					function() {
						var id = $(this).parent().parent().parent().attr('id');
						$.ajax({
							type : "post",
							url : "xuanzhong.action",
							data : {
								id : id
							},
							success : function(data) {
								$('li').each(function() {
											$(this).children().find('.moren').text('');
											if ($(this).attr('id') == data)
												$(this).children().find('.moren').text('（默认收货地址）');
										})
							}
						});
					});
			$('.xiugai').click(function(){
				var id = $(this).parent().parent().parent().attr('id');
				window.location.href = 'addressUpdate.action?id='+id;
			});
		})
	</script>

</body>
</html>