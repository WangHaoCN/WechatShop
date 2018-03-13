<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title></title>
<link href="${pageContext.request.contextPath}/css/public.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/login.css"
	rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
<script>
	$(window).load(function() {
		$("#status").fadeOut();
		$("#preloader").delay(350).fadeOut("slow");
	})
</script>
</head>

<body>
	<div class="mobile">
		<!--页面加载 开始-->
		<div id="preloader">
			<div id="status">
				<p class="center-text">
					<span>拼命加载中···</span>
				</p>
			</div>
		</div>
		<!--页面加载 结束-->
		<!--header 开始-->
		<header>
			<div class="header">
				<a class="new-a-back" href="javascript:history.back();"> <span><img
						src="${pageContext.request.contextPath}/images/iconfont-fanhui.png"></span>
				</a>
				<h2>收货地址</h2>
			</div>
		</header>
		<!--header 结束-->

		<div class="w main">
			<form id="frm_login" method="post" action="addressUpload.action"
				onsubmit="return submittext()">
				<div class="item item-username">
					<input id="openid" class="txt-input txt-username" type="text"
						placeholder="请输入用户名" name="openId" disabled="true" value="${sessionScope.user.openId }"> <b
						class="input-close" style="display: none;" ></b>
				</div>

				<div class="item item-username">
					<select name="school" class="txt-input txt-username" id="school">
						<option value="" id="schoolval">-- 请选择学校信息(必填) --</option>
					</select>
				</div>

				<div class="item item-username">
					<select name="buildingNo" class="txt-input txt-username" id="build">
						<option value="">-- 请选择楼号信息（必填） --</option>
					</select>
				</div>
				<div class="item item-username">
					<input id="province" class="txt-input txt-username" type="text"
						placeholder="请输入省份" value="${address.province }" name="province">
				</div>

				<div class="item item-username">
					<input id="city" class="txt-input txt-username" type="text"
						placeholder="请输入城市" value="${address.city }" name="city">
				</div>
				<div class="item item-username">
					<input id="roomNo" class="txt-input txt-username" type="text"
						placeholder="请输入房间号等详细信息(必填)" value="${address.roomNo }" name="roomNo">
				</div>

				<div class="item item-username">
					<input id="name" class="txt-input txt-username" type="text"
						placeholder="请输入收货人姓名(必填)" value="${address.name }" name="name">
				</div>
				<div class="item item-username">
					<input id="phone" class="txt-input txt-username" type="text"
						placeholder="请输入收货人电话(必填)" value="${address.phone }" name="phone">
				</div>
				<div class="ui-btn-wrap">
					<input class="ui-btn-lg ui-btn-primary" type="submit" id="submit" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
	//表单验证
	function submittext() {
		var num = 0;
		if($('#openid').val() == ''){
			num++;
		}
		if($('#school').val() == ''){
			num++;
		}if($('#build').val() == ''){
			num++;
		}if($('#roomNo').val() == ''){
			num++;
		}if($('#name').val() == ''){
			num++;
		}if($('#phone').val() == ''){
			num++;
		}
		if(num>0){
			alert('必填信息不能为空哦~');	
			return false;
		}
	
	}

	$(function() {
		
		if('${address.school}'!=''){
			$('#schoolval').attr('value','{address.school}');
			$('#schoolval').html('${address.school}');
		}
			

		//显示学校信息
		$.ajax({
			type : "post",
			url : "school.action",
			data : {
				wareId : -1
			},
			success : function(data) {
				$('#school').html(data);
			}
		});

		$("#school").change(function() {
			var build = $(this).val();
			//显示学校信息
			$.ajax({
				type : "post",
				url : "schoolBuilding.action",
				data : {
					build : build
				},
				success : function(data) {
					$('#build').html(data);
				}
			});
		});

	});
</script>
