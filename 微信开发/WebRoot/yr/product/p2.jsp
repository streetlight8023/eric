<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page language="java" import="com.yr.utils.DataConfig,java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title></title>
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
<meta name="Keywords" content=""/>
<meta name="Description" content="" />
<%@ include file="/commons/meta.jsp" %>

<link type="text/css" href="<%=ctx%>/resources/css/form.css" rel="stylesheet" />
<link type="text/css" href="<%=ctx%>/resources/css/swiper.css" rel="stylesheet" />
</head>
<body>
	<%@ include file="/commons/head.jsp" %>
	<div class="wrapper">
		<div class="border mt10">
			<div class="swiper-container gallery-thumbs">
				<!-- Add Arrows -->
		        <div class="swiper-button-next swiper-button-white orange-1"></div>
		        <div class="swiper-button-prev swiper-button-white orange-1"></div>
		        <div class="swiper-wrapper" style="border-left: 1px solid #d8d8d8;">
		            <div class="swiper-slide">现货白银</div>
		            <div class="swiper-slide">现货铂金</div>
		            <div class="swiper-slide">现货钯金</div>
		            <div class="swiper-slide">现货铜</div>
		            <div class="swiper-slide">现货镍</div>
		            <div class="swiper-slide">现货铝</div>
		        </div>
		    </div>
			<!-- Swiper -->
		    <div class="swiper-container gallery-top">
		        <div class="swiper-wrapper">
		            <div class="swiper-slide">
		            	<div class="h10"></div>
		            	<div class="wrapper">
		            		<ul>
		            			<li><span class="f16 b mr5">现货白银</span>标准账户为例</li>
		            			<li class="mt10"><b>日均波动：</b><orange>3.53%</orange>－相当于股票<orange>7</orange>个涨停板,<orange>80%</orange>投资者的选择</li>
		            			<li><b>交易单位： 15千克/手　</b></li>
		            			<li><b>日均盈利空间： ≈70.5%（20倍杠杆）</b></li>
		            			<li><b>所属交易所：天津贵金属交易中心</b></li>
		            			<li><b>单笔最大交易限额：50手</b></li>
		            		</ul>
		            		<h1 class="f16 b mt10">产品介绍</h1>
		            		<p>白银，在历史上曾经与黄金一样，作为重要的货币物资，具有储备职能， 也曾作为国际间支付的重要手段。现阶段，白银有许多投资品种，其中现货白银是一种利用资金杠杆原理进行的一种合约式买卖， 以保证金为5-8%的投资品种。80%的投资者选择投资现货白银。</p>
		            		<h1 class="f16 b mt10">交易细则</h1>
		            		<table class="mt10 w100">
		            			<thead>
		            				<tr>
		            					<th class="w30 orange-1 white h32">合约类型</th>
		            					<th class="orange-1 white h32">标准合约</th>
		            				</tr>
		            			</thead>
		            			<tbody>
		            				<tr>
		            					<td class="h32 alignLeft">交易品种</td>
		            					<td>现货白银</td>
		            				</tr>
		            				<tr>
		            					<td class="h32 alignLeft">报价基准</td>
		            					<td>以伦敦现货价格为基础，综合国内价格及人民银行人民币兑美元基准汇率</td>
		            				</tr>
		            				<tr>
		            					<td class="h32 alignLeft">交易单位</td>
		            					<td>15千克／手</td>
		            				</tr>
		            				<tr>
		            					<td class="h32 alignLeft">最小变价单位</td>
		            					<td>1元／千克</td>
		            				</tr>
		            				<tr>
		            					<td class="h32 alignLeft">合约期限</td>
		            					<td>连续交易</td>
		            				</tr>
		            				<tr>
		            					<td class="h32 alignLeft">夏令时交易时间</td>
		            					<td>现货白银、现货钯金、现货铂金周一为早8:00至周二早4:00，周二到周五为早6:00至次日早4:00；现货铜、现货铝、现货镍周一早8:00至周六早2:00 </td>
		            				</tr>
		            			</tbody>
		            		</table>
		            	</div>
		            </div>
		            <div class="swiper-slide">
		            	<div class="h10"></div>
		            	<div class="wrapper">
		            		<ul>
		            			<li><span class="f16 b mr5">现货铂金</span>标准账户为例</li>
		            			<li class="mt10"><b>日均波动：1.95% </b></li>
		            			<li><b>交易单位：1000千克/手</b></li>
		            			<li><b>日均盈利空间：≈38.1%</b></li>
		            			<li><b>所属交易所：天津贵金属交易中心</b></li>
		            			<li><b>单笔最大交易限额：5手</b></li>
		            		</ul>
		            		<h1 class="f16 b mt10">产品介绍</h1>
		            		<p>铂金的稀有性在全球范围内年产量仅为黄金的5%，铂金供应短缺，价格一直被看好，而现货铂金是以特定品质铂金作为交易标的物的现货合约，是以保证金为5-8%的杠杆交易新产品。 </p>
		            		<h1 class="f16 b mt10">交易细则</h1>
		            		<table class="mt10 w100">
		            			<thead>
		            				<tr>
		            					<th class="w30 orange-1 white h32">合约类型</th>
		            					<th class="orange-1 white h32">标准合约</th>
		            				</tr>
		            			</thead>
		            			<tbody>
		            				<tr>
		            					<td class="h32 alignLeft">交易品种</td>
		            					<td>现货铂金</td>
		            				</tr>
		            				<tr>
		            					<td class="h32 alignLeft">报价基准</td>
		            					<td>以伦敦现货价格为基础，综合国内价格及人民银行人民币兑美元基准汇率</td>
		            				</tr>
		            				<tr>
		            					<td class="h32 alignLeft">交易单位</td>
		            					<td>1千克／手</td>
		            				</tr>
		            				<tr>
		            					<td class="h32 alignLeft">最小变价单位</td>
		            					<td>0.01元／克</td>
		            				</tr>
		            				<tr>
		            					<td class="h32 alignLeft">合约期限</td>
		            					<td>连续交易</td>
		            				</tr>
		            				<tr>
		            					<td class="h32 alignLeft">夏令时交易时间</td>
		            					<td>现货白银、现货钯金、现货铂金周一为早8:00至周二早4:00，周二到周五为早6:00至次日早4:00；现货铜、现货铝、现货镍周一早8:00至周六早2:00 </td>
		            				</tr>
		            			</tbody>
		            		</table>
		            	</div>
		            </div>
		            <div class="swiper-slide">
		            	<div class="h10"></div>
		            	<div class="wrapper">
		            		<ul>
		            			<li><span class="f16 b mr5">现货钯金</span>标准账户为例</li>
		            			<li class="mt10"><b>日均波动：1.71%  最大收益率（20倍杠杆）约为 60.7%</b></li>
		            			<li><b>交易单位：1000克/手</b></li>
		            			<li><b>日均盈利空间：≈34.2%</b></li>
		            			<li><b>所属交易所：天津贵金属交易中心</b></li>
		            			<li><b>单笔最大交易限额：5手</b></li>
		            		</ul>
		            		<h1 class="f16 b mt10">产品介绍</h1>
		            		<p>钯金是世界上最稀有的贵金属之一，每年总产量不到黄金的8%。投资钯金的成本较低，适合中小投资者，而现货钯金是以特定品质钯金作为交易标的物的现货合约，是以保证金为5-8%的杠杆交易新产品。</p>
		            		<h1 class="f16 b mt10">交易细则</h1>
		            		<table class="mt10 w100">
		            			<thead>
		            				<tr>
		            					<th class="w30 orange-1 white h32">合约类型</th>
		            					<th class="orange-1 white h32">标准合约</th>
		            				</tr>
		            			</thead>
		            			<tbody>
		            				<tr>
		            					<td class="h32 alignLeft">交易品种</td>
		            					<td>交易品种</td>
		            				</tr>
		            				<tr>
		            					<td class="h32 alignLeft">报价基准</td>
		            					<td>以伦敦现货价格为基础，综合国内价格及人民银行人民币兑美元基准汇率</td>
		            				</tr>
		            				<tr>
		            					<td class="h32 alignLeft">交易单位</td>
		            					<td>1千克／手</td>
		            				</tr>
		            				<tr>
		            					<td class="h32 alignLeft">最小变价单位</td>
		            					<td>0.01元／克</td>
		            				</tr>
		            				<tr>
		            					<td class="h32 alignLeft">合约期限</td>
		            					<td>连续交易</td>
		            				</tr>
		            				<tr>
		            					<td class="h32 alignLeft">夏令时交易时间</td>
		            					<td>现货白银、现货钯金、现货铂金周一为早8:00至周二早4:00，周二到周五为早6:00至次日早4:00；现货铜、现货铝、现货镍周一早8:00至周六早2:00 </td>
		            				</tr>
		            			</tbody>
		            		</table>
		            	</div>
		            </div>
		            <div class="swiper-slide">
		            	<div class="h10"></div>
		            	<div class="wrapper">
		            		<ul>
		            			<li><span class="f16 b mr5">现货铜</span>标准账户为例</li>
		            			<li class="mt10"><b>日均波动：1.63% ，最大收益率（20倍杠杆）约为71.7%</b></li>
		            			<li><b>交易单位：5吨/手</b></li>
		            			<li><b>日均盈利空间：≈31.9%</b></li>
		            			<li><b>所属交易所：天津贵金属交易中心</b></li>
		            			<li><b>单笔最大交易限额：5手</b></li>
		            		</ul>
		            		<h1 class="f16 b mt10">产品介绍</h1>
		            		<p>铜作为重要工业原料之一，被广泛应用于社会生产、生活的各个领域。可贵的物理和化学属性，使得铜在全球工业中占有举足轻重的地位。 现货铜是以特定品质铜作为交易标的物的现货合约，是以保证金为5-8%的杠杆交易产品</p>
		            		<h1 class="f16 b mt10">交易细则</h1>
		            		<table class="mt10 w100">
		            			<thead>
		            				<tr>
		            					<th class="w30 orange-1 white h32">合约类型</th>
		            					<th class="orange-1 white h32">标准合约</th>
		            				</tr>
		            			</thead>
		            			<tbody>
		            				<tr>
		            					<td class="h32 alignLeft">交易品种</td>
		            					<td>现货铜</td>
		            				</tr>
		            				<tr>
		            					<td class="h32 alignLeft">报价基准</td>
		            					<td>以伦敦现货价格为基础，综合国内价格及人民银行人民币兑美元基准汇率</td>
		            				</tr>
		            				<tr>
		            					<td class="h32 alignLeft">交易单位</td>
		            					<td>5吨／手</td>
		            				</tr>
		            				<tr>
		            					<td class="h32 alignLeft">最小变价单位</td>
		            					<td>1元／吨</td>
		            				</tr>
		            				<tr>
		            					<td class="h32 alignLeft">合约期限</td>
		            					<td>连续交易</td>
		            				</tr>
		            				<tr>
		            					<td class="h32 alignLeft">夏令时交易时间</td>
		            					<td>现货白银、现货钯金、现货铂金周一为早8:00至周二早4:00，周二到周五为早6:00至次日早4:00；现货铜、现货铝、现货镍周一早8:00至周六早2:00 </td>
		            				</tr>
		            			</tbody>
		            		</table>
		            	</div>
		            </div>
		            <div class="swiper-slide">
		            	<div class="h10"></div>
		            	<div class="wrapper">
		            		<ul>
		            			<li><span class="f16 b mr5">现货镍</span>标准账户为例</li>
		            			<li class="mt10"><b>日均波动：2.57% ，最大收益率（12.5 倍杠杆）约为53.3%</b></li>
		            			<li><b>交易单位：1000千克/手</b></li>
		            			<li><b>日均盈利空间：≈31.2%</b></li>
		            			<li><b>所属交易所：天津贵金属交易中心</b></li>
		            			<li><b>单笔最大交易限额：6手</b></li>
		            		</ul>
		            		<h1 class="f16 b mt10">产品介绍</h1>
		            		<p>镍是化学元素之一，化学符号为Ni，原子序数为28，属过渡金属。近似银白色、硬而有延展性并具有铁磁性的金属元素， 在现实社会中用途广泛。镍近似银白色、硬而有延展性并具有铁磁性的金属元素。现货镍是以镍作为交易标的物，是以保证金为8%的杠杆交易产品。</p>
		            		<h1 class="f16 b mt10">交易细则</h1>
		            		<table class="mt10 w100">
		            			<thead>
		            				<tr>
		            					<th class="w30 orange-1 white h32">合约类型</th>
		            					<th class="orange-1 white h32">标准合约</th>
		            				</tr>
		            			</thead>
		            			<tbody>
		            				<tr>
		            					<td class="h32 alignLeft">交易品种</td>
		            					<td>现货镍</td>
		            				</tr>
		            				<tr>
		            					<td class="h32 alignLeft">报价基准</td>
		            					<td>以伦敦现货价格为基础，综合国内价格及人民银行人民币兑美元基准汇率</td>
		            				</tr>
		            				<tr>
		            					<td class="h32 alignLeft">交易单位</td>
		            					<td>1000千克／手</td>
		            				</tr>
		            				<tr>
		            					<td class="h32 alignLeft">最小变价单位</td>
		            					<td>0.01元／千克</td>
		            				</tr>
		            				<tr>
		            					<td class="h32 alignLeft">合约期限</td>
		            					<td>连续交易</td>
		            				</tr>
		            				<tr>
		            					<td class="h32 alignLeft">夏令时交易时间</td>
		            					<td>现货白银、现货钯金、现货铂金周一为早8:00至周二早4:00，周二到周五为早6:00至次日早4:00；现货铜、现货铝、现货镍周一早8:00至周六早2:00</td>
		            				</tr>
		            			</tbody>
		            		</table>
		            	</div>
		            </div>
		            <div class="swiper-slide">
		            	<div class="h10"></div>
		            	<div class="wrapper">
		            		<ul>
		            			<li><span class="f16 b mr5">现货铝</span>标准账户为例</li>
		            			<li class="mt10"><b>日均波动：1.48% ，最大收益率（20倍杠杆）约为55.9%</b></li>
		            			<li><b>交易单位：5吨/手</b></li>
		            			<li><b>日均盈利空间：≈29.5%</b></li>
		            			<li><b>所属交易所：天津贵金属交易中心</b></li>
		            			<li><b>单笔最大交易限额：20手</b></li>
		            		</ul>
		            		<h1 class="f16 b mt10">产品介绍</h1>
		            		<p>铝是银白色轻金属，有延展性，是世界上最为广泛应用的金属之一。现货铝于2014年5月19日上市交易，是以铝为标的物，以保证金为8%的杠杆交易产品。</p>
		            		<h1 class="f16 b mt10">交易细则</h1>
		            		<table class="mt10 w100">
		            			<thead>
		            				<tr>
		            					<th class="w30 orange-1 white h32">合约类型</th>
		            					<th class="orange-1 white h32">标准合约</th>
		            				</tr>
		            			</thead>
		            			<tbody>
		            				<tr>
		            					<td class="h32 alignLeft">交易品种</td>
		            					<td>现货铝</td>
		            				</tr>
		            				<tr>
		            					<td class="h32 alignLeft">报价基准</td>
		            					<td>以伦敦现货价格为基础，综合国内价格及人民银行人民币兑美元基准汇率</td>
		            				</tr>
		            				<tr>
		            					<td class="h32 alignLeft">交易单位</td>
		            					<td>5吨／手</td>
		            				</tr>
		            				<tr>
		            					<td class="h32 alignLeft">最小变价单位</td>
		            					<td>1元／吨</td>
		            				</tr>
		            				<tr>
		            					<td class="h32 alignLeft">合约期限</td>
		            					<td>连续交易</td>
		            				</tr>
		            				<tr>
		            					<td class="h32 alignLeft">夏令时交易时间</td>
		            					<td>现货白银、现货钯金、现货铂金周一为早8:00至周二早4:00，周二到周五为早6:00至次日早4:00；现货铜、现货铝、现货镍周一早8:00至周六早2:00</td>
		            				</tr>
		            			</tbody>
		            		</table>
		            	</div>
		            </div>
		        </div>
		    </div>
		
		    <!-- Swiper JS -->
		    <script type="text/javascript" src="<%=ctx%>/resources/js/swiper.jquery.js"></script>
		
		    <!-- Initialize Swiper -->
		    <script>
		    var galleryTop = new Swiper('.gallery-top', {
		        
		    });
		    var galleryThumbs = new Swiper('.gallery-thumbs', {
		    	nextButton: '.swiper-button-next',
		        prevButton: '.swiper-button-prev',
		        centeredSlides: true,
		        slidesPerView: 'auto',
		        touchRatio: 0.2,
		        slideToClickedSlide: true
		    });
		    galleryTop.params.control = galleryThumbs;
		    galleryThumbs.params.control = galleryTop;
		    
		    </script>
</div>
</div>
</body>
</html>

 		