/**
 * 关键字表js
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
		url: '../../litemall/keyword/list?_' + $.now(),
		height: $(window).height()-54,
		queryParams: function(params){
			params.name = vm.keyword;
			return params;
		},
		columns: [
			{checkbox: true},
			{field : "storeName", title : "店铺名称", width : "100px"},
			{field : "keyword", title : "关键字", width : "100px"},
			{field : "url", title : "关键字的跳转链接", width : "100px"},
			{field : "isHot", title : "是否是热门关键字", width : "100px",
                formatter: function (value, row, index) {
                    if (value === 1){
                        return '<span class="label label-success">是</span>';
                    }
                    return '<span class="label label-warning">否</span>';
                }
			},
			{field : "isDefault", title : "是否是默认关键字", width : "100px",
                formatter: function (value, row, index) {
                    if (value === 1){
                        return '<span class="label label-success">是</span>';
                    }
                    return '<span class="label label-warning">否</span>';
                }
			},
			{field : "sortOrder", title : "排序", width : "100px"}, 
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
				title: '新增关键字表',
				url: 'mall/keyword/add.html?_' + $.now(),
				width: '600px',
				height: '520px',
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit: function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections');
			if(checkedRow(ck)){
				dialogOpen({
					title: '编辑关键字表',
					url: 'mall/keyword/edit.html?_' + $.now(),
					width: '600px',
					height: '520px',
					success: function(iframeId){
						top.frames[iframeId].vm.liteMallKeyword.id = ck[0].id;
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
					url: '../../litemall/keyword/remove?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});
			}
		}
	}
})