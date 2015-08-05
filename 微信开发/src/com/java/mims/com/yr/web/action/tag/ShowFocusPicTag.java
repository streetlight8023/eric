package com.yr.web.action.tag;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hs.mims.domain.product.FocusPic;
import com.hs.mims.service.product.FocusPicService;
import com.yr.utils.DataConfig;
/**
 * 首页--右上角客户服务标签
 */
public class ShowFocusPicTag extends SimpleTagSupport {
	/**
	 * 1：首页；4：开户页面；3：加盟页面
	 */
	private Integer type;

	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * 焦点图信息展示
	 * parameter: type

	 */
	public void doTag() throws JspException, IOException {
		StringBuffer sb = new StringBuffer();
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(((PageContext) this.getJspContext()).getServletContext());
		FocusPicService focusPicService = (FocusPicService) context.getBean("focusPicService");
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("showAddress", type);
				List<FocusPic> list = (List<FocusPic>) focusPicService.queryFocusPicByQueryParameter(map);
				         //  <div class="swiper-slide"><img src="<%=ctx%>/resources/images/banner/banner2.png" /></div>

				for(FocusPic cl:list){
					if(cl.getUrlPath()!=null&&!cl.getUrlPath().equals("")){
					  /* sb.append("<li class='swiper-slide' alt='"+cl.getAlt()+"' title='"+cl.getAlt()+"' target='_blank' data-href='"+cl.getUrlPath()+"'  style='background:url("+DataConfig.FTP_URL+"/"+cl.getPicPath()+") center center'><img src=");	   
					   sb.append("</li>");*/
					   
					   sb.append("<div class='swiper-slide'><a target='_blank' href='"+DataConfig.DOM_URL+cl.getUrlPath()+"'><img alt='"+cl.getAlt()+"' src='"+ DataConfig.FTP_URL+"/"+cl.getPicPath() +"' /></a>");	   
					   sb.append("</div>");
					}else{
						sb.append("<div class='swiper-slide'><a target='_blank' href='"+DataConfig.XIHU_ZHENGBA+"'><img alt='"+cl.getAlt()+"' src='"+ DataConfig.FTP_URL+"/"+cl.getPicPath() +"' /></a>");
						   sb.append("</div>");
					}
				}
		this.getJspContext().getOut().write(sb.toString());
	}
}
