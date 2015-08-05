package com.yr.utils;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;


public class DataConfig {
	
//	public static String WEIXIN_GUANZHU="您好！我是易润贵金属小编，感谢您的关注！mo-微笑我们会在每周一至周五的上午十点准时发布最新投资资讯，欢迎阅读。您也可以直接在对话框中发送以下内容：\n\n发送数字1，获取今日【易润评论】；\n发送数字2，获取今日【国际要闻】；\n发送数字3，参加【财经易学堂】，获取贵金属投资学习资料。\n更多应用指南，请直接发送“0”！\n了解更多投资资讯，请点击右上角的“小人”mo-拥抱按钮，查看历史消息。如果您有投资需求或困惑，欢迎拨打易润24小时客服热线：400-6706-202";
	public static String WEIXIN_GUANZHU="携手易润贵金属，共创财富神话！在这里，您可以了解投资最新资讯；在这里，您可以获取理财最新方法。\n\n 发送数字1，获取每日专家点评【跳转分析师说版块】\n\n发送数字2，获取贵金属最新行情动态【跳转行情走势】\n\n发送数字3，开启赚钱之旅【跳转开户版块】\n\n 发送数字4，获取客服界面【跳转客服中心】 \n\n发送数字5，获取实盘开户【跳转实盘开户】 \n\n发送数字6，获取产品介绍【跳转产品介绍】\n\n 发送数字7，获取常见问题【跳转常见问题】，发送数字8，获取易润简介【跳转关于易润】，\n\n发送数字8，获取易润荣誉 【跳转易润荣誉】    想了解更多投资资讯，请点击右上角小人按钮，查看历史消息。如果您有投资需求或困惑，欢迎拨打易润24小时客服热线：400-6706-202！";
	
	
//	public final static String DOM_URL = "http://127.0.0.1:8080/wx";
//	public final static String DOM_URL = "http://192.168.1.185:80/wx";
//	public final static String DOM_URL = "http://192.168.1.242:8080/wx";
	public final static String DOM_URL = "http://wx.yr202.com";

	public static String ACCESS_TOKEN="6JHvOsUg5wcTCWPLcBcfP3UngLcNzwegw_cda9nFoJta6SuaEdpZHvtj43F-WtOmvLJyTGDaxN2YY1FB_mtsL19fyFe4fnnZxcjcg0b0qv0";

	//白银xml地址
	public final static String AG_XML = "http://ftp.yrjin.com:8099/xml/Ag.xml";
	
	/**
	 * 西湖争霸赛
	 */
	public final static String XIHU_ZHENGBA = "http://www.yr202.com/yr/active/xhlj.html";

	
	/**
	 * ftp url
	 */
	public final static String FTP_URL = "http://ftp.yrjin.com:8099/img";
	
	/**
	 * ftp 下载软件url
	 */
	public final static String FTP_FILE_URL = "http://ftp.yrjin.com:8099/file";

	
	/**
	 *  fromPage来源页
	 */
	public final static String OPEN_ACCOUNT_FROMPAGE_WEIZHAN = "微网站";
	/**
	 * 微站第二页
	 */
	public final static String OPEN_ACCOUNT_FROMPAGE_WEIZHAN_2 = "微网站第二页";
	
	/**
	 * 开户类型 实盘开户
	 */
	public final static Integer  OPEN_ACCOUNT_TYPE_SHIPAN =1;
	/**
	 * 行情数据接口
	 */
	public final static String SPOT_CLOSE_INTEFACE="http://180.213.5.147:8080/tradeweb/hq.jsp";
	/**
	 * 测试数据
	 */
//	public final static String SPOT_CLOSE_INTEFACE="http://123.150.41.139:9191/tradeweb/hq.jsp";
	

	//订阅
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";
	//取消订阅
	public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";

	public final static String RESP_MESSAGE_TYPE_TEXT = "text";

	public final static String RESP_MESSAGE_TYPE_IMAGE = "image";

	public final static String RESP_MESSAGE_TYPE_VOICE = "voice";

	public final static String RESP_MESSAGE_TYPE_VIDEO = "video";

	public final static String RESP_MESSAGE_TYPE_LOCATION = "location";
	
	public final static String RESP_MESSAGE_TYPE_CLICK = "CLICK";

	public final static String RESP_MESSAGE_TYPE_EVENT = "event";
	
	 public static final String RESP_MESSAGE_TYPE_NEWS = "news"; 

	public final static String RESP_MESSAGE_TYPE_FIRST = "大家好，易润欢迎你";
	
	public final static String AppSecret = "708e5a8228926be796ef7c13bfb0f9fa";
	
	public final static String AppID = "wx1f0e15cc63106c6a";
	
	public final static String LEMEI_ACCOUNT_USER = "gh_b5658d9385f9";
	
	
	
	public static String getRandomCode(){
		//6位随机码
		Random r = new Random();
		int xx = r.nextInt(1000000);
		while(xx<100000){
			xx = r.nextInt(1000000);
		}
		return String.valueOf(xx);
	}
	
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Real-IP");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			return ip;
		}
		ip = request.getHeader("X-Forwarded-For");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			// 多次反向代理后会有多个IP值，第一个为真实IP。
			int index = ip.indexOf(',');
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		} else {
			return request.getRemoteAddr();
		}
	}

}
