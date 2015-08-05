package com.yr.utils;

import com.hs.core.dao.support.Page;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;


import com.hs.core.dao.support.Page;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public class CommonPage
{
  public static void setPage(Page page, String goUrl, Map<String, Object> queryParameter, HttpServletRequest request)
  {
    int h = goUrl.indexOf("html");

    if (h > 0) {
      goUrl = goUrl.substring(0, goUrl.length() - 9);
    }
    StringBuilder sb = new StringBuilder();
    int currentPage = new Integer((String)queryParameter.get("currentPage")).intValue();
    int countPage = page.getTotalPageCount();
    if ((currentPage <= countPage) && (currentPage > 0)) {
      sb.append("<p class='fr f14'>");
      if (currentPage != 1) {
        sb.append("<a  href='" + goUrl + "-" + (currentPage - 1) + "-" + queryParameter.get("limit") + ".html'>上一页</a>&nbsp;");
        sb.append("<a href='" + goUrl + "-1-" + queryParameter.get("limit") + ".html'>1</a>");
        if (currentPage - 1 > 4) {
          sb.append("...");
          sb.append("<a href='" + goUrl + "-" + (currentPage - 3) + "-" + queryParameter.get("limit") + ".html'>" + (currentPage - 3) + "</a>");
          sb.append("<a href='" + goUrl + "-" + (currentPage - 2) + "-" + queryParameter.get("limit") + ".html'>" + (currentPage - 2) + "</a>");
          sb.append("<a href='" + goUrl + "-" + (currentPage - 1) + "-" + queryParameter.get("limit") + ".html'>" + (currentPage - 1) + "</a>");
        } else {
          if (currentPage > 2)
            sb.append("<a href='" + goUrl + "-2-" + queryParameter.get("limit") + ".html'>2</a>");
          if (currentPage > 3)
            sb.append("<a href='" + goUrl + "-3-" + queryParameter.get("limit") + ".html'>3</a>");
          if (currentPage > 4)
            sb.append("<a href='" + goUrl + "-4-" + queryParameter.get("limit") + ".html'>4</a>");
        }
        if (currentPage < countPage)
          sb.append("<a class='curr' herf='###'>" + currentPage + "</a>");
        if (countPage - currentPage > 4) {
          sb.append("<a href='" + goUrl + "-" + (currentPage + 1) + "-" + queryParameter.get("limit") + ".html'>" + (currentPage + 1) + "</a>");
          sb.append("<a href='" + goUrl + "-" + (currentPage + 2) + "-" + queryParameter.get("limit") + ".html'>" + (currentPage + 2) + "</a>");
          sb.append("<a href='" + goUrl + "-" + (currentPage + 3) + "-" + queryParameter.get("limit") + ".html'>" + (currentPage + 3) + "</a>");
          sb.append("...");
        } else {
          if (countPage - currentPage >= 2)
            sb.append("<a href='" + goUrl + "-" + (currentPage + 1) + "-" + queryParameter.get("limit") + ".html'>" + (currentPage + 1) + "</a>");
          if (countPage - currentPage >= 3)
            sb.append("<a href='" + goUrl + "-" + (currentPage + 2) + "-" + queryParameter.get("limit") + ".html'>" + (currentPage + 2) + "</a>");
          if (countPage - currentPage >= 4)
            sb.append("<a href='" + goUrl + "-" + (currentPage + 3) + "-" + queryParameter.get("limit") + ".html'>" + (currentPage + 3) + "</a>");
        }
        if (countPage == currentPage)
          sb.append("<a class='curr' herf'###'>" + currentPage + "</a>");
        else
          sb.append("<a href='" + goUrl + "-" + countPage + "-" + queryParameter.get("limit") + ".html'>" + countPage + "</a>");
        if (currentPage < countPage)
          sb.append("<a  class='page_next' href='" + goUrl + "-" + (currentPage + 1) + "-" + queryParameter.get("limit") + ".html'>下一页</a>");
        else
          sb.append("<a  class='page_next' herf='###'>下一页</a>");
      }
      else {
        sb.append("<a class='page_prev' herf='###'>上一页</a>");
        sb.append("<a class='curr' herf='###'>1</a>");

        if (countPage - currentPage > 4) {
          sb.append("<a href='" + goUrl + "-" + (currentPage + 1) + "-" + queryParameter.get("limit") + ".html'>" + (currentPage + 1) + "</a>");
          sb.append("<a href='" + goUrl + "-" + (currentPage + 2) + "-" + queryParameter.get("limit") + ".html'>" + (currentPage + 2) + "</a>");
          sb.append("<a href='" + goUrl + "-" + (currentPage + 3) + "-" + queryParameter.get("limit") + ".html'>" + (currentPage + 3) + "</a>");
          sb.append("...");
          sb.append("<a href='" + goUrl + "-" + countPage + "-" + queryParameter.get("limit") + ".html'>" + countPage + "</a>");
        } else {
          if (countPage >= 2)
            sb.append("<a href='" + goUrl + "-" + (currentPage + 1) + "-" + queryParameter.get("limit") + ".html'>" + (currentPage + 1) + "</a>");
          if (countPage >= 3)
            sb.append("<a href='" + goUrl + "-" + (currentPage + 2) + "-" + queryParameter.get("limit") + ".html'>" + (currentPage + 2) + "</a>");
          if (countPage >= 4)
            sb.append("<a href='" + goUrl + "-" + (currentPage + 3) + "-" + queryParameter.get("limit") + ".html'>" + (currentPage + 3) + "</a>");
        }
        if (countPage == 1)
          sb.append("<a class='page_next'  href='###'>下一页</a>");
        else
          sb.append("<a class='page_next'  href='" + goUrl + "-" + (currentPage + 1) + "-" + queryParameter.get("limit") + ".html'>下一页</a>");
      }
//      sb.append("<span><b class='color_f60'>" + currentPage + "</b>/" + countPage + "页</span>");
      sb.append("</p>");
    }
    else {
      sb.append("<p class='fr f14'>");
      sb.append("<a class='page_prev' href='###'>上一页</a>&nbsp;");
      sb.append("<a class='curr' herf='###'>1</a>");
      sb.append("<a  class='page_next' herf='###'>下一页</a>");
//      sb.append("<span><b class='color_f60'>0</b>/0页</span>");
      sb.append("</p>");
    }
    request.setAttribute("pageDiv", sb.toString());
  }
}