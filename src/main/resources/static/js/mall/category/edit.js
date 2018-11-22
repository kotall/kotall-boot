/**
 * 编辑-类目表js
 */
var vm = new Vue({
	el:'#dpLTE',
	data: {
        liteMallCategory: {
            id: 0,
            pid:'',
            level:'L1'
        },
        categoryDatas:[]
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
		},
        getCategory:function () {
            var _self = this;
            $.ajax("../../litemall/category/getSecondCategory").then(function(response){
                _self.categoryDatas = response.rows;
            });
            /*this.$http({           //调用接口
                method:'GET',
                url:"/rms/litemall/category/getSecondCategory"  //this指data
            }).then(function(response){  //接口返回数据
                this.categoryDatas = response.data;
				console.log(response);
            },function(error){
            })*/

        },
        selectChange:function () {
            this.liteMallCategory.pid = 0;
        }
	},
    created: function () {
        this.getCategory();
    }
})