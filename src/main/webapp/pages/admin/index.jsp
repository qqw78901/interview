<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.jeff.common.*"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="UTF-8" />
<title><%=mConst.serverName%> 版本号:<%=mConst.Version%></title>

<meta name="description" content="用户登陆页" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="<%=request.getContextPath()%>/image/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminex/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminex/fonts/css/font-awesome.min.css" />

</head>			

<STYLE>
body {
	background: #ebebeb;
	font-family: "Helvetica Neue", "Hiragino Sans GB", "Microsoft YaHei",
		"\9ED1\4F53", Arial, sans-serif;
	color: #222;
	font-size: 12px;
}

* {
	padding: 0px;
	margin: 0px;
}

.top_div {
	background: #1F7A8E;
	width: 100%;
	height: 400px;
}

.ipt {
	border: 1px solid #d3d3d3;
	padding: 10px 10px;
	width: 290px;
	border-radius: 4px;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	-webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow
		ease-in-out .15s;
	-o-transition: border-color ease-in-out .15s, box-shadow ease-in-out
		.15s;
	transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s
}

.ipt:focus {
	border-color: #66afe9;
	outline: 0;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
		rgba(102, 175, 233, .6);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
		rgba(102, 175, 233, .6)
}

a {
	text-decoration: none;
}

.tou {
	background:
		url("<%=request.getContextPath()%>/pages/resources/images/tou.png")
		no-repeat;
	width: 97px;
	height: 92px;
	position: absolute;
	top: -87px;
	left: 142px;
}

.left_hand {
	background:
		url("<%=request.getContextPath()%>/pages/resources/images/left_hand.png")
		no-repeat;
	width: 32px;
	height: 37px;
	position: absolute;
	top: -38px;
	left: 150px;
}

.right_hand {
	background:
		url("<%=request.getContextPath()%>/pages/resources/images/right_hand.png")
		no-repeat;
	width: 32px;
	height: 37px;
	position: absolute;
	top: -38px;
	right: -64px;
}

.initial_left_hand {
	background:
		url("<%=request.getContextPath()%>/pages/resources/images/hand.png")
		no-repeat;
	width: 30px;
	height: 20px;
	position: absolute;
	top: -12px;
	left: 110px;
}

.initial_right_hand {
	background:
		url("<%=request.getContextPath()%>/pages/resources/images/hand.png")
		no-repeat;
	width: 30px;
	height: 20px;
	position: absolute;
	top: -12px;
	right: -122px;
}

.left_handing {
	background:
		url("<%=request.getContextPath()%>/pages/resources/images/left-handing.png")
		no-repeat;
	width: 30px;
	height: 20px;
	position: absolute;
	top: -24px;
	left: 139px;
}

.right_handinging {
	background:
		url("<%=request.getContextPath()%>/pages/resources/images/right_handing.png")
		no-repeat;
	width: 30px;
	height: 20px;
	position: absolute;
	top: -21px;
	left: 210px;
}

#yzm {
	width: 226px;
}
.header{
background: rgb(255, 255, 255); border-radius: 10px;margin: -166px auto auto; border: 1px solid rgb(231, 231, 231); border-image: none; width: 400px; height: 280px; text-align: center;
}
@media (max-width: 420px) { 
.header{
width:100%;
}

}
</STYLE>



<BODY>
	<DIV class="top_div"></DIV>
	<DIV class="header">
		<DIV style="width: 165px; height: 230px; position: absolute;">
			<DIV class="tou"></DIV>
			<DIV class="initial_left_hand" id="left_hand"></DIV>
			<DIV class="initial_right_hand" id="right_hand"></DIV>
		</DIV>
		<h2 style="padding: 0px 0px 10px; position: relative;" class='dark'><%=mConst.serverName%></h2> 
		<P style="position: relative;" >
			<INPUT class="ipt" type="text" placeholder="请输入登陆信息" value=""
				id="loginName">
		</P>
		<p style="position: relative;">
			<input class="ipt" id="password" type="password" placeholder="请输入密码"
				value=""/>
		</P>

		<p style="position: relative;">
			<input type="number" id="yzm" name="yzm" class="ipt"
				placeholder="验证码" /> <img id="yzmImg"
				src="<%=request.getContextPath()%>/servlet/CreateImage" width="60px"
				height="28px" alt="验证码" />
		</p>
		<p style="position: relative;">
		<button class='btn btn-primary btn-lg' id="dlButtom" type='button'>登录</button>
		</p>
		<form id='loginForm'></form>

