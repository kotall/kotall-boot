/**
 * 新增-购物车商品表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallCart: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../litemall/litemall/save?_' + $.now(),
		    	param: vm.liteMallCart,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
