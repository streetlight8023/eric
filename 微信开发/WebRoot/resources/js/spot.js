/**
 * index.jsp 行情数据表格 实时数据
 */
jQuery(function() {
	
	var ROOT = $("#ROOT").val();
	getSpot();  
	
	$("#column_nav a").click(function(){
		var num = $(this).index();
		$("#column_nav a").removeClass("curr");
		$(this).addClass("curr");
		$("#zoushiBox .zoushi").hide();
		$("#zoushiBox .zoushi").eq(num).show();
		spot_z();
	})
	
/*	setInterval(function(){
                
	},1000*50000000);*/
	
			getSpot();  


 	function getSpot() {
 		var userSessionUrl = ROOT+ "/spot/spot_getSpots.action";
	 	$.ajax({
			type : "POST",
			url : ROOT + "/spot/spot_getSpots.action",
			dataType : "json",
			success : function(data) {
				//注意spots顺序可能不一致
				spots = data.result;
				for (var n = 0; n < spots.length; n++) {
					if(spots[n].spotName == 'Ag'){
						adNum(n,0);
					}else if(spots[n].spotName == 'Pt'){
						adNum(n,1);
					}else if(spots[n].spotName == 'Pd'){
						adNum(n,2);
					}else if(spots[n].spotName == 'Ni'){
						adNum(n,3);
					}else if(spots[n].spotName == 'Cu'){
						adNum(n,4);			
					}else if(spots[n].spotName == 'Al'){
						adNum(n,5);
					}
				}
			}
		});
 	}
 	//生成各类产品的对应数据
 	function adNum(n,x){
 		var y = parseFloat(spots[n].riseFall);
		var f2 =  Math.round(y*100)/100;
		
		var i = parseFloat(spots[n].riseFallRange);
		var i2 = getFloatStr(i*100);
		$("#data tbody tr").eq(x).find("td").each(function(){
			var index = $(this).index();
			if(index == 1){
				$(this).html(spots[n].realTimePrice);
			}else if(index == 2){
				if(y >= 0){
					$(this).html("<span style='color:red'>+" + f2 + "</span>");
				}else if(y < 0){
					$(this).html("<span style='color:green'>" + f2 + "</span>");
				}
			}else if(index == 3){
				if(i >= 0){
					$(this).html("<span style='color:red'>+" + i2 + "%</span>");
				}else if(i < 0){
					$(this).html("<span style='color:green'>-" + i2 + "%</span>");
				}
			}
		})
 	}
 	
	
	//保留小数点后两位,整数自动加上.00
	var getFloatStr = function(num){  
        num += '';  
        num = num.replace(/[^0-9|\.]/g, ''); //清除字符串中的非数字非.字符  
          
        if(/^0+/) //清除字符串开头的0  
            num = num.replace(/^0+/, '');  
        if(!/\./.test(num)) //为整数字符串在末尾添加.00  
            num += '.00';  
        if(/^\./.test(num)) //字符以.开头时,在开头添加0  
            num = '0' + num;  
        num += '00';        //在字符串末尾补零  
        num = num.match(/\d+\.\d{2}/)[0];  
        return num;
    };
});

