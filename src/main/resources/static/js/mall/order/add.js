/**
 * 新增-订单表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallOrder: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../litemall/order/save?_' + $.now(),
		    	param: vm.liteMallOrder,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
