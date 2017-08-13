var grid_selector = "#bigset";

//resize to fit page size
$(window).on('resize.jqGrid', function () {
	doResize(grid_selector);
})

function getParentSize(id) {
	if(!id){
		id = "#bigset";
	}
	//console.log("size");
	var parent_column = $(id).closest('[class*="col-"]');
	var adjw = $(id).data("adjw"); 
	var adjh = $(id).data("adjh"); 
	var winW, winH;
	winW =  parent_column.width();
	if(adjw ){
		winW =  winW + adjw;
	}
	winH =  300;
	if(adjh ){
		winH =  winH + adjh;
	}
	return {
		WinW : winW,
		WinH : winH
	};
}

//resize on sidebar collapse/expand
$(document).on('settings.ace.jqGrid' , function(ev, event_name, collapsed) {
	if( event_name === 'sidebar_collapsed' || event_name === 'main_container_fixed' ) {
		//setTimeout is for webkit only to give time for DOM changes and then redraw!!!
		setTimeout(function() {
			doResize(grid_selector);
		}, 0);
	}
})

 
//重置表格
function doResize(id) { //最小width设置 ：<table id="bigset" width="1800"></table>
	if(!id){
		id = "#bigset";
	}
	if(!isMobile()){
		var ss = getParentSize(id);
		var w = ss.WinW ;
		var h = ss.WinH;
		var minw = $(id).attr("width");
		if(minw!=undefined && w<minw){
			w = minw;
		}
		$(id).jqGrid('setGridWidth',w ).jqGrid('setGridHeight',h);
	}
			
}

function isMobile(){
	var flag = false;
	if( $(window).width()<768){
		flag = true;
	}
	return flag;
}

//判断浏览器
function browserRedirect() {
    var sUserAgent = navigator.userAgent.toLowerCase();
    var bIsIpad = sUserAgent.match(/ipad/i) == "ipad";
    var bIsIphoneOs = sUserAgent.match(/iphone os/i) == "iphone os";
    var bIsMidp = sUserAgent.match(/midp/i) == "midp";
    var bIsUc7 = sUserAgent.match(/rv:1.2.3.4/i) == "rv:1.2.3.4";
    var bIsUc = sUserAgent.match(/ucweb/i) == "ucweb";
    var bIsAndroid = sUserAgent.match(/android/i) == "android";
    var bIsCE = sUserAgent.match(/windows ce/i) == "windows ce";
    var bIsWM = sUserAgent.match(/windows mobile/i) == "windows mobile";
    //document.writeln("您的浏览设备为：");
    if (bIsIpad || bIsIphoneOs || bIsMidp || bIsUc7 || bIsUc || bIsAndroid || bIsCE || bIsWM) {
        //document.writeln("phone");
    } else {
        //document.writeln("pc");
    }
}
 