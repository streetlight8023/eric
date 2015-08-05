package com.yr.service.implement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yr.domain.weixin.Article;
import com.yr.domain.weixin.ImageMessage;
import com.yr.domain.weixin.NewsMessage;
import com.yr.domain.weixin.TextMessage;
import com.yr.domain.weixin.VoiceMessage;
import com.yr.service.WeiXinService;
import com.yr.utils.DataConfig;
import com.yr.utils.HttpClientConnectionManager;
import com.yr.utils.MessageUtil;

/**
 * 微信交互接口实现类
 * 
 * @author: zhangyw
 * @since: March 6, 2015 3:28:31 PM
 * @history:
 ************************************************ 
 * @file: WeiXinServiceImp.java
 * @Copyright: 2015 yr Electronics Co.,Ltd. All right reserved.
 *********************************************** 
 */
public class WeiXinServiceImp implements WeiXinService {

	/**
	 * 创建微信菜单
	 * 
	 * @description
	 * @param params
	 *            用传入的内容列入 json 格式：
	 *            "{\"button\":[{\"name\":\"休闲娱乐\",\"sub_button\":[{\"type\":\"click\",\"name\":\"笑话大全\",\"key\":\"m_joke\"},{\"type\":\"click\",\"name\":\"内涵段子\",\"key\":\"m_duanzi\"},{\"type\":\"click\",\"name\":\"爆笑图片\",\"key\":\"m_laughImg\"}]},{\"name\":\"实用工具\",\"sub_button\":[{\"type\":\"click\",\"name\":\"天气查询\",\"key\":\"m_weather\"},{\"type\":\"click\",\"name\":\"公交查询\",\"key\":\"m_bus\"},{\"type\":\"click\",\"name\":\"功能菜单\",\"key\":\"m_sysmenu\"}]},{\"name\":\"消息示例\",\"sub_button\":[{\"type\":\"click\",\"name\":\"关于企特\",\"key\":\"m_about\"},{\"type\":\"click\",\"name\":\"图文消息\",\"key\":\"m_imgmsg\"},{\"type\":\"click\",\"name\":\"音乐消息\",\"key\":\"m_musicmsg\"}]}]}"
	 *            ;
	 * @param accessToken
	 * @return
	 * @throws Exception
	 * @create march 14, 2015 10:09:26 AM zhangyw
	 * @history
	 */
	public String createMenu() throws Exception {

		StringBuilder sb = new StringBuilder();
		sb.append("{\"button\":[{");
		sb.append("{");
		sb.append(" \"type\":\"click\",");
		sb.append(" name:\"易润\",");
		sb.append(" key:\"亲，测试测试测试！\"");
		sb.append("},");

		sb.append("{");
		sb.append(" \"type\":\"view\",");
		sb.append(" name:\"菜单一\",");
		sb.append(" url:\"http://www.baidu.com/\"");
		sb.append("},");

		sb.append("{");
		sb.append(" \"type\":\"click\",");
		sb.append(" name:\"菜单二\",");
		sb.append(" key:\"" + DataConfig.RESP_MESSAGE_TYPE_FIRST + "\"");
		sb.append("}");

		sb.append("}]");
		DefaultHttpClient httpclient = new DefaultHttpClient();
		httpclient = (DefaultHttpClient) HttpClientConnectionManager
				.getSSLInstance(httpclient); // 接受任何证书的浏览器客户端

		HttpPost httpost = HttpClientConnectionManager
				.getPostMethod("https://api.weixin.qq.com/cgi-bin/menu/create?access_token="
						+ DataConfig.ACCESS_TOKEN);
		httpost.setEntity(new StringEntity(sb.toString(), "UTF-8"));
		HttpResponse response = httpclient.execute(httpost);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		System.out.println(jsonStr);
		JSONObject object = JSON.parseObject(jsonStr);
		return object.getString("errmsg");
	}

	/**
	 * 获取微信accessToken
	 * 
	 * @description
	 * @param appid
	 * @param secret
	 * @return
	 * @throws Exception
	 * @create march 14, 2015 10:09:26 AM zhangyw
	 * @history
	 */
	public String getAccessToken() throws Exception {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		httpclient = (DefaultHttpClient) HttpClientConnectionManager
				.getSSLInstance(httpclient); // 接受任何证书的浏览器客户端
		HttpGet get = HttpClientConnectionManager
				.getGetMethod("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
						+ DataConfig.AppID + "&secret=" + DataConfig.AppSecret);
		HttpResponse response = httpclient.execute(get);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");

		System.out.println(jsonStr);

		String accessToken = JSON.parseObject(jsonStr)
				.getString("access_token");

		System.out.println(accessToken);

		return accessToken;
	}

