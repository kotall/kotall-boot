/**
 * 新增-品牌商表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallBrand: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../litemall/brand/save?_' + $.now(),
		    	param: vm.liteMallBrand,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
