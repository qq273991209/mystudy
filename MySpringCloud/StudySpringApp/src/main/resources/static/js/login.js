$(function(){
		$("#btn").click(function(){
			var name=$("input[name=name]").val();
			var password = $("input[name=password]").val();
			$.ajax({
				type:"get",
				url:"login",
				data:{
					"name":name,
					"password":password
				},
				dataType:"json",
				success:login
			});
		});
	});
	
	function login(data){
		if(data.code==200){
			$(location).attr("href","index.jsp");
		}else{
			alert("账号或密码错误！");
		}
	}