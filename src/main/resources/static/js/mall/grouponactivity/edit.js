/**
 * 编辑-js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallGroupon: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../litemall/grouponactivity/info?_' + $.now(),
		    	param: vm.liteMallGroupon.id,
		    	success: function(data) {
		    		vm.liteMallGroupon = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../litemall/grouponactivity/update?_' + $.now(),
		    	param: vm.liteMallGroupon,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})