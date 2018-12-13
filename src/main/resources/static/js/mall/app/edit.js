/**
 * 编辑-app配置表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallApp: {
			id: 0
		},
        storeList:[]
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../litemall/app/info?_' + $.now(),
		    	param: vm.liteMallApp.id,
		    	success: function(data) {
		    		vm.liteMallApp = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../litemall/app/update?_' + $.now(),
		    	param: vm.liteMallApp,
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