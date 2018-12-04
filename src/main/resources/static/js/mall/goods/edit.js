var editor ;

/**
 * 编辑-商品基本信息表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
        liteMallGoods: {
            id: 0,
            picUrl:'',
            gallery:'',
            detail:'',
            categoryId:''
        },
        gallerys:[],
        categoryDatas:[]
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../litemall/goods/info?_' + $.now(),
		    	param: vm.liteMallGoods.id,
		    	success: function(data) {
					debugger
		    		vm.liteMallGoods = data;
                    $('#select2-id').val(vm.liteMallGoods.categoryId).trigger("change");
                    var gallery = vm.liteMallGoods.gallery;
                    var isOnSale = vm.liteMallGoods.isOnSale;
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
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../litemall/goods/update?_' + $.now(),
		    	param: vm.liteMallGoods,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		},
        getCategory:function () {
            var _self = this;
            $.ajax("../../litemall/category/getParentCategory",{}).then(function(response){
                _self.categoryDatas = response.rows;
            });
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
                $('#demo2').before('<img src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img">')
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
            gallery = gallery +";"+ url;
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
});


$("#select2-id").select2({
    placeholder: "请选择商品类目",
    allowClear: true
}).on('change', function (e) {
    debugger
    vm.liteMallGoods.categoryId=$("#select2-id").val();
});
