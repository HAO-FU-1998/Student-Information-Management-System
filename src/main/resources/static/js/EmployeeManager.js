$(function(){
	tableObj.tableInit();   // 表格初始化	
});		
				

var tableObj;
tableObj = {
	tableInit:function(){		
		$("#employeeTable").bootstrapTable({
					url:'admin/employeeManager.do',
					toolbar:'#toolbar',
					striped:true,		//设置奇偶行不同背景色
					
					showRefresh:"ture",  //显示刷新按钮
					showToggle:"ture",  //显示格式切换按钮
					showColumns:"ture",  //显示列过滤按钮
					
					//排序相关
					sortName:'id',
					sortOrder:'asc',
					
					//分页相关
					pagination:true,  //显示分页
					pageNumber:1, 	  //初始化加载第一页
					pageSize:5,		  //每页几条数据
					pageList:[2,5,10],//可以选择的每页数量
					sidePagination:"server",//表示服务器端请求分页的数据
					
					//提交到Server的参数列表
					//分页
					queryParamsType:"undefined",//分页相关提交到服务器端的参数自定义
					queryParams:function(params){
						console.dir(params);
						//参数params中自带pageSize,pageNumber,sortName,sortOrder
						params.nameKey = $.trim($("#search_uname").val());
						params.deptName = $.trim($("#formSearch.deptName").val());
						params.isLeader = $('#formSearch input[name="status"]:checked').val();
						return params;
					},
					
					columns:[{
						field:'',
						title:'序号',
						checkbox: true
					},{
						field:'empNo',
						title:'员工编号',
						sortable: true,
					},{
						field:'name',
						title:'姓名',
						sortable: true,
					},{
						field:'dept',
						title:'所属部门',
						sortable: true,
					},
					//{field:'active' , title:'是否激活'},
					{
						field:'reportTo',
						title:'是否是领导',
						formatter:function(value, row, index){
							return value ==null ? '是':'否';
						}
					},{
						title:'操作',
						formatter : oprFun,  //使用叫做operateFormatter函数来设置该列所显示的内容
						events:operateEvents,		//设置该列按照class名称加载相应的员工动作，
					}],
					
				});
	
	}
};
			
	function oprFun(value, row, index) {
		var update = '<button type="button" class="edit btn btn-xs btn-primary"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改</button>&nbsp;&nbsp;';
		var del = '<button type="button" class="remove btn btn-xs btn-danger"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>删除</button>';
		return update + del;
	}
	window.operateEvents = { 
		'click .edit' : function(e , value , row , index) {
				console.dir(row) ;
		 },
		 'click .remove' : function(e , value , row , index) {
		}
	};