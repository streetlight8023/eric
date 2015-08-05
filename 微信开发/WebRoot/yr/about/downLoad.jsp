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
	<div class="wrapper vhidden">
		<div class="consult-tit alignCenter radius mt5">动动手指,掌握第一手行情</div>
		
		<h2 class="h42 b">易润贵金属APP下载</h2>
		
		<p class="b">由津贵所自主开发，通过公安部对信息系统安全等级保护的认证。功能强大、操作简单，能够提供实时行情、网上交易及查询、实时转账等功能。
		方便您出入金，让您的投资交易得到安全可靠的保障，时刻把握市场投资机会。</p>
		<p class="fr b">（授权码请咨询客户经理获取）</p>
		<div style="clear: both"></div>
		<table class="yr-table mt20">
			<tr>
				<td class="w30">
					<img alt="" src="<%=ctx %>/resources/images/pic/pro002.jpg">
				</td>
				<td class="w70 alignRight">
			    	<a  class="btn green-2 white w95 ml5 h34 radius" href="<%=DataConfig.FTP_FILE_URL %>/ttj.apk" >天通金交易软件(Android)</a>
			    	<a  class="btn blue-1 white w95 ml5 h34 radius mt10" href="https://itunes.apple.com/cn/app/tian-tong-jin/id575816603?mt=8">天通金交易软件(IOS)</a>
				</td>
			</tr>
		</table>
		<table class="yr-table mt20">
			<tr>
				<td class="w30">
					<img alt="" src="<%=ctx %>/resources/images/pic/pro004.png">
				</td>
				<td class="w70 alignRight">
			    	<a  class="btn green-2 white w95 ml5 h34 radius"  href="<%=DataConfig.FTP_FILE_URL %>/htjy.apk" >慧通金银交易客户端(Android)</a>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>

