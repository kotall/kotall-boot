/**
 * 编辑-js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallGrouponRules: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../litemall/grouponrules/info?_' + $.now(),
		    	param: vm.liteMallGrouponRules.id,
		    	success: function(data) {
		    		vm.liteMallGrouponRules = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../litemall/grouponrules/update?_' + $.now(),
		    	param: vm.liteMallGrouponRules,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})