/**
 * 编辑-订单表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallOrder: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../litemall/order/info?_' + $.now(),
		    	param: vm.liteMallOrder.id,
		    	success: function(data) {
		    		vm.liteMallOrder = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../litemall/order/update?_' + $.now(),
		    	param: vm.liteMallOrder,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})