	/**
	 * 查询微信菜单
	 * 
	 * @description
	 * @param accessToken
	 * @return
	 * @throws Exception
	 * @create march 14, 2015 10:09:26 AM zhangyw
	 * @history
	 */
	public String getMenuInfo(String accessToken) throws Exception {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		httpclient = (DefaultHttpClient) HttpClientConnectionManager
				.getSSLInstance(httpclient); // 接受任何证书的浏览器客户端
		HttpGet get = HttpClientConnectionManager
				.getGetMethod("https://api.weixin.qq.com/cgi-bin/menu/get?access_token="
						+ accessToken);
		HttpResponse response = httpclient.execute(get);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		return jsonStr;
	}

	/**
	 * 删除自定义微信菜单
	 * 
	 * @description
	 * @param accessToken
	 * @return
	 * @create march 14, 2015 10:09:26 AM zhangyw
	 * @history
	 */
	public String getAccessToken(String accessToken) throws Exception {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		httpclient = (DefaultHttpClient) HttpClientConnectionManager
				.getSSLInstance(httpclient); // 接受任何证书的浏览器客户端
		HttpGet get = HttpClientConnectionManager
				.getGetMethod("https://api.weixin.qq.com/cgi-bin/menu/delete?access_token="
						+ accessToken);
		HttpResponse response = httpclient.execute(get);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject object = JSON.parseObject(jsonStr);
		return object.getString("errmsg");
	}

	@SuppressWarnings("all")
	public synchronized String processRequest(HttpServletRequest request,Map<String, String> requestMap) throws Exception {

		String respMessage = null;

		String respContent = "请求处理异常，请稍候尝试！";
		String msgType = requestMap.get("MsgType");// 消息类型
		String toUserName = requestMap.get("ToUserName");// 公众账号
		String fromUserName = requestMap.get("FromUserName");
		String eventType = requestMap.get("Event");
		String content = requestMap.get("Content");

		//1 今日评论 2，今日 要问，3易润
		if (msgType.equals(DataConfig.RESP_MESSAGE_TYPE_TEXT)) {
			if (content != null && content != "") {
				TextMessage textMessage = this.getTextMessage(fromUserName,toUserName);
				if (content.equals("1")) {
					textMessage.setContent("<a href='"+ DataConfig.DOM_URL+"/analyst/'>分析师说</a>");
				} else if (content.equals("2")) {
					textMessage.setContent("<a href='"+ DataConfig.DOM_URL+"/hangqing/'>行情走势</a>");
				} else if (content.equals("3")) {
					textMessage.setContent("<a href='"+ DataConfig.DOM_URL+"/kehu/'>开户</a>");
				} else if (content.equals("4")) {
					textMessage.setContent("<a href='"+ DataConfig.DOM_URL+"/kaihu/xinxi/'>客服中心</a>");
				} else if (content.equals("5")) {
					textMessage.setContent("<a href='"+ DataConfig.DOM_URL+"/kaihu/xinxi/'>实盘开户</a>");
				} else if (content.equals("6")) {
					textMessage.setContent("<a href='"+ DataConfig.DOM_URL+"/kehu/product/'>产品介绍</a>");
				} else if (content.equals("7")) {
					textMessage.setContent("<a href='"+ DataConfig.DOM_URL+"/kehu/liuyan/'>常见问题</a>");
				} else if (content.equals("8")) {
					textMessage.setContent("<a href='"+ DataConfig.DOM_URL+"/kehu/honour/'>易润荣誉</a>");
				}
				
				respMessage = MessageUtil.textMessageToXml(textMessage);
				return respMessage;
			}
			// 如果关注
		} else if (msgType.equals(DataConfig.RESP_MESSAGE_TYPE_EVENT)) {
				respContent = DataConfig.WEIXIN_GUANZHU;
				TextMessage textMessage = this.getTextMessage(fromUserName,toUserName);
		
				if (eventType.equals(DataConfig.EVENT_TYPE_SUBSCRIBE)) {
					textMessage.setContent(DataConfig.WEIXIN_GUANZHU);
					respMessage = MessageUtil.textMessageToXml(textMessage);
				}
			return respMessage;
		} else {
			// 消息头部分
			NewsMessage baseNewsMsg = this.getBaseNewsMsg(fromUserName,toUserName);
			// 消息体
			String autoArticalReply = this.autoArticalReply(baseNewsMsg, "2");

			return autoArticalReply;
		}
		return null;
	}

