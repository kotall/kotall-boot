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
			{field : "orderSn", title : "订单编号", width : "100px"},
			{field : "userId", title : "用户ID", width : "100px"},
			{field : "orderStatus", title : "订单状态", width : "100px"},
			{field : "orderPrice", title : "订单金额", width : "100px"},
			{field : "actualPrice", title : "支付金额", width : "100px"},
			{field : "payTime", title : "付款时间", width : "100px"},
			{field : "shipSn", title : "物流单号", width : "100px"},
			{field : "shipChannel", title : "物流渠道", width : "100px"},
			{field : "opt", title : "操作", width : "200px",
                formatter : function(value, row, index) {
                    var _html = '';
                    if (hasPermission('litemall:order:edit')) {
                        _html += '<a href="javascript:;" onclick="vm.edit(\''+row.id+'\')" title="编辑"><i class="fa fa-pencil"></i>&nbsp;&nbsp;</a>';
                    }
                    if (hasPermission('litemall:order:remove')) {
                        _html += '<a href="javascript:;" onclick="vm.remove(\''+row.id+'\')" title="删除"><i class="fa fa-trash-o"></i>&nbsp;&nbsp;</a>';
                    }
                    return _html;
			    }
			}
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