</DIV>
	
</BODY>
<script src='<%=request.getContextPath()%>/adminex/js/jquery-1.10.2.min.js'></script>

<!-- basic scripts -->

<script src="<%=request.getContextPath()%>/adminex/js/bootstrap.js"></script>
<script type="text/javascript">
			if('ontouchstart' in window) {
				document.write("<link rel='stylesheet' href='<%=request.getContextPath()%>/pages/resources/layer/mobile/need/layer.css'/>");
				document.write("<script src='<%=request.getContextPath()%>/pages/resources/layer/mobile/layer.js'>"+"<"+"/script>");

			}
			else
				document.write("<script src='<%=request.getContextPath()%>/pages/resources/layer/layer.js'>"+"<"+"/script>");
</script>

<%-- <script src="<%=request.getContextPath()%>/pages/resources/layer/layer.js"></script> --%>
<script src="<%=request.getContextPath()%>/adminex/js/jquery.validate.min.js"></script>
<script src="<%=request.getContextPath()%>/pages/js/common.js"></script>



<c:if test="${loginError !=null && loginError!='' }">
	<script type="text/javascript">
		layer.alert("${loginError}");
		</script>
</c:if>

<SCRIPT type="text/javascript">
$(function(){
	//得到焦点
	$("#password").focus(function(){
		$("#left_hand").animate({
			left: "150",
			top: " -38"
		},{step: function(){
			if(parseInt($("#left_hand").css("left"))>140){
				$("#left_hand").attr("class","left_hand");
			}
		}}, 2000);
		$("#right_hand").animate({
			right: "-64",
			top: "-38px"
		},{step: function(){
			if(parseInt($("#right_hand").css("right"))> -70){
				$("#right_hand").attr("class","right_hand");
			}
		}}, 2000);
	});
	//失去焦点
	$("#password").blur(function(){
		$("#left_hand").attr("class","initial_left_hand");
		$("#left_hand").attr("style","left:100px;top:-12px;");
		$("#right_hand").attr("class","initial_right_hand");
		$("#right_hand").attr("style","right:-112px;top:-12px");
	});
});
</SCRIPT>

<script type="text/javascript">

		jQuery(function () {
			bindkeyboard("#yzm");
			bindkeyboard("#password");
		});
		</script>
<!-- inline scripts related to this page -->
<script type="text/javascript">
			jQuery(function($) {
			 $("#dlButtom").click(function() {
				 doSubmit();
			 });			 
			});
			$("#yzmImg").click(function(){
				this.src="<%=request.getContextPath()%>/servlet/CreateImage?date=" + new Date().getTime();
			})
			
			 
			function goByForm(url){
				location.href=url;
				return true;
			}
			function doSubmit(){

			   	var loginname = $("#loginName").val();
			   	var pw = $("#password").val();
			   	var yzm  = $('#yzm').val();
				$.ajax({
					type : "POST",
					url : "<%=request.getContextPath()%>/admin/login.do",
					data : {
						loginName : loginname,
						password : pw,
						yzm : yzm
					},
					success : function(data) {
						if (data.info=="success") {
							goByForm("<%=request.getContextPath()%>/pages/admin/main.jsp");
					
						} else {
							
							layer.open({
								title:["登录失败",'margin-top:0px;background-color: #1F7A8E; color:#fff;'],
								content:data.message,
								closeBtn:0,
								success:function(){
									unbindkeyboard("#yzm");
									unbindkeyboard("#password");
								},
								yes:function(index){
									layer.close(index);
									bindkeyboard("#yzm");
									bindkeyboard("#password");			
								}
							})
					
						}
					}
				});
			}
			function bindkeyboard(seletor){
				$(seletor).on('keydown',function(e){
					   if(e.keyCode == 13){
					    
					    	doSubmit();
					   }
				});
			}
			function unbindkeyboard(seletor){
				$(seletor).off('keydown');
			}
		</script>
</html>




