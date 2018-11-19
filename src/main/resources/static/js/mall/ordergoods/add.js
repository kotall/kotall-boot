/**
 * 新增-订单商品表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallOrderGoods: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../litemall/ordergoods/save?_' + $.now(),
		    	param: vm.liteMallOrderGoods,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
