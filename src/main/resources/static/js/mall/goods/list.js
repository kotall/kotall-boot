/**
 * 商品基本信息表js
 */

$(function () {
	initialPage();
	getGrid();
    getGrid2();
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


function getGrid2() {
    $('#dataGrid2').bootstrapTableEx({
        url: '../../litemall/goods/list?_' + $.now(),
        height: 350,
        pagination:false,
        dataField: "",
        queryParams: function(params){
            params.name = vm.keyword;
            return params;
        },
        columns: [
            {checkbox: true},
            {field : "specification", title : "规格名", width : "100px"},
            {field : "value", title : "规格值", width : "100px"},
            {field : "picUrl", title : "规格图片", width : "100px",
                formatter : function(value, row, index) {
                    return '<img  src="'+value+'" class="img-rounded" width="80px" height="60px">';
            }},
            {field : "id", title : "操作", width : "100px",
                formatter : function(value, row, index) {
                    var _html = '';
                    if (hasPermission('litemall:goods:edit')) {
                        _html += '<a href="javascript:;" onclick="vm.specificationEdit(\''+index+'\')" title="编辑"><i class="fa fa-pencil"></i></a>\t';
                    }
                    if (hasPermission('litemall:goods:remove')) {
                        _html += '<a href="javascript:;" onclick="vm.remove(\''+row.id+'\')" title="删除"><i class="fa fa-trash-o"></i></a>\t';
                    }
                    return _html;				}
            }
        ]
    })
}



var vm = new Vue({
	el:'#dpLTE',
	data: {
		keyword: null,
        showList: true,
        title:'',
        title2:'',
        title3:'',
        title4:'',
        gallerys:[],
        categoryDatas:[],
        liteMallGoods: {
            id: null,
            picUrl:'',
            gallery:'',
            detail:'',
            categoryId:''
        },
        liteMallGoodsSpecification:{
            specification:'1',
            value:'2',
            picUrl:''
        }

	},
	methods : {
		load: function() {
			vm.showList=true;
			vm.liteMallGoods = {};
			vm.gallerys = {};
            $('.add').remove();
			//vm.categoryDatas = [];
            editorUtils.clear(editor);
			$('#dataGrid').bootstrapTable('refresh');
		},
        add: function(){
            vm.showList = false;
            vm.title = "商品基本信息";
            vm.title2 = "商品规格";
            vm.title3 = "商品库存";
            vm.title4 = "商品参数";
        },
		edit: function(id) {
            vm.showList = false;
            vm.title = "修改商品信息";
            vm.getCategory();
            $.SetForm({
                url: '../../litemall/goods/info?_' + $.now(),
                param: id,
                success: function(data) {
                    debugger
                    vm.liteMallGoods = data;
                    $('#select2-id').val(vm.liteMallGoods.categoryId).trigger("change");
                    var gallery = vm.liteMallGoods.gallery;
                    vm.gallerys = gallery.split(";");
                    editor = editorUtils.init({
                        change: function (html) {
                            debugger
                            html = $.base64.encode(html);
                            vm.liteMallGoods.detail=html;
                        }
                    });
                    editor.txt.html($.base64.decode(vm.liteMallGoods.detail));
                }
            });
		},
		saveOrUpdate: function () {
            if (!$('#form').Validform()) {
                return false;
            }
            var url = vm.liteMallGoods.id == null ? '../../litemall/goods/save?_' + $.now() : '../../litemall/goods/update?_' + $.now();
            debugger
            if(vm.liteMallGoods.id == null){
                $.SaveForm({
                    url: url,
                    param: vm.liteMallGoods,
                    success: function(data) {
                        $.currentIframe().vm.load();
                    }
                });
			}else{
                $.ConfirmForm({
                    url: url,
                    param: vm.liteMallGoods,
                    success: function(data) {
                        $.currentIframe().vm.load();
                    }
                });
			}


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
			},
        getCategory:function () {
            var _self = this;
            $.ajax("../../litemall/category/getParentCategory",{}).then(function(response){
                _self.categoryDatas = response.rows;
            });
        },
        specificationSubmit:function () {
            debugger
            vm.liteMallGoodsSpecification.specification = $("#specification").val();
            vm.liteMallGoodsSpecification.value = $("#value").val();
            vm.liteMallGoodsSpecification.picUrl = $("#picUrl2").val();
            console.log(vm.liteMallGoodsSpecification.specification)
            $("#myModal").modal('hide');
            $('#dataGrid2').bootstrapTable('insertRow', {
                index:$('#dataGrid2').bootstrapTable('getOptions').totalRows,
                row:vm.liteMallGoodsSpecification
            });
        },
        specificationEdit:function (index) {
            var row = $("#dataGrid2").bootstrapTable('getData')[index];
            debugger
            $("#specification").val(row.specification);
            $("#value").val(row.value);
            $("#picUrl2").val(row.picUrl);
            $("#myModal").modal('show');
        }
	},
    created:function () {
        this.getCategory();
    }
})



layui.use('upload', function(){
    var $ = layui.jquery
        ,upload = layui.upload;

    //普通图片上传
    var uploadInst = upload.render({
        elem: '#demo1'
        ,url: '../../litemall/storage/create'
        ,before: function(obj){
            //预读本地文件示例，不支持ie8
            obj.preview(function(index, file, result){
                $('#demo1').attr('src', result); //图片链接（base64）
            });
        }
        ,done: function(res){
            var _self = this;
            //如果上传失败
            if(res.code > 0){
                return layer.msg('上传失败');
            }
            debugger
            var url = res.rows.url;
            vm.liteMallGoods.picUrl=url;
            //上传成功
        }
        ,error: function(){
            //演示失败状态，并实现重传
            var demoText = $('#demoText');
            demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
            demoText.find('.demo-reload').on('click', function(){
                uploadInst.upload();
            });
        }
    });


    //普通图片上传
    var uploadInst2 = upload.render({
        elem: '#demo2'
        ,url: '../../litemall/storage/create'
        ,before: function(obj){
            //预读本地文件示例，不支持ie8
            obj.preview(function(index, file, result){
                $('#demo2').before('<img src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img add">')
                //$('#demo2').attr('src', result); //图片链接（base64）
            });
        }
        ,done: function(res){
            var _self = this;
            //如果上传失败
            if(res.code > 0){
                return layer.msg('上传失败');
            }
            var url = res.rows.url;
            var gallery = vm.liteMallGoods.gallery;
            debugger
            if(gallery != '' && gallery != null){
                gallery = gallery.concat(';',url);
            }else{
                gallery = url;
            }
            vm.liteMallGoods.gallery=gallery;
            //上传成功
        }
        ,error: function(){
            //演示失败状态，并实现重传
            var demoText = $('#demoText2');
            demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
            demoText.find('.demo-reload').on('click', function(){
                uploadInst.upload();
            });
        }
    });


    //普通图片上传
    var uploadInst3 = upload.render({
        elem: '#demo3'
        ,url: '../../litemall/storage/create'
        ,before: function(obj){
            //预读本地文件示例，不支持ie8
            obj.preview(function(index, file, result){
                $('#demo3').attr('src', result); //图片链接（base64）
            });
        }
        ,done: function(res){
            var _self = this;
            //如果上传失败
            if(res.code > 0){
                return layer.msg('上传失败');
            }
            debugger
            var url = res.rows.url;
            $("#picUrl2").val(url);
            //上传成功
        }
        ,error: function(){
            //演示失败状态，并实现重传
            var demoText = $('#demoText3');
            demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
            demoText.find('.demo-reload').on('click', function(){
                uploadInst.upload();
            });
        }
    });
});

$("#select2-id").select2({
    placeholder: "请选择商品类目",
    allowClear: true
}).on('change', function (e) {
    debugger
    vm.liteMallGoods.categoryId=$("#select2-id").val();
});

editor = editorUtils.init({
    change: function (html) {
        debugger
        html = $.base64.encode(html);
        vm.liteMallGoods.detail=html;
    }
});