package com.yr.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * 微信交互接口
 * 
 * @author: zhangyw
 * @since: March  6, 2015 3:28:31 PM
 * @history: ***********************************************
 * @file: WeiXinService.java
 * @Copyright: 2015 yr Electronics Co.,Ltd. All right reserved.
 *             **********************************************
 */
public interface WeiXinService {
	/**
	 * 创建微信菜单
	 * 
	 * @description
	 * @param params
	 * @param accessToken
	 * @return
	 * @throws Exception
	 * @create March 15, 2015 10:03:40 AM zhangyw
	 * @history
	 */
	public String createMenu() throws Exception;

	/**
	 * 获取微信accessToken
	 * 
	 * @description
	 * @param appid
	 * @param secret
	 * @return
	 * @throws Exception
	 * @create March 15, 2015 10:03:40 AM zhangyw
	 * @history
	 */
	public String getAccessToken() throws Exception;

	/**
	 * 查询微信菜单
	 * 
	 * @description
	 * @param accessToken
	 * @return
	 * @throws Exception
	 * @create March 15, 2015 10:03:40 AM zhangyw
	 * @history
	 */
	public String getMenuInfo(String accessToken) throws Exception;

	/**
	 * 删除自定义微信菜单
	 * 
	 * @description
	 * @param accessToken
	 * @return
	 * @create March 15, 2015 10:03:40 AM zhangyw
	 * @history
	 */
	public String getAccessToken(String accessToken) throws Exception;

	public String processRequest(HttpServletRequest request,
			Map<String, String> requestMap) throws Exception;

	/**
	 * 握手微信交互信息
	 * 
	 * @description
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @create March 15, 2015 10:03:40 AM zhangyw
	 * @history
	 */
	public String chatWeiXin(HttpServletRequest request,
			HttpServletResponse response, String signature, String timestamp,
			String nonce, String echostr) throws Exception;


	
}
