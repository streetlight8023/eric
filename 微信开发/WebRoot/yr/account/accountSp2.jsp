<%@ page contentType="text/html; charset=UTF-8"%>
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
	<div class="h10"></div>
	<div class="wrapper">
		<div class="border radius">
			<div class="wrapper spLc">
				<section class="splc1 splc_active"><div class="spLc_tip radius spLc_tipLeft">提交开户信息<i class="dec"></i></div><span></span></section>
				<section class="splc2"><span></span></section>
				<section class="splc3"><span></span></section>
				<section class="splc4"><span></span></section>
			</div>
			<div class="mauto sp_tip mt20">
				<h2>温馨提示：</h2>
				<p class="mt5">1、开户人的姓名、身份证和银行卡必须完全一致，为同一个人，否则会导致开户失败；</p><br/>
				<p>2、银行卡必须是储蓄卡，不能使用信用卡，否则会导致开户失败。</p>
			</div>
			<form class="registerform"  action="<%=ctx%>/fastOpenAccount_toProtocolPage.action" method="post">
				<input type="hidden" name="customer.id" value= "${id}"/>
				<dl>
					<dd>
						<label>您的姓名</label>
						<div class="yzm">
							<input type="text" placeholder="请输入您的姓名" name="customer.customerName" id="memberName"	value= "${memberName}" class="inputxt" datatype="name" nullmsg="请输入您的姓名" errormsg="请输入真实姓名" />
							<div class="info"><span class="Validform_checktip"></span><span class="dec"></span></div>
						</div>
					</dd>
					<dd>
						<label>身份证号</label>
						<div class="yzm">
							<input type="text" placeholder="请输入您的身份证号码" value="" name="customer.papersNum"  ajaxurl=""   class="inputxt" datatype="idcard" nullmsg="请输入您的身份证号码！" errormsg="身份证号码有误" />
							<div class="info"><span class="Validform_checktip"></span><span class="dec"></span></div>
						</div>
					</dd>
					<dd>
						<label>开户银行</label>
						<div class="yzm" name="nice-select">
							<i class="smallSjx"></i>
							<input type="text" placeholder="请选择银行" name="customer.signBankName" class="inputxt nice-select-input input-bank" datatype="*" nullmsg="请选择银行" readonly />
							<ul class="nice-select none">
								<li>中国工商银行</li>
								<li>中国建设银行</li>
								<li>招商银行</li>
							</ul>
							<div class="info"><span class="Validform_checktip"></span><span class="dec"></span></div>
						</div>
					</dd>
					<dd>
						<label>银行卡号</label>
						<div class="yzm">
							<input type="number" placeholder="请输入您的银行卡账号" name="customer.visaCardNo"  class="inputxt" datatype="bank" nullmsg="请输入您的银行卡账号" errormsg="银行卡账号格式有误" />
							<div class="info"><span class="Validform_checktip"></span><span class="dec"></span></div>
						</div>
					</dd>
				</dl>
				<input type="submit" class="btn mt10 orange-1 white h42 w90 mauto f16 radius" value="下一步"  />
			</form>
			<div class="h10"></div>
		</div>
	</div>
</body>
	<script type="text/javascript" src="<%=ctx%>/resources/js/Validform_v5.3.2.js"></script>
	<script type="text/javascript" src="<%=ctx%>/resources/js/mobile.js" defer="defer"></script>
</html>

