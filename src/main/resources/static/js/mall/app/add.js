/**
 * 新增-app配置表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallApp: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../litemall/app/save?_' + $.now(),
		    	param: vm.liteMallApp,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
