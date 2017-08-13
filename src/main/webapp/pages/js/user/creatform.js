/**
 * Created by King-z on 2016/10/11 0011.
 */
var markInput = 0;
$(function () {
    $("#add_form_th").click(function () {
        addText();
    });
    $("#add_form_radio").click(function(){
        addRadio();
    });
    $("#add_form_check").click(function(){
       addCheck();
    });
    $("#add_form_selec").click(function(){
        addOption();
    });

    $("#apply_form_th").click(function(){
        preview();
    });
    $("#del_form_th").click(function(){
        removeOne();
    });
    $("#submit_form_th").click(function(){
        if(!Allvalid())return;
        $("#myModal-1").modal("show");
    });
    $("#is_time_limit").change(function(){
        var limit = $(this).val();
        if (limit != "F") {
            $("#time_limit_input").show();
        } else {
            $("#time_limit_input").hide();
        }
    });
    $("#add_form").click(function(){
        saveForm();
    });
    addSelect();
    loadInterview();
    addValidate();
});

function addText() {
/*    var content = "                                                        <div class=\"form-group\" id=\"add_form_group" + markInput +"\">" +
        "                                                            <input type=\"text\" name=\"th_detail\" class=\"form-control add_th_input \" id=\"add_input" + markInput +
        "\" placeholder=\"在此输入问题标题\">" +
        "                                                        </div>";*/
    var content = "                                                        <div class=\"form-group\" id=\"add_form_group" + markInput +"\">" +
        "                                                                <div class=\"input-group m-bot15\">"+
        "                                                            <input type=\"text\" name=\"th_detail\" class=\"form-control add_th_input need_rq\" data-qtype=\"text\" id=\"add_input" + markInput +
        "\" placeholder=\"在此输入问题标题\">" +
        "                                                                        <span class=\"input-group-addon is_required\""+
        "                                                                              data-placement=\"top\" title=\"是否必填\">"+
        "                                                                            <div class=\" flat-green single-row\">"+
        "                                                                                <input type=\"checkbox\" checked>"+
        "                                                                            </div>"+
        "                                                                        </span>"+
        "                                                                </div>"+
        "                                                            </div>";
    $("#th-add-body").append(content);
    markInput++;
    addTooltip();
    initIcheck();

}
function addRadio(){
    var content = "<div class='radio_div' id='add_form_group" +markInput+
        "'> <label>单选</label>";
    content += "                                                        <div class=\"form-group\" id=\"add_form_group_head" + markInput + "\">" +
    "                                                            <input type=\"text\" name=\"th_detail\" class=\"form-control add_th_input need_rq\" data-qtype=\"radio\" id=\"add_input" + markInput +
    "\" placeholder=\"在此输入单选标题\">" +
    "                                                        </div>";

    content += "                                                        <div class=\"form-group\" id=\"add_form_group_element" + markInput + "\">" +
    "                                                            <input type=\"text\" name=\"th_detail\" class=\"tags  need_rq \"  id=\"add_input_element_" + markInput +
    "\" placeholder=\"输入选项内容回车确定\">" +
    "                                                        </div>";
    content += "</div>";
    $("#th-add-body").append(content);
    $('#add_input_element_'+markInput).tagsInput({width:'auto',defaultText:'回车增加'});
    markInput++;


}

function addSelect() {
    $('input.date-range-picker').datetimepicker({
        language: 'zh-CN',
        autoclose:true, //选择日期后自动关闭
        todayBtn:true
    });
    $("#start_Dt").on('changeDate',function(ev){
        $("#end_Dt").datetimepicker('setStartDate',$(this).val()).val($(this).val());
    });
}
function addCheck(){
    var content = "<div class='check_div' id='add_form_group" +markInput+
        "'> <label>多选</label>";
    content += "                                                        <div class=\"form-group\" id=\"add_form_group_head" + markInput + "\">" +
    "                                                            <input type=\"text\" name=\"th_detail\" class=\"form-control add_th_input need_rq\" data-qtype=\"check\" id=\"add_input" + markInput +
    "\" placeholder=\"在此输入多选标题\">" +
    "                                                        </div>";

    content += "                                                        <div class=\"form-group\" id=\"add_form_group_element" + markInput + "\">" +
    "                                                            <input type=\"text\" name=\"th_detail\" class=\"tags  need_rq \"  id=\"add_input_element_" + markInput +
    "\" placeholder=\"输入选项内容回车确定\">" +
    "                                                        </div>";
    content += "</div>";
    $("#th-add-body").append(content);
    $('#add_input_element_'+markInput).tagsInput({width:'auto',defaultText:'回车增加'});
    markInput++;
}

