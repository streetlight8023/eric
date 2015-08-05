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
<script type="text/javascript">
jQuery(function() {
	var w = $("#analyst-rp").width() - 12 - 84;
	$("#analyst-rp a marquee").width(w);
	$("#analyst-rp a").each(function(){
		var createTime = $(this).find("input").val();
		var time = createTime.split(" ",1);
		var day = time[0].split("-",3);
		$(this).find(".createTime").text(day[2] + "日早评：");
	})
})

</script>
</head>
<body>
	<%@ include file="/commons/head.jsp" %>
	<div class="wrapper vhidden">
	<table class="w100 mt10">
		<tr>
			<td class="w40">
				<div class="analyst-img">
					<img src="${zhiboUser.imgPath }" alt="" />
				</div>
			</td>
			<td>
				<div class="Triangle-box w95 ptb10 whiteBg shadow radius alignCenter mauto">
	          		<b>易润资深分析师 : ${zhiboUser.customerName}</b>
	        	</div> 
			</td>
		</tr>
	</table>
		
		
        <div class="banner" id="analyst-rp">
        <c:forEach var="item" items="${newlist}" varStatus="stu">
        	<c:if test="${stu.index < 5 }">
        		<a href="javascript: void(0)">
        			<input type="hidden" value="${item.createDate}" />
        			<b class="createTime fl"></b><marquee class="fl" behavior="scroll" align="absmiddle" cellspacing="0" cellpadding="0" direction="left" scrollamount="3" loop="infinite" scrolldelay="1" height="40">${item.alt}</marquee>
        		</a>
        	</c:if>        	
        </c:forEach>
        </div>
        <div class="banner alignCenter">
        	<div class="h10"></div>
        	<orange>现在开户更有话费等礼包相送</orange>
        	<a href="<%=ctx %>/kaihu/xinxi/" class="btn radius orange-1 h42 white f16 mt10 mauto w100" >三分钟极速开户</a>
        	<div class="h10"></div>
        </div>
	</div>
</body>
</html>

