var removeId = new Array();
	var id;
	var type;
	var publish;
	$(function(){
		$(".btn").click(function(){
			var contexts = "";
			var falg = true;
			$("input[name='newContext']").each(
				function(){
					contexts += $(this).val() + "^";
				}
			)
			var sin = $("input[name=sin]:checked").val();
			var pub = $("input[name=pub]:checked").val();
			if(sin==type && pub == publish){
				falg = false;
			}
			
			if(removeId.length!=0){
				removeId = JSON.stringify(removeId )
			}else{
				removeId="";
			}

			$.ajax({
				type:"post",
				url:"voteContextUpdate",
				data:{
					"id":id,
					"contexts":contexts,
					"removeId":removeId,
					"sin":sin,
					"pub":pub,
					"falg":falg
				},
				dataType:"json",
				success:function(data){
					$.ajax({
						type:"get",
						url:"index",
						dataType:"json",
						success:window.parent.display
					});
					$(location).attr("href","manage.jsp")
				}
			})
		});
		$("#add").click(function(){
			var str = "<p><lable>投票类容:</lable><input type='text' name='newContext'  />"
			+"<a class='delete' href='javascript:void(0)'>删除</a></p>";

			$("#context").append(str);
		});
		id = $(location).attr("href").split("=")[1];
		$.ajax({
			type:"get",
			url:"voteContextDisplay",
			data:{
				"id":id
			},
			dataType:"json",
			success:displayManage
			
		});
	});
	
	function displayManage(data){
		console.log(data);
		var str = "";
		var voteContext = data.data["voteContext"];
		for(var index = 0;index < voteContext.length; index++){
			if(index == 0){
				$(".panel-title").html(voteContext[index].voteName);
				type = voteContext[index].voteType;
				publish = voteContext[index].votePublish;
				if(type==1){
					$("#sinA").prop("checked",true);
				}else{
					$("#sinB").prop("checked",true);
				}
				if(publish==1){
					$("#pubA").prop("checked",true);
				}else{
					$("#pubB").prop("checked",true);
				}
			}
			str += "<p><lable>投票类容:</lable><input type='text' class='allContext' value='"+ voteContext[index].context +"' readonly='readonly'/>"
			+"<a id='"+ voteContext[index].votecontext_id+"' class='delete' href='javascript:void(0)'>删除</a></p>";
		}
		$("#context").html(str);
		$("#context").on("click",".delete",function(){
			var id = $(this).attr('id');
			if(id == undefined || id == ''){
				$(this).parent().remove();
			}else{
				$(this).parent().remove();
				removeId.push(id);
			}
			
		})
	}