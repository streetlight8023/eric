
 $(document).ready(function(){
	$(".registerform").Validform({
		tiptype:function(msg,o,cssctl){
			if(!o.obj.is("form")){
				var objtip=o.obj.parents(".yzm").find(".Validform_checktip");
				cssctl(objtip,o.type);
				objtip.text(msg);
				
				var infoObj=o.obj.parents(".yzm").find(".info");
				if(o.type==2){
					infoObj.fadeOut(200);
				}else{
					if(infoObj.is(":visible")){return;}
					var top= 0;

					infoObj.css({
						right: -7,
						top:-35
					}).show().animate({
						top:-28	
					},200);
				}
				
			}	
		},
		usePlugin:{
			passwordstrength:{
				minLen:6,
				maxLen:18,
				trigger:function(obj,error){
					if(error){
						obj.parents("td").next().find(".passwordStrength").hide();
					}else{
						obj.parents("td").next().find(".info").hide();
						obj.parents("td").next().find(".passwordStrength").show();	
					}
				}
			}
		},
		postonce:true,
		datatype:{
			"need1":function(gets,obj,curform,regxp){
				var need=1,
					numselected=curform.find("input[name='"+obj.attr("name")+"']:checked").length;
				return  numselected >= need ? true : "没有同意xxx";
			},
			"tel":function(gets,obj,curform,regxp){
				reg = /^0{0,1}(13[0-9]|14[0-9]|15[0-9]|17[0-9]|18[0-9]|19[0-9])[0-9]{8}$/;
				return reg.test(obj.val());
			},
			"name":function(gets,obj,curform,regxp){
				if(obj.val().length>20){
					return false;
				}else{
				reg=/^[\u4e00-\u9fa5]+[.．·]{0,1}[\u4e00-\u9fa5]+$/; 
				return reg.test(obj.val());}
			},
			"yhm":function(gets,obj,curform,regxp){
				var atleast=6,
					atmax=18;
				var getAnsiLength = function(b,ansi) {
					
					if (!(typeof b == 'string') || !ansi) {
						return b.length;
					}
					var a=b.match(/[^\x00-\x80]/g);
					return b.length+(a?a.length:0);
				};
				var reg = /^[a-zA-Z][a-zA-Z0-9_]*$/;
				var len=getAnsiLength(gets,true);
				if(len<atleast){
					return "用户名不能少于"+atleast+"个字符";
				}else if(len>atmax){
					return "用户名不能超过"+atmax+"个字符";
				}else{
					return reg.test(obj.val());
				}
				return true;
			},
			 "isNull":function(gets,obj,curform,regxp){
				return true;
		   	},
			"bank":function(gets,obj,curform,regxp){
				var reg = /^[0-9]{16,19}$/;
				var a = obj.val().replace(/[ ]/g,""); 
				return reg.test(a);
				},
			"code":function(gets,obj,curform,regxp){
				var reg = /^[0-9]{6}$/;
				return reg.test(obj.val());
			},
			"*6-16":function(gets,obj,curform,regxp){
				var atleast=6,
					atmax=16;
				var getAnsiLength = function(b,ansi) {
					if (!(typeof b == 'string') || !ansi) {
						return b.length;
					}
					var a=b.match(/[^\x00-\x80]/g);
					return b.length+(a?a.length:0);
				};
				
 				var len=getAnsiLength(gets,true);
				if(len<atleast){
					return "密码不能少于"+atleast+"位";
				}else if(len>atmax){
					return "密码不能超过"+atmax+"位";
				}
				return true;
			},
			"nn":function(gets,obj,curform,regxp){
				var reg =  /^\s*[\u4e00-\u9fa5]{2,15}\s*$/;  
				
				return reg.test(obj.val());
			},
			"email":function(gets,obj,curform,regxp){
			   reg=/^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
			   
				   return reg.test(obj.val());
		   }, 
			"idcard":function(gets,obj,curform,datatype){
				var Wi = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 ];
				var ValideCode = [ 1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2 ];
			
				if (gets.length == 18){   
					var a_idCard = gets.split("");
					if (isValidityBrithBy18IdCard(gets)&&isTrueValidateCodeBy18IdCard(a_idCard)) {   
						return true;   
					}   
					return false;
				}
				return false;
				
				function isTrueValidateCodeBy18IdCard(a_idCard) {   
					var sum = 0; 
					if (a_idCard[17] == 'X') {   
						a_idCard[17] = 10;
					}   
					for ( var i = 0; i < 17; i++) {   
						sum += Wi[i] * a_idCard[i];
					}   
					valCodePosition = sum % 11;
					if (a_idCard[17] == ValideCode[valCodePosition]) {   
						return true;   
					}
					return false;   
				}
				
				function isValidityBrithBy18IdCard(idCard18){   
					var year = idCard18.substring(6,10);   
					var month = idCard18.substring(10,12);   
					var day = idCard18.substring(12,14);   
					var temp_date = new Date(year,parseFloat(month)-1,parseFloat(day));   
					
					if(temp_date.getFullYear()!=parseFloat(year) || temp_date.getMonth()!=parseFloat(month)-1 || temp_date.getDate()!=parseFloat(day)){   
						return false;   
					}
					return true;   
				}
				
				
			}
		}
	});
});

