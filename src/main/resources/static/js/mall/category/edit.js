/**
 * 编辑-类目表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallCategory: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../litemall/category/info?_' + $.now(),
		    	param: vm.liteMallCategory.id,
		    	success: function(data) {
		    		vm.liteMallCategory = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../litemall/category/update?_' + $.now(),
		    	param: vm.liteMallCategory,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})