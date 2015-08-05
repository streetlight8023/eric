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
				<section class="splc1 splc_active"><span></span></section>
				<section class="splc2 splc_active"><span></span></section>
				<section class="splc3 splc_active"><div class="spLc_tip radius spLc_tipRight">阅读开户协议<i class="dec"></i></div><span></span></section>
				<section class="splc4"><span></span></section>
			</div>
			<div class="mauto sp_tip mt20">
				为了保障您的交易安全，请尽快登陆交易系统，设置您的个人登录密码，电话密码以及资金密码并注意妥善保管。
			</div>
			<div class="sp3 mt10 mauto">
				<div class="sp4_con sp4_padding">
					<i></i>
					<b>恭喜完成实盘开户，请您尽快通过网银或者银行柜台完成签约，任何疑问可联系人工客服</b>
				</div>
				<div class="sp4_mess sp4_padding mt10">
					<i></i>
					<b>您的账户信息如下：</b><br/>
					<b>账　　号：</b><orange>${member.account}</orange><br/>
					<b>密　　码：</b><orange>${member.password}</orange><br/>
					<b>电话密码：</b><orange>${member.password}</orange><br/>
					<b>资金密码：</b><orange>111111</orange>
				</div>
				<div class="sp4_mz mt10">
					<h3>免责声明</h3>
					<p>尊敬的客户，为保证您的交易及资金安全，请确保您个人开户资料的真实性、有效性，严格使用本人相关信息、资料完成开户手续。
					对于使用非本人信资料完成贵金属投资账户开户所带来的任何风险或损失，天津贵金属交易所及易润贵金属经营有限公司不承担任何法律责任，
					由此行为引起的任何纠纷，易润贵金属将保留进一步诉诸法律的权利。</p>
				</div>
			</div>
			<div class="h10"></div>
			<a class="btn mt10 orange-1 white h42 w90 mauto f16 radius" href="<%=ctx %>/kaihu/jihuo/">完成网银签约后点击激活账户</a>
			<a class="btn fl ml5 mt5 radius h42 border-orange blue plr10" href="http://www.yr202.com/help/qianyue.html"><i class="icon-edit"></i>网银签约教程</a>
			<a class="btn fr mr5 mt5 radius h42 border-orange blue plr10" href="<%=ctx %>/kehu/tel/"><i class="icon-kefu"></i>联系人工客服</a>
		</div>
	</div>
</body>
</html>

