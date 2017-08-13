<%@ page contentType="text/html;charset=UTF-8"%>
<form action="" name="myForm" id="myForm" method="post" ></form>
<input type="hidden" id="baseUrl" name="baseUrl" value="<%=request.getContextPath()%>">

<%@ page import="java.util.*"%>

		<!-- basic scripts -->
		<!--[if !IE]> -->
		
		<script type="text/javascript">
			window.jQuery || document.write("<script src='<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/jquery.js'>"+"<"+"/script>");
		</script>
       <script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/jquery-ui-1.9.2.custom.min.js"></script>
		<!-- <![endif]-->

		<!--[if IE]>
		<script type="text/javascript">
			window.jQuery || document.write("<script src='<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/jquery1x.js'>"+"<"+"/script>");
		</script>
		<![endif]-->
		<script src="<%=request.getContextPath()%>/pages/js/layer/layer.js"></script>
		<script type="text/javascript">
			<!-- 检测触摸屏设备 -->
			if('ontouchstart' in document.documentElement) document.write("<script src='<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/jquery.mobile.custom.js'>"+"<"+"/script>");
		</script>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/bootstrap.js"></script>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/dataTables/jquery.dataTables.js"></script>
        <script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/dataTables/jquery.dataTables.bootstrap.js" ></script>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/dataTables/dataTables_cn.js" ></script>
		
		
		<!-- page specific plugin scripts -->
		<%-- <script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/jquery-ui.js"></script> --%>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/fuelux/fuelux.tree.js"></script> 
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/date-time/bootstrap-datepicker.js"></script>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/jqGrid/jquery.jqGrid.js"></script>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/jqGrid/i18n/grid.locale-cn.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/pages/js/autoadj_page_jqgird_in_ace.js"></script> 
		
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/fuelux/fuelux.wizard.js"></script>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/jquery.validate.js"></script>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/additional-methods.js"></script>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/jquery.validate.messages_cn.js"></script>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/bootbox.js"></script>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/jquery.maskedinput.js"></script>
		
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/select2.js"></script>
        
		<!-- ace scripts -->
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/ace/elements.scroller.js"></script>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/ace/elements.colorpicker.js"></script>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/ace/elements.fileinput.js"></script>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/ace/elements.typeahead.js"></script>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/ace/elements.wysiwyg.js"></script>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/ace/elements.spinner.js"></script>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/ace/elements.treeview.js"></script>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/ace/elements.wizard.js"></script>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/ace/elements.aside.js"></script>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/ace/ace.js"></script>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/ace/ace.ajax-content.js"></script>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/ace/ace.touch-drag.js"></script>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/ace/ace.sidebar.js"></script>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/ace/ace.sidebar-scroll-1.js"></script>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/ace/ace.submenu-hover.js"></script>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/ace/ace.widget-box.js"></script>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/ace/ace.settings.js"></script>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/ace/ace.settings-rtl.js"></script>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/ace/ace.settings-skin.js"></script>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/ace/ace.widget-on-reload.js"></script>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/ace/ace.searchbox-autocomplete.js"></script>
		
		
		<!-- inline scripts related to this page -->

		<!-- the following scripts are used in demo only for onpage help and you don't need them -->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/css/ace.onpage-help.css" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/docs/assets/js/themes/sunburst.css" />

		<script type="text/javascript"> ace.vars['base'] = '..'; </script>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/ace/elements.onpage-help.js"></script>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/assets/js/ace/ace.onpage-help.js"></script>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/docs/assets/js/rainbow.js"></script>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/docs/assets/js/language/generic.js"></script>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/docs/assets/js/language/html.js"></script>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/docs/assets/js/language/css.js"></script>
		<script src="<%=request.getContextPath()%>/pages/js/aceadmin1.3.5/docs/assets/js/language/javascript.js"></script>	
		<script src="<%=request.getContextPath()%>/pages/js/common.js"></script>
		<%-- <script src="<%=request.getContextPath()%>/pages/js/common_iso.js"></script> --%>
<script type="text/javascript">
function goByForm(url){
	document.getElementById("myForm").action = url;
	document.getElementById("myForm").submit();
	return true;
}


jQuery(function($) {
	$("#logoutBtn").on(ace.click_event, function() {
		var appType= getAppType();
		if( appType =='A'){ 
			system.logout();
		}else if( appType =='I'){ 
			logout();
		}else{
			bootbox.confirm("确定退出吗?", function(result) {
				if(result) {
					var url ="<%=request.getContextPath()%>/logout.jsp";
					goByForm(url);
				}
			});
		}
		
	});
	
	
	$("#sidebar-shortcuts").find(".build").on(ace.click_event, function() {
		bootbox.alert("功能开发中..." );
	});
	$('[data-rel=tooltip]').tooltip({container:'body'}); //添加弹出提示
	$('[data-rel=popover]').popover({container:'body'});//与tooltip类似，扩展弹出框 添加弹出提示
});

 
//已完成页面在下面添加，未完成的页面跳转会打开新窗口
var completeUrl = [ 
	
];

