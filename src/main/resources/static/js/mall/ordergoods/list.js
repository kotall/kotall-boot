/**
 * 订单商品表js
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
		url: '../../litemall/ordergoods/list?_' + $.now(),
		height: $(window).height()-54,
		queryParams: function(params){
			params.name = vm.keyword;
			return params;
		},
		columns: [
			{checkbox: true},
			{field : "orderId", title : "订单表的订单ID", width : "100px"}, 
			{field : "goodsId", title : "商品表的商品ID", width : "100px"}, 
			{field : "goodsName", title : "商品名称", width : "100px"}, 
			{field : "goodsSn", title : "商品编号", width : "100px"}, 
			{field : "productId", title : "商品货品表的货品ID", width : "100px"}, 
			{field : "number", title : "商品货品的购买数量", width : "100px"}, 
			{field : "price", title : "商品货品的售价", width : "100px"}, 
			{field : "specifications", title : "商品货品的规格列表", width : "100px"}, 
			{field : "picUrl", title : "商品货品图片或者商品图片", width : "100px"}, 
			{field : "comment", title : "订单商品评论，如果是-1，则超期不能评价；如果是0，则可以评价；如果其他值，则是comment表里面的评论ID。", width : "100px"}, 
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
				title: '新增订单商品表',
				url: 'mall/ordergoods/add.html?_' + $.now(),
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
					title: '编辑订单商品表',
					url: 'mall/ordergoods/edit.html?_' + $.now(),
					width: '420px',
					height: '350px',
					success: function(iframeId){
						top.frames[iframeId].vm.liteMallOrderGoods.id = ck[0].id;
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
					url: '../../litemall/ordergoods/remove?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});
			}
		}
	}
})