/**
 * 编辑-app配置表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallApp: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../litemall/app/info?_' + $.now(),
		    	param: vm.liteMallApp.id,
		    	success: function(data) {
		    		vm.liteMallApp = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../litemall/app/update?_' + $.now(),
		    	param: vm.liteMallApp,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})