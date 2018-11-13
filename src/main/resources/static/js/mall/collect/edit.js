/**
 * 编辑-收藏表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallCollect: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../litemall/collect/info?_' + $.now(),
		    	param: vm.liteMallCollect.id,
		    	success: function(data) {
		    		vm.liteMallCollect = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../litemall/collect/update?_' + $.now(),
		    	param: vm.liteMallCollect,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})