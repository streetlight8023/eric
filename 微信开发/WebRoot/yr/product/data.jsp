<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page language="java" import="com.yr.utils.DataConfig,java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title></title>
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
<meta name="Keywords" content=""/>
<script type="text/javascript" src="<%=DataConfig.DOM_URL %>/resources/js/spot.js"></script>
<meta name="Description" content="" />
<%@ include file="/commons/meta.jsp" %>
<script type="text/javascript" src="<%=ctx %>/resources/js/spot.js"></script>
</head>
<body>
<%@ include file="/commons/head.jsp" %>
<div class="data">
	<span class="w50 orange alignCenter h44 b f18 block fl data-active" id="hq">行情数据</span>
	<span class="w50 orange alignCenter h44 b f18 block fl" id="k">K线图</span>
</div>
<table class="w100 data-tab" id="data">
	<thead>
		<tr>
			<th width="90">类型</th>
			<th>最新</th>
			<th>涨跌</th>
			<th>涨幅</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td align="left" class="pleft10">现货白银</td>
			<td align="center">-</td>
			<td align="center">-</td>
			<td align="center">-</td>
		</tr>
		<tr>
			<td align="left" class="pleft10">现货铂金</td>
			<td align="center">-</td>
			<td align="center">-</td>
			<td align="center">-</td>
		</tr>
		<tr>
			<td align="left" class="pleft10">现货钯金</td>
			<td align="center">-</td>
			<td align="center">-</td>
			<td align="center">-</td>
		</tr>
		<tr>
			<td align="left" class="pleft10">现货镍</td>
			<td align="center">-</td>
			<td align="center">-</td>
			<td align="center">-</td>
		</tr>
		<tr>
			<td align="left" class="pleft10">现货铜</td>
			<td align="center">-</td>
			<td align="center">-</td>
			<td align="center">-</td>
		</tr>
		<tr>
			<td align="left" class="pleft10">现货铝</td>
			<td align="center">-</td>
			<td align="center">-</td>
			<td align="center">-</td>
		</tr>
	</tbody>
</table>
<iframe src="http://weixin2.baidao.com/assets/quotes/index.html#products/1" scrolling="no" class="data-tu data-tab none" id="data-iframe"></iframe>

<div class="h10"></div>
</body>
<script>
	$(function(){
		$("#data tbody tr").click(function(){
			var index = $(this).index();
			var path = "http://weixin2.baidao.com/assets/quotes/index.html#products/";
			var pro = ["1","6","5","7","8","9"];
			$("#data").hide();
			$("#hq").removeClass("data-active");
			$("#k").addClass("data-active");
			$("#data-iframe").attr("src",path + pro[index]).show();
		})
		$(".data span").click(function(){
			var index = $(this).index();
			$(".data span").removeClass("data-active");
			$(this).addClass("data-active");
			$(".data-tab").hide();
			$(".data-tab").eq(index).show();
		})
	})
</script>
</html>
