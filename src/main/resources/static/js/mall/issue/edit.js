/**
 * 编辑-常见问题表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallIssue: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../litemall/issue/info?_' + $.now(),
		    	param: vm.liteMallIssue.id,
		    	success: function(data) {
		    		vm.liteMallIssue = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../litemall/issue/update?_' + $.now(),
		    	param: vm.liteMallIssue,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})