package com.yr.web.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ctc.wstx.util.DataUtil;
import com.hs.core.dao.support.Page;
import com.hs.dolphin.sys.utils.DateUtil;
import com.hs.mims.domain.front.CompanyNews;
import com.hs.mims.domain.zhibo.ZhiboUser;
import com.hs.mims.service.front.NewsService;
import com.hs.mims.service.zhibo.ZhiboUserService;
import com.hs.mims.utils.DataConfig;
import com.yr.utils.BaseAction;

public class AnalystDataAction extends BaseAction {
	
	/**
	 * 获取分析师资料
	 */
	private static final long serialVersionUID = -7655420710697344968L;
	
	private ZhiboUserService zhiboUserService;
	private NewsService newsService;
	

	/**
	 * 获取分析师资料
	 */
	public String getAnalysts(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("authority", 1);
		map.put("sort", "id");
		map.put("dir", "asc");
		map.put("isDelete", DataConfig.DELETE_NO);
		List<ZhiboUser> analysts = zhiboUserService.queryByParameter(map);
		getRequest().setAttribute("analysts", analysts);
		
		
		//早评
		Map<String, Object> queryParameter = bindMap();
		queryParameter.put("isDelete", DataConfig.DELETE_NO);
		queryParameter.put("sort", "DATE_FORMAT(create_date,'%Y-%m-%d %H:%i:%S')");
		queryParameter.put("dir", "desc");
		queryParameter.put("start", "1");
		queryParameter.put("currentPage", "1");		
		queryParameter.put("limit", "2");	
		queryParameter.put("type", "6");
		Page page = this.newsService.queryForJquery(queryParameter);
		List<CompanyNews> newlist=(List<CompanyNews>) page.getData();
		if(newlist.size() > 0){	
			getRequest().setAttribute("morning", newlist.get(0));	
			getRequest().setAttribute("date", DateUtil.stringToUtilDate(newlist.get(0).getCreateDate()));	
		}
		return "getAnalysts";
	}
	
	
	public ZhiboUserService getZhiboUserService() {
		return zhiboUserService;
	}



	public void setZhiboUserService(ZhiboUserService zhiboUserService) {
		this.zhiboUserService = zhiboUserService;
	}


	public NewsService getNewsService() {
		return newsService;
	}


	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}
	
	

	
}
