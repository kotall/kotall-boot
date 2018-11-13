/**
 * 新增-类目表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallCategory: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../litemall/category/save?_' + $.now(),
		    	param: vm.liteMallCategory,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
