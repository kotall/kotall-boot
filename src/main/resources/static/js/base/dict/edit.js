/**
 * 编辑-通用字典js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		macro:{
            // dictId: null,
			typeName: null,
			typeId: 0,
			type: 1,
			orderNum: 0,
			status: 1
		}
	},
	methods : {
		macroTree: function(){
		    dialogOpen({
				id: 'layerMacroTree',
				title: '选择目录',
		        url: 'base/dict/tree.html?_' + $.now(),
		        scroll : true,
		        width: "300px",
		        height: "450px",
		        yes : function(iframeId) {
		        	top.frames[iframeId].vm.acceptClick();
				}
		    })
		},
		setForm: function() {
			$.SetForm({
				url: '../../sys/dict/info?_' + $.now(),
		    	param: vm.macro.dictId,
		    	success: function(data) {
		    		vm.macro = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../sys/dict/update?_' + $.now(),
		    	param: vm.macro,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
