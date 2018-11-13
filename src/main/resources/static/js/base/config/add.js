/**
 * 新增-系统配置信息表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		sysConfig: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../config/save?_' + $.now(),
		    	param: vm.sysConfig,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
