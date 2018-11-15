/**
 * 店铺表 js
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
		url: '../../litemall/store/list?_' + $.now(),
		height: $(window).height()-54,
		queryParams: function(params){
			params.name = vm.keyword;
			return params;
		},
		columns: [
			{checkbox: true},
			{field : "name", title : "店铺名称", width : "100px"}, 
			{field : "status", title : "店铺状态", width : "100px"},
			{field : "type", title : "店铺类型", width : "100px"}, 
			{field : "mainBuz", title : "主营业务", width : "100px"}, 
			{field : "brand", title : "店铺招牌", width : "100px"}, 
			{field : "address", title : "店铺地址", width : "100px"}, 
			{field : "locationX", title : "店铺位置X", width : "100px"}, 
			{field : "locationY", title : "店铺位置Y", width : "100px"}, 
			{field : "userId", title : "店主ID", width : "100px"}, 
			{field : "contactMan", title : "联系人", width : "100px"}, 
			{field : "contactPhone", title : "联系电话", width : "100px"},
			{field : "createTime", title : "创建时间", width : "100px"}		]
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
				title: '新增店铺表 ',
				url: 'mall/store/add.html?_' + $.now(),
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
					title: '编辑店铺表 ',
					url: 'mall/store/edit.html?_' + $.now(),
					width: '420px',
					height: '350px',
					success: function(iframeId){
						top.frames[iframeId].vm.liteMallStore.id = ck[0].id;
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
					url: '../../litemall/store/remove?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});
			}
		}
	}
})