/**
 * 编辑-常见问题表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
		liteMallIssue: {
			id: 0
		},
        storeList:[]
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../litemall/issue/info?_' + $.now(),
		    	param: vm.liteMallIssue.id,
		    	success: function(data) {
		    		vm.liteMallIssue = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../litemall/issue/update?_' + $.now(),
		    	param: vm.liteMallIssue,
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