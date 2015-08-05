package com.yr.web.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hs.core.dao.support.Page;
import com.hs.mims.domain.front.CompanyNews;
import com.hs.mims.domain.zhibo.ZhiboUser;
import com.hs.mims.service.front.NewsService;
import com.hs.mims.service.zhibo.ZhiboUserService;
import com.hs.mims.utils.DataConfig;
import com.yr.utils.BaseAction;
public class MorningCommensAction extends BaseAction {
	
	/**
	 * 微站分析师早评
	 */
	private static final long serialVersionUID = -7655420710697344968L;
	
	private NewsService newsService;
	private ZhiboUserService zhiboUserService;
	
	/**
	 * 获取某一个分析师的所有早评或者最新的早评
	 */
	public String getAnalystComments(){
		String id=  getRequest().getParameter("id");
		ZhiboUser zhiboUser= zhiboUserService.get(Integer.parseInt(id));
		getRequest().setAttribute("zhiboUser", zhiboUser);
		
		Map<String, Object> queryParameter = bindMap();
		queryParameter.put("id", null);
		queryParameter.put("articleUrl", id);
		queryParameter.put("isDelete", DataConfig.DELETE_NO);
		queryParameter.put("sort", "DATE_FORMAT(create_date,'%Y-%m-%d %H:%i:%S')");
		queryParameter.put("dir", "desc");
		queryParameter.put("currentPage", "1");	
		queryParameter.put("limit", "15");
		queryParameter.put("type", "6");
		Page page = this.newsService.queryForJquery(queryParameter);
		List<CompanyNews> newlist=(List<CompanyNews>) page.getData();
		getRequest().setAttribute("newlist", newlist);
//		printJson(response, JsonUtils.bean2Json(page));
		return "getComments";
	}
	
	
	public NewsService getNewsService() {
		return newsService;
	}

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}


	public ZhiboUserService getZhiboUserService() {
		return zhiboUserService;
	}


	public void setZhiboUserService(ZhiboUserService zhiboUserService) {
		this.zhiboUserService = zhiboUserService;
	}
	
	

	
}
