<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page language="java" import="com.yr.utils.DataConfig,java.util.Date" %>
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
	<div class="wrapper vhidden" id="case">
		<div class="h10"></div>
		<h1>本期用户</h1>
		<table class="yr-table mt10">
			<c:forEach var="earnCase" items="${earnCasees}" varStatus="status">
			 	<c:if test="${status.index==0}">
			 		<tr>
						<td class="w40">
							<div class="case-img">
								<img src="<%=DataConfig.FTP_URL%>/${earnCase.imgpath}"></img>
							</div>
						</td>
						<td class="w60">
							<div class="whiteBg shadow radius w95 mauto alignLeft"><div class="plr10 ptb10">${earnCase.context}</div></div>
						</td>
					</tr>
				</c:if> 
			</c:forEach>
		</table>
		<table class="yr-table mt10">
			<tr>
				<td class="w15">
					<span class="early radius">早<br/>评</span>
				</td>
				<td class="w85 whiteBg radius">
					<c:forEach var="zaoping" items="${news}" varStatus="newsStatus">
		        		<c:if test="${newsStatus.index==0}">
				       	 	<a href="javascript:void()" class="block plr10 ptb10">	
				       	 <%-- 	<fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/> --%>
				       	 	${zaoping.alt}</a>
		        		</c:if> 
			       	 </c:forEach>
				</td>
			</tr>
		</table>
		<table class="yr-table mt10" id="case-table">	
			<c:forEach var="earnCase" items="${earnCasees}" varStatus="status">
				 	<c:if test="${status.index==1}">
				 		<tr>
							<td class="w30">
								<div class="case-img">
									<img src="<%=DataConfig.FTP_URL%>/${earnCase.imgpath}"></img>
								</div>
							</td>
							<td class="w70">
								<div class="whiteBg shadow radius w98 alignLeft"><div class="plr10 ptb10">${earnCase.context}</div></div>
							</td>
						</tr>
					</c:if> 
				 	
				 	<c:if test="${status.index==2}">
				 		<tr>
							<td class="w30">
								<div class="case-img">
									<img src="<%=DataConfig.FTP_URL%>/${earnCase.imgpath}"></img>
								</div>
							</td>
							<td class="w70">
								<div class="whiteBg shadow radius w98 alignLeft"><div class="plr10 ptb10">${earnCase.context}</div></div>
							</td>
						</tr>
					</c:if> 
					
				 	<c:if test="${status.index==3}">
				 		<tr>
							<td class="w30">
								<div class="case-img">
									<img src="<%=DataConfig.FTP_URL%>/${earnCase.imgpath}"></img>
								</div>
							</td>
							<td class="w70">
								<div class="whiteBg shadow radius w98 alignLeft"><div class="plr10 ptb10">${earnCase.context}</div></div>
							</td>
						</tr>
					</c:if> 
				</c:forEach>
		</table>
	</div>
</body>
</html>

