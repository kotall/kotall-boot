/**
 * 评论表js
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
		url: '../../litemall/comment/list?_' + $.now(),
		height: $(window).height()-54,
		queryParams: function(params){
			params.name = vm.keyword;
			return params;
		},
		columns: [
			{checkbox: true},
			{field : "valueId", title : "如果type=0，则是商品评论；如果是type=1，则是专题评论。", width : "100px"}, 
			{field : "type", title : "评论类型，如果type=0，则是商品评论；如果是type=1，则是专题评论；如果type=3，则是订单商品评论。", width : "100px"}, 
			{field : "content", title : "评论内容", width : "100px"}, 
			{field : "userId", title : "用户表的用户ID", width : "100px"}, 
			{field : "hasPicture", title : "是否含有图片", width : "100px"}, 
			{field : "picUrls", title : "图片地址列表，采用JSON数组格式", width : "100px"}, 
			{field : "star", title : "评分， 1-5", width : "100px"}, 
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
				title: '新增评论表',
				url: 'mall/comment/add.html?_' + $.now(),
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
					title: '编辑评论表',
					url: 'mall/comment/edit.html?_' + $.now(),
					width: '420px',
					height: '350px',
					success: function(iframeId){
						top.frames[iframeId].vm.liteMallComment.id = ck[0].id;
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
					url: '../../litemall/comment/remove?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});
			}
		}
	}
})