	/**
	 * 文本消息头
	 * 
	 * @param fromUserName
	 * @param toUserName
	 * @return
	 */
	public TextMessage getBaseTextMsg(String fromUserName, String toUserName) {
		TextMessage textMessage = new TextMessage();
		textMessage.setToUserName(fromUserName);
		textMessage.setFromUserName(toUserName);
		textMessage.setCreateTime(new Date().getTime());
		// textMessage.setMsgType(DataConfig.RESP_MESSAGE_TYPE_TEXT);
		// textMessage.setFuncFlag(0);
		return textMessage;
	}

	/**
	 * 图文信息
	 * 
	 * @param fromUserName
	 * @param toUserName
	 * @return
	 */
	public NewsMessage getBaseNewsMsg(String fromUserName, String toUserName) {
		NewsMessage newsMessage = new NewsMessage();
		// 注意toUserName和formUsername要反着写
		newsMessage.setToUserName(fromUserName);
		newsMessage.setFromUserName(toUserName);
		newsMessage.setCreateTime(new Date().getTime());
		// newsMessage.setFuncFlag(0);
		newsMessage.setMsgType(DataConfig.RESP_MESSAGE_TYPE_NEWS);
		return newsMessage;
	}

	public String autoArticalReply(NewsMessage newsMessage, String num) {
		// 单图文
		if (num.equals("1")) {
			List<Article> articleList = new ArrayList<Article>();
			Article article = new Article();
			article.setTitle("易润 微信 标题");
			article.setDescription("内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容");
			article.setPicUrl("http://www.yr202.com/resources/images/qrcode_258x258.jpg");
			article.setUrl("http://blog.csdn.net/lyq8479");
			articleList.add(article);
			// 图文消息个数
			newsMessage.setArticleCount(articleList.size());
			// 图文消息包含的图文集合
			newsMessage.setArticles(articleList);
			String newsMessageToXml = MessageUtil.newsMessageToXml(newsMessage);
		}
		// 多图文
		if (num.equals("2")) {
			List<Article> articleList = new ArrayList<Article>();
			Article article = new Article();
			article.setTitle("易润 微信 标题");
			article.setDescription("内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容");
			article.setPicUrl("http://www.yr202.com/resources/images/qrcode_258x258.jpg");
			article.setUrl("http://blog.csdn.net/lyq8479");

			Article article1 = new Article();
			article1.setTitle("易润 微信 标题");
			article1.setDescription("内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容");
			article1.setPicUrl("http://www.yr202.com/resources/images/qrcode_258x258.jpg");
			article1.setUrl("http://blog.csdn.net/lyq8479");

			articleList.add(article);
			articleList.add(article1);
			// 图文消息个数
			newsMessage.setArticleCount(articleList.size());
			// 图文消息包含的图文集合
			newsMessage.setArticles(articleList);
		}
		String newsMessageToXml = MessageUtil.newsMessageToXml(newsMessage);

		return newsMessageToXml;
	}

	/**
	 * 文本消息内容
	 * 
	 * @param num
	 * @return
	 */
	public static String autoTextReply(String num) {
		if (num.equals("1")) {
		}

		return null;
	}

