/**
 * 新增-意见反馈表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallFeedback: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../litemall/feedback/save?_' + $.now(),
		    	param: vm.liteMallFeedback,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
