/**
 * 编辑-购物车商品表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallCart: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../litemall/litemall/info?_' + $.now(),
		    	param: vm.liteMallCart.id,
		    	success: function(data) {
		    		vm.liteMallCart = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../litemall/litemall/update?_' + $.now(),
		    	param: vm.liteMallCart,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})