var currMenu = '${param.currMenu}';
jQuery(function($) {
	$(document).ajaxStart(function(){
		layer.load(2, {shade: 0.6,time: 1000*20}); 
	}).ajaxComplete(function(){
		//layer.closeAll();
		layer.closeAll('loading');
	});
	
	//解决下拉按钮背景问题（移动端）
	$(".dropdown-menu li a").on(ace.click_event, function() {
		 var obj = $(this);
		 setTimeout( function() {
			 obj.css("background","#fff");
			}, 500 );
		
	});
	
	if($("#leftMenu")){
		$.ajax({
			url:'<%=request.getContextPath()%>/ajaxmenutree.do',
			type:'post',
			data:'type=ajax',
			success:function(data){
				//var obj=eval( "(" + data + ")" );
				var rows = JSON.parse(data.info);
				if(rows){
					var html = createMenu(rows,"1");
					$("#leftMenu").append(html); 
					//展开树枝(展开父元素)
					$(".curr_menu").parents("li").addClass("active open");
				} 
				
			}
		});	
	}
	
	
	if(isMobile()){
		$(document).on("click","a",function(){
			var url = $(this).attr("href");
			if( url && url.indexOf('#')!=0){
				 goByForm(url);
			 }else{
			 }
		}); 
		 
	}
	
	 
});

function createMenu(rows,pId){
	var html = "";
	if(pId =="1"){
		
		//console.log("currMenu:"+currMenu);
		//先添加首页
		html +="<li class='@li_class'> "+
				"		<a   href='<%=request.getContextPath()%>/main.jsp' class='' ta> "+
				"		<i class='menu-icon fa fa-home'></i> "+   
				"		<span class='menu-text'>首页</span> "+
				" 		<b class='arrow'></b>"+	
				"	</a> "+
				"	<b class='arrow '></b> "+
				"</li>";
		if(currMenu =='main.jsp'){
			html = html.replace("@li_class","active"); 
		}else{
			html = html.replace("@li_class",""); 
		}
	}
	
	for(var i in rows){//动态添加数据
		var menuId = "";
		if(rows[i].PARENT_ID== pId){
			menuId = rows[i].MENU_ID;
			html +="<li class='@li_class'> "+
			"		<a target='@target' href='<%=request.getContextPath()%>"+rows[i].MENU_URL+"' class='@a_class'> "+
			"		<i class='menu-icon @fa_class'></i> "+  //fa-desktop
			"		<span class='menu-text'>"+rows[i].MENU_NAME+"</span> "+
			" 		<b class='arrow @b_class'></b>"+	
			"	</a> "+
			"	<b class='arrow '></b> "; //
			if(jQuery.inArray(rows[i].MENU_URL, completeUrl)==-1){
				html = html.replace("@target","_blank");
			}else{
				html = html.replace("@target","_self");
			}
			//console.log("currMenu:"+currMenu +" rows[i].MENU_URL:"+rows[i].MENU_URL);
			if(currMenu ==rows[i].MENU_URL){//标记当前
				html = html.replace("@li_class","active curr_menu"); 
			}else{
				html = html.replace("@li_class",""); 
			}
			/* 
			icon-layout icon-gears
			applicationIcon application_cascadeIcon icon-basic application_doubleIcon */
			var child = createMenu(rows,menuId);
			//生成图标
			if(rows[i].ICONCLS=='icon-layout'){//功能菜单树枝
				html = html.replace("@fa_class"," fa fa-list");
			}else if(rows[i].ICONCLS=='icon-gears'){//功能菜单叶子
				html = html.replace("@fa_class"," fa fa-caret-right");
			}else if(rows[i].ICONCLS=='applicationIcon'){//报表树枝
				html = html.replace("@fa_class"," fa fa-desktop");
			}else if(rows[i].ICONCLS=='application_cascadeIcon'){//报表(报表) BRM
				html = html.replace("@fa_class"," fa fa-file-o");//fa-file-o
			}else if(rows[i].ICONCLS=='icon-basic'){//报表(类型)
				html = html.replace("@fa_class"," fa fa-list-alt");//fa-list-alt
			}else if(rows[i].ICONCLS=='application_doubleIcon'){//报表(类型)
				html = html.replace("@fa_class"," fa fa-list-alt");//fa-list-alt
			}
			if(child!=""){
				html = html.replace("@b_class"," fa fa-angle-down");
				html = html.replace("@a_class"," dropdown-toggle");
				child = "<ul class='submenu'>"+ child +"</ul>";
			}else{
				html = html.replace("@b_class"," ");
				html = html.replace("@a_class","");
			}
			
			html =	html + child+"</li>";
			
		}
		//console.log(html);
	}
	return html;
}

//-->
</script>
			 