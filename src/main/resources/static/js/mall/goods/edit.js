/**
 * 编辑-商品基本信息表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallGoods: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../litemall/goods/info?_' + $.now(),
		    	param: vm.liteMallGoods.id,
		    	success: function(data) {
		    		vm.liteMallGoods = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../litemall/goods/update?_' + $.now(),
		    	param: vm.liteMallGoods,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})