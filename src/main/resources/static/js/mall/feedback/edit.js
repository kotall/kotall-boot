/**
 * 编辑-意见反馈表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallFeedback: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../litemall/feedback/info?_' + $.now(),
		    	param: vm.liteMallFeedback.id,
		    	success: function(data) {
		    		vm.liteMallFeedback = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../litemall/feedback/update?_' + $.now(),
		    	param: vm.liteMallFeedback,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})