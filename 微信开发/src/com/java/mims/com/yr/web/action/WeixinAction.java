package com.yr.web.action;

import java.io.PrintWriter;
import java.util.Map;

import com.yr.service.WeiXinService;
import com.yr.utils.BaseAction;
import com.yr.utils.MessageUtil;
import com.yr.utils.SHA1Util;

/**
 * @author: zhangyw
 * @since: 2014-5-28 下午3:52:48
 * @history:
 ************************************************ 
 * @file: WeixinAction.java
 * @Copyright: 2014 All right reserved.
 ************************************************/

public class WeixinAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6946012276365264695L;
	private WeiXinService weiXinService;

	public void setWeiXinService(WeiXinService weiXinService) {
		this.weiXinService = weiXinService;
	}

	public void weiXinInfoProxy() throws Exception {

		String echostr = this.getRequest().getParameter("echostr");

		Map<String, String> parseXml = MessageUtil.parseXml(this.getRequest());
		String processRequest = weiXinService.processRequest(this.getRequest(),parseXml);

		 PrintWriter out = this.getResponse().getWriter();
		this.getResponse().setContentType("text/html");
		this.getResponse().setCharacterEncoding("UTF-8");
		out.write(processRequest);
		 System.out.println(echostr);

		out.flush();
		out.close();

	}

	@SuppressWarnings("all")
	public String getXML() {
		// 图文
		String bb = "<xml><ToUserName><![CDATA[ot31Lt10ZOe-fUtPKLWy41vKTxwU]]></ToUserName><FromUserName><![CDATA[gh_f1a57356fdde]]></FromUserName><CreateTime>1428049342024</CreateTime><MsgType><![CDATA[news]]></MsgType><ArticleCount>2</ArticleCount><Articles><item><Title><![CDATA[易润 微信 标题]]></Title> <Description><![CDATA[内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容]]></Description><PicUrl><![CDATA[http://www.yr202.com/resources/images/qrcode_258x258.jpg]]></PicUrl><Url><![CDATA[http://blog.csdn.net/lyq8479]]></Url></item>";
		String dd = " <xml><ToUserName><![CDATA[ot31Lt10ZOe-fUtPKLWy41vKTxwU]]></ToUserName><FromUserName><![CDATA[gh_f1a57356fdde]]></FromUserName><CreateTime>1428049342024</CreateTime><MsgType><![CDATA[news]]></MsgType><ArticleCount>2</ArticleCount><Articles><item><Title><![CDATA[易润 微信 标题]]></Title> <Description><![CDATA[内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容]]></Description><PicUrl><![CDATA[http://www.yr202.com/resources/images/qrcode_258x258.jpg]]></PicUrl><Url><![CDATA[http://blog.csdn.net/lyq8479]]></Url></item><item><Title><![CDATA[微信 标题副标题]]></Title><Description><![CDATA[内容内容内容内容内容内容内容内容内容内容内容内容内容2222222222]]></Description><PicUrl><![CDATA[http://www.yr202.com/resources/images/qrcode_258x258.jpg]]></PicUrl><Url><![CDATA[http://blog.csdn.net/lyq8479]]></Url></item></Articles></xml> ";
		String ff = "<xml><ToUserName><![CDATA[ot31Lt10ZOe-fUtPKLWy41vKTxwU]]></ToUserName><FromUserName><![CDATA[gh_f1a57356fdde]]></FromUserName><CreateTime>1428049342024</CreateTime><MsgType><![CDATA[news]]></MsgType><ArticleCount>2</ArticleCount><Articles><item><Title><![CDATA[易润 微信 标题]]></Title><Description><![CDATA[内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容]]></Description><PicUrl><![CDATA[http://www.yr202.com/resources/images/qrcode_258x258.jpg]]></PicUrl> <Url><![CDATA[http://blog.csdn.net/lyq8479]]></Url></item><item> <Title><![CDATA[易润 微信 标题]]></Title><Description><![CDATA[内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容]]></Description> <PicUrl><![CDATA[http://www.yr202.com/resources/images/qrcode_258x258.jpg]]></PicUrl> <Url><![CDATA[http://blog.csdn.net/lyq8479]]></Url></item></Articles></xml>";
		String hh = " <xml><ToUserName><![CDATA[ot31Lt10ZOe-fUtPKLWy41vKTxwU]]></ToUserName><FromUserName><![CDATA[gh_f1a57356fdde]]></FromUserName><CreateTime><![CDATA[1429692382715]]></CreateTime><MsgType><![CDATA[text]]></MsgType><MsgId><![CDATA[0]]></MsgId><FuncFlag><![CDATA[0]]></FuncFlag><Content><![CDATA[您好！我是易润贵金属小编，感谢您的关注！mo-微笑我们会在每周一至周五的上午十点准时发布最新投资资讯，欢迎阅读。您也可以直接在对话框中发送以下内容：发送数字1，获取今日【易润评论】；发送数字2，获取今日【国际要闻】；发送数字3，参加【财经易学堂】，获取贵金属投资学习资料。更多应用指南，请直接发送“0”！了解更多投资资讯，请点击右上角的“小人”mo-拥抱按钮，查看历史消息。如果您有投资需求或困惑，欢迎拨打易润24小时客服热线：400-6706-202]]></Content></xml>";
		String cc = " <xml><ToUserName><![CDATA[ot31Lt10ZOe-fUtPKLWy41vKTxwU]]></ToUserName><FromUserName><![CDATA[gh_f1a57356fdde]]></FromUserName><CreateTime>1428049342024</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[你好]]></Content></xml>";
		String ee = " <xml><ToUserName><![CDATA[gh_f1a57356fdde]]></ToUserName> <FromUserName><![CDATA[ot31Lt10ZOe-fUtPKLWy41vKTxwU]]></FromUserName><CreateTime><![CDATA[1429690020141]]></CreateTime> <MsgId><![CDATA[0]]></MsgId> <FuncFlag><![CDATA[0]]></FuncFlag> <ArticleCount><![CDATA[2]]></ArticleCount><Articles><item><Title><![CDATA[易润 微信 标题]]></Title>  <Description><![CDATA[内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容]]></Description> <PicUrl><![CDATA[http://www.yr202.com/resources/images/qrcode_258x258.jpg]]></PicUrl> <Url><![CDATA[http://blog.csdn.net/lyq8479]]></Url></item> <item><Title><![CDATA[易润 微信 标题]]></Title> <Description><![CDATA[内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容]]></Description><PicUrl><![CDATA[http://www.yr202.com/resources/images/qrcode_258x258.jpg]]></PicUrl><Url><![CDATA[http://blog.csdn.net/lyq8479]]></Url></item></Articles></xml>";
		String gg = "<xml> <ToUserName><![CDATA[ot31Lt10ZOe-fUtPKLWy41vKTxwU]]></ToUserName> <FromUserName><![CDATA[gh_f1a57356fdde]]></FromUserName> <CreateTime><![CDATA[1429691543296]]></CreateTime> <MsgType><![CDATA[text]]></MsgType><MsgId><![CDATA[0]]></MsgId><FuncFlag><![CDATA[0]]></FuncFlag><Content><![CDATA[您好！我是易润贵金属小编，感谢您的关注！mo-微笑我们会在每周一至周五的上午十点准时发布最新投资资讯，欢迎阅读。您也可以直接在对话框中发送以下内容：发送数字1，获取今日【易润评论】；发送数字2，获取今日【国际要闻】；发送数字3，参加【财经易学堂】，获取贵金属投资学习资料。更多应用指南，请直接发送“0”！了解更多投资资讯，请点击右上角的“小人”mo-拥抱按钮，查看历史消息。如果您有投资需求或困惑，欢迎拨打易润24小时客服热线：400-6706-202]]></Content></xml>";
		return hh;
	}

}
