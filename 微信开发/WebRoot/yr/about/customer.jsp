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
<body id="customer" style="overflow: hidden">
	<div class="wrapper">
		<div class="w70 mauto">
			<img class="w95 alignLeft mt10" alt="" src="<%=ctx %>/resources/images/icon/logo.png" />
		</div>
		
		<a href="tel:4006706202" class="radius mt10 mauto shadow" id="customerTel">
			<orange class="b">400-6706-202</orange>
			<p>现货白银投资开户平台</p>
			<i></i>
		</a>
		<table class="w80 mauto mt20">
			<tr>
				<td class="w50">
					<a href="<%=ctx %>/kehu/tel/" class="block w100">
						<div class="customer-list orange-2 mauto">
							<img alt="" class="w75 mauto" src="<%=ctx %>/resources/images/icon/kfrx.png" />
						</div>
						<div class="w80 mauto h24 alignCenter whiteBg">客服热线</div>
						<div class="h10"></div>
					</a>
				</td>
				<td class="w50">
					<a href="<%=ctx %>/kehu/product/" class="block w100">
						<div class="customer-list orange-1 mauto">
							<img alt="" class="w75 mauto" src="<%=ctx %>/resources/images/icon/yrcp.png" />
						</div>
						<div class="w80 mauto h24 alignCenter whiteBg">易润产品</div>
						<div class="h10"></div>
					</a>
				</td>
			</tr>
			<tr>
				<td class="w50">
					<a href="<%=ctx%>/kehu/honour/" class="block w100">
						<div class="customer-list green-4 mauto">
							<img alt="" class="w70 mauto" src="<%=ctx %>/resources/images/icon/yrry.png" />
						</div>
						<div class="w80 mauto h24 alignCenter whiteBg">易润荣誉</div>
						<div class="h10"></div>
					</a>
				</td>
				<td class="w50">
					<a href="<%=ctx%>/kehu/huodong/" class="block w100">
						<div class="customer-list green-3 mauto">
							<img alt="" class="w70 mauto" src="<%=ctx %>/resources/images/icon/yrhd.png" />
						</div>
						<div class="w80 mauto h24 alignCenter whiteBg">理财测试</div>
						<div class="h10"></div>
					</a>
				</td>
			</tr>
			<tr>
				<td class="w50">
					<a href="<%=ctx%>/kehu/liuyan/" class="block w100">
						<div class="customer-list red-1 mauto">
							<img alt="" class="w65 mauto" src="<%=ctx %>/resources/images/icon/khxs.png" />
						</div>
						<div class="w80 mauto h24 alignCenter whiteBg">常见问题</div>
						<div class="h10"></div>
					</a>
				</td>
				<td class="w50">
					<a href="<%=ctx%>/kehu/yirun/" class="block w100">
						<div class="customer-list blue-1 mauto">
							<img alt="" class="w90 mauto" src="<%=ctx %>/resources/images/icon/gyyr.png" />
						</div>
						<div class="w80 mauto h24 alignCenter whiteBg">关于易润</div>
						<div class="h10"></div>
					</a>
				</td>
			</tr>
		</table>
	</div>
	<a href="<%=ctx%>/" class="home">
		<img class="mauto mt5" alt="" src="<%=ctx %>/resources/images/icon/sytb.png">
		<p>返回首页</p>
	</a>
</body>
</html>

