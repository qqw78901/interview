var t = document.documentElement.clientWidth;
window.onresize = function() {//改变窗口大小的时候会触发
	if (t != document.documentElement.clientWidth) {
		t = document.documentElement.clientWidth;
		doResize();
	}
}

function doResize() {//最小width设置 ：<table id="bigset" width="1800"></table>
	// adjw：页面宽度需要调整的值;adjh：页面高度需要调整的值
	// alert('进入doResize()');
	var ss = getPageSize();
	//alert(ss.WinH +"-"+ adjh);
	var w = ss.WinW - adjw;
	var h = ss.WinH - adjh;
	var minw = $("#bigset").attr("width");
	if(minw!=undefined && w<minw){
		w = minw;
	}
	console.log(w + " - " + minw	);
	$("#bigset").jqGrid('setGridWidth',w ).jqGrid('setGridHeight',h);
			
}
 

function getPageSize() {
	// alert('进入getPageSize()');
	// http://www.blabla.cn/js_kb/javascript_pagesize_windowsize_scrollbar.html
	var winW, winH;
	if (window.innerHeight) {// all except IE
		winW = window.innerWidth;
		winH = window.innerHeight;
	} else if (document.documentElement
			&& document.documentElement.clientHeight) {// IE 6 Strict Mode
		winW = document.documentElement.clientWidth;
		winH = document.documentElement.clientHeight;
	} else if (document.body) { // other
		winW = document.body.clientWidth;
		winH = document.body.clientHeight;
	} // for small pages with total size less then the viewport
	return {
		WinW : winW,
		WinH : winH
	};
}
