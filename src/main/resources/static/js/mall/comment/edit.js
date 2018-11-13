/**
 * 编辑-评论表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallComment: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../litemall/comment/info?_' + $.now(),
		    	param: vm.liteMallComment.id,
		    	success: function(data) {
		    		vm.liteMallComment = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../litemall/comment/update?_' + $.now(),
		    	param: vm.liteMallComment,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})