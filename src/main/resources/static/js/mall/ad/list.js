/**
 * 广告表js
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
		url: '../../litemall/ad/list?_' + $.now(),
		height: $(window).height()-54,
		queryParams: function(params){
			params.name = vm.keyword;
			return params;
		},
		columns: [
			{checkbox: true},
			{field : "storeName", title : "店铺", width : "120px"},
			{field : "name", title : "广告标题", width : "100px"},
			{field : "link", title : "广岛链接地址", width : "100px"},
			{field : "url", title : "广告宣传图片", width : "100px",
                formatter : function(value, row, index) {
                    return '<img  src="'+value+'" class="img-rounded" width="80px" height="60px">';
                }
			},
			{field : "position", title : "广告位置", width : "100px"},
			{field : "content", title : "活动内容", width : "100px"}, 
			{field : "startTime", title : "广告开始时间", width : "100px"}, 
			{field : "endTime", title : "广告结束时间", width : "100px"}, 
			{field : "enabled", title : "是否启动", width : "100px",
                formatter: function (value, row, index) {
                    if(value === 0){
                        return '<i class="fa fa-toggle-off"></i>';
                    }
                    if(value === 1){
                        return '<i class="fa fa-toggle-on"></i>';
                    }
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
				title: '新增广告表',
				url: 'mall/ad/add.html?_' + $.now(),
				width: '720px',
				height: '600px',
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit: function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections');
			if(checkedRow(ck)){
				dialogOpen({
					title: '编辑广告表',
					url: 'mall/ad/edit.html?_' + $.now(),
					width: '720px',
					height: '600px',
					success: function(iframeId){
						top.frames[iframeId].vm.liteMallAd.id = ck[0].id;
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
					url: '../../litemall/ad/remove?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});
			}
		}
	}
})