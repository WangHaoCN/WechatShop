<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>青年校园</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/gwcstyle.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/gwcgoodscar.css" />

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
		<span>购物车</span> <a style="font-size:15px" href="usermoregoods.action"
			class="head_info_other">更多</a>
	</div>
	<!--头部信息 end-->

	<!--无商品页面 与 有商品模块切换，后台调用购物车list数据，如果购物车无数据，如果有数据则显示该注释下方代码-->
	<!--内容信息 start-->
	<div class="main_con">
		<div class="main_con_allchoose"></div>
		<div class="main_con_goods">
			<ul>
				<c:forEach var="ware" items="${userGwc}">
					<li id="${ware.wareId}"><span class=""></span> <img
						src="${pageContext.request.contextPath}/images/goodscar_pic1.png"
						style="margin-left: 1.2rem" />
						<div id="${ware.wareId}" class="wares">
							<p class="title">
								<a href=""><font>${ware.name}</font><font
									style="font-size: 0.4rem; font-weight: lighter;">${ware.describe}</font></a>
							</p>
							<p class="money">
								<font class="${ware.wareId}">${ware.price}</font><input
									class="xiugai add" type="button" value="+" /> <input
									class="num" type="text" value="<fmt:formatNumber type="number" value="${ware.count}" maxFractionDigits="0"/>" class="number" />
								<input class="xiugai del" type="button" value="-" />
							</p>
						</div></li>
				</c:forEach>
			</ul>

		</div>
	</div>
	<!--内容信息 end-->

	<!--结算信息 start-->
	<div class="settlement">
		<div class="settlement_left">
			<font class="zongji">总计：</font><font class="money">￥<span
				id="zongjia"></span></font>
		</div>
		<div class="settlement_right">
			<input id="tijiaodingdan" type="button" value="提交订单" />
		</div>
	</div>
	<!--结算信息 end-->

	<!--删除弹窗 start-->
	<div class="del_tc">
		<div class="del_tc_box">
			<div class="del_tc_box_title">确认删除此商品？</div>
			<div class="del_tc_box_content">
				<input class="cancel" type="button" value="取消" onclick="" /> <input
					class="ok" type="button" value="确认" />
			</div>
		</div>
	</div>
	<!--删除弹窗 end-->

	<!--无商品页面 与 有商品模块切换，后台调用购物车list数据，如果购物车无数据，则显示该注释下方代码-->
	<!--goodscar.css 修改样式 .no_goods{display: block}-->

	<!--无商品页面 start-->
	<div class="no_goods">
		<img src="${pageContext.request.contextPath}/images/no_goods_ico.png" />
		<p>
			购物车里没有东西哦~<br />快去商城逛逛吧！
		</p>
		<a href="usermoregoods.action">即刻添置</a>
	</div>

	<script>
		var kind = 0;
		var count = 0;
		function prejisuan() {
			var count1 = -1;
			var money = 0;
			$("li").each(function() {
				count++;
			});
			if (count == 0)
				$('.no_goods').show();
			//计算价格
			$.ajax({
				type : "post",
				url : "zongjia.action",
				data : {
					wareId : -1,
					kind : -1,
					count : count1
				},
				dataType : "json",
				success : function(data) {
					console.log('pre' + data);
					$('#zongjia').html(data);
				}
			});
		}

		$(function() {
			prejisuan();
			var wareid = -1;
			function jisuan(count1) {
				var money = 0;
				$("li").each(function() {
					count++;
				});
				if (count == 0)
					$('.no_goods').show();

				//计算价格
				$.ajax({
					type : "post",
					url : "zongjia.action",
					data : {
						wareId : wareid,
						kind : kind,
						count : count1
					},
					dataType : "json",
					success : function(data) {
						console.log(data);
						$('#zongjia').html(data + '');
					}
				});
			}
			$('.xiugai').click(function() {
				if ($(this).attr('value') == '-') {
					kind = 2;
					wareid = $(this).parent().parent().attr('id');
					count1 = $(this).siblings('.num').val();
					jisuan(count1);
				} else if ($(this).attr('value') == '+') {
					kind = 1;
					wareid = $(this).parent().parent().attr('id');
					count1 = $(this).siblings('.num').val();
					jisuan(count1);
				}
			})
			
			$('#tijiaodingdan').click(function(){
				var num = 0;
				$("li").each(function(){
				    num++;
				});
				if(num == 0)
					alert('购物车里没有东西哦~快去商城逛逛吧！');
				else
					window.location.href = 'confirmDingdan.action';
			})

		})
	</script>
</body>

</html>