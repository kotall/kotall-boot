/**
 * 新增-文件存储表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		sysOss: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../sys/oss/save?_' + $.now(),
		    	param: vm.sysOss,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
