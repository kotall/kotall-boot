/**
 * 编辑-系统配置信息表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		sysConfig: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../config/info?_' + $.now(),
		    	param: vm.sysConfig.id,
		    	success: function(data) {
		    		vm.sysConfig = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../config/update?_' + $.now(),
		    	param: vm.sysConfig,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})