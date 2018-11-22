/**
 * 类目表js
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
		url: '../../litemall/category/list?_' + $.now(),
		height: $(window).height()-54,
		queryParams: function(params){
			params.name = vm.keyword;
			return params;
		},
		columns: [
			{checkbox: true},
			{field : "name", title : "类目名称", width : "100px"}, 
			{field : "keywords", title : "类目关键字", width : "100px"},
			{field : "desc", title : "类目广告语介绍", width : "100px"}, 
			{field : "pid", title : "父类目ID", width : "100px"}, 
			{field : "iconUrl", title : "类目图标", width : "100px"}, 
			{field : "picUrl", title : "类目图片", width : "100px"}, 
			{field : "level", title : "", width : "100px"}, 
			{field : "sortOrder", title : "排序", width : "100px"}, 
			{field : "addTime", title : "创建时间", width : "100px"}
		]
	})
}

var vm = new Vue({
	el:'#dpLTE',
	data: {
		keyword: null,

	},
	methods : {
		load: function() {
			$('#dataGrid').bootstrapTable('refresh');
		},
		save: function() {
			dialogOpen({
				title: '新增类目表',
				url: 'mall/category/add.html?_' + $.now(),
				width: '620px',
				height: '750px',
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit: function() {
			var ck = $('#dataGrid').bootstrapTable('getSelections');
			if(checkedRow(ck)){
				dialogOpen({
					title: '编辑类目表',
					url: 'mall/category/edit.html?_' + $.now(),
                    width: '620px',
                    height: '450px',
					success: function(iframeId){
						top.frames[iframeId].vm.liteMallCategory.id = ck[0].id;
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
					url: '../../litemall/category/remove?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});
			}
		}
	}
})