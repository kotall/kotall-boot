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
			{field : "password", title : "用户密码", width : "100px"}, 
			{field : "gender", title : "性别：0 未知， 1男， 1 女", width : "100px"}, 
			{field : "birthday", title : "生日", width : "100px"}, 
			{field : "lastLoginTime", title : "最近一次登录时间", width : "100px"}, 
			{field : "lastLoginIp", title : "最近一次登录IP地址", width : "100px"}, 
			{field : "userLevel", title : "0 普通用户，1 VIP用户，2 高级VIP用户", width : "100px"}, 
			{field : "nickname", title : "用户昵称或网络名称", width : "100px"}, 
			{field : "mobile", title : "用户手机号码", width : "100px"}, 
			{field : "avatar", title : "用户头像图片", width : "100px"}, 
			{field : "weixinOpenid", title : "微信登录openid", width : "100px"}, 
			{field : "status", title : "0 可用, 1 禁用, 2 注销", width : "100px"}, 
			{field : "addTime", title : "创建时间", width : "100px"}, 
			{field : "updateTime", title : "更新时间", width : "100px"}, 
			{field : "deleted", title : "逻辑删除", width : "100px"}
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
				width: '420px',
				height: '350px',
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
					width: '420px',
					height: '350px',
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