/**
 * 编辑-js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallGroupon: {
			id: 0
		},
        storeList:[]
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../litemall/grouponactivity/info?_' + $.now(),
		    	param: vm.liteMallGroupon.id,
		    	success: function(data) {
		    		vm.liteMallGroupon = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../litemall/grouponactivity/update?_' + $.now(),
		    	param: vm.liteMallGroupon,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		},
        getStoreList: function () {
            var _self = this;
            $.ajax({
                'url': "../../litemall/store/list?_" + $.now(),
                'type': 'POST',
                'contentType': 'application/json',
                'data': JSON.stringify({'pageNumber': 1, 'pageSize' : 10}),
                'dataType': 'json'
            }).then(function(res){
                _self.storeList = res.rows;
            });
        }
	},
    created: function () {
        this.getStoreList();
    }
})