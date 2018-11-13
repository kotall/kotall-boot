/**
 * 新增-常见问题表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallIssue: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../litemall/issue/save?_' + $.now(),
		    	param: vm.liteMallIssue,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
