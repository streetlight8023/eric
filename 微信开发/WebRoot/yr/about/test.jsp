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
	<!-- 焦点图 开始 -->
	<div class="border bnone pnone">
		<img src="<%=ctx %>/resources/images/pic/lccs.png" alt="极速开户" />
	</div>
	<!-- 焦点图 结束 -->
	
	<div class="wrapper vhidden">
		<div class="border mt10">
			<div class="wrapper"  id="test">
				<h1>大扫除时，您会扔掉下列哪一类物品？</h1>
				<ul class="mt10">
					<li>
						<span class="test-round test-active"><div></div></span>旧衣服
					</li>
					<li>
						<span class="test-round"><div></div></span>体积过大的老电器
					</li>
					<li>
						<span class="test-round"><div></div></span>零零碎碎的小东西
					</li>
					<li>
						<span class="test-round"><div></div></span>过期杂志
					</li>
				</ul>
				<h1 class="mt10">测试结果：</h1>
				<div class="border test-result">
					<div class="test-result-text">
						<orange>旧衣服</orange>
						<b>测试结果：</b>
						<span>你赚钱的能力很强，花钱的能力更强，尽管你收入很高，但仍然觉得自己钱不够花，建议保持老一辈的优良传统，生活中还是多多开源节流些吧,可以投资一些贵金属产品。</span>
					</div>
					<div class="test-result-text none">
						<orange>体积过大的老电器</orange>
						<b>测试结果：</b>
						<span>你的理财观念属于冲动派，虽然买起东西来不至于浪费，但是却常常买了一些用不着的装饰品、衣服等等，而你又不擅于另开财源，因此你需要一个擅于管帐的人帮助你，如果投资贵金属则需要多听听分析师意见。</span>
					</div>
					<div class="test-result-text none">
						<orange>零零碎碎的小东西</orange>
						<b>测试结果：</b>
						<span>你买东西至少考虑三次以上，但是在朋友面前又装作花钱毫不在乎的样子，所以一般人都觉得你的经济很宽裕，实际上你是个开源和节流都并重的理财大师。 最合适投资贵金属。</span>
					</div>
					<div class="test-result-text none">
						<orange>过期杂志</orange>
						<b>测试结果：</b>
						<span>你从不乱花钱，购买的东西通常都物美价廉。美中不足的是，你只在节流方面努力，很少思考开源的方法，要记住财富不是节省出来的。</span>
					</div>
				</div>
			</div>
		</div>
		<div class="h10"></div>
	</div>
</body>
<script>
	$(function(){
		$(".test-round").click(function(){
			var index = $(this).parents("li").index();
			$(".test-round").removeClass("test-active");
			$(this).addClass("test-active");
			$(".test-result .test-result-text").hide();
			$(".test-result .test-result-text").eq(index).show();
			$(".test-round").unbind('click');
		})
	})
</script>
</html>
