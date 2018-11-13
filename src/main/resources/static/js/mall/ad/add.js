/**
 * 新增-广告表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallAd: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../litemall/ad/save?_' + $.now(),
		    	param: vm.liteMallAd,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
