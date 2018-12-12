/**
 * 新增-关键字表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallKeyword: {
			id: 0
		},
        storeList:[]
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
