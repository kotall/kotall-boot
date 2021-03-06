/**
 * 编辑-类目表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
        liteMallCategory: {
            id: 0,
            pid:'',
            level:'L1',
            iconUrl:'',
            picUrl:''
        },
        categoryDatas:[],
        storeList:[]
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../litemall/category/info?_' + $.now(),
		    	param: vm.liteMallCategory.id,
		    	success: function(data) {
		    		vm.liteMallCategory = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../litemall/category/update?_' + $.now(),
		    	param: vm.liteMallCategory,
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
        },
        getCategory:function () {
            var _self = this;
            $.ajax("../../litemall/category/getSecondCategory").then(function(response){
                _self.categoryDatas = response.rows;
            });
            /*this.$http({           //调用接口
                method:'GET',
                url:"/rms/litemall/category/getSecondCategory"  //this指data
            }).then(function(response){  //接口返回数据
                this.categoryDatas = response.data;
				console.log(response);
            },function(error){
            })*/

        },
        selectChange:function () {
            this.liteMallCategory.pid = 0;
        }
	},
    created: function () {
        this.getCategory();
        this.getStoreList();
    }
});

layui.use('upload', function(){
    var $ = layui.jquery
        ,upload = layui.upload;

    //普通图片上传
    var uploadInst = upload.render({
        elem: '#test1'
        ,url: '../..//litemall/storage/create'
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
            vm.liteMallCategory.iconUrl=url;
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
        elem: '#test2'
        ,url: '../..//litemall/storage/create'
        ,before: function(obj){
            //预读本地文件示例，不支持ie8
            obj.preview(function(index, file, result){
                $('#demo2').attr('src', result); //图片链接（base64）
            });
        }
        ,done: function(res){
            var _self = this;
            //如果上传失败
            if(res.code > 0){
                return layer.msg('上传失败');
            }
            var url = res.rows.url;
            vm.liteMallCategory.picUrl=url;
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
