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
    <%@ include file="commons/showIndexFocus.jsp" %>
	<!-- 焦点图 结束 -->
	<div class="h10"></div>
	<div class="wrapper">
		<!-- 按钮 -->
		<table class="syButtons">
			<tr>
				<td><a class="btn fl h34 radius" href="<%=ctx%>/analyst/">分析师说</a></td>
				<td><a class="btn fl h34 radius" href="<%=ctx%>/hangqing/">行情走势</a></td>
				<td><a class="btn h34 fr radius" href="<%=ctx%>/anli/">投资案例</a></td>
				<td><a class="btn h34 fr radius" href="<%=ctx%>/download/">软件下载</a></td>
			</tr>
		</table>
		<ul class="syButtons mt10">
			<li class="w70 fl alignLeft"><a class="btn radius h42 w95 fl kskh" href="<%=ctx %>/kaihu/xinxi/"><i class="icon-kskh"></i>快速开户</a></li>
			<li class="w30 fl alignRight"><a class="btn h42 radius w95 f16 fr" href="<%=ctx %>/kehu/">客户服务</a></li>
		</ul>
		<!-- 按钮 结束 -->
		<div class="h10"></div>
		<!-- tab 开始 -->
		<div class="border radius" id="tabSy">
			<div class="tabPageination">
				
			</div>
			<div class="swiper-wrapper">
				<!-- 赚钱快 -->
				<div class="swiper-slide">
					<div class="conPad">
						<h3 class="b">贵金属投资优势</h3>
						<table id="indexSy" class="mt10">
							<tr>
								<td>
									<img src="<%=ctx %>/resources/images/icon/icon_01.png" alt="收益高" />
									<h4>收益高</h4>
									<p>1%波动≈20%收益</p>
								</td>
								<td>
									<img src="<%=ctx %>/resources/images/icon/icon_02.png" alt="赚钱机会多 " />
									<h4>赚钱机会多 </h4>
									<p>涨跌皆赚,当日买卖</p>
								</td>
							</tr>
							<tr>
								<td>
									<img src="<%=ctx %>/resources/images/icon/icon_03.png" alt="门槛低" />
									<h4>门槛低</h4>
									<p>328元即可交易一手</p>
								</td>
								<td>
									<img src="<%=ctx %>/resources/images/icon/icon_04.png" alt="资金安全 " />
									<h4>资金安全</h4>
									<p>资金银行存管</p>
								</td>
							</tr>
							<tr>
								<td>
									<img src="<%=ctx %>/resources/images/icon/icon_05.png" alt="第三方监管" />
									<h4>第三方监管</h4>
									<p>无人为操控 交易公平</p>
								</td>
								<td>
									<img src="<%=ctx %>/resources/images/icon/icon_06.png" alt="合法有保障 " />
									<h4>合法有保障</h4>
									<p>国家审批、政府特批</p>
								</td>
							</tr>
						</table>
				
					</div>
				</div>
				
				<!-- 收益高 -->
				<div class="swiper-slide">
					<div class="conPad">
						<ul id="syol">
							<li>资金放大，<b>5万当50万</b>用——提高资金使用率，放大12.5~20倍（杠杆原理）</li>
							<li>小资金撬动大收益，28万当500万！李先生投入资金28万，短短19天，净赚156万，收益翻5.6倍！</li>
							<li class="alignCenter"><b>每天都是牛市 — </b><orange><b>资金翻倍最快只需一天</b></orange></li>
						</ul>
					</div>
				</div>
				
				<!-- 速开户 -->
				<div class="swiper-slide">
					<div class="conPad">
					    <form class="registerform" action="<%=ctx%>/fastOpenAccount_saveAccountBase.action" class="registerform" id= "onlineRegisterForm" method="post">
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
										<input type="text" placeholder="验证码" name="randCode" id="randCode" ajaxurl="<%=ctx%>/msg/msg_chckedMobileCode.action"  class="inputxt radius" datatype="code" nullmsg="请输入手机验证码" errormsg="验证码只能为6位数字" disabled />
    									<input type="button" class="code radius" value="获取验证码" />
										<div class="info"><span class="Validform_checktip"></span><span class="dec"></span></div>
									</div>
								</dd>
							</dl>
							<input type="submit" id="toSecondStep" class="btn border-orange whiteBg w90 mauto h34 radius orange f16 mt10" value="点击开启我的赚钱之旅"  />
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- tab 结束 -->
	</div>
</body>
	<script type="text/javascript" src="<%=ctx%>/resources/js/swiper.jquery.js"></script>
	<script type="text/javascript" src="<%=ctx%>/resources/js/Validform_v5.3.2.js"></script>
	<script type="text/javascript" src="<%=ctx%>/resources/js/mobile.js" defer="defer"></script>
	<script type="text/javascript">
		var swiper = new Swiper('.swiper-container', {
	        pagination: '.swiper-pagination',
	        paginationClickable: true,
	        autoplay: 3000,
	        autoplayDisableOnInteraction: false,
	        watchActiveIndex: true,
	        followFinger: false,
	        loop: true,
	        lazyLoading : true,
	        lazyLoadingInPrevNext : true,
	    });
		
		var swiper = new Swiper('#tabSy', {
			pagination: '.tabPageination',
	        paginationClickable: true,
	        autoplayDisableOnInteraction: false,
	        watchActiveIndex: true,
	        followFinger: false,//不跟随手指
	        bulletClass: 'sytab-pagination-bullet',//自定义的分页class
            bulletActiveClass: 'sytab-pagination-bullet-active',//自定义的分页active
            autoplay: 2000,//自动轮播时间
            autoplayStopOnLast: true, //自动轮播一次,最后一块结束自动轮播
            paginationOpen: true,//打开自定义的分页内容
            paginationText: ["赚钱快","收益高","速开户"], //分页的内容
	    }); 
	</script>
</html>

 		