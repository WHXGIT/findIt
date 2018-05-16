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
		var nickname = $("#myCenterNickname").val();
		var age = $("#myCenterAge").val();
		var sex = $("#myCenterSex").val();
		var phone = $("#myCenterPhone").val();
		var otherConnect = $("#myCenterOtherConnect").val();
		var data = {'nickname': nickname, 'age':age, 'sex':sex, 'phone':phone,
			'otherConnect':otherConnect};
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


//查询证件信息
function searchCred(){

}
$(function page(){
	//生成分页控件
	kkpager.generPageHtml({
		pno : '${p.pageNo}',
		mode : 'link', //可选，默认就是link
		//总页码
		total : '${p.totalPage}',
		//总数据条数
		totalRecords : '${p.totalCount}',
		//链接前部
		hrefFormer : '${hrefFormer}',
		//链接尾部
		hrefLatter : '${hrefLatter}',
		//链接算法
		getLink : function(n){
			//这里是默认算法，算法适用于比如：
			//hrefFormer=http://www.xx.com/news/
			//hrefLatter=.html
			//那么首页（第1页）就是http://www.xx.com/news/20131212.html
			//第2页就是http://www.xx.com/news/20131212_2.html
			//第n页就是http://www.xx.com/news/20131212_n.html
			if(n == 1){
				return this.hrefFormer + this.hrefLatter;
			}
			return this.hrefFormer + '_' + n + this.hrefLatter;
		}
	});
});