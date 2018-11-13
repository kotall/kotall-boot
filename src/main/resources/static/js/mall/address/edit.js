/**
 * 编辑-收货地址表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallAddress: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../litemall/address/info?_' + $.now(),
		    	param: vm.liteMallAddress.id,
		    	success: function(data) {
		    		vm.liteMallAddress = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../litemall/address/update?_' + $.now(),
		    	param: vm.liteMallAddress,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})