/**
 * 编辑-广告表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallAd: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../litemall/ad/info?_' + $.now(),
		    	param: vm.liteMallAd.id,
		    	success: function(data) {
		    		vm.liteMallAd = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../litemall/ad/update?_' + $.now(),
		    	param: vm.liteMallAd,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})