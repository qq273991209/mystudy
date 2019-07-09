$(function () {
var infoexcel =null; 
	/*alert("进来了")*/
    $('#bootstarp').bootstrapTable({
        url: 'pageExtendMobile',         //请求后台的URL（*）
        method: 'post',                      //请求方式（*）
        contentType: "application/x-www-form-urlencoded",//post请求的话就加上这个句话
        toolbar: '#toolbar',                //工具按钮用哪个容器
        striped: false,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否显示分页（*）
        sortable: true,                     //是否启用排序
        sortOrder: "asc",                   //排序方式
       // queryParams: oTableInit.queryParams,//传递参数（*）
        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber:1,                       //初始化加载第一页，默认第一页
        pageSize: 5,                       //每页的记录行数（*）
        pageList: [5, 10, 20],        //可供选择的每页的行数（*）
        //search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
        strictSearch: true,
        showColumns: true,                  //是否显示所有的列
        showRefresh: true,                  //是否显示刷新按钮
        minimumCountColumns: 2,             //最少允许的列数
        clickToSelect: true,                //是否启用点击选中行
        //height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "id",                     //每一行的唯一标识，一般为主键列
        showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
        cardView: false,                    //是否显示详细视图
        detailView: false,
        queryParams: function (params) { // 请求服务器数据时发送的参数，可以在这里添加额外的查询参数，返回false则终止请求
            return {
                pageSize:params.limit, // 每页要显示的数据条数 （params.limit）不可变表示开始数据位置 size可以变 对应后台的取值
                curPage: params.offset, // 每页显示数据的开始行号 （params.offset）不可变表示结束数据位置 cur可以变 对应后台的取值
           
                //上面两个参数后端分页不能少
                //可以加自己的参数
            }
        },
        responseHandler: function(data) {//请求得到参数处理 res是服务器返回的参数 （可以取任何变量名（和AJAX一样））
        	infoexcel = data.data.pageExtendMobile;
        	//console.log(data);
           /* alert("回来了哦")*/
            return {
                "total": data.data.pageExtendMobile.tolSize,//总条数 （"total"）不能变 插件特定解析字段 后面的值可根据实际情况做变化
                "rows": data.data.pageExtendMobile.datas //数据  （"rows"）不能变 插件特定解析字段 后面的值可根据实际情况做变化
               
            };
        },
        columns: [ {                            // table所要显示的列
        	checkbox: true
        }, {
            field: 'pre', //对象属性字段 与java对象类中字段一致
            title: '号码前七位',
            align: 'center'
        }, {
            field: 'provice',
            title: '所在省',
            align: 'center'
        }, {
            field: 'city',
            title: '所在市',
            align: 'center'
        }, {
            field: 'code',
            title: '地区编号',
            align: 'center'

        },{
            field: 'postcode',
            title: '邮编',
            align: 'center'

        },{
            field: 'operators',
            title: '所属运营商',
            align: 'center'
           /* formatter:addFunctionAlty,//表格中增加按钮
            events:{            	
                "click #info":function(e,value,row,index) {
                	 console.log(row);
                    $("#id").val(row.id);
                    $("#name").val(row.name);
                    $("#phone").val(row.phone);
                    $("#address").val(row.address);
                    
                }
            	
            	}*/

            //给按钮注册事件  "click #btn_delete" 对应事件 和选择器
        }]
    });


    function addFunctionAlty(value, row, index) {
        return [
      	"<button id='info' type='button' class='btn btn-info btn-sm' data-toggle='modal' data-target='#myModal'>查看</button>"
        ].join('');
        
    }

    $("#btn").click(function(){
    	
    	$("body").append("<form action='pageExceltendMobile' method='post'><input type='hidden' name='pageSize' value='"+infoexcel.pageSize+"'><input type='hidden' name='curPage' value='"+infoexcel.curPage+"'></form>")
    	$("form").submit();
    	/* $.ajax({
				type : "post",
				url : "pageExceltendMobile",
				dataType : "binary",
				data:{"pageSize":infoexcel.pageSize,"curPage":infoexcel.curPage},
				async : false,
				success : function(data) {
					//alert(data);
				}
    	 })*/
    })
    
    })
