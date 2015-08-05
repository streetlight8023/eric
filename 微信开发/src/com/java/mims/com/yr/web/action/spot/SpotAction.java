package com.yr.web.action.spot;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.hs.mims.domain.spot.Spot;
import com.yr.utils.BaseAction;
import com.yr.utils.DataConfig;

public class SpotAction extends BaseAction {

	private static final long serialVersionUID = -3911946526125944562L;

	
	/**
	 * 实时行情数据
	 */
	public  void getSpots(){
		try {
		Map<String, Object> result = new HashMap<String, Object>();
		String documentStr = parseXml2Str(DataConfig.SPOT_CLOSE_INTEFACE);
		List<Spot> spot =getSpotsFromUrl(documentStr);
		result.put("result", spot);
		printJson(Object2Json(result));
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public   String parseXml2Str(String url)  {
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setRequestProperty("Accept-Encoding", "gzip,deflate");
			InputStream inputStream = connection.getInputStream();
			GZIPInputStream in1 = new GZIPInputStream(inputStream);
			byte[] by = new byte[1024 * 1024];
			StringBuffer strBuffer = new StringBuffer();
			int len = 0;
			while ((len = in1.read(by)) != -1) {
				strBuffer.append(new String(by, 0, len, "gbk"));
			}
			String kLineStr = strBuffer.toString();
			return kLineStr;
			
		} catch (Exception e) {
			
			return null;
		}
		
		
	}
	
	public   List<Spot> getSpotsFromUrl(String documentStr){
	
		List<Spot> spots = new  ArrayList<Spot>();
			try {
				Document document = DocumentHelper.parseText(documentStr);
				Element rootElement = document.getRootElement();
				Element REP = rootElement.element("REP");
				Element RESULTLIST = REP.element("RESULTLIST");
				for (Iterator iter = RESULTLIST.elementIterator(); iter.hasNext();) {
					Element attributeElement = (Element) iter.next();
					Spot spot = new Spot();
					String commodityCode = attributeElement.elementTextTrim("CO_I");
					//收盘价
					String closePrice = attributeElement.elementTextTrim("CLOSE_PRICE");
					//当前价
					String curPrice = attributeElement.elementTextTrim("CUR_PRICE");
					//最高价
					String hight = attributeElement.elementTextTrim("HIGH");
					//最低价
					String low = attributeElement.elementTextTrim("LOW");
					//涨跌百分比
					float riseFallRangeF = (Float.parseFloat(curPrice) - Float.parseFloat(closePrice)) / Float.parseFloat(closePrice);
					String riseFallRange= riseFallRangeF+"";
					/*System.out.println(commodityCode+"is"+riseFallRange);*/
					//涨跌
					float riseFallF =Float.parseFloat(curPrice) - Float.parseFloat(closePrice);
					
					String riseFall= riseFallF+"";
					
					spot.setSpotName(commodityCode);
					spot.setMAXPrice(hight);
					spot.setMIXPrice(low);
					spot.setRealTimePrice(curPrice);
					spot.setRiseFallRange(riseFallRange);
					spot.setRiseFall(riseFall);
					spots.add(spot);
				}
				return spots;
			} catch (Exception e) {
				return null;
			}
		}

}
