/**
 * 新增-用户浏览足迹表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallFootprint: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../litemall/footprint/save?_' + $.now(),
		    	param: vm.liteMallFootprint,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
