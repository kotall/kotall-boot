/**
 * js
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
		url: '../../litemall/grouponactivity/list?_' + $.now(),
		height: $(window).height()-54,
		queryParams: function(params){
			params.name = vm.keyword;
			return params;
		},
		columns: [
			{checkbox: true},
			{field : "storeName", title : "店铺", width : "120px"},
			{field : "orderId", title : "关联的订单ID", width : "100px"},
			{field : "grouponId", title : "参与的团购ID", width : "100px"},
			{field : "rulesId", title : "团购规则ID", width : "100px"},
			{field : "userId", title : "用户ID", width : "100px"}, 
			{field : "creatorUserId", title : "创建者ID", width : "100px"}, 
			{field : "shareUrl", title : "团购分享图片地址", width : "100px",
                formatter : function(value, row, index) {
                    return '<img  src="'+value+'" class="img-rounded" width="80px" height="60px">';
                }
			},
			{field : "payed", title : "是否已经支付", width : "100px",
				formatter: function (value, index) {
                    if (value == 0){
                        return '<span class="label label-default">未支付</span>';
                    }
                    return '<span class="label label-info">已支付</span>';
                }
			},
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
				title: '新增',
				url: 'mall/grouponactivity/add.html?_' + $.now(),
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
					title: '编辑',
					url: 'mall/grouponactivity/edit.html?_' + $.now(),
					width: '420px',
					height: '350px',
					success: function(iframeId){
						top.frames[iframeId].vm.liteMallGroupon.id = ck[0].id;
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
					url: '../../litemall/grouponactivity/remove?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});
			}
		}
	}
})