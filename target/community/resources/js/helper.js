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
	    height = iframe.contentWindow.document.documentElement.scrollHeight;//����iframe�ڻ���¸߶�
	    iframe.height = Math.max(height,405);//445
	   }
	   else if (iframe.Document && iframe.Document.body.scrollHeight)
	   {
	    height = iframe.Document.body.scrollHeight;//����iframe��ie�µĸ߶�
	    iframe.height = Math.max(height,405);//445
	   }
	}catch(e){}
	
	if (parent != null){
		resetIframe(window.parent.document.getElementById(parent));
	}
}

//Ϊ�ӵ�����ӵ��Ч��
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