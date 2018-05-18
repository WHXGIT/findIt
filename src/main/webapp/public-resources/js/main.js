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
	if (text == '修改') {
		$('input').attr("readonly", false);
		$('#myCenterUSId').text('保存');
	}
	if (text == '保存') {
		$('input').attr("readonly", true);
		$('#myCenterUSId').text('修改');
		save();
	}

	function save() {
		var nickname = $("#myCenterNickname").val();
		var age = $("#myCenterAge").val();
		var sex = $("#myCenterSex").val();
		var phone = $("#myCenterPhone").val();
		var otherConnect = $("#myCenterOtherConnect").val();
		var data = {
			'nickname': nickname, 'age': age, 'sex': sex, 'phone': phone,
			'otherConnect': otherConnect
		};
		$.ajax({
			data: JSON.stringify(data),
			dataType: "json",
			type: "post",
			contentType: "application/json",
			url: "/user/updatePerInfo",
			success: function () {

			},
			error: function () {

			}
		});
	}
}


// 点击查询
function clickSearchCred() {
	searchCred(9, 1);
}

//全局变量 pagination
var pagination;

//查询证件信息
function searchCred(pageCount, currentPage) {
	var credNo = $("#searchCredNo").val();
	var credName = $("#searchCredName").val();
	var credHoldName = $("#searchCredHoldName").val();
	var data = [{'credNo': credNo, 'credName': credName, 'credHoldName': credHoldName}];
	var dataPage = {'pageCount': pageCount, 'currentPage': currentPage, 'data': data};
	$.ajax({
		data: JSON.stringify(dataPage),
		dataType: "json",
		type: "post",
		contentType: "application/json",
		url: "/credential/search",
		success: function (data) {
			pagination = data.pagination;
			sessionStorage.setItem("pagination", pagination);
			init(pagination);
			initTable(pagination);
		},
		error: function () {

		}
	});
}


function initTable(pagination) {
	var data = pagination.data;
	var showHtml = '';

	for(var i=0; i<data.length; i++){
		showHtml+="<div class=\"col-md-3 col-md-offset-1 search-card\">\n" +
			"            <div class=\"search-card-title\">\n" +
			"                <span>\n" +
			"                    证件信息\n" +
			"                </span>\n" +
			"                <hr class='search-card-hr'/>\n" +
			"            </div>\n" +
			"            <div class=\"search-card-content\">\n" +
			"                <span>持有人：</span><span id=\"searchResultHoldName\">"+ data[i].credHoldName +"</span><br/>\n" +
			"\t            <span>证件名：</span><span id=\"searchResultName\">"+ data[i].credName +"</span>\n" +
			"            </div>\n" +
			"            <button class=\"search-card-operate\" onclick='searchCredComment("+ JSON.stringify(data[i].credId) +");' id="+data[i].credId+">评论</button>\n" +
			"            <button class=\"search-card-operate\" onclick='searchCredDetail("+ JSON.stringify(data[i]) +");' id="+data[i].credId+">详情</button>\n" +
			"\t\t</div>";
	}
	$('#showList').html(showHtml);
}

//分页
function init(pagination) {
	// pagination = sessionStorage.getItem("pagination");
	kkpager.generPageHtml({
		pno: pagination.currentPage,
		mode: 'click', //设置为click模式
		//总页码
		total: pagination.totalPage,
		//总数据条数
		totalRecords: pagination.totalCount,
		//点击页码、页码输入框跳转、以及首页、下一页等按钮都会调用click
		//适用于不刷新页面，比如ajax
		click: function (n) {
			searchCred(9, n);
			//这里可以做自已的处理
			//...
			//处理完后可以手动条用selectPage进行页码选中切换
			this.selectPage(n);
		},
		//getHref是在click模式下链接算法，一般不需要配置，默认代码如下
		getHref: function (n) {
			return '#';
		}

	})
}

//展示证件详细信息
function searchCredDetail(credentail){
	$('#search-background').css("display","block");
	$('.search-detail').css("display","block");
	$('#s-d-name').text("证件名：" + credentail.credName);
	$('#s-d-no').text("证件编号：" + credentail.credNo);
	$('#s-d-hold-name').text("持有人姓名：" + credentail.credHoldName);
	$('#s-d-address').text("持有人地址：" + credentail.address);
}

function ensure() {
	$('.search-detail').css("display","none");
	$('.search-background').css("display","none");
}
//评论
function searchCredComment(id) {
	alert(id);
}

//查询信件信息
function searchLetter(pageCount, currentPage) {
	var credNo = $("#searchCredNo").val();
	var credName = $("#searchCredName").val();
	var credHoldName = $("#searchCredHoldName").val();
	var data = [{'credNo': credNo, 'credName': credName, 'credHoldName': credHoldName}];
	var dataPage = {'pageCount': pageCount, 'currentPage': currentPage, 'data': data};
	$.ajax({
		data: JSON.stringify(dataPage),
		dataType: "json",
		type: "post",
		contentType: "application/json",
		url: "/credential/search",
		success: function (data) {
			pagination = data.pagination;
			sessionStorage.setItem("pagination", pagination);
			init(pagination);
			initTable(pagination);
		},
		error: function () {

		}
	});
}