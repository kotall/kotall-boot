/**
 * 编辑-品牌商表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallBrand: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../litemall/brand/info?_' + $.now(),
		    	param: vm.liteMallBrand.id,
		    	success: function(data) {
		    		vm.liteMallBrand = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../litemall/brand/update?_' + $.now(),
		    	param: vm.liteMallBrand,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})