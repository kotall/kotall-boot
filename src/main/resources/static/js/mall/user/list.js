/**
 * 用户表js
 */

$(function () {
	initialPage();
	getGrid();
});

function initialPage() {
	$(window).resize(function() {
		$('#dataGrid').bootstrapTable('resetView', {height: $(window).height()-54});
	});
}

function getGrid() {
	$('#dataGrid').bootstrapTableEx({
		url: '../../litemall/user/list?_' + $.now(),
		height: $(window).height()-54,
		queryParams: function(params){
			params.name = vm.keyword;
			return params;
		},
		columns: [
			{checkbox: true},
			{field : "username", title : "用户名称", width : "100px"}, 
			{field : "gender", title : "性别", width : "100px"},
			{field : "birthday", title : "生日", width : "100px"}, 
			{field : "userLevel", title : "用户等级", width : "100px"},
			{field : "nickname", title : "用户昵称或网络名称", width : "100px"}, 
			{field : "status", title : "用户状态", width : "100px"},
			{field : "addTime", title : "创建时间", width : "120px"}
		]
	})
}

var vm = new Vue({
	el:'#dpLTE',
	data: {
		keyword: null
	},
	methods : {
		load: function() {
			$('#dataGrid').bootstrapTable('refresh');
		},
		save: function() {
			dialogOpen({
				title: '新增用户表',
				url: 'mall/user/add.html?_' + $.now(),
				width: '500px',
				height: '500px',
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit: function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections');
			if(checkedRow(ck)){
				dialogOpen({
					title: '编辑用户表',
					url: 'mall/user/edit.html?_' + $.now(),
					width: '500px',
					height: '500px',
					success: function(iframeId){
						top.frames[iframeId].vm.liteMallUser.id = ck[0].id;
						top.frames[iframeId].vm.setForm();
					},
					yes: function(iframeId){
						top.frames[iframeId].vm.acceptClick();
					}
				});
			}
		},
		remove: function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections'), ids = [];	
			if(checkedArray(ck)){
				$.each(ck, function(idx, item){
					ids[idx] = item.id;
				});
				$.RemoveForm({
					url: '../../litemall/user/remove?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});
			}
		}
	}
})