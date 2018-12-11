/**
 * 意见反馈表js
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
		url: '../../litemall/feedback/list?_' + $.now(),
		height: $(window).height()-54,
		queryParams: function(params){
			params.name = vm.keyword;
			return params;
		},
		columns: [
			{checkbox: true},
            {field : "storeName", title : "店铺名称", width : "120px"},
			{field : "userId", title : "用户ID", width : "100px"},
			{field : "username", title : "用户名称", width : "100px"}, 
			{field : "mobile", title : "手机号", width : "100px"}, 
			{field : "feedType", title : "反馈类型", width : "100px"}, 
			{field : "content", title : "反馈内容", width : "100px"}, 
			{field : "status", title : "状态", width : "100px",
                formatter: function (value, index) {
                    if (value == 0){
                        return '<span class="label label-warning">未解决</span>';
                    }
                    return '<span class="label label-info">已解决</span>';
                }
			},
			{field : "hasPicture", title : "是否含有图片", width : "100px",
				formatter: function (value, index) {
                    if (value){
                        return '<span class="label label-success">是</span>';
                    }
                    return '<span class="label label-default">否</span>';
                }
			}, 
			{field : "picUrls", title : "图片地址列表，采用JSON数组格式", width : "100px"}, 
			{field : "addTime", title : "创建时间", width : "120px"},
			{field : "updateTime", title : "更新时间", width : "120px"}
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
				title: '新增意见反馈表',
				url: 'mall/feedback/add.html?_' + $.now(),
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
					title: '编辑意见反馈表',
					url: 'mall/feedback/edit.html?_' + $.now(),
					width: '420px',
					height: '350px',
					success: function(iframeId){
						top.frames[iframeId].vm.liteMallFeedback.id = ck[0].id;
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
					url: '../../litemall/feedback/remove?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});
			}
		}
	}
})