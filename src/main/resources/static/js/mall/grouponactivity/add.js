/**
 * 新增-js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallGroupon: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../litemall/grouponactivity/save?_' + $.now(),
		    	param: vm.liteMallGroupon,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
