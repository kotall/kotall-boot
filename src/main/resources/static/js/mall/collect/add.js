/**
 * 新增-收藏表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallCollect: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../litemall/collect/save?_' + $.now(),
		    	param: vm.liteMallCollect,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