function addOption(){
    var content = "<div class='option_div' id='add_form_group" +markInput+
        "'> <label>下拉框</label>";
    content += "                                                        <div class=\"form-group\" id=\"add_form_group_head" + markInput + "\">" +
    "                                                            <input type=\"text\" name=\"th_detail\" class=\"form-control add_th_input need_rq\" data-qtype=\"option\" id=\"add_input" + markInput +
    "\" placeholder=\"在此输入问题标题\">" +
    "                                                        </div>";

    content += "                                                        <div class=\"form-group\" id=\"add_form_group_element" + markInput + "\">" +
    "                                                            <input type=\"text\" name=\"th_detail\" class=\"tags  need_rq \"  id=\"add_input_element_" + markInput +
    "\" placeholder=\"输入选项内容回车确定\">" +
    "                                                        </div>";
    content += "</div>";
    $("#th-add-body").append(content);
    $('#add_input_element_'+markInput).tagsInput({width:'auto',defaultText:'回车增加'});
    markInput++;
}

function preview(){
    var content="";
    var element = [];

    $(".add_th_input").each(function(i,val){
        var order = i+1;
        var type = $(val).attr('data-qtype');
        var required = $(val).parent().find("input[type=checkbox]").is(":checked")?"&nbsp;(必填)":"";
        if(type=="text"){
            var eleVal = $(val).val();
            content+="                                                    <div class=\"form-group\">"+
            "                                                        <label for=\"form_th_name\">"+eleVal+required+
            "                                                            </label><input type=\"text\" class=\"form-control\" id=\"form_th_" +order+ "\">"+
            "                                                    </div>";
        }else if(type=="radio"){
            var  eleHead = $(val).val()+"&nbsp;(必填)";
            var eleArr = $(val).closest('.radio_div').find('.tags').val().split(',');
            content+=
                "<label>"+eleHead+"</label>";
            content+="                                                        <div class=\"form-group icheck\" id=\"form_th_" +order+
            "\">";
            $(eleArr).each(function(i,item){
                content+="                                                            <div class=\"square-green\">"+
                "                                                                <div class=\"radio\"><label>"+
                "                                                                    <input tabindex=\"3\" type=\"radio\" value=\"" +item+
                "\" name=\"form_th_" +order+ "\">"+ "" +item+ "</label>"+
                "                                                                </div>"+
                "                                                            </div>";
            });
            content+="</div>"
        }else if(type=="check"){
            var  eleHead1 = $(val).val()+"&nbsp;(必填)";
            var eleArr1 = $(val).closest('.check_div').find('.tags').val().split(',');
            content+=
                "<label>"+eleHead1+"</label>";
            content+="                                                        <div class=\"form-group icheck\" id=\"form_th_" +order+
            "\">";
            $(eleArr1).each(function(i,item){
                content+="                                                            <div class=\"square-green\">"+
                "                                                                <div class=\"checkbox\"><label>"+
                "                                                                    <input tabindex=\"3\" type=\"checkbox\" value=\"" +item+
                "\" name=\"form_th_" +order+ "\">"+ "" +item+ "</label>"+
                "                                                                </div>"+
                "                                                            </div>";
            });
            content+="</div>"
        }else if(type="option"){
            var  eleHead2 = $(val).val()+"&nbsp;(必填)";
            var eleArr2 = $(val).closest('.option_div').find('.tags').val().split(',');
            content+= "<label>"+eleHead2+"</label>";
            content+="<div class=\"form-group\" id=\"form_th_" +order+"\"><select class='form-control'>";
            $(eleArr2).each(function(i,item){
               content+="<option value=\"" +item+ "\">" +item+ "</option>"
            });
            content+="</select></div>"
        }
    });
    $("#add_th_preview").html(content);
    initIcheck();
    /*add theme*/
    var themearr=[];
    themearr[0]=$("#add_input_theme").val();
    themearr[1]=$("#add_input_ps").val();
    var theme="<h4 class=\"text-center\">"+themearr[0]+"</h4><p><strong>&emsp;&emsp;"+themearr[1]+"</strong></p>";
    $("#add_th_preview_theme").html(theme)

}

