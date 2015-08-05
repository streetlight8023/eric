<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
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
		<table class="yr-table mt10">
			<tr>
				<td class="w25">
					<span class="early radius">今日<br/>早评</span>
				</td>
				<td class="w75 whiteBg radius">
					<a href="javascript:void()" class="block plr10 ptb10">${morning.alt}</a>
				</td>
			</tr>
		</table>
		<table class="yr-table mt20">
		<c:forEach items="${analysts }" var="item" varStatus="stu">
		<c:if test="${stu.index<3 }">
			<tr>
        		<td class="w35">
        			<div class="case-img">
						<a href="<%=ctx%>/analyst/celv_${item.id}.html"><img src="${item.imgPath}" alt="" /></a>
					</div>
        		</td>
        		<td class="w65">
	        		<a href="<%=ctx%>/morningCommens_getAnalystComments.action?id=${item.id}">
	        			<div class="analyst-box radius alignCenter mt10 fl">
			          		${item.customerIp }
			       		</div>
			       	</a>
        		</td>
        	</tr>
        </c:if>
		</c:forEach>        	
        </table>
        
        <a href="<%=ctx %>/kaihu/xinxi/" class="btn orange-1 w100 h42 radius white f16 mt20" >边听分析师说边实盘开户赚钱</a>
        <div class="h10"></div>
	</div>

</body>
</html>

