package com.yr.web.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hs.mims.domain.front.EarnReckon;
import com.hs.mims.domain.product.Product;
import com.hs.mims.service.front.EarnCaseService;
import com.hs.mims.service.front.EarnReckonService;
import com.hs.mims.service.product.ProductService;
import com.yr.utils.BaseAction;
public class SpotIIntroductionAction extends BaseAction {
	
	/**
	 * 投资品种介绍
	 */
	private static final long serialVersionUID = -7655420710697344968L;
	
	private ProductService productService;
	
	
	public void getInvestmentCase(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sort", "sort_id");
		map.put("dir", "desc");
		List<Product>list=productService.queryProductByQueryParameter(map);
	}
	
	


	public ProductService getProductService() {
		return productService;
	}



	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	
}
