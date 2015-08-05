<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page language="java" import="com.yr.utils.DataConfig,com.hs.dolphin.web.support.UserSession,java.util.Date,com.hs.dolphin.sys.utils.DateUtil" %>
<%
	String ctxIndexFocus = request.getContextPath();
	UserSession.getInstance(request).setTokinId(DateUtil.toDateTimeString(new Date()));
%>
<div class="index-banner">
  
	<!--幻灯片-->
	<div class="swiper-container">
		<div class="swiper-wrapper">
		    <yr:showFocusPicTag type="6"/>
	    </div>
	    <div class="swiper-pagination"></div>
	</div>
</div>
