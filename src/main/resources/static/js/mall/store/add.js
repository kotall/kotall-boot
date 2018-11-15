/**
 * 新增-店铺表 js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallStore: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../litemall/store/save?_' + $.now(),
		    	param: vm.liteMallStore,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