//获取验证码按钮
$(document).ready(function(){
	var InterValObj; //timer变量，控制时间
	var count = 59; //间隔函数，1秒执行
	var curCount;//当前剩余秒数
	var ROOT= $("#ROOT").val();
	$(".code").attr("disabled",true).addClass("code-gray");
	$(".yrtip").hide();
	$("input[datatype='code']").attr("disabled",true).addClass("code-gray");
	
	$(".code").click(function(){
		curCount = count;
		var _this = $(this)
		$(this).val(curCount + "秒后重新验证");
		//$(this).parent().next().find(".Validform_checktip").text("如果收不到短信请拨4006706202");
		$(this).parent().find(".Validform_checktip").text("如果收不到短信请拨4006706202");
		$(this).siblings(".yrtip").show();
		$(this).attr("disabled",true).addClass("code-gray");
		$(this).siblings("input").attr("disabled",false).removeClass("code-gray");
				
		InterValObj = window.setInterval(function(){
	    	if (curCount == 0) {                
	        	window.clearInterval(InterValObj);//停止计时器
	            _this.removeAttr("disabled").removeClass("code-gray");//启用按钮
	            _this.val("重新发送验证码");
	        }
	        else {
	            curCount--;
	            _this.val(curCount + "秒后重新验证");
	        }
	    }, 1000); //启动计时器，1秒执行一次
		//发送短信
		var mobile= $(this).parents("form").find("input[id=mobile]").val(); 
		$.ajax({
			type: "POST",
			url: ROOT +"/fastOpenAccount_getMessageCode.action",
			data: {mobile: mobile},
			dataType: "text",
			success: function(data){
            	if(data!=null)
                	$(".code").parent().next().find(".Validform_checktip").html(data).addClass("Validform_wrong");
			}
		});
	})
});

//自定义下拉菜单
$('[name="nice-select"]').click(function(e){
    $('[name="nice-select"]').find('ul').hide();
    $(this).find('ul').show();
	e.stopPropagation();
});
$('[name="nice-select"] li').click(function(e){
	var val = $(this).text();
	var index = $(this).index();
	var tagname = $(this).parents('[name="nice-select"]').find('.nice-select-input');
	if(tagname.is('input')){
		tagname.val(val)
	}else{
		tagname.html(val);
		$(".sp3_txt .sp3_txt_div").hide().eq(index).show();
	}
	$('[name="nice-select"] ul').hide();
	e.stopPropagation();
});
$(document).click(function(){
	$('[name="nice-select"] ul').hide();
});