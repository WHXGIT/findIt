/**
 * description: 用于Letter的显示
 * params:
 * author:Andy
 */

//查询信件信息
function searchGetLetter(pageCount, currentPage) {
	var dataPage = {'pageCount': pageCount, 'currentPage': currentPage};
	$.ajax({
		data: JSON.stringify(dataPage),
		dataType: "json",
		type: "post",
		contentType: "application/json",
		url: "/letter/getSearch",
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

function clickSelfGetLetter() {
	window.location.href = "/getLetter";
}



//查询信件信息
function searchSendLetter(pageCount, currentPage) {
	var data = "";
	var dataPage = {'pageCount': pageCount, 'currentPage': currentPage};
	$.ajax({
		data: JSON.stringify(dataPage),
		dataType: "json",
		type: "post",
		contentType: "application/json",
		url: "/letter/sendSearch",
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

function clickSelfSentLetter() {
	window.location.href = "/sendLetter";
}