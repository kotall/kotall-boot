
var ImageUpload ={
        //点击
        clickImg : function(obj){
            $(obj.currentTarget).parent().find('.upload_input').click();
        },
        //删除
        deleteImg : function(obj){
            obj = obj.currentTarget;
            $(obj).parent().find('input').val('');
            //IE9以下
            $(obj).parent().find('img.preview').css("filter","");
            $(obj).parent().find('img.preview').attr("src",'');
            $(obj).hide();
            $(obj).parent().find('.addImg').show();
        },
        //选择图片
        change : function (file) {
            file = file.currentTarget;
            var data = file.files[0];
            var formData = new FormData();
            var url = "";
            formData.append('file', data);
            $.ajax({
                url : '../..//litemall/storage/create',//这里写你的url
                type : 'POST',
                async : false,
                data : formData,
                contentType: false,// 当有文件要上传时，此项是必须的，否则后台无法识别文件流的起始位置
                processData: false,// 是否序列化data属性，默认true(注意：false时type必须是post)
                dataType: 'json',//这里是返回类型，一般是json,text等
                clearForm: true,//提交后是否清空表单数据
                success: function(res) {   //提交成功后自动执行的处理函数，参数data就是服务器返回的数据。
                    debugger
                    url = res.rows.url;
                },
                error: function(data) {  //提交失败自动执行的处理函数。
                    if(data.code > 0){
                        return layer.msg('上传失败');
                    }
                }
            });
            //预览
            var pic = $(file).parent().find(".preview");
            //添加按钮
            var addImg = $(file).parent().find(".addImg");
            //删除按钮
            var deleteImg = $(file).parent().find(".delete");

            var ext=file.value.substring(file.value.lastIndexOf(".")+1).toLowerCase();

            // gif在IE浏览器暂时无法显示
            if(ext!='png'&&ext!='jpg'&&ext!='jpeg'){
                if (ext != '') {
                    alert("图片的格式必须为png或者jpg或者jpeg格式！");
                }
                return;
            }
            //判断IE版本
            var isIE = navigator.userAgent.match(/MSIE/)!= null,
                isIE6 = navigator.userAgent.match(/MSIE 6.0/)!= null;
            isIE10 = navigator.userAgent.match(/MSIE 10.0/)!= null;
            if(isIE && !isIE10) {
                file.select();
                var reallocalpath = document.selection.createRange().text;
                // IE6浏览器设置img的src为本地路径可以直接显示图片
                if (isIE6) {
                    vm.gallerys[index]=reallocalpath;
                    pic.attr("src",reallocalpath);
                }else{
                    // 非IE6版本的IE由于安全问题直接设置img的src无法显示本地图片，但是可以通过滤镜来实现
                    pic.css("filter","progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale',src=\"" + reallocalpath + "\")");
                    // 设置img的src为base64编码的透明图片 取消显示浏览器默认图片
                    pic.attr('src','data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==');
                    vm.gallerys[index]='data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==';
                }
                addImg.hide();
                deleteImg.show();
            }else {
                this.html5Reader(file,pic,addImg,deleteImg);
            }
            debugger
            return url;
        },
        //H5渲染
        html5Reader : function(file,pic,addImg,deleteImg){
            var file = file.files[0];
            var reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onload = function(e){
                pic.attr("src",this.result);
            }
            addImg.hide();
            deleteImg.show();
        }

};
