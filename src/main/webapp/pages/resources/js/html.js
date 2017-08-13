//--------------------------------------------------------------
//
// 导航栏样式调整
//
//--------------------------------------------------------------
//调整树的css与图片
//一级
$(".dtree > div:first").remove();

//查找所有一级
var lv1 = $(".dtree > .clip > .dTreeNode");
//去除左边图片，添加样式
lv1.each(function(i,v){$(v).find("a,img").eq(0).hide()});
//查找所有有孩子的一级
var lv1HasChild = lv1.filter(function(){ return $(this).next("div").is(".clip"); });
//对没有孩子的一级设置样式
lv1.not(lv1HasChild).find("a:last").addClass("leftNavTree_mainItem_nochild");

//对有孩子的设置内容
//$(function(){
lv1HasChild.each(function(i,v){
	var o = $(v);
	if (o.next("div").is(":hidden"))
		o.find("a:last").addClass("leftNavTree_mainItem").removeClass("leftNavTree_mainItem_off");
	else
		o.find("a:last").addClass("leftNavTree_mainItem_off").removeClass("leftNavTree_mainItem");
});
//});

//子级
var lvSubBox = $(".dtree > .clip > .clip > .dTreeNode");
//添加文件小图标
lvSubBox.addClass("leftNavTree_subItemBox").find("img[src$='join.gif'],img[src$='joinbottom.gif']").after('<span class="icons icon3"></span>');

//一级添加事件
//替换原有的 tree.o
$(function(){
	lv1HasChild
		.each(function(i,v){
			v = $(v);
			a = v.children("a:last");
			//处理 href 属性
			var arg = a.prop("href");
			arg = arg.match(/\((.*?)\)/)[1];
			//alert(arg);
			a.prop("href", "###").attr("treeid", arg);
	}).click(function(e){
			var o = $(e.currentTarget)
			var a = o.children("a:last");
			tree.o.call(tree, a.attr("treeid"));
			if (o.next("div").is(":visible"))
				a.addClass("leftNavTree_mainItem_off").removeClass("leftNavTree_mainItem");
			else
				a.addClass("leftNavTree_mainItem").removeClass("leftNavTree_mainItem_off");
				
	});
});


