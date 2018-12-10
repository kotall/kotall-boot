/**
 * app配置表js
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
		url: '../../litemall/app/list?_' + $.now(),
		height: $(window).height()-54,
		queryParams: function(params){
			params.name = vm.keyword;
			return params;
		},
		columns: [
			{checkbox: true},
			{field : "sid", title : "sid", width : "100px"},
			{field : "storeId", title : "店铺ID", width : "100px"}, 
			{field : "version", title : "版本", width : "100px"}, 
			{field : "tradeType", title : "微信支付类型", width : "100px"},
			{field : "appId", title : "微信小程序appId", width : "100px"},
			{field : "subAppId", title : "微信小程序子appId", width : "100px"},
			{field : "mchId", title : "微信商户号", width : "100px"},
			{field : "subMchId", title : "微信子商户号", width : "100px"},
			{field : "mchKey", title : "微信商户秘钥", width : "100px"},
			{field : "signType", title : "微信签名类型", width : "100px"},
			{field : "keyPath", title : "微信证书路径", width : "100px"},
			{field : "notifyUrl", title : "微信支付结果通知地址", width : "100px"},
			{field : "createdTime", title : "创建时间", width : "100px"}
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
				title: '新增app配置表',
				url: 'mall/app/add.html?_' + $.now(),
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
					title: '编辑app配置表',
					url: 'mall/app/edit.html?_' + $.now(),
					width: '420px',
					height: '350px',
					success: function(iframeId){
						top.frames[iframeId].vm.liteMallApp.id = ck[0].id;
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
					url: '../../litemall/app/remove?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});
			}
		}
	}
})