/**
 * 编辑-搜索历史表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallSearchHistory: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../litemall/history/info?_' + $.now(),
		    	param: vm.liteMallSearchHistory.id,
		    	success: function(data) {
		    		vm.liteMallSearchHistory = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../litemall/history/update?_' + $.now(),
		    	param: vm.liteMallSearchHistory,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})