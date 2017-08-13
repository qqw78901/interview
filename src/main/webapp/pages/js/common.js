/*common function*/
$.extend($.validator.messages, {
    required: "必填字段",
    remote: "请修正该字段",
    email: "请输入正确格式的电子邮件",
    url: "请输入合法的网址",
    date: "请输入合法的日期",
    dateISO: "请输入合法的日期 (ISO).",
    number: "请输入合法的数字",
    digits: "只能输入整数",
    creditcard: "请输入合法的信用卡号",
    equalTo: "请再次输入相同的值",
    accept: "请输入拥有合法后缀名的字符串",
    maxlength: $.validator.format("请输入一个长度最多是 {0} 的字符串"),
    minlength: $.validator.format("请输入一个长度最少是 {0} 的字符串"),
    rangelength: $.validator.format("请输入一个长度介于 {0} 和 {1} 之间的字符串"),
    range: $.validator.format("请输入一个介于 {0} 和 {1} 之间的值"),
    max: $.validator.format("请输入一个最大为 {0} 的值"),
    min: $.validator.format("请输入一个最小为 {0} 的值")
});

$(function () {
    var LAYER;
    $(document).ajaxStart(function () {
    	try{
    		  LAYER = layer.load(2);
    	}
    	catch(e){
    		console.log("fali to layer.load");
            LAYER=layer.open({type:2});
    	}
      
    });
    $(document).ajaxComplete(function () {
    	try{
    		  layer.close(LAYER);
    	}
    	catch(e){
    		console.log("fali to layer.load");
    	}
      
    })
});

function sexFormat(value, row, index) {
    return value == "T" ? "男" : "女";
}

function whetherFormat(value, row, index) {
    return value == "T" ? "是" : "否";
}

function gradeFormat(value) {
    if (value == "1") return "超级管理员";
    if (value == "2") return "主要负责人";
    if (value == "3") return "次要负责人";
    return "不合法";
}

function resultFormat(value) {
    if (value == "T") return "<span class='green'>通过</span>";
    if (value == "F") return "<span class='red'>未通过</span>";
    return "<span class='light_blue'>未决定</span>";
}

function deleteFormatter(value, row, index) {
    return [
        '<a class="remove" href="javascript:void(0)" title="删除">',
        '<i class="glyphicon glyphicon-remove"></i>',
        '</a>'].join('');
}

function rowStyle(row, index) {
    return index % 2 == 1 ? {classes: 'info'} : {classes: 'active'};
}

function resetpswFormatter(value, row, index) {
    return [
        '<a class="change_psw" href="javascript:void(0)" title="重置密码">',
        '<i class="glyphicon glyphicon-pencil"></i>',
        '</a>'].join('');
}
function commonBtnFormatter(klass,title,gly){
        return [
            '<a class="' +klass+ '" href="javascript:void(0)" title="' +title+ '">',
            '<i class="glyphicon glyphicon-' +gly+ '"></i>',
            '</a>'].join('');
}