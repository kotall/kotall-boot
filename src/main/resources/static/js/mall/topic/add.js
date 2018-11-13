/**
 * 新增-专题表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallTopic: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../litemall/topic/save?_' + $.now(),
		    	param: vm.liteMallTopic,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
