/**
 * 新增-评论表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallComment: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../litemall/comment/save?_' + $.now(),
		    	param: vm.liteMallComment,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
