$(function(){
		$("#chose").change(function(){
			$("#context").html("");
			var num = $(this).val();
			for(var index=0;index<num;index++){
				var str = "<p><lable>投票类容:</lable><input type='text' name='newContext'/>"
					+"<a class='delete' href='javascript:void(0)'>删除</a></p>";

				$("#context").append(str);
				
			}
			
		});
		$(".sure").click(function(){
			var contexts = "";
			
			$("input[name='newContext']").each(
				function(){
					contexts += $(this).val() + "^";
				}
			)
			
			var sin = $("#sin").val();
			var pub = $("#pub").val();
			var title = $("input[name=title]").val();
			$.ajax({
				type:"post",
				url:"addvoteAndContext",
				
				data:{
					_method:"PUT",
					"title":title,
					"contexts":contexts,
					"sin":sin,
					"pub":pub
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
		
	});