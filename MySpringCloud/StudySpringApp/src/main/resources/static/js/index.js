$(function(){
    	$("#end").click(function(){
    		$.ajax({
    			type:"get",
    			url:"end",
    			dataType:"json",
    			success:function(data){
    				$(location).attr("href","login.jsp");
    			}
    		});
    	});
        $(".account").click(function(){
            $("#conent").attr("src","account.jsp");
        });

        $(".new").click(function(){
            $("#conent").attr("src","new.jsp");
        });

        $(".select").click(function(){
            $("#conent").attr("src","select.jsp");
        });

        $(".manage").click(function(){
            $("#conent").attr("src","manage.jsp");
        });

        $(".voteIndex").click(function(){
            $("#conent").attr("src","voteIndex.jsp");
        });

		$.ajax({
			type:"get",
			url:"index",
			dataType:"json",
			success:display
		});

    });

    setInterval(function() {
        var now = (new Date()).toLocaleString();
        $('#current_time').html(now);
    }, 1000);

    function display(data){


    	var siginle = 0;
    	var check = 0;
    	var votes = data.data["votes"];
    	for(var index = 0; index < votes.length; index++){
    		if(votes[index].type==1){
    			siginle =votes[index].typeNum;
    			
    		}else if(votes[index].type==0){
    			
    			check =votes[index].typeNum;
    		}
    	}
    	$("#total").html("总共投票有："+(check+siginle)+"个");
    	$("#siginle").html("单选投票有："+siginle+"个");
    	$("#check").html("复选投票有："+check+"个");
    }
    