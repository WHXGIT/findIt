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
		$('#myCenterSex').removeAttr("disabled");
		$('#myCenterUSId').text('保存');
		$('.my-center-input').css('background','white');
	}
	if (text == '保存') {
		$('input').attr("readonly", true);
		$('#myCenterSex').attr("disabled", "disabled");
		$('#myCenterUSId').text('修改');
		$('.my-center-input').css('background','#F0F2F5');
		save();
	}

	function save() {
		var nickname = $("#myCenterNickname").val();
		var age = $("#myCenterAge").val();
		var sex = $("#myCenterSex").val();
		if (sex == 2) {
			sex = "UNKNOWN";
		} else if (sex == 1) {
			sex = "MALE";
		} else {
			sex = "FEMALE";
		}
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
	excuteSearchCred(dataPage);
}

function clickSearchSelfCred(exType, type) {
	window.location.href = "/search/" + exType + "/" + type;
}

function searchSelfCred(pageCount, currentPage, exType, type) {
	var data = [{'credType': type}];
	var dataPage = {'pageCount': pageCount, 'currentPage': currentPage, 'data': data};
	excuteSearchCred(dataPage);
}

function clickSelfCommentCred(exType, type) {
	window.location.href = "/search/" + exType + "/" + type;
}

function searchSelfCommentCred(pageCount, currentPage, exType, type) {
	var data = null;
	var dataPage = {'pageCount': pageCount, 'currentPage': currentPage, 'data': data};
	excuteSearchCommentCred(dataPage);
}

function excuteSearchCommentCred(dataPage) {
	$.ajax({
		data: JSON.stringify(dataPage),
		dataType: "json",
		type: "post",
		contentType: "application/json",
		url: "/credential/searchComment",
		success: function (data) {
			pagination = data.pagination;
			sessionStorage.setItem("pagination", pagination);
			init(pagination, 'cred');
			initTable(pagination);
		},
		error: function () {

		}
	});
}

/**
 * decirption: 执行证件查询
 * params: 需要发送的数据
 * author: Andy
 */
function excuteSearchCred(dataPage) {
	$.ajax({
		data: JSON.stringify(dataPage),
		dataType: "json",
		type: "post",
		contentType: "application/json",
		url: "/credential/search",
		success: function (data) {
			pagination = data.pagination;
			sessionStorage.setItem("pagination", pagination);
			init(pagination, 'cred');
			initTable(pagination);
		},
		error: function () {

		}
	});
}


function initTable(pagination) {
	var data = pagination.data;
	var showHtml = '';

	for (var i = 0; i < data.length; i++) {
		showHtml += "<div class=\"col-md-3 col-md-offset-1 search-card\">\n" +
			"            <div class=\"search-card-title\">\n" +
			"                <span>\n" +
			"                    证件信息\n" +
			"                </span>\n" +
			"                <hr class='search-card-hr'/>\n" +
			"            </div>\n" +
			"            <div class=\"search-card-content\">\n" +
			"                <span>持有人：</span><span id=\"searchResultHoldName\">" + data[i].credHoldName + "</span><br/>\n" +
			"\t            <span>证件名：</span><span id=\"searchResultName\">" + data[i].credName + "</span>\n" +
			"            </div>\n" +
			"            <a class=\"search-card-operate\" href='/comment/credDetail/" + data[i].credId + "' id=" + data[i].credId + ">详情</a>\n" +
			"\t\t</div>";
	}
	$('#showList').html(showHtml);
}

