$(function(){
		$(".sure").click(function(){

			var password = $("input[name=password]").val();
			var oldPwd = $("input[name=oldPwd]").val();
			var newPwd1 = $("input[name=newPwd1]").val();
			var newPwd2 = $("input[name=newPwd2]").val();
			if(password != oldPwd){
				alert("原来的密码输入错误！");
				return;
			}
			if(newPwd1 != newPwd2){
				alert("两次新密码输入错误");
				return;
			}
			$.ajax({
				type:"post",
				url:"updateAccountPwd",
				data:{
					"pwd":newPwd1
				},
				dataType:"json",
				success:function(){

					window.parent.location.href = "login.jsp";
				}
			});
		});
	})