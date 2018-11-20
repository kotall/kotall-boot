/**
 * 购物车商品表js
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
		url: '../../litemall/litemall/list?_' + $.now(),
		height: $(window).height()-54,
		queryParams: function(params){
			params.name = vm.keyword;
			return params;
		},
		columns: [
			{checkbox: true},
			{field : "storeId", title : "店铺ID", width : "100px"}, 
			{field : "userId", title : "用户表的用户ID", width : "100px"}, 
			{field : "goodsId", title : "商品表的商品ID", width : "100px"}, 
			{field : "goodsSn", title : "商品编号", width : "100px"}, 
			{field : "goodsName", title : "商品名称", width : "100px"}, 
			{field : "productId", title : "商品货品表的货品ID", width : "100px"}, 
			{field : "price", title : "商品货品的价格", width : "100px"}, 
			{field : "number", title : "商品货品的数量", width : "100px"}, 
			{field : "specifications", title : "商品规格值列表，采用JSON数组格式", width : "100px"}, 
			{field : "checked", title : "购物车中商品是否选择状态", width : "100px"}, 
			{field : "picUrl", title : "商品图片或者商品货品图片", width : "100px"}, 
			{field : "addTime", title : "创建时间", width : "100px"}
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
				title: '新增购物车商品表',
				url: 'mall/litemall/add.html?_' + $.now(),
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
					title: '编辑购物车商品表',
					url: 'mall/litemall/edit.html?_' + $.now(),
					width: '420px',
					height: '350px',
					success: function(iframeId){
						top.frames[iframeId].vm.liteMallCart.id = ck[0].id;
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
					url: '../../litemall/litemall/remove?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});
			}
		}
	}
})