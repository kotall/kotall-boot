// 获取请求参数
// 使用示例
// location.href = http://localhost:8080/index.html?id=123
// T.p('id') --> 123;
var url = function(name) {
	var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r!=null)return  unescape(r[2]); return null;
}

//登录token
var token = localStorage.getItem("token");
if(token == 'null'){
    parent.location.href = 'login.html';
}

//全局配置
$.ajaxSetup({
	dataType: "json",
	cache: false,
    headers: {
        "token": token
    },
    complete: function(xhr) {
        if(xhr.responseJSON.code == 401){
            toUrl('login.html');
        }
    }
})

//权限判断
function hasPermission(permission) {
    if(isNullOrEmpty(window.parent.perms)) {
    	return false;
    }
	if (window.parent.perms.indexOf(permission) > -1) {
        return true;
    } else {
        return false;
    }
}

toUrl = function(href) {
	window.location.href = href;
}

$.fn.bootstrapTableEx = function(opt){
	var defaults = {
		url: '',
		dataField: "rows",
		method: 'post',
		dataType: 'json',
		selectItemName: 'id',
		clickToSelect: true,
		pagination: true,
		smartDisplay: false,
		pageSize: 10,
		pageList: [10, 20, 30, 40, 50],
        paginationLoop: false,
		sidePagination: 'server',
		queryParamsType : null,
		columns: []
	}
	var option = $.extend({}, defaults, opt);
	$(this).bootstrapTable(option);
}