//分页
function init(pagination, type) {
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
			if('cred' == type){
				searchCred(9, n);
			}else if('letter' == type){
				searchLetter(9, n);
			}

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
function searchCredDetail(credentail) {
	window.location.href = "/credDetail";
	searchCredComment(credentail.credId);
}

function addLetter() {
	window.location.href = "/write_letter";
}

//查询信件信息
function searchLetter(pageCount, currentPage) {
	var title = $("#title").val();
	var data = [{'title': title}];
	var dataPage = {'pageCount': pageCount, 'currentPage': currentPage, 'data': data};
	$.ajax({
		data: JSON.stringify(dataPage),
		dataType: "json",
		type: "post",
		contentType: "application/json",
		url: "/letter/search",
		success: function (data) {
			pagination = data.pagination;
			sessionStorage.setItem("pagination", pagination);
			init(pagination, 'letter');
			initLetter(pagination);
		},
		error: function () {

		}
	});
}

function initLetter(pagination) {
	var data = pagination.data;
	var showHtml = '';

	for (var i = 0; i < data.length; i++) {
		var timeHandler = Object.create(TimeHandler);
		showHtml += "<div onclick='letterDetail(" + JSON.stringify(data[i]) + ");' class='letter-content'>\n" +
			"            <div class=\"letter-title\">" + data[i].title + "</div>\n" +
			"            <div class=\"letter-date\">" + timeHandler.formatDateTime(data[i].createTime) + "</div>\n" +
			"        </div>";
	}
	$('#showList').html(showHtml);

}

function letterDetail(data) {
	var timeHandler = Object.create(TimeHandler);
	$("#letter-detail").css("display", "block");
	$("#letter-title").text(data.title);
	$("#letter-get-user").text(data.toName);
	$("#letter-sent-user").text(data.createName);
	$("#letter-sent-time").text(timeHandler.formatDateTime(data.createTime));
	$("#letter-content").html(data.content);
}

function letterDetailHide() {
	$("#letter-detail").css("display", "none");
}


function changeCode() {
	window.location.href = "/captcha-image";
}

/**
 * decirption: 捡到证件填写还是上传图片
 * params：
 * author: Andy
 */

function changeMode(flag) {
	if (flag == 0) {
		$(".main-find").css("display", "none");
		$(".main-identify").css("display", "block");
	}
	if (flag == 1) {
		$(".main-find").css("display", "block");
		$(".main-identify").css("display", "none");
	}

}

/**
 * decirption: 首页加载是默认执行查询
 * params：
 * author: Andy
 */
function onloadInit() {
	$.ajax({
		dataType: "json",
		type: "get",
		contentType: "application/json",
		url: "/index/init",
		success: function (data) {
			var data = data.vo;
			$("#all-cred-no").text(data.allPublishCred + " 件");
			$("#all-user-no").text("用户数量 " + data.allUser + " 人");
			$("#get-cred").text(data.allFindCred + "件");
			$("#unfind-cred").text("未被寻找 " + data.allLeftCred + " 件");
			$("#get-letter").text(data.allLetter + " 封");
			$("#involve-user").text("涉及人数 " + data.allUsedletter + " 人");
			var showHtml = '';

			for (var i = 0; i < data.message.length; i++) {
				var message = JSON.parse(data.message[i]);
				if (message.cred_name == undefined) {
					message.cred_name = "一封感谢信"
				}
				showHtml += "<div>" +
					"<img class='index-activity-img' src='" + message.head_img + "' />" +
					"<span><b>" + message.nickname + "</b></span> 发布了" +
					"<span><b>" + message.cred_name + "</b></span>" +
					"</div>";
			}
			$('#index-activity').html(showHtml);
		},
		error: function () {

		}
	});
}

function initUserCenter() {
	$.ajax({
		dataType: "json",
		type: "get",
		contentType: "application/json",
		url: "/user/userCenter",
		success: function (data) {
			var data = data.vo;
			$("#duringDays").text(data.duringDays + " 天");
			$("#allPublishCred").text(data.allPublishCred + "");
			$("#allFinishCred").text(data.allFinishCred + " ");
			$("#allGetLetter").text(data.allGetLetter + " ");
			$("#allSentLetter").text(data.allSentLetter + " ");
			$("#allCommentCred").text(data.allCommentCred + " ");
			$("#allMocriReward").text(data.allMocriReward + " ");
			$("#head-img").html("<img class='my-center-head-img' src='" + data.userVO.headImg + "'>");

			if (data.userVO.sex == "UNKNOWN") {
				$("#myCenterSex").val(2);
			} else if (data.userVO.sex == "MALE") {
				$("#myCenterSex").val(1);
			} else {
				$("#myCenterSex").val(0);
			}
		},
		error: function () {

		}
	});
}

function chageCode() {
	var time = new Date().getTime();
	$("#kaptchaImage").attr('src', '/captcha-image?id=' + time);
}