	public static String processRequest(HttpServletRequest request) {
		String respMessage = null;
		try {
			// 默认返回的文本消息内容
			String respContent = "请求处理异常，请稍候尝试！";

			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);

			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");

			// 回复文本消息
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			// textMessage.setMsgType(DataConfig.RESP_MESSAGE_TYPE_TEXT);
			// textMessage.setFuncFlag(0);

			// 文本消息
			if (msgType.equals(DataConfig.RESP_MESSAGE_TYPE_TEXT)) {
				respContent = "您发送的是文本消息！";
			}
			// 图片消息
			else if (msgType.equals(DataConfig.RESP_MESSAGE_TYPE_IMAGE)) {
				respContent = "您发送的是图片消息！";
			}
			// 地理位置消息
			else if (msgType.equals(DataConfig.RESP_MESSAGE_TYPE_LOCATION)) {
				respContent = "您发送的是地理位置消息！";
			}
			// 链接消息
			else if (msgType.equals(DataConfig.RESP_MESSAGE_TYPE_LOCATION)) {
				respContent = "您发送的是链接消息！";
			}
			// 音频消息
			else if (msgType.equals(DataConfig.RESP_MESSAGE_TYPE_VOICE)) {
				respContent = "您发送的是音频消息！";
			}
			// 事件推送
			else if (msgType.equals(DataConfig.RESP_MESSAGE_TYPE_EVENT)) {
				// 事件类型
				String eventType = requestMap.get("Event");
				// 订阅
				if (eventType.equals(DataConfig.EVENT_TYPE_SUBSCRIBE)) {
					respContent = "谢谢您的关注！";
				}
				// 取消订阅
				else if (eventType.equals(DataConfig.EVENT_TYPE_UNSUBSCRIBE)) {
					// TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
				}
				// 自定义菜单点击事件
				else if (eventType.equals(DataConfig.RESP_MESSAGE_TYPE_CLICK)) {
					// TODO 自定义菜单权没有开放，暂不处理该类消息
				}
			}

			textMessage.setContent(respContent);
			respMessage = MessageUtil.textMessageToXml(textMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return respMessage;
	}

	/**
	 * 设置声音发送者/接收者消息
	 * 
	 * @param requestMap
	 * @return
	 * @throws Exception
	 * @create 2015-3-30 下午02:37:28 zhangyw
	 * @history
	 */
	public VoiceMessage getVoiceMessage(Map<String, String> requestMap)
			throws Exception {
		// 发送方帐号（open_id）
		String fromUserName = requestMap.get("FromUserName");
		// 公众帐号
		String toUserName = requestMap.get("ToUserName");
		VoiceMessage voiceMessage = new VoiceMessage();
		voiceMessage.setToUserName(fromUserName);
		voiceMessage.setFromUserName(toUserName);
		voiceMessage.setCreateTime(new Date().getTime());
		voiceMessage.setMsgType(DataConfig.RESP_MESSAGE_TYPE_VOICE);
		voiceMessage.setFuncFlag(0);
		voiceMessage.setMediaId(requestMap.get("media_id"));
		voiceMessage.setMsgType(requestMap.get("Format"));

		return voiceMessage;
	}

	/**
	 * 设置发送者/接收者消息
	 * 
	 * @description
	 * @param request
	 * @return
	 * @throws Exception
	 * @create Jul 2, 2014 3:53:33 PM zhangyw
	 * @history
	 */

	public TextMessage getTextMessage(String fromUserName, String toUserName)
			throws Exception {
		// 发送方帐号（open_id）
		// String fromUserName = requestMap.get("FromUserName");
		// // 公众帐号
		// String toUserName = requestMap.get("ToUserName");
		TextMessage textMessage = new TextMessage();
		textMessage.setToUserName(fromUserName);
		textMessage.setFromUserName(toUserName);
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(DataConfig.RESP_MESSAGE_TYPE_TEXT);
		// textMessage.setFuncFlag(0);
		return textMessage;
	}

	/**
	 * 设置发送者/接收者消息
	 * 
	 * @description
	 * @param request
	 * @return
	 * @throws Exception
	 * @create Jul 2, 2014 3:53:33 PM zhangyw
	 * @history
	 */

	public ImageMessage getImgMessage(Map<String, String> requestMap)
			throws Exception {
		// 发送方帐号（open_id）
		String fromUserName = requestMap.get("FromUserName");
		// 公众帐号
		String toUserName = requestMap.get("ToUserName");
		ImageMessage textMessage = new ImageMessage();
		textMessage.setToUserName(toUserName);
		textMessage.setFromUserName(fromUserName);
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(DataConfig.RESP_MESSAGE_TYPE_IMAGE);
		textMessage.setPicUrl(requestMap.get("PicUrl"));
		textMessage.setFuncFlag(0);
		return textMessage;
	}

	public String chatWeiXin(HttpServletRequest request,
			HttpServletResponse response, String signature, String timestamp,
			String nonce, String echostr) throws Exception {
		// 1. 将token、timestamp、nonce三个参数进行字典序排序
		String token = "yr202_wx_hangz_werttyhhjkmnbnvbc";
		String[] str = { token, timestamp, nonce };
		for (int i = 0; i < str.length - 1; i++) {
			for (int j = i + 1; j < str.length; j++) {
				if (str[i].compareTo(str[j]) > 0) {// 字符串比较用compareTo方法
					String temp = str[i];
					str[i] = str[j];
					str[j] = temp;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (String str1 : str) {
			sb.append(str1);
		}
		return sb.toString();
	}

}
