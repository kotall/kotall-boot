/**
 * 编辑-专题表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallTopic: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../litemall/topic/info?_' + $.now(),
		    	param: vm.liteMallTopic.id,
		    	success: function(data) {
		    		vm.liteMallTopic = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../litemall/topic/update?_' + $.now(),
		    	param: vm.liteMallTopic,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})