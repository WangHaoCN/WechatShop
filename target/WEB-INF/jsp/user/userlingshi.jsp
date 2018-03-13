<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="m.178hui.com" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>青年校园</title>
<link href="${pageContext.request.contextPath}/css/public.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/baoliao.css"
	rel="stylesheet" type="text/css">

<script src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
<script>
	$(window).load(function() {
		$("#status").fadeOut();
		$("#preloader").delay(350).fadeOut("slow");
	})
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".shaixuan").click(function(event) {
			event.stopPropagation();
			$(".shaixuan_box").show();
			$(".shaixuan_box").animate({
				right : '100%'
			});
			$("body,html").css("overflow", "hidden");
			$(".shaixuan_box").css("overflow", "auto");
			$('body').bind("touchmove", function(e) {
				e.preventDefault();
			});
		});
		$(".shaixuan_mall a").click(function(event) {
			$("body,html").css("overflow", "auto");
			$(".shaixuan_box").animate({
				right : '-100%'
			});
			$(".shaixuan_box").hide(5);
			$("body").unbind("touchmove");
		});
		$('#sousuo').click(function() {
			var val = $('#sousuokuang').val();
			window.location.href = 'search.action?val=' + val;
		})
	});
</script>
</head>

<body>
	<div class="mobile">
		<div class="search w">
			<form action="" method="get">
				<input name="" type="text" class="search_input" placeholder="搜索商品"
					id="sousuokuang"><input name="" type="button"
					class="search_submit" value="搜索" id="sousuo">
			</form>
		</div>

		<div class="baoliao w">
			<div class="ui-tab">
				<ul class="ui-tab-nav">
					<li><a href="usermoregoods.action">全部</a></li>
					<li class="current"><a href="userlingshi.action">零食</a></li>
					<li><a href="usershuiguo.action">水果</a></li>
					<li><a href="userqita.action">其他</a></li>
				</ul>

				<!-- 零食页面 -->

				<div class="ui-tab-content">

					<c:forEach var="ware" items="${wares}">
						<!-- 商品详情页面 -->
						<a href="xiangxixinxi.action?id=${ware.wareId}">
							<div class="baoliao_content">
								<div class="bl_img">
									<!-- 商品图片 -->
									<img src="${ware.imageUrl}" />
								</div>
								<div class="bl_right">
									<div class="bl_title">
										<!-- 商品名 -->${ware.name}</div>
									<div class="bl_note">
										<!-- 促销广告 -->${ware.describe}</div>
									<div class="bl_tag">
										<div class="bl_price">
											<!-- 商品价格 -->
											￥${ware.price}
										</div>
										<div class="bl_oprice">
											<!-- 商品原价 -->
											原价:${ware.yuanjia}
										</div>
										<div class="bl_time">
											<!-- 商品上传时间 -->
											${ware.date}
										</div>
										<div class="bl_mall">
											<!-- 上传楼长楼号 -->
											${ware.managerid}
										</div>
									</div>
								</div>
							</div>
						</a>
					</c:forEach>

				</div>
				
			</div>
		</div>
		<div class="footer w">h</div>
		<footer>
			<a href="index.action">
				<div class="mune">
					<img src="${pageContext.request.contextPath}/images/sy2.png">
					<p>首页</p>
				</div>
			</a> <a href="usermoregoods.action">
				<div class="mune">
					<img src="${pageContext.request.contextPath}/images/sp1.png">
					<p class="red">更多商品</p>
				</div>
			</a> <a href="usergwc.action">
				<div class="mune">
					<img src="${pageContext.request.contextPath}/images/gwc2.png">
					<p>购物车</p>
				</div>
			</a> <a href="usermain.action">
				<div class="mune">
					<img src="${pageContext.request.contextPath}/images/gr2.png">
					<p>个人中心</p>
				</div>
			</a>
		</footer>

		<script>
			(function(doc, win) {
				var docEl = doc.documentElement, resizeEvt = 'orientationchange' in window ? 'orientationchange'
						: 'resize', recalc = function() {
					var clientWidth = docEl.clientWidth;
					if (!clientWidth)
						return;
					docEl.style.fontSize = 100 * (clientWidth / 750) + 'px';
				};

				if (!doc.addEventListener)
					return;
				win.addEventListener(resizeEvt, recalc, false);
				doc.addEventListener('DOMContentLoaded', recalc, false);
			})(document, window);
		</script>
		<script type="text/javascript">
			$('.check-on').click(function() {
				$(this).toggleClass('check-off');
			})
		</script>
	</div>
</body>