/**
 * 新增-js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallGrouponRules: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../litemall/grouponrules/save?_' + $.now(),
		    	param: vm.liteMallGrouponRules,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
