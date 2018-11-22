/**
 * 编辑-文件存储表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		sysOss: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../sys/oss/info?_' + $.now(),
		    	param: vm.sysOss.id,
		    	success: function(data) {
		    		vm.sysOss = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../sys/oss/update?_' + $.now(),
		    	param: vm.sysOss,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})