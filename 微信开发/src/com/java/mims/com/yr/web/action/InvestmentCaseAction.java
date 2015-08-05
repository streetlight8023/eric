package com.yr.web.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hs.dolphin.sys.utils.DateUtil;
import com.hs.mims.domain.front.CompanyNews;
import com.hs.mims.domain.front.EarnCase;
import com.hs.mims.service.front.EarnCaseService;
import com.hs.mims.service.front.NewsService;
import com.yr.utils.BaseAction;
public class InvestmentCaseAction extends BaseAction {
	
	/**
	 * 获取投资案例
	 */
	private static final long serialVersionUID = -7655420710697344968L;
	
	private EarnCaseService earnCaseService;
	private NewsService newsService;


	/**
	 * 获取投资案例
	 */
	public String  getInvestmentCase(){
		
		Map<String, Object> parmMap= new HashMap<String, Object>();
		parmMap.put("limit", 5);
		parmMap.put("start", 1);
		parmMap.put("currentPage", 1);
		parmMap.put("type", EarnCase.TYPE_3);	//微信投资案例
		parmMap.put("sort", "create_time");
		parmMap.put("dir", "asc");
		List<EarnCase> earnCasees = earnCaseService.queryList(parmMap);
		
		Map<String, Object> newsMap= new HashMap<String, Object>();
		newsMap.put("sort", "create_date");
		newsMap.put("type", "6");
		newsMap.put("dir", "desc");
		List<CompanyNews> news = newsService.queryList(newsMap);
		getRequest().setAttribute("date", DateUtil.stringToUtilDate(news.get(0).getCreateDate()));	
		getRequest().setAttribute("news", news);

		getRequest().setAttribute("earnCasees", earnCasees);
		return "investmentCase";
	}
	
	
	
	public EarnCaseService getEarnCaseService() {
		return earnCaseService;
	}

	public void setEarnCaseService(EarnCaseService earnCaseService) {
		this.earnCaseService = earnCaseService;
	}
	public NewsService getNewsService() {
		return newsService;
	}

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}
}
