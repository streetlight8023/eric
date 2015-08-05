package com.yr.web.action;

import java.util.Map;

import com.hs.core.dao.support.Page;
import com.hs.mims.service.front.CustomService;
import com.yr.utils.BaseAction;
public class FAQAction extends BaseAction {
	
	/**
	 * FAQ
	 */
	private static final long serialVersionUID = -7655420710697344968L;
	
	private CustomService customService;
	
	/**
	 * 获取FAQ列表
	 * @return
	 * @throws Exception
	 */
	public String queryQuestionNewsPage() throws Exception {
		Map<String, Object> queryParameter = bindMap();
		Page page = new Page();
		queryParameter.put("limit", "15");
		queryParameter.put("currentPage", "1");	
		queryParameter.put("type", "5");
		queryParameter.put("sort", "createDate");
		queryParameter.put("dir", "desc");
		queryParameter.put("isPublish", "2");
		queryParameter.put("isDelete", "1");
		page = this.customService.queryForJquery(queryParameter);
		getRequest().setAttribute("pList", page.getData());
		return "keFuQuestion";
	}

	public CustomService getCustomService() {
		return customService;
	}

	public void setCustomService(CustomService customService) {
		this.customService = customService;
	}
		
}
