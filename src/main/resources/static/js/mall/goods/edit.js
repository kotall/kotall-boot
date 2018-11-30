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
            detail:''
        },
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../litemall/goods/info?_' + $.now(),
		    	param: vm.liteMallGoods.id,
		    	success: function(data) {
					debugger
		    		vm.liteMallGoods = data;
                    editor = editorUtils.init({
                        change: function (html) {
                            debugger
							html = html.replace(/\"/g,"\\'");
                            vm.liteMallGoods.detail=html;
                        }
                    });
                    editor.txt.html(vm.liteMallGoods.detail)
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
		}
	}
})






