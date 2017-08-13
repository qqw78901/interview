function resetIframe(id, parent){
	var iframe;
	if (typeof id == "object")
		iframe = id;
	else
		iframe = document.getElementById(id);
	var height;
	try{
	if(iframe.contentDocument && iframe.contentWindow.document.documentElement.scrollHeight)
	   {
	    height = iframe.contentWindow.document.documentElement.scrollHeight;//设置iframe在火狐下高度
	    iframe.height = Math.max(height,405);//445
	   }
	   else if (iframe.Document && iframe.Document.body.scrollHeight)
	   {
	    height = iframe.Document.body.scrollHeight;//设置iframe在ie下的高度
	    iframe.height = Math.max(height,405);//445
	   }
	}catch(e){}
	
	if (parent != null){
		resetIframe(window.parent.document.getElementById(parent));
	}
}

//为子导航添加点击效果
if (window.$){
	$(function(){
	$(".mainpage_headerNavBox a").click(function(e){
		var thisa = $(e.currentTarget);
		thisa.addClass("on").siblings().removeClass("on");
	}).eq(0).addClass("on");
	})
}

/*
function resetIframe(id){
    var iframe = document.getElementById(id);
    try{
    	/*
        var height = 0;
        if (iframe.contentWindow.document.documentElement){
        	height = iframe.contentWindow.document.documentElement.scrollHeight;
        }else{
        	height = iframe.contentWindow.document.body.scrollHeight;
        }
        alert(height);
        
        var bHeight = iframe.contentWindow.document.body.scrollHeight;
        var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
        var height = Math.max(bHeight, dHeight);
        height += 20;
        height = Math.max(height, 270);
        iframe.height =  height;
    }catch (ex){}
}
*/