if (window.configonly != true){
	
	//--------------------------------------------------------------
	//
	// 底部快捷菜单
	//
	// 右键插件例子
	// 例子 http://joewalnes.github.com/jquery-simple-context-menu/example.html
	//
	//--------------------------------------------------------------
	
	document.writeln("<STYLE type=\"text/css\">");
	
	//180 是原高度 15 是上面bar的高度
	document.writeln("	#boxad11 {WIDTH: 148px; HEIGHT: 180px; HEIGHT: 19px;} ");
	document.writeln("  #boxad11 dd{height:160px;}");
	document.writeln("	#boxad11 dt,#boxad11 dt #AD_tit,#boxad11 dt a{height:18px;line-height:19px;}");
	document.writeln("	#closead11,#zoomad11{width:12px; height:15px;line-height:15px; display:block; }");
	
	document.writeln("    #boxad11 ul,#boxad11 dl,#boxad11 dt,#boxad11 dd{padding:0px;margin:0px;list-style-type: none;background:none; list-style:none;");
	document.writeln("    transparent;}");
	document.writeln("	#boxad11 a {color: #333333;text-decoration: none;}");
	document.writeln("	#boxad11 {PADDING: 1px 1px 0px 1px; FONT-SIZE: 12px; Z-INDEX: 300; FLOAT: right; OVERFLOW:");
	document.writeln("    hidden; background-color:#fff; ");
	document.writeln("	/* 大小 */");
	document.writeln("	RIGHT: 0px; BOTTOM: 0px; POSITION:fixed;");
	document.writeln("    _POSITION:absolute; ");
	document.writeln(" /*兼容IE6*/ <!--[if IE 6]> _TOP:expression(document.offsetParent.scrollTop+document.documentElement.clientHeight-this.offsetHeight);<![endif]--> /*兼容IE6*/}/*tit样式*/"); 
	document.writeln("	#boxad11 dt{text-align:left;cursor:pointer;background: url(../../../resources/images/quick_menu_bg.gif) no-repeat 0 0;}");
	document.writeln("	#boxad11 dt a{color:#fff;line-height:19px;height:19px;}");
	document.writeln("	#boxad11 dt #AD_tit{display:block;overflow:hidden;}");
	document.writeln("	#boxad11 dd{ background-color: #EEF4F9;display:block; margin:0 auto; overflow:auto; padding:4px");
	document.writeln("    0px 4px 0px;}");
	document.writeln("	#AD_tit{ width:70%;float:left;color:#203D5F;font-size:10pt;");
	document.writeln("	text-indent:0.8em;font-weight:bold;}");
	document.writeln("	#closead11{width:12px; float:right;}");
	document.writeln("	#zoomad11{ float:right;}");
	document.writeln("	#closead11 img{ margin-top:8px}");
	document.writeln("	#zoomad11 img{ margin-top:10px}");
	document.writeln("	#boxad11 .icon3{ margin:0 5px 0 0; }");
	document.writeln("	#boxad11 ul li{padding:5px 0 5px 4px;}");
	document.writeln("  #boxad11 .icon_quick{background-position:-60px -60px;width:12px;height:11px;margin: 4px 5px 0 13px;}");
	document.writeln("  #boxad11 .icon_quick_up{background-position:-90px -60px;width:12px;height:11px;}");
	document.writeln("#boxad11 .icon11{margin-top:-1px;width:19px;}");
	document.writeln("</STYLE>");
	document.writeln("<dl id=boxad11>");
	document.writeln("    <dt>");
	document.writeln("        <span class=\"icons icon_quick icon_quick_up\"></span><a href=\"#\" style=\"display:block;\">快捷菜单 </a>");
	document.writeln("    </dt>");
	document.writeln("    <dd>");
	document.writeln("        <ul>");
	document.writeln("		</ul>");
	document.writeln("    </dd>");
	document.writeln("</dl>");
	
	//右键菜单 demo
	//http://labs.abeautifulsite.net/archived/jquery-contextMenu/demo/
	/*
	document.writeln('<ul id="myMenuAdd" class="contextMenu">');
	document.writeln('		<li class="edit separator"><a href="#addfav">添加到快捷菜单<a><li>');
	document.writeln('</ul>');
	document.writeln('<ul id="myMenuDel" class="contextMenu">');
	document.writeln('		<li class="edit separator"><a href="#addfav">从快捷菜单删除<a><li>');
	document.writeln('</ul>');
	*/
	
	var boxad11 = $("#boxad11");
	$("dt a", boxad11).click(function(){
		if (!boxad11.is(":animated")){
			if (boxad11.height() > 100){
				$("dt span", boxad11).addClass("icon_quick_up");
				boxad11.animate({height:"19px"}, 300);
			}else{
				$("dt span", boxad11).removeClass("icon_quick_up");
				boxad11.animate({height:"180px"}, 300);
			}
		}
	});
	
	//状态维持
	//数据队列中保存的是 menu_id
	boxad11.status = (function(){
		var s = {tree:$(".dtree:eq(0)")};
		s.unis = [];
		//转移当前菜单的id为menu_id
		s.menu_id = function(id){
			var menu_id = $("#"+id).prop("href");
			//try{
			menu_id = menu_id.match(/MENU_ID\=(.*)/)[1];
			//}catch(e){return;}
			return menu_id;
		};
		//将menu_id转移为当前菜单的id
		s.from_menu_id = function(menu_id){
			var o = $("a[href$='" + menu_id + "']", s.tree);
			if (o.length > 0){
				return o.prop("id");
			}else{
				return null;
			}
		};
		//接收id，查询其menu_id，保存一下
		s.add = function(uni){
			menu_id = s.menu_id(uni);
			if (s.own(menu_id)==-1){
				s.unis.push(menu_id);
				s.update();
				return s.unis.length-1;
			}else{
				return -1;
			}
		};
		//删除其中一项数据
		//v 如果是数字，则移除第v+1个数据
		//v 如果是字符串，则是栏目的id，转移为menu_id，删除并更新
		s.del = function(v){
			if (typeof v == 'number'){
				s.unis.splice(v,1);
				s.update();
				return true;
			}else{
				menu_id = s.menu_id(v);
				v = s.own(menu_id);
				if (v != -1){
					s.unis.splice(v,1);
					s.update();
					return true;
				}
			}
			return false;
		};
		s.own = function(i){
			return $.inArray(i, s.unis);
		};
		//状态更新
		s.update = function(){
			//setCookie("leftStatus",s.unis.join(','));
			//s.updateSort();
			$.get("../../foreground/nmconfig/ajaxMenu.do?method=saveMyMenu&remark="+s.unis.join(','));
		};
		//根据当前快捷菜单，再进行排序
		s.updateSort = function(){
			s.unis = $.map( $("a", boxad11.ul), function(v){ return $(v).attr("menu_id") } );
		};
		//从状态更新菜单
		s.getStatus = function(){
			//var _unis = getCookie("leftStatus");
			var _unis = quick_menu_data;//外部数据来源，在jsp中定义，类型为数字数组
			if (_unis == null || _unis.length == 0)
				return;
			boxad11.clear();
			$.each( _unis, function(i,v){
				//将menu_id转移为当前菜单的id，并递交到 boxad11.add函数当中
				var id = s.from_menu_id(v);
				if (id != null) boxad11.add(id);
			});
		};
		return s;
	})();
	
	//添加菜单
	boxad11.ul = $("ul:first", boxad11);
	boxad11.temp = '<li><span class="icons icon3"></span>'+
	'<a id="stree13" class="node" '+
	'href="{$url}" '+
	'title="{$title}" target="framain" onclick="javascript: tree.s();">'+
	'{$title}</a></li>';
	boxad11.temp = '<li box_id="{$uni}"><span class="icons icon11"></span><a href="###" target="framain" a_id="{$id}" menu_id="{$menu_id}">{$title}</a></li>';
	boxad11.clear = function(){boxad11.ul.empty()};
	//o 可以是字符串，则查找其id, 也可以是jquery
	//
	boxad11.add = function(o){
		var id;
		if (typeof o == 'string'){
			id = o;
			o = $("#"+id);
		}else
			id = o.prop("id");
		if (o == null || o.length == 0)
			return;
		var index = boxad11.status.add(id);
		
		if (index > -1){
			boxad11.ul.append(boxad11.temp.replace("{$uni}",index)
					.replace("{$title}",o.text())
					.replace("{$id}", id)
					.replace("{$menu_id}", boxad11.status.menu_id(id))
					.replace("###", o.prop("href")));
			bindUlContext();
		}
		
	};
	//删除的可以是a标签的html，或者是 status中uni数组的index, 
	//index会在add过程执行时，保存在 box_id当中
	boxad11.del = function(o){
		boxad11.status.del(o.attr("a_id"));
		o.parent().remove();
		bindUlContext();
	};
	//设置可排序
	boxad11.sortable = function(){
		boxad11.ul.sortable({
			axis: 'y',
			update: function(){boxad11.status.updateSort();boxad11.status.update();}})
			.disableSelection();
	};
	
	//相关事件
	$(function() {
		$(".dtree a[title]").contextMenu({
			menu: 'myMenuAdd'
			},
			function(action, el, pos) {
				boxad11.add($(el));
		});
		
		boxad11.status.getStatus();
		bindUlContext();
		//奇怪
		$(".contextMenu").next("a").remove();
		$(".contextMenu li").not("[class]").remove();
		$(".contextMenu a").not("[href]").remove();
		
	});
}
//configonly == null
//重新绑定事件,绑定删除，绑定排序
function bindUlContext(){
	$("a",boxad11.ul).contextMenu({
		menu: 'myMenuDel'
		},
		function(action, el, pos) {
			e = $(el);
			if (e.prop("tagName") == "A")
				boxad11.del(e); 
		/*
		alert(
			'Action: ' + action + '\n\n' +
			'Element ID: ' + $(el).attr('id') + '\n\n' + 
			'X: ' + pos.x + '  Y: ' + pos.y + ' (relative to element)\n\n' + 
			'X: ' + pos.docX + '  Y: ' + pos.docY+ ' (relative to document)'
			);
			*/
	});
	boxad11.sortable();
}








