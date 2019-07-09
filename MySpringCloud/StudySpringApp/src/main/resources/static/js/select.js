$(function(){
		$(".btn").click(function(){

			$.ajax({
				type:"get",
				url:"voteDisplayByCondition",
				dataType:"json",
				data:{
					'condition':$("input[name=condition]").val()
				},
				success:displayVote
			});
		});
	});
	function displayVote(data){
		var str = "<table class='table table-bordered'><tr><td>投票编号</td><td>投票主题</td>"+
				"<td>创建时间</td><td>创建人</td><td>投票状态</td>"+
				" <td>投票类型</td><td>编辑</td></tr>";
				console.log(data);
		var votes = data.data["votes"];
		
		for(var index = 0;index < votes.length;index++){
			str += "<tr>";
			str += "<td>" + votes[index].vote_id +"</td>";
			str += "<td>" + votes[index].title +"</td>";
			str += "<td>" + votes[index].createdate +"</td>";
			str += "<td>" + votes[index].adminName +"</td>";
			str += "<td>" + votes[index].publish +"</td>";
			str += "<td>" + votes[index].type +"</td>";
			str += "<td><a class='check' id='"+votes[index].vote_id+"' href='javascript:void(0)'>编辑</a></td>";
			str += "</tr>";
		}
		str += "</table>";
		$("#context").html(str);
		$(".check").click(function(){
			$(location).attr("href","updateManage.jsp?id="+$(this).attr("id"));
		});
	}