function removeOne(){
    if(markInput==0)return;
    $("#add_form_group"+(--markInput)).remove();
}

function saveForm(){
    /*remember to validate*/
    var selected= $('#interview_table').bootstrapTable('getSelections');
    if(!selected.length){
        layer.alert("请选择面试");return;
    }
    var interviewId=selected[0].id;
    var isLimit = $("#is_time_limit").val();
    var data ={};
    data.timeLimit = isLimit;
    if(isLimit=="T"){
        /*validate*/
        if(!$("#validate_time").valid()) return;
        data.startTime=$("#start_Dt").val();
        data.endTime = $("#end_Dt").val();
    }
    data.title=$("#add_input_theme").val();
    data.ps = $("#add_input_ps").val();
    data.interviewId=interviewId;
    var order = 1;
    var formTh =[];
    var qType;
    $(".add_th_input").each(function(i,val){
        var element = {};
        qType = $(val).attr("data-qtype");
        /*公用相同字段*/
        element.orderby = order++;
        element.isIndex ="F";
        element.name = $(val).val();
        element.type = qType;
        switch (qType){
            case "text":
                element.required=$(val).parent().find("input[type=checkbox]").is(":checked")?"T":"F";
                break;
            case "radio":
                element.required="T";
                element.typeText =JSON.stringify($(val).closest('.radio_div').find('.tags').val().split(','));
                break;
            case "check":
                element.required="T";
                element.typeText =JSON.stringify($(val).closest('.check_div').find('.tags').val().split(','));
                break;
            case "option":
                element.required="T";
                element.typeText =JSON.stringify($(val).closest('.option_div').find('.tags').val().split(','));
                break;

        }
        if(qType!='text'||qType!='textarea'){

        }
        formTh.push(element);
    });
    data.elements =formTh;
    console.log(data);
    $.ajax({
    	url:"../../form/insertForm.do",
    	type:"POST",
        data:JSON.stringify(data),
        dataType:"JSON",
        contentType: "application/json",
    	success:function(data){
            $("#myModal-1").modal('hide');
            layer.msg(data.info);
        }
    })
}

function loadInterview(){
    $('#interview_table').bootstrapTable({
        url: '../../interview/page.do',
        pagination: true,
        pageSize: 2,
        cache:false,
        striped:true,
        pageList: [2,4,6,8],
        showRefresh: true,
        formatSearch:function(){return "精准搜索名称"},
        strictSearch:false,
        detailView: false,//父子表
        clickToSelect:true,
        sidePagination: 'server',
        columns: [{
            field: 'id',
            title: 'ID',
            visible:false
        },{
            field: 'state',
            title: 'state',
            radio:true
        }, {
            field: 'title',
            title: '面试名称',
            align: 'center'
        }],
        onCheck:function(){
            $("#add_form").removeAttr("disabled");
        }
    });
}

function addValidate(){
    $("#add_th_form").validate({
        rules:{
            theme:"required",
            th_detail:"required"
        },
        errorPlacement: function (error, element) {
            if (element.is(":radio"))
                error.appendTo(element.closest(".icheck"));
            else
                error.appendTo(element.closest('.form-group'));
        }
    });
    $("#validate_time").validate({
        rules:{
            'start_Dt':"required",
            'end_Dt':"required"
        },
        errorPlacement: function (error, element) {
            if (element.is(":radio"))
                error.appendTo(element.closest(".icheck"));
            else
                error.appendTo(element.parent().parent());
        }
    })
}


/**
 * @return {boolean}
 */
function Allvalid(){
    var result=true;
    $("#add_th_form").find('.need_rq').each(function () {
        result&=$(this).valid();
    });
    if(!$(".add_th_input").length){
        layer.alert("未设置问题，请设置");
        result=false;
    }
    return result;
}

function addTooltip(){
    $('.is_required').tooltip({
        title:"是否必填",
        placement:"top"
    });
}
function initIcheck(){
    $('.flat-green input').iCheck({
        checkboxClass: 'icheckbox_flat-green',
        radioClass: 'iradio_flat-green'
    });
    $('.square-green input').iCheck({
        checkboxClass: 'icheckbox_square-green',
        radioClass: 'iradio_square-green',
        increaseArea: '20%' // optional
    });
}