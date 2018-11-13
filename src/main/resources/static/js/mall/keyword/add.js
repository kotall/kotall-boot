/**
 * 新增-关键字表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallKeyword: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../litemall/keyword/save?_' + $.now(),
		    	param: vm.liteMallKeyword,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
