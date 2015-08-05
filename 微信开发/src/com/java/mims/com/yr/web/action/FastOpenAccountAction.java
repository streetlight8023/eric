package com.yr.web.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.dolphin.web.support.UserSession;
import com.hs.mims.domain.front.Customer;
import com.hs.mims.domain.front.Member;
import com.hs.mims.service.front.CustomerService;
import com.hs.mims.service.front.MemberService;
import com.hs.mims.utils.ClientWebService;
import com.yr.utils.BaseAction;
import com.yr.utils.DataConfig;
public class FastOpenAccountAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6354428681244145091L;


	public final static String MESSAGECODE="_MESSAGESESSIONCODE";

	
	//短信验证码
	private String randCode;
	private Customer customer;
	private Member member;
	private Integer checkedType;	//验证是否重复类型 1.实盘 2.模拟 	3.预约
	private CustomerService customerService;
	private MemberService memberService;
	Map<String, Object> map= new HashMap<String, Object>();

	/**
	 * 获取手机验证码
	 * @throws Exception 
	 */
	public void getMessageCode() throws Exception{
		String mobile= getRequest().getParameter("mobile");
		randCode= DataConfig.getRandomCode();
		Map<String, String> map= new HashMap<String, String>();
		map.put("mobile", mobile);
		map.put("code", randCode);
		Cookie cookieuser = new Cookie(mobile, randCode);
		cookieuser.setPath("/");
		cookieuser.setMaxAge(600);
		this.getResponse().addCookie(cookieuser);
		System.out.println("手机号码:"+mobile+"\n验证码:"+randCode);
		String result=ClientWebService.sendSms("您的验证码是:"+randCode+"，工作人员不会向您索取，请勿向任何人泄露。",mobile);
		System.out.println("result......................:"+result);
		if(result.equals("32")){
		  this.printText("同一号码相同内容发送次数太多");
		}

	}
	
	/**
	 * 校验验证码是否通过
	 * @param request
	 * @param response
	 * @param mobile
	 * @return
	 */
	private  static boolean checkMobileCodeExit(HttpServletRequest request,
			HttpServletResponse response, String mobile,String code) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie coo : cookies) {
				if (coo.getName().equals(mobile)&&coo.getValue().equals(code)) 
					return true;
			}
		}
		
		return false;
	}
	
	
	/**
	 * 设置广告件
	 * @param c
	 */
	private void setAdvId(Customer c){
		String advId=this.getIpAdvId(this.getRequest(), this.getResponse(),DataConfig.getIpAddr(this.getRequest()));
		if(advId!=null)
			c.setAdvInfoId(Integer.valueOf(advId));
	}
	
	
	/**
	 * 获取手机号验证码校验
	 * @param request
	 * @param response
	 * @param mobile
	 * @return
	 */
	private  String getIpAdvId(HttpServletRequest request,HttpServletResponse response, String ip) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie coo : cookies) {
				if (coo.getName().equals(ip)) 
					return coo.getValue();
			}
		}
		return null;
	}
	
	/**
	 * 验证手机号和验证码是否属于获取验证码的手机号
	 * @param mobile
	 * @param code
	 * @return
	 * @throws IOException 
	 */
	@SuppressWarnings("all")
	public void chckedMobileCode() throws IOException{
		String mobile= getRequest().getParameter("mobile");
		randCode=  getRequest().getParameter("param");
		Map<String,Object>queryParameter=new HashMap<String,Object>();
		if(!this.checkMobileCodeExit(this.getRequest(), this.getResponse(), mobile, randCode)){
			queryParameter.put("info", "验证码错误或已失效!");
			queryParameter.put("status", "n");
		}else{
			queryParameter.put("status", "y");
		}
		printJson(Object2Json(queryParameter));
	}
	
	
	
	/**
	 * 保存开户基本信息 (姓名手机号码) 
	 * 把member放入request中 并对customer状态进行保存
	 * @return
	 * @throws Exception 
	 */
	public String saveAccountBase() throws Exception{
		
		// 用于判断重复提交
		if (UserSession.getInstance(this.getRequest()).getTokinId() == null){
			return "index";
		}
		
		Customer newCustomer =new Customer();
		newCustomer.setSubmitChannel(DataConfig.OPEN_ACCOUNT_TYPE_SHIPAN);
		newCustomer.setFromPage(DataConfig.OPEN_ACCOUNT_FROMPAGE_WEIZHAN);
		Member member=	(Member)getRequest().getSession().getAttribute("session_member");
		
		String memberName=this.getRequest().getParameter("memberName");
		String memberMobile=this.getRequest().getParameter("mobile");
		
		if(checkMobileScript(memberMobile)){
			//为true验证不通过
			return "index";
		}
		
		if(member==null){
			if(this.getRequest().getParameter("kaihu")==null){
				return "onlineOne";
			}
			member=new Member();
		}
		
		member.setMemberName(memberName);
		member.setMobile(memberMobile);
		member.setMemberStatus(Member.MEMBERSTATUS_2);
		member.setIsDelete(Member.ISDELETE_1);
		
		getRequest().setAttribute("memberName",member.getMemberName());
		
		newCustomer.setMobile(memberMobile);
		newCustomer.setCustomerName(member.getMemberName());
		//放入session session过期从第一步提交
		getRequest().getSession().setAttribute("session_member", member);
		
		this.setAdvId(newCustomer);
		
		newCustomer.setIp(DataConfig.getIpAddr(this.getRequest()));
		Integer id= customerService.setCustomerFromWeiZhan(newCustomer, null, member);
		getRequest().setAttribute("id", id);
		return "onlineTwo";
	}
	
	public String toProtocolPage(){
		this.getRequest();
		return "ProtocolPage";
	}
	
	
	
	/**
	 * 在线开户 -- 实盘开户
	 * 银行卡号 身份证号 开户银行
	 * @return
	 * @throws Exception
	 */
	public String saveOpenAccount() throws Exception{

		// 用于判断重复提交
		if (UserSession.getInstance(this.getRequest()).getTokinId() == null){
			return "index";
		}
		//获取session内member的值
		Member member= (Member) getRequest().getSession().getAttribute("session_member");
		customer.setSubmitChannel(DataConfig.OPEN_ACCOUNT_TYPE_SHIPAN);
		customer.setFromPage(DataConfig.OPEN_ACCOUNT_FROMPAGE_WEIZHAN_2);
		
		customer.setSourceChannel(Customer.CHANNEL_1);//来源通道--在线开户
		customer.setSourceChannelName("在线开户");
		customer.setMobile(member.getMobile());
		member.setMemberStatus(Member.MEMBERSTATUS_1);
		customer.setIp(DataConfig.getIpAddr(this.getRequest()));
		
		Map<String, Object> resultMap= customerService.openAccount(customer, member);
		String result=  resultMap.get("result").toString();
		if(!Boolean.valueOf(result)){
			getRequest().setAttribute("result", "fail");
			getRequest().setAttribute("name", customer.getCustomerName());
			getRequest().setAttribute("msg", resultMap.get("msg"));
			getRequest().setAttribute("errorMsg", resultMap.get("errorResult"));
			
		}else{
			getRequest().setAttribute("result", "success");
			Member memberModel= (Member) resultMap.get("member");
			//保存member
			memberService.insert(memberModel);
			getRequest().setAttribute("member", memberModel);
		}
		// 取消重复提交标志
		UserSession.getInstance(this.getRequest()).setTokinId(null);
		
		return "onlineFinish";
	}

	
	/**
	 * 用户名重复检查
	 * @return
	 * @throws IOException 
	 */
	public void checkedUserName() throws IOException{
		member= new Member();
		String userName=getRequest().getParameter("param");
		member.setMemberName(userName);
		member= memberService.getByName(member);
		if(member!=null && !member.getMemberName().equals("")){
			map.put("info", "该用户名已存在!");
			map.put("status", "n");
		}else{
			map.put("status", "y");
		}
		printJson(Object2Json(map));
	}
	
	
	/**
	 * 检查手机号码是否存在
	 * @throws Exception 
	 */
	public void checkedMobileExist() throws Exception{	
		Map<String,Object>queryParameter=new HashMap<String,Object>();
		queryParameter.put("isShipan", Customer.ISSHIPAN_1);
		queryParameter.put("mobile", getRequest().getParameter("param"));
		boolean result= customerService.checkedMobileForOnline(queryParameter);
		if(result){
			map.put("info", "该号已有记录，请拨打4006706202");
			map.put("status", "n");
		}else{
			map.put("status", "y");
		}
		printJson(Object2Json(map));
	}
	
	
	/**
	 * 手机号注册验证
	 * @throws Exception 
	 */
	public void checkedCardExist() throws Exception{
		
		Map<String,Object>queryParameter=new HashMap<String,Object>();
		queryParameter.put("isShipan", Customer.ISMONI_1);
	    queryParameter.put("papersNum", getRequest().getParameter("param"));
		boolean result= customerService.checkedMobileForOnline(queryParameter);
		if(result){
			map.put("info", "该身份证已经注册过!");
			map.put("status", "n");
		}else{
			map.put("status", "y");
		}
		printJson(Object2Json(map));
	}
	
	
	
	
	/**
	 * 检查手机号 验证规则
	 * 返回true则直接跳转404
	 * @param mobile
	 * @return
	 * @throws Exception 
	 */
	public boolean checkMobileScript(String mobile) throws Exception{
		//boolean result= false;
		String regx= "^0{0,1}(13[0-9]|14[0-9]|15[0-9]|17[0-9]|18[0-9]|19[0-9])[0-9]{8}$";
		Pattern regex = Pattern.compile(regx);
		Matcher matcher = regex.matcher(mobile);
		boolean flag = matcher.matches();
		if(mobile==null || mobile.equals("") ||!flag){
			return true; 
		}
		return false;
	}


	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getRandCode() {
		return randCode;
	}
	public void setRandCode(String randCode) {
		this.randCode = randCode;
	}
	
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Integer getCheckedType() {
		return checkedType;
	}
	public void setCheckedType(Integer checkedType) {
		this.checkedType = checkedType;
	}
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
}