function getCookie(name) {
    var arg = name + "=";
    var alen = arg.length;
    var clen = document.cookie.length;
    var i = 0;
    var j = 0;
    while(i < clen) {
        j = i + alen;   
        if(document.cookie.substring(i, j) == arg)
            return getCookieval_r(j);
        i = document.cookie.indexOf(" ", i) + 1;
        if(i == 0)
            break;
    } 
    return null;
}
function deleteCookie(name) {
    var exp = new Date(); 
    var cval = getCookie(name); 
    exp.setTime(exp.getTime() - 1); 
    document.cookie = name + "=" + cval + "; expires=" + exp.toGMTString();
}
var gCookieExpDays = 80;
function setCookie(name, value) {
    var argv = setCookie.arguments;
    var argc = setCookie.arguments.length;
    var exp = (argc > 2) ? argv[2] : gCookieExpDays;
    var path = (argc > 3) ? argv[3] : null;
    var domain = (argc > 4) ? argv[4] : null;
    var secure = (argc > 5) ? argv[5] : false;
    var expires = new Date();
    deleteCookie(name);
    expires.setTime(expires.getTime() + (exp*24*60*60*1000));
    document.cookie = name + "=" + encodeURIComponent( value ) +
        "; expires=" + expires.toGMTString() +
        ((domain == null) ? "" : ("; domain=" + domain)) +
        ((path == null) ? "" : ("; path=" + path)) +
        ((secure == true) ? "; secure" : "");
}
function getCookieval_r(offset) {
    var endstr = document.cookie.indexOf (";", offset);
    if(endstr == -1) {
        endstr = document.cookie.length;
    }
    return unescape(document.cookie.substring(offset, endstr));
}
