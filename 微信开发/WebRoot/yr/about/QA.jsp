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
	<div class="wrapper vhidden">
		<div class="h10"></div>
		<div class="border" id="qa">
			<div class="h10"></div>
			<c:forEach items="${pList}" var="item" varStatus="stu">
				<section>
					<span><orange>Q：</orange>${item.articleTitle }</span>
					<p><orange class="b">A：</orange>${item.alt}</p>
				</section>
			</c:forEach>			
		</div>
        <div class="banner alignCenter">
        	<a href="<%=ctx%>/kaihu/xinxi/" class="btn orange-1 white w100 h42 f16 mt20 radius" >三分钟极速开户</a>
        	<div class="h10"></div>
        </div>
	</div>
</body>
<script type="text/javascript">
	$(function(){
		$("section:first").find("p").show();
		$("section:first").find("span").addClass("active");
		$("section").click(function(){
			if($(this).find("p").is(":visible")){
				
			}else{
				$(this).siblings("section").find("p").hide();
				$(this).find("p").show();
				$(this).siblings("section").find("span").removeClass("active");
				$(this).find("span").addClass("active");
			}
		})
	})
</script>
</html>

