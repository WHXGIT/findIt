$(function() {
	var Accordion = function(el, multiple) {
		this.el = el || {};
		this.multiple = multiple || false;

		// Variables privadas
		var links = this.el.find('.link');
		// Evento
		links.on('click', {el: this.el, multiple: this.multiple}, this.dropdown)
	}

	Accordion.prototype.dropdown = function(e) {
		var $el = e.data.el;
		$this = $(this),
			$next = $this.next();

		$next.slideToggle();
		$this.parent().toggleClass('open');

		if (!e.data.multiple) {
			$el.find('.submenu').not($next).slideUp().parent().removeClass('open');
		};
	};

	var accordion = new Accordion($('#accordion'), false);
});


function clickListUser(pageCount, currentPage){
	var data = {pageCount: pageCount, currentPage: currentPage};
	$.ajax({
		data: JSON.stringify(data),
		type: "post",
		dataType:"json",
		contentType:"application/json",
		url: "/admin/listUser",
		success: function (data) {
			pagination = data.page;
			initListUser(pagination);
		},
		error: function () {

		}
	});
}

function initListUser(page){
	var showHtml = "";
	var tempHtml = "";
	for(var i = 0; i < page.data.length; i++){
		tempHtml +=
			"                <tr>\n" +
			"                 <td>" + (i + 1) +"</td>\n" +
			"                 <td>"+page.data[i].username+"</td>\n" +
			"                 <td>"+page.data[i].nickname+"</td>\n" +
			"                 <td>"+page.data[i].age+"</td>\n" +
			"                 <td>"+SexHandler.formatSex(page.data[i].sex)+"</td>\n" +
			"                 <td>"+TimeHandler.formatDateTime(page.data[i].registerTime)+"</td>\n" +
			"                 <td>"+StateHandler.formatState(page.data[i].state)+"</td>\n" +
			"                 <td><a href='/admin/forbidUser/"+ page.data[i].userId +"'>封号</a></td>\n" +
			"                </tr>\n";
	}

	showHtml = "<table id='table' class='table'>\n" +
		"                <thead>\n" +
		"                    <tr>\n" +
		"                        <td>序号</td>\n" +
		"                     <td>账号</td>\n" +
		"                     <td>昵称</td>\n" +
		"                     <td>年龄</td>\n" +
		"                     <td>性别</td>\n" +
		"                     <td>注册时间</td>\n" +
		"                        <td>账号状态</td>\n" +
		"                        <td>操作</td>\n" +
		"                    </tr>\n" +
		"                </thead>\n" +
		"" +
		"                <tbody>\n" +
		"" + tempHtml+
		"                </tbody>\n" +
		"            </table>";

	$("#list-table").html(showHtml);
	SetTrColor("table");
}

function SetTrColor(tableId) {
	var table = document.getElementById(tableId);//根据table的 id 属性值获得对象
	var rows = table.getElementsByTagName("tr");//获取table类型的tr元素的列表
	for (var i = 0; i < rows.length; i++) {
		if (i % 2 == 0) {
			rows[i].style.backgroundColor = "#ffffff";//偶数行时背景色为#D9F5D4
		}
		else {
			rows[i].style.backgroundColor = "#F0F0F0";//单数行时背景色为white
		}
	}
}


function clickListCred(pageCount, currentPage){

	var data = {pageCount: pageCount, currentPage: currentPage};
	$.ajax({
		data: JSON.stringify(data),
		type: "post",
		dataType:"json",
		contentType:"application/json",
		url: "/admin/listCred",
		success: function (data) {
			pagination = data.page;
			initListCred(pagination);
		},
		error: function () {

		}
	});
}

function initListCred(page){
	var showHtml = "";
	var tempHtml = "";
	for(var i = 0; i < page.data.length; i++){
		tempHtml +=
			"                <tr>\n" +
			"                 <td>" + (i + 1) +"</td>\n" +
			"                 <td>"+page.data[i].credNo+"</td>\n" +
			"                 <td>"+page.data[i].credName+"</td>\n" +
			"                 <td>"+page.data[i].credHoldName+"</td>\n" +
			"                 <td>"+page.data[i].address+"</td>\n" +
			"                 <td><a onclick='credDetail("+JSON.stringify(page.data[i])+")'>详情</a>" +
			"<a href='/admin/pass/"+ page.data[i].credId +"'>通过</a>" +
			"<a href='/admin/forbid/"+ page.data[i].credId +"'>禁止</a></td>\n" +
			"                </tr>\n";
	}

	showHtml = "<table id='table' class='table'>\n" +
		"                <thead>\n" +
		"                    <tr>\n" +
		"                        <td>序号</td>\n" +
		"                     <td>证件编号</td>\n" +
		"                     <td>证件名</td>\n" +
		"                     <td>持有人姓名</td>\n" +
		"                     <td>证件地址</td>\n" +
		"                        <td>操作</td>\n" +
		"                    </tr>\n" +
		"                </thead>\n" +
		"" +
		"                <tbody>\n" +
		"" + tempHtml+
		"                </tbody>\n" +
		"            </table>";

	$("#list-table").html(showHtml);
	SetTrColor("table");
}

function credDetail(credentialDO) {
	var showHtml = "";
	showHtml += "<div class=\"search-detail\">\n" +
		"   <div class=\"search-detail-card\">\n" +
		"    <ul class=\"search-detail-card-content\">\n" +
		"                    <li><label>证件编号:</label> "+credentialDO.credNo +"</li>\n" +
		"     <li><label>证件名:</label> "+credentialDO.credName +"</li>\n" +
		"     <li><label>持有人姓名:</label> "+credentialDO.credHoldName +"</li>\n" +
		"     <li><label>证件含有地址:</label> "+credentialDO.address +"</li>\n" +
		"     <li><label>拾取时间:</label> "+TimeHandler.formatDateTime(credentialDO.pickTime)+"</li>\n" +
		"     <li><label>拾取地点:</label> "+credentialDO.pickAddress +"</li>\n" +
		"     <li><label>丢失时间:</label> "+TimeHandler.formatDateTime(credentialDO.lostTime) +"</li>\n" +
		"     <li><label>丢失地点:</label> "+credentialDO.lostAddress +"</li>\n" +
		"     <li><label>证件照片:</label><img class=\"comment-img\" src=\" "+credentialDO.photoPath +"\"></li>\n" +
		"     <li><label>微报酬:</label> "+credentialDO.microReward +"</li>\n" +
		"     <li><label>描述:</label> "+credentialDO.description +"</li>\n" +
		"    </ul>\n" +
		"   </div>\n" +
		"  </div>";
	$("#list-table").html(showHtml);
}
