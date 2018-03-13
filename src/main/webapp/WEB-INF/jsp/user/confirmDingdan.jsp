<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>购物车</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/gwcstyle.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/dd.css" />

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.11.2.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/js.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/goodscar.js"></script>
</head>

<body>
	<!--头部信息 start-->
	<div class="head_info">
		<a onclick="window.history.go(-1)" class="head_info_return"><img
			src="${pageContext.request.contextPath}/images/head_returnIcon.png" /></a>
		<span>确认订单</span>
	</div>
	<!--头部信息 end-->
	<div class="sh">
		<div class="sm">
			<div class="left">${sessionScope.address.name }</div>
			<div class="right">${sessionScope.address.phone }</div>
		</div>
		<br />
		<div class="sm">
			<span>收货地址：${sessionScope.address.school } -
				${sessionScope.address.buildingNo } </span>
		</div>
		<div class="a">
			<a href="#" class="head_info_other"><img
				src="${pageContext.request.contextPath}/images/cpmc_inof_icon1.png"
				alt="" /> </a>
		</div>
	</div>
	<!--无商品页面 与 有商品模块切换，后台调用购物车list数据，如果购物车无数据，如果有数据则显示该注释下方代码-->
	<!--内容信息 start-->
	<div class="main_con">
		<div class="main_con_allchoose">
			<span class=""></span>商品 <img src="images/goods_del.png" /></a>
		</div>
		<div class="main_con_goods">
			<ul>
				<c:forEach var="ware" items="${wares}">
					<c:if test="${ware.count != 0}">
						<!-- 商品详情页面 -->
						<a href="xiangxixinxi.action?id=${ware.wareId}">
							<li id="${ware.wareId}"><span class=""></span> <img
								src="${pageContext.request.contextPath}/images/goodscar_pic1.png"
								style="margin-left: 1.2rem" />
								<div id="${ware.wareId}" class="wares">
									<p class="title">
										<a href=""><font style="font-size: 15px">${ware.name}</font><font
											style="font-size: 0.4rem; font-weight: lighter;">${ware.describe}</font></a>
									</p>
									<p class="money">
										<font class="${ware.wareId}"
											style="font-size: 10px; width: 200px">￥${ware.price} x
											${ware.count}件</font>
									</p>
								</div></li>
						</a>
					</c:if>
				</c:forEach>

			</ul>

		</div>
	</div>

	<!--结算信息 start-->
	<div class="settlement">
		<div class="settlement_left">
			<font class="zongji">总计：</font><font class="money">￥${price }</font><br />
		</div>
		<div class="settlement_right">
			<input type="button" value="提交订单" id="tijiao" />
		</div>
	</div>
</body>
<script>
	$(function() {
		$('#tijiao').click(function() {
			window.location.href = 'TijiaoDingdan.action&price' + $
			{
				price
			}
			;
		})
	})
</script>

</html>