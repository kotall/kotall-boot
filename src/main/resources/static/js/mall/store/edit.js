/**
 * 编辑-店铺表 js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallStore: {
			id: 0,
            brand: null
		},
        storeList:[]
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../litemall/store/info?_' + $.now(),
		    	param: vm.liteMallStore.id,
		    	success: function(data) {
		    		vm.liteMallStore = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../litemall/store/update?_' + $.now(),
		    	param: vm.liteMallStore,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		},
        getStoreList: function () {
            var _self = this;
            $.ajax({
                'url': "../../litemall/store/list?_" + $.now(),
                'type': 'POST',
                'contentType': 'application/json',
                'data': JSON.stringify({'pageNumber': 1, 'pageSize' : 10}),
                'dataType': 'json'
            }).then(function(res){
                _self.storeList = res.rows;
            });
        }
	},
    created: function () {
        this.getStoreList();
    }
});

layui.use('upload', function(){
        var $ = layui.jquery,upload = layui.upload;

        // 普通图片上传
        var uploadInst = upload.render({
            elem: '#brandPicUrl',
            url: '../../litemall/storage/create',
            before: function(obj){
                // 预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#brandPicUrl').attr('src', result); //图片链接（base64）
                });
            },
            done: function(res){
                var _self = this;
                // 如果上传失败
                if(res.code > 0){
                    return layer.msg('上传失败');
                }
                debugger
                var url = res.rows.url;
                vm.liteMallStore.brand=url;
                // 上传成功
            },
            error: function(){
                //演示失败状态，并实现重传
                var demoText = $('#uploadResult');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function(){
                    uploadInst.upload();
                });
            }
        });
    }
);