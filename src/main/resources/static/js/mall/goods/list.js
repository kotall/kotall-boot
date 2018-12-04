/**
 * 商品基本信息表js
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
		url: '../../litemall/goods/list?_' + $.now(),
		height: $(window).height()-54,
		queryParams: function(params){
			params.name = vm.keyword;
			return params;
		},
		columns: [
			{checkbox: true},
			{field : "storeId", title : "店铺ID", width : "100px"}, 
			{field : "goodsSn", title : "商品编号", width : "100px"}, 
			{field : "name", title : "商品名称", width : "100px"}, 
			{field : "categoryId", title : "商品所属类目ID", width : "100px"}, 
			{field : "brandId", title : "所属品牌商", width : "100px"},
			/*{field : "gallery", title : "商品宣传图片列表，采用JSON数组格式", width : "100px"}, */
			{field : "keywords", title : "商品关键字", width : "100px"},
			{field : "brief", title : "商品简介", width : "100px"},
            {field : "picUrl", title : "商品图片", width : "100px",
                formatter : function(value, row, index) {
                    return '<img  src="'+value+'" class="img-rounded" width="80px" height="60px">';
                }},
			{field : "isOnSale", title : "是否上架", width : "100px",
                formatter : function(value, row, index) {
                    if (value === true){
                        return '<span class="label label-success">是</span>';
					}
                    return '<span class="label label-warning">否</span>';
                }},
			/*{field : "shareUrl", title : "商品分享朋友圈图片", width : "100px"}, */
			{field : "isNew", title : "是否新品首发", width : "100px",
                formatter : function(value, row, index) {
                    if (value === 0){
                        return '<span class="label label-success">是</span>';
                    }
                    return '<span class="label label-warning">否</span>';
                }},
			{field : "isHot", title : "是否人气推荐", width : "100px",
                formatter : function(value, row, index) {
                    if (value === 0){
                        return '<span class="label label-success">是</span>';
                    }
                    return '<span class="label label-warning">否</span>';
                }},
			{field : "unit", title : "商品单位", width : "100px"},
			{field : "counterPrice", title : "专柜价格", width : "100px"}, 
			{field : "retailPrice", title : "零售价格", width : "100px"}, 
			/*{field : "detail", title : "商品详细介绍", width : "100px",
				formatter : function(value, row, index) {
					return $.base64.decode(value);
				}
			},*/
			{field : "id", title : "操作", width : "100px",
				formatter : function(value, row, index) {
                    var _html = '';
                    if (hasPermission('litemall:goods:edit')) {
                        _html += '<a href="javascript:;" onclick="vm.edit(\''+row.id+'\')" title="编辑"><i class="fa fa-pencil"></i></a>\t';
                    }
                    if (hasPermission('litemall:goods:remove')) {
                        _html += '<a href="javascript:;" onclick="vm.remove(\''+row.id+'\')" title="删除"><i class="fa fa-trash-o"></i></a>\t';
                    }
                    return _html;				}
			}
            /*,{field : "addTime", title : "创建时间", width : "100px"},
            {field : "updateTime", title : "更新时间", width : "100px"},
            {field : "deleted", title : "逻辑删除", width : "100px"}*/
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
				title: '新增商品基本信息表',
				url: 'mall/goods/add.html?_' + $.now(),
				width: '1020px',
				height: '750px',
                maxmin: true,
				isFull:true,
                scroll : true,
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});

		},
		edit: function(id) {
				dialogOpen({
					title: '编辑商品基本信息表',
					url: 'mall/goods/edit.html?_' + $.now(),
                    width: '1020px',
                    height: '750px',
                    maxmin: true,
                    isFull:true,
                    scroll : true,
					success: function(iframeId){
						top.frames[iframeId].vm.liteMallGoods.id = id;
						top.frames[iframeId].vm.setForm();
					},
					yes: function(iframeId){
						top.frames[iframeId].vm.acceptClick();
					}
				});
		},
        remove: function(menuId) {
            var ids = [];
                ids.push(menuId);
				$.RemoveForm({
					url: '../../litemall/goods/remove?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});
			}
	}
})