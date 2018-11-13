/**
 * 新增-收货地址表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallAddress: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../litemall/address/save?_' + $.now(),
		    	param: vm.liteMallAddress,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
