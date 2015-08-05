<%@ page contentType="text/html; charset=UTF-8"%>
<%
	String ctx = request.getContextPath();
	response.setHeader("Pragma","No-cache");     
	response.setHeader("Cache-Control","no-cache");     
	response.setDateHeader("Expires", 0);   
	
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://wx.yr202.com" prefix="yr"%>
<meta content="no" name="apple-mobile-web-app-capable"><!-- ios允许全屏 -->
<meta content="telephone=no" name="format-detection"><!-- 禁止将长数字默认为电话号码 -->
<link rel="apple-touch-icon" href="<%=ctx%>/resources/images/icon/yr.png"><!-- ios保存到桌面 -->
<link rel="shortcut icon " href="<%=ctx%>/favicon.ico" />
<link type="text/css" href="<%=ctx%>/resources/css/style.css" rel="stylesheet" />
<link type="text/css" href="<%=ctx%>/resources/css/form.css" rel="stylesheet" />
<link type="text/css" href="<%=ctx%>/resources/css/swiper.css" rel="stylesheet" />
<script type="text/javascript" src="<%=ctx%>/resources/js/jquery.js"></script>
<input type="hidden" id="ROOT" name="ROOT" value="<%=ctx %>" />
<input type="hidden" value="${sequneId }" id="sequneId" />