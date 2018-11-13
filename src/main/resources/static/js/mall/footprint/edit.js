/**
 * 编辑-用户浏览足迹表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallFootprint: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../litemall/footprint/info?_' + $.now(),
		    	param: vm.liteMallFootprint.id,
		    	success: function(data) {
		    		vm.liteMallFootprint = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../litemall/footprint/update?_' + $.now(),
		    	param: vm.liteMallFootprint,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})