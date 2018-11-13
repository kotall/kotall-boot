/**
 * 编辑-订单商品表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallOrderGoods: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../litemall/goods/info?_' + $.now(),
		    	param: vm.liteMallOrderGoods.id,
		    	success: function(data) {
		    		vm.liteMallOrderGoods = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../litemall/goods/update?_' + $.now(),
		    	param: vm.liteMallOrderGoods,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})