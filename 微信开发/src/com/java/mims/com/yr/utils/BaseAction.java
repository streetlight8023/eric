package com.yr.utils;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class BaseAction extends ActionSupport
{
  private static final long serialVersionUID = 1L;

  public ActionContext getActionContext()
  {
    return ActionContext.getContext();
  }

  public ValueStack getValueStack() {
    return getActionContext().getValueStack();
  }

  protected HttpServletRequest getRequest()
  {
    return (HttpServletRequest)getActionContext().get("com.opensymphony.xwork2.dispatcher.HttpServletRequest");
  }

  protected HttpServletResponse getResponse()
  {
    return (HttpServletResponse)getActionContext().get("com.opensymphony.xwork2.dispatcher.HttpServletResponse");
  }

  protected Map<String, Object> bindMap()
  {
    Map map = new HashMap();
    HttpServletRequest request = getRequest();
    Enumeration enumeration = request.getParameterNames();
    while (enumeration.hasMoreElements()) {
      String name = (String)enumeration.nextElement();
      String value = request.getParameter(name).trim();
      map.put(name, value);
    }
    return map;
  }

  protected void printJson(String text)
    throws IOException
  {
    doPrint(getResponse(), text, "text/x-json;charset=UTF-8");
  }

  protected void printText(String text)
  {
    doPrint(getResponse(), text, "text/plain;charset=UTF-8");
  }

  private void doPrint(HttpServletResponse response, String text, String contentType)
  {
    try
    {
      response.setContentType(contentType);
      response.getWriter().write(text);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  
  /**
	 * @method bean2JsonInCombox
	 * @param List
	 *            里面存放的所有的JAVABEAN 对象
	 * @param id
	 *            (id 为JAVABEAN
	 *            中的某个属性名字（其中该属性的值一般都为唯一的主键值）用于Combox中隐藏的,注：填写的方式就是按JAVABEAN
	 *            中的属性命名规则进行填入,该参数对应于JAVABEAN中的类型必须为（Integer或String)(必须参数）
	 * 
	 * 
	 * 
	 * @param text
	 *            （text 为JAVABEAN 中的某个属性名字，用于Combox中显示的值，注：填写的方式就是按JAVABEAN
	 *            中的属性命名规则进行填入,该参数对应于JAVABEAN中的类型必须为String(必须参数）
	 * 
	 * 
	 * 
	 * @param idType
	 *            （idType 为辨别参数id 的类型，这里一般针对两种类型进行操作包括（Integer和 String )方式(必须参数）
	 * 
	 * @return String
	 * @description :将某个JAVABEAN对象转换成Json字符串
	 * 
	 * 
	 *              用于显示于Combox 中的数据
	 * @author zhangyw 2014-5-23 20:27:10
	 */

	public String bean2JsonInCombox(List resultList, String id, String text,
			String idType) throws Exception {
		Object idValue = null;
		StringBuffer str = new StringBuffer("{\"totalCount\": 1,\"data\":[");
		if (null != resultList && 0 < resultList.size()) {
			for (Iterator iter = resultList.iterator(); iter.hasNext();) {
				Object obj = iter.next();
				if (idType.equalsIgnoreCase("Integer")) {
					idValue = (Integer) obj
							.getClass()
							.getMethod(
									"get" + id.substring(0, 1).toUpperCase()
											+ id.substring(1))
							.invoke(obj, null);
				}
				if (idType.equalsIgnoreCase("String")) {
					idValue = (String) obj
							.getClass()
							.getMethod(
									"get" + id.substring(0, 1).toUpperCase()
											+ id.substring(1))
							.invoke(obj, null);
				}
				String textValue = (String) obj
						.getClass()
						.getMethod(
								"get" + text.substring(0, 1).toUpperCase()
										+ text.substring(1)).invoke(obj, null);
				str.append("{ \"id\" : ");
				str.append("\"" + idValue + "\",");
				str.append(" \"text\" : ");
				str.append(" \"" + textValue + "\"");
				str.append("},");
			}
			str.delete(str.length() - 1, str.length());
		}
		str.append("]}");
		return str.toString();
	}
    public String Object2Json(Object obj){  
        JSONObject json = JSONObject.fromObject(obj);//将java对象转换为json对象  
        String str = json.toString();//将json对象转换为字符串  
          
        return str;  
    }  
}