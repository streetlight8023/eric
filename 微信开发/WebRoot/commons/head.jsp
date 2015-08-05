<%@ page contentType="text/html; charset=UTF-8"%>
<header>
	<a href="<%=ctx %>" class="block fl w30">
		<img class="w100" src="<%=ctx %>/resources/images/icon/logo.png" />
	</a>
	<span class="block fr"></span>
	<div style="clear: both"></div>
	<div class="nav none">
		<a class="bnone" href="<%=ctx %>/analyst/">分析师说</a>
		<a href="<%=ctx %>/hangqing/">行情走势</a>
		<a href="<%=ctx %>/anli/">投资案例</a>
		<a href="<%=ctx %>/download/">软件下载</a>
		<a href="<%=ctx %>/kaihu/xinxi/">快速开户</a>
		<a href="<%=ctx %>/kehu/">客户服务</a>
		<i></i>
	</div>
</header>
<footer>
	<table class="w100">
		<tr>
			<td><a href="<%=ctx %>/kaihu/xinxi/">
				<img alt="" src="<%=ctx %>/resources/images/icon/kskh.png">
				<p>快速开户</p>
				</a>
			</td>
			<td><a href="tel:4006706202">
				<img alt="" src="<%=ctx %>/resources/images/icon/pho_sy.png">
				<p>400热线</p>
				</a>
			</td>
			<td><a href="http://wpa.qq.com/msgrd?v=3&uin=2693403582&site=qq&menu=yes">
				<img alt="" src="<%=ctx %>/resources/images/icon/txqq.png">
				<p>客服QQ</p>
			</a>
			</td>
			<td class="bnone"><a href="<%=ctx%>/">
				<img alt="" src="<%=ctx %>/resources/images/icon/sytb.png">
				<p>首页</p>
				</a>
			</td>
		</tr>
	</table>
</footer>
<script>
	$(function(){
		$("header span").click(function(){
			if($(".nav").css("right") == "-35%"){
				$(".nav").show(0).animate({"right":"10"},100).animate({"right":"0"},100);
			}else{
				$(".nav").animate({"right":"-35%"},80).delay(180).hide(0);
			}
		})
		$("body").append("<div style='width: 100%; height: 0.45rem; z-index: 0;'></div>")
	})
</script>