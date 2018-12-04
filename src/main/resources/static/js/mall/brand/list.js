
/**
 * 品牌商表js
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
		url: '../../litemall/brand/list?_' + $.now(),
		height: $(window).height()-54,
		queryParams: function(params){
			params.name = vm.keyword;
			return params;
		},
		columns: [
			{checkbox: true},
			{field : "storeName", title : "店铺", width : "200px"},
			{field : "name", title : "品牌商名称", width : "200px"},
			{field : "picUrl", title : "品牌商图片", width : "100px",
                formatter : function(value, row, index) {
                    return '<img  src="'+value+'" class="img-rounded" width="80px">';
                }},
            {field : "desc", title : "品牌商简介", width : "200px",
				formatter : function (value, row, index) {
            	    var str = value;
					return "<span title=" + str + ">" + cutStr(value, 20) + "</span>";
                }
			},
			{field : "floorPrice", title : "低价", width : "20px"},
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
				title: '新增品牌商表',
				url: 'mall/brand/add.html?_' + $.now(),
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
					title: '编辑品牌商表',
					url: 'mall/brand/edit.html?_' + $.now(),
					width: '600px',
					height: '520px',
					success: function(iframeId){
						top.frames[iframeId].vm.liteMallBrand.id = ck[0].id;
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
					url: '../../litemall/brand/remove?_' + $.now(),
			    	param: ids,
			    	success: function(data) {
			    		vm.load();
			    	}
				});
			}
		}
	}
})

/**
 * 字符串截取
 * @param str
 * @param len
 * @returns {*}
 */
cutStr = function (str, len) {
    var strLen = 0;
    var s = "";
    for (var i = 0; i < str.length; i++) {
        if (str.charCodeAt(i) > 128) {
            strLen += 2;
        } else {
            strLen++;
        }
        s += str.charAt(i);
        if (strLen >= len) {
            return s+"...";
        }
    }
    return s;
}