/**
 * 订单表js
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
		url: '../../litemall/order/list?_' + $.now(),
		height: $(window).height()-54,
		queryParams: function(params){
			params.name = vm.keyword;
			return params;
		},
		columns: [
			{checkbox: true},
			{field : "userId", title : "用户ID", width : "100px"},
			{field : "orderSn", title : "订单编号", width : "100px"}, 
			{field : "orderStatus", title : "订单状态", width : "100px"}, 
			{field : "consignee", title : "收货人名称", width : "100px"}, 
			{field : "mobile", title : "收货人手机号", width : "100px"}, 
			{field : "address", title : "收货具体地址", width : "100px"}, 
			{field : "message", title : "用户订单留言", width : "100px"}, 
			{field : "goodsPrice", title : "商品总费用", width : "100px"}, 
			{field : "freightPrice", title : "配送费用", width : "100px"}, 
			{field : "couponPrice", title : "优惠券减免", width : "100px"}, 
			{field : "integralPrice", title : "用户积分减免", width : "100px"}, 
			{field : "grouponPrice", title : "团购优惠价减免", width : "100px"}, 
			{field : "orderPrice", title : "订单费用", width : "100px"},
			{field : "actualPrice", title : "实付费用", width : "100px"},
			{field : "payId", title : "微信付款编号", width : "100px"}, 
			{field : "payTime", title : "微信付款时间", width : "100px"}, 
			{field : "shipSn", title : "发货编号", width : "100px"}, 
			{field : "shipChannel", title : "发货快递公司", width : "100px"}, 
			{field : "shipTime", title : "发货开始时间", width : "100px"}, 
			{field : "confirmTime", title : "用户确认收货时间", width : "100px"}, 
			{field : "comments", title : "待评价订单商品数量", width : "100px"}, 
			{field : "endTime", title : "订单关闭时间", width : "100px"}
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
				title: '新增订单表',
				url: 'mall/order/add.html?_' + $.now(),
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
					title: '编辑订单表',
					url: 'mall/order/edit.html?_' + $.now(),
					width: '420px',
					height: '350px',
					success: function(iframeId){
						top.frames[iframeId].vm.liteMallOrder.id = ck[0].id;
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
					url: '../../litemall/order/remove?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});
			}
		}
	}
})