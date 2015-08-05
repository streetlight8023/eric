<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page language="java" import="com.yr.utils.DataConfig,java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title></title>
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
<meta name="Keywords" content=""/>
<meta name="Description" content="" />
<%@ include file="/commons/meta.jsp" %>
</head>
<body>
	<%@ include file="/commons/head.jsp" %>
	<!-- 焦点图 开始 -->
	<div class="border bnone pnone">
		<img src="<%=ctx %>/resources/images/pic/jskh.png" alt="极速开户" />
	</div>
	<!-- 焦点图 结束 -->
	<div class="h10"></div>
	<div class="wrapper">
		<!-- tab 开始 -->
		<div class="border radius" id="tabSy">
			<div class="tabPageination">
				
			</div>
			<div class="swiper-wrapper">
				<!-- 开户流程 -->
				<div class="swiper-slide">
					<div class="conPad">
						<img src="<%=ctx %>/resources/images/pic/liuc.png" alt="开户流程" />
					</div>
				</div>
				
				<!-- 所需资料 -->
				<div class="swiper-slide">
					<div class="conPad">
						<ul class="figure-list" id="informationNeed">
							<li>
								<figure style="background-color: #38b8e8">
									<a href="javascript:void(0)">
										<b>手机</b>
										<p>用于接受验证<br/>码及电话回访</p>
									</a>
								</figure>
							</li>
							<li>
								<figure style="background-color: #55b700">
									<a href="javascript:void(0)">
										<b>身份证</b>
										<p>有效期内的本<br/>人二代身份证</p>
									</a>
								</figure>
							</li>
							<li>
								<figure style="background-color: #965ebf">
									<a href="javascript:void(0)">
										<b>银行卡</b>
										<p class="mt5">本人借记卡</p>
									</a>
								</figure>
							</li>
						</ul>
					</div>
				</div>
				
				<!-- 支持银行 -->
				<div class="swiper-slide">
					<div class="conPad" id="zcBank">
						<p>三大银行共同支持，安全，保障</p>
						<p>资金第三方存管，出入金自由</p>
						<img alt="三大银行" src="<%=ctx %>/resources/images/pic/bank.png" />
					</div>
				</div>
			</div>
			
			<!-- 实盘开户 流程 第一步 -->
			<form class="registerform"  action="<%=DataConfig.DOM_URL%>/fastOpenAccount_saveAccountBase.action" method="post">
				 <input type='hidden' name="kaihu" value="kaihu"/>
				 <input type="hidden" name="fromPage" value="<%=request.getServletPath()%>" />
				<dl>
					<dd>
						<label>　您的姓名</label>
						<div class="yzm">
							<input type="text" placeholder="请输入您的姓名" name="memberName" id="memberName" class="inputxt radius" datatype="name" nullmsg="请输入您的姓名" errormsg="请输入真实姓名" />
							<div class="info"><span class="Validform_checktip"></span><span class="dec"></span></div>
						</div>
					</dd>
					<dd>
						<label>　手机号码</label>
						<div class="yzm">
							<input type="number" placeholder="请输入您的手机号码"  name="mobile" id="mobile" class="inputxt radius"  datatype="tel" ajaxurl="<%=ctx%>/msg/msg_checkedMobileExist.action" nullmsg="请输入您的手机号码" errormsg="手机号码格式不对" />
							<div class="info"><span class="Validform_checktip"></span><span class="dec"></span></div>
						</div>
					</dd>
					<dd>
						<label>手机验证码</label>
						<div class="yzm">
							<input type="number" placeholder="验证码" name="randCode" id="randCode" ajaxurl="<%=ctx%>/msg/msg_chckedMobileCode.action"  class="radius inputxt" datatype="code" nullmsg="请输入手机验证码" errormsg="验证码只能为6位数字" disabled />
							<input type="button" class="code radius" value="获取验证码"  />
							<div class="info"><span class="Validform_checktip"></span><span class="dec"></span></div>
						</div>
					</dd>
				</dl>
				<div class="h20"></div>
				<input type="submit" class="btn mt10 orange-1 white h42 w90 mauto f16 radius" value="点击开启我的赚钱之旅"  />
			</form>
			<div class="h10"></div>
		</div>
		<!-- tab 结束 -->
	</div>
</body>
	<script type="text/javascript" src="<%=ctx%>/resources/js/swiper.jquery.js"></script>
	<script type="text/javascript" src="<%=ctx%>/resources/js/Validform_v5.3.2.js"></script>
	<script type="text/javascript" src="<%=ctx%>/resources/js/mobile.js" defer="defer"></script>
	<script type="text/javascript">
		var swiper = new Swiper('#tabSy', {
			pagination: '.tabPageination',
	        paginationClickable: true,
	        autoplayDisableOnInteraction: false,
	        watchActiveIndex: true,
	        followFinger: false,
	        bulletClass: 'sytab-pagination-bullet',
            bulletActiveClass: 'sytab-pagination-bullet-active',
            paginationOpen: true,
            paginationText: ["开户流程","所需资料","支持银行"],
            autoplay: 2000,
            autoplayStopOnLast: true
	    });
	</script>
</html>

