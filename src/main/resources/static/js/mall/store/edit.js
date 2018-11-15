/**
 * 编辑-店铺表 js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallStore: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../litemall/store/info?_' + $.now(),
		    	param: vm.liteMallStore.id,
		    	success: function(data) {
		    		vm.liteMallStore = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../litemall/store/update?_' + $.now(),
		    	param: vm.liteMallStore,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})