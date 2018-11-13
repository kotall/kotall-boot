/**
 * 编辑-用户表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallUser: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../litemall/user/info?_' + $.now(),
		    	param: vm.liteMallUser.id,
		    	success: function(data) {
		    		vm.liteMallUser = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../litemall/user/update?_' + $.now(),
		    	param: vm.liteMallUser,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})