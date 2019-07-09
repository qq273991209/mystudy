		var userno= $("#userno").html();
    	//alert(userno)
    	var socket;
    	if(typeof(WebSocket) == "undefined") {
    	    console.log("您的浏览器不支持WebSocket");
    	}else{
    	    console.log("您的浏览器支持WebSocket");

    	//实现化WebSocket对象，指定要连接的服务器地址与端口  建立连接
    	    	socket = new WebSocket("ws://127.0.0.1:9998/spring/websocket/"+1);
    	    //打开事件
    	    	socket.onopen = function() {
    	        console.log("Socket 已打开");
    	        //socket.send("ok");
    	    };
    	    //获得消息事件
    	    var info ="";
    	    socket.onmessage = function(msg) {
    	        console.log("收到服务器响应的信息："+msg.data);
//    	        var infos = msg.data.split("&");
//    	        info=infos[1];
//    	        if(info=="8"||info=="6"||info=="9"){
//    	        	 start(infos[0]+infos[2]);
//    	        }else{
//    	        	start(infos[0]+infos[2]+"<a onclick='lookinfo()' style='color: red'>点击查看</a>");
//    	        }
    	        //creatIframe("jsp/fortend/personal/CarRentalFrontPage.jsp",'出租车位');
    	        //setMessageInnerHTML(msg.data);
    	        //发现消息进入    调后台获取
    	        //getCallingList();
    	    };
    	    //关闭事件
    	    socket.onclose = function() {
    	        console.log("Socket已关闭");
    	    };
    	    //发生了错误事件
    	    socket.onerror = function() {
    	    	console.log("Socket发生了错误");
    	    }

    	    //关闭连接
    	    function closeWebSocket() {
    	        socket.close();
    	    }
    	
    	    //发送消息
    	    function send(ToSendUserId,message) {
    	    	//var message = $("#info").val();//要发送的消息内容
    	    	var now=getNowFormatDate();//获取当前时间
    	    	//document.getElementById('message').innerHTML += (now+"发送人："+userno+'<br/>'+"---"+message) + '<br/>';
    	    	//document.getElementById('message').style.color="red";
    	    	//var ToSendUserno=document.getElementById('usernoto').value; //接收人编号：4567
    	    	var messages=message+"|"+ToSendUserId//将要发送的信息和内容拼起来，以便于服务端知道消息要发给谁 
    	        socket.send(messages); 
    	    }
    	    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    	    window.onbeforeunload = function () {
    	        closeWebSocket();
    	    }
    	  		//获取当前时间
    	        function getNowFormatDate() {
    	            var date = new Date();
    	            var seperator1 = "-";
    	            var seperator2 = ":";
    	            var month = date.getMonth() + 1;
    	            var strDate = date.getDate();
    	            if (month >= 1 && month <= 9) {
    	                month = "0" + month;
    	            }
    	            if (strDate >= 0 && strDate <= 9) {
    	                strDate = "0" + strDate;
    	            }
    	            var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
    	                    + " " + date.getHours() + seperator2 + date.getMinutes()
    	                    + seperator2 + date.getSeconds();
    	            return currentdate;
    	    }
    	}