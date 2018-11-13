/**
 * 新增-用户表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallUser: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../litemall/user/save?_' + $.now(),
		    	param: vm.liteMallUser,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
