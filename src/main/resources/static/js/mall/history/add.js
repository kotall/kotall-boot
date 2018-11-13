/**
 * 新增-搜索历史表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallSearchHistory: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../litemall/history/save?_' + $.now(),
		    	param: vm.liteMallSearchHistory,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