formatDate = function (v, format) {
    if (!v) return "";
    var d = v;
    if (typeof v === 'string') {
        if (v.indexOf("/Date(") > -1)
            d = new Date(parseInt(v.replace("/Date(", "").replace(")/", ""), 10));
        else
            d = new Date(Date.parse(v.replace(/-/g, "/").replace("T", " ").split(".")[0]));//.split(".")[0] 用来处理出现毫秒的情况，截取掉.xxx，否则会出错
    }
    var o = {
        "M+": d.getMonth() + 1,
        "d+": d.getDate(),
        "h+": d.getHours(),
        "m+": d.getMinutes(),
        "s+": d.getSeconds(),
        "q+": Math.floor((d.getMonth() + 3) / 3),
        "S": d.getMilliseconds()
    };
    if (/(y+)/.test(format)) {
        format = format.replace(RegExp.$1, (d.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(format)) {
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
        }
    }
    return format;
}

isNullOrEmpty = function (obj) {
    if ((typeof (obj) == "string" && obj == "") || obj == null || obj == undefined) {
        return true;
    } else {
        return false;
    }
}

isNotNullOrEmpty = function (obj) {
    if ((typeof (obj) == "string" && obj == "") || obj == null || obj == undefined) {
        return false;
    } else {
        return true;
    }
}

checkedArray = function (id) {
    var isOK = true;
    if (id == undefined || id == "" || id == 'null' || id == 'undefined') {
        isOK = false;
        dialogMsg('您没有选中任何数据项！');
    }
    return isOK;
}

checkedRow = function (id) {
    var isOK = true;
    if (id == undefined || id == "" || id == 'null' || id == 'undefined') {
        isOK = false;
        dialogMsg('您没有选中任何数据项！');
    } else if (id.length > 1) {
        isOK = false;
        dialogMsg('您只能选择一条数据项！');
    }
    return isOK;
}

reload = function () {
    location.reload();
    return false;
}

dialogOpen = function(opt){
	var defaults = {
		id : 'layui-layer-iframe',
		title : '',
		width: '',
		height: '',
		url : null,
		scroll : false,
		data : {},
		btn: ['确定', '取消'],
		success: function(){},
		yes: function(){}
	}
	var option = $.extend({}, defaults, opt), content = null;
	if(option.scroll){
		content = [option.url]
	}else{
		content = [option.url, 'no']
	}
		top.layer.open({
            type : 2,
            id : option.id,
            title : option.title,
            scroll: option.scroll,
            closeBtn : 1,
            anim: -1,
            isOutAnim: false,
            shadeClose : false,
            shade : 0.3,
            area : [option.width, option.height],
            content : content,
            btn: option.btn,
			maxmin:option.maxmin,
            success: function(index,layero){
            	if(option.isFull){
                    top.layer.full(top.layer.index);
                }
                option.success(option.id+""+layero);
            },
            yes: function(index,layero){
                var win = $(layero).find("iframe")[0].id;
                option.yes(win);
            }
        });


}

dialogContent = function(opt){
	var defaults = {
		title : '系统窗口',
		width: '',
		height: '',
		content : null,
		data : {},
		btn: ['确定', '取消'],
		success: null,
		yes: null
	}
	var option = $.extend({}, defaults, opt);
	return top.layer.open({
	  	type : 1,
		title : option.title,
		closeBtn : 1,
		anim: -1,
		isOutAnim: false,
		shadeClose : false,
		shade : 0.3,
		area : [option.width, option.height],
		shift : 5,
		content : option.content,
		btn: option.btn,
		success: option.success,
		yes: option.yes
    });
}

dialogAjax = function(opt){
	var defaults = {
		title : '系统窗口',
		width: '',
		height: '',
		url : null,
		data : {},
		btn: ['确定', '取消'],
		success: null,
		yes: null
	}
	var option = $.extend({}, defaults, opt);
	$.post(option.url, null, function(content){
		layer.open({
		  	type : 1,
			title : option.title,
			closeBtn : 1,
			anim: -1,
			isOutAnim: false,
			shadeClose : false,
			shade : 0.3,
			area : [option.width, option.height],
			shift : 5,
			content : content,
			btn: option.btn,
			success: option.success,
			yes: option.yes
	    });
	});
}

dialogAlert = function (content, type) {
	var msgType = {
		success:1,
		error:2,
		warn:3,
		info:7
	};
	if(isNullOrEmpty(type)){
		type='info';
	}
	top.layer.alert(content, {
        icon: msgType[type],
        title: "系统提示",
        anim: -1,
        btnAlign: 'c',
		isOutAnim: false
    });
}

dialogConfirm = function (content, callBack) {
	top.layer.confirm(content, {
		area: '338px',
		icon: 7,
        anim: -1,
		isOutAnim: false,
        title: "系统提示",
        btn: ['确认', '取消'],
        btnAlign: 'c',
    	yes: callBack
    });
}

dialogMsg = function(msg, type) {
	var msgType = {
		success:1,
		error:2,
		warn:3,
		info:7
	};
	if(isNullOrEmpty(type)){
		type='info';
	}
	top.layer.msg(msg, {
		icon: msgType[type],
		time: 2000
	}); 
}

dialogClose = function() {
	var index = top.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
	top.layer.close(index); //再执行关闭 
}

dialogLoading = function(flag) {
	if(flag){
		top.layer.load(0, {
			shade: [0.1,'#fff'],
			time: 2000
		});
	}else{
		top.layer.closeAll('loading');
	}
}

$.fn.GetWebControls = function (keyValue) {
    var reVal = "";
    $(this).find('input,select,textarea').each(function (r) {
        var id = $(this).attr('id');
        var type = $(this).attr('type');
        switch (type) {
            case "checkbox":
                if ($("#" + id).is(":checked")) {
                    reVal += '"' + id + '"' + ':' + '"1",'
                } else {
                    reVal += '"' + id + '"' + ':' + '"0",'
                }
                break;
            default:
                var value = $("#" + id).val();
                if (value == "") {
                    value = "&nbsp;";
                }
                reVal += '"' + id + '"' + ':' + '"' + $.trim(value) + '",'
                break;
        }
    });
    reVal = reVal.substr(0, reVal.length - 1);
    if (!keyValue) {
        reVal = reVal.replace(/&nbsp;/g, '');
    }
    reVal = reVal.replace(/\\/g, '\\\\');
    reVal = reVal.replace(/\n/g, '\\n');
    var postdata = jQuery.parseJSON('{' + reVal + '}');
    return postdata;
};

$.fn.SetWebControls = function (data) {
    var $id = $(this)
    for (var key in data) {
        var id = $id.find('#' + key);
        if (id.attr('id')) {
            var type = id.attr('type');
            var value = $.trim(data[key]).replace(/&nbsp;/g, '');
            switch (type) {
                case "checkbox":
                    if (value == 1) {
                        id.attr("checked", 'checked');
                    } else {
                        id.removeAttr("checked");
                    }
                    break;
                default:
                    id.val(value);
                    break;
            }
        }
    }
}

tabiframeId = function () {
    var iframeId = top.$(".DP_iframe:visible").attr("id");
    return iframeId;
}

$.currentIframe = function () {
    var tabId = tabiframeId();
	if(isNullOrEmpty(tabId)) {//单页iframe嵌套
		return $(window.parent.document).contents().find('#main')[0].contentWindow;
    }
    return $(window.parent.document).contents().find('#'+tabiframeId())[0].contentWindow;//多层tab页嵌套
}



/**
 * 富文本编辑器工具类
 * @type {{init: editor.init}}
 */
editorUtils = {
    init: function(opt) {
        var defaults = {
            element: '#editor',
            change: function(){}
        };
        var option = $.extend({}, defaults, opt);
        var editor = new window.wangEditor(option.element);
        editor.customConfig.uploadImgServer = '../../litemall/storage/create';
        editor.customConfig.uploadFileName = 'file';
        editor.customConfig.onchange= function(html) {
            option.change(html);
        };
        editor.customConfig.uploadImgHeaders = {
            'Accept': 'application/json',
            "token": token
        };
        editor.customConfig.uploadImgHooks = {
            before: function (xhr, editor, files) {
                // 图片上传之前触发
                // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象，files 是选择的图片文件

                // 如果返回的结果是 {prevent: true, msg: 'xxxx'} 则表示用户放弃上传
                // return {
                //     prevent: true,
                //     msg: '放弃上传'
                // }
            },
            success: function (xhr, editor, result) {
                // 图片上传并返回结果，图片插入成功之后触发
                // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象，result 是服务器端返回的结果
            },
            fail: function (xhr, editor, result) {
                // 图片上传并返回结果，但图片插入错误时触发
                // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象，result 是服务器端返回的结果
            },
            error: function (xhr, editor) {
                // 图片上传出错时触发
                // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象
            },
            timeout: function (xhr, editor) {
                // 图片上传超时时触发
                // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象
            },

            // 如果服务器端返回的不是 {errno:0, data: [...]} 这种格式，可使用该配置
            // （但是，服务器端返回的必须是一个 JSON 格式字符串！！！否则会报错）
            customInsert: function (insertImg, result, editor) {
                // 图片上传并返回结果，自定义插入图片的事件（而不是编辑器自动插入图片！！！）
                // insertImg 是插入图片的函数，editor 是编辑器对象，result 是服务器端返回的结果

                // 举例：假如上传图片成功后，服务器端返回的是 {url:'....'} 这种格式，即可这样插入图片：
                var url = result.rows.url;
                insertImg(url);

                // result 必须是一个 JSON 格式字符串！！！否则报错
            }
        };

        editor.customConfig.customAlert = function(info) {
            debugger
            dialogAlert(info, 'error');
        };
        editor.create();
        return editor;
    },
    set: function($editor, content) {
        $editor.txt.html(content);
    },
    get: function($editor) {
        return $editor.txt.html();
    },
    text: function($editor) {
        return $editor.txt.text();
    },
    append: function($editor, content) {
        $editor.txt.append(content)
    },
    clear: function($editor) {
        $editor.txt.clear()
    },
    hasContents: function ($editor) {
        var content = this.get($editor);
        return isNotNullOrEmpty(this.get($editor)) && "<p><br></p>" !== content;
    }
}


/**
 * 初始化select2选择器
 * @param placeholder
 * @returns {*|void}
 */
$.fn.selectInitEx = function(placeholder, search) {
    var opt = {
        placeholder: placeholder,
        theme: "bootstrap",
        language: "zh-CN"
    }
    if (search === false) {
        opt.minimumResultsForSearch = 'Infinity';
    }
    return $(this).select2(opt);
}

/**
 * 根据ajax地址初始化select2选择器
 * @param opt
 * @returns {*}
 */
$.fn.selectBindEx = function(opt) {
    var $select = $(this);
    var defaults = {
        url: '',
        async: true,
        text: 'name',
        value: 'id',
        placeholder: '请选择...',
        selected: '',
        allowClear: false,
        theme: "bootstrap",
        language: "zh-CN",
        change: function(){}
    }
    if (opt.search === false) {
        opt.minimumResultsForSearch = 'Infinity';
    }
    var option = $.extend({}, defaults, opt);
    var selectControl = null;
    $.ajax({
        type: 'get',
        async: option.async,
        contentType : 'application/json',
        url: option.url,
        data: null,
        success: function(r) {
            if ($select.hasClass("select2-hidden-accessible")) {
                $select.empty();
                $select.select2('destroy');
            }
            selectControl = $select.select2(option);
            $.each(r, function(idx, item){
                selectControl.append("<option value='"+item[option.value]+"'>"+item[option.text]+"</option>");
            })
            $select.val(option.selected);
            $select.on('change', function() {
                option.change($select.val());
            });
        },
        dataType: 'json'
    });
    return selectControl;
}