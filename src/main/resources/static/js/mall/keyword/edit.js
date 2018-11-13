/**
 * 编辑-关键字表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallKeyword: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../litemall/keyword/info?_' + $.now(),
		    	param: vm.liteMallKeyword.id,
		    	success: function(data) {
		    		vm.liteMallKeyword = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../litemall/keyword/update?_' + $.now(),
		    	param: vm.liteMallKeyword,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})