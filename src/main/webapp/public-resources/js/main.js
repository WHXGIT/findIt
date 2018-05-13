/**
 * description: main
 * author: whx
 */

/**
* decirption: 个人中心用户信息修改
* params：
* author: Andy
*/

function update() {
	var text = $('#myCenterUSId').text();
	if(text == '修改'){
		$('input').attr("readonly",false);
		$('#myCenterUSId').text('保存');
	}
	if(text == '保存'){
		$('input').attr("readonly",true);
		$('#myCenterUSId').text('修改');
		save();
	}
	function save() {

		var data = {'nickname':'andyWong'};
		$.ajax({
			data: JSON.stringify(data),
			dataType:"json",
			type:"post",
			contentType:"application/json",
			url: "/user/updatePerInfo",
			success: function () {
				
			},
			error:function () {

			}
		});
	}
}


/** 生成验证码
 * @param {Number} min 范围最小值
 * @param {Number} max 范围最大值
 * @param {String} charStr指定的字符串中生成组合
 * @returns {String} 返回字符串结果
 * */
function randomRange(min, max, charStr){
	var returnStr = "", //返回的字符串
		range; //生成的字符串长度

	//随机生成字符
	var autoGetStr = function(){
		var charFun = function(){
			var n= Math.floor(Math.random()*62);
			if(n<10){
				return n; //1-10
			}
			else if(n<36){
				return String.fromCharCode(n+55); //A-Z
			}
			else{
				return String.fromCharCode(n+61); //a-z
			}
		}
		while(returnStr.length< range){
			returnStr += charFun();
		}
	};

	//根据指定的字符串中生成组合
	var accordCharStrGet = function(){
		for(var i=0; i<range; i++){
			var index = Math.round(Math.random() * (charStr.length-1));
			returnStr += charStr.substring(index,index+1);
		}
	};
	if(typeof min == 'undefined'){
		min = 10;
	}
	if(typeof max == 'string'){
		charStr = max;
	}
	range = ((max && typeof max == 'number') ? Math.round(Math.random() * (max-min)) + min : min);

	if(charStr){
		accordCharStrGet();
	}else{
		autoGetStr();
	}
	return returnStr;
}