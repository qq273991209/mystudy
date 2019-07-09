$(function(){
		$(".sure").click(function(){
			var accout = $("input[name=accout]").val();
			var newPwd1 = $("input[name=newPwd1]").val();
			var newPwd2 = $("input[name=newPwd2]").val();

			if(newPwd1 != newPwd2){
				alert("两次新密码输入错误");
				return;
			}
			$.ajax({
				type:"post",
				url:"insertAccountPwd",
				data:{
					"account":accout,
					"pwd":newPwd1
				},
				dataType:"json",
				success:function(){
					window.parent.location.href = "login.jsp";
				}
			});
		});
	})