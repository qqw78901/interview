/**
 * Created by King-z on 2016/10/14 0014.
 */
var FormId = $("body").data("formid");
var Interview="";
$(function () {
    $("[data-toggle='tooltip']").tooltip();
    $.ajax({
        url: "../../form/show.do",
        data: {id: FormId},
        type: "GET",
        dataType: 'JSON',
        success: function (data) {
            if (!data.data){
                $("#null_form").show();
                return;
            }
            $("#entry_form").show();
            creatForm(data.data);
        },
        error:function(){
            $("#null_form").show();
        }
    });
    $("#submit_btn").click(function(){
        /*lack of validate*/
        submitForm();
    });
    $(".fa.fa-qrcode").click(function(){
        loadQCode();
    });
    $("#qCode_modal").on('show.bs.modal',function(){
        $(".qCode").attr("src","../../qcode/get.do");
    });
    addValidate();
    bindRadio();

});

function creatForm(value) {
    Interview = value.interviewId||"";
    var theme = "<p><strong>&emsp;&emsp;" + (value.ps || '') + "</strong></p>";
    $("#th_view_title").html(value.title);
    $("#th_view_theme").html(theme);
    var content = "";
    var eleArr = value.elements;
    eleArr = eleArr.sort(sortElement);
    $(eleArr).each(function (i, ele) {
        var order = ele.orderby;
        var type = ele.type;
        var eleVal = ele.name;
        var eleId = ele.id;
        var required = ele.required=="T"?"&nbsp;(必填)":"";
        var requiredClass  =  ele.required=="T"?'required':'';
        var sonArr=[];
        switch (type){
            case "text":
                content += "                                                    <div class=\"form-group\">" +
                "                                                        <label>" + eleVal +required+
                "                                                            </label><input type=\"text\" data-thid=\"" +eleId+"\" class=\"form-control th_input " +requiredClass+
                "\" id=\"form_th_" + order + "\">" +
                "</div>";
                break;
            case "radio":
                sonArr = JSON.parse(ele.typeText);
                content+=
                    "<label>"+eleVal+required+"</label>";
                content+="                                                        <div class=\"form-group icheck th_radio\" data-thid=\"" +eleId+"\" id=\"form_th_" +order+
                "\">";
                $(sonArr).each(function(j,item){
                    content+="                                                            <div class=\"square-green\">"+
                    "                                                                <div class=\"radio\"><label>"+
                    "                                                                    <input class=\"" +requiredClass+
                    "\"tabindex=\"3\" type=\"radio\" value=\"" +item+
                    "\" name=\"form_th_" +order+ "\">"+ "" +item+ "</label>"+
                    "                                                                </div>"+
                    "                                                            </div>";
                });
                content+="</div>";
                break;
            case "textarea":
                content += "                                                    <div class=\"form-group\">" +
                "                                                        <label>" + eleVal +required+
                "                                                            </label><textarea  data-thid=\"" +eleId+"\" class=\"form-control th_input " +requiredClass+
                "\" id=\"form_th_" + order + "\"></textarea>" +
                "</div>";
                break;


        }

    });
    $("#th_view").html(content);
    initIcheck();
}
function sortElement(a, b) {
    return a.orderby * 1 - b.orderby * 1;
}

function submitForm(){
    if(!validate()){
        layer.open({
            content:"请检查输入的内容",
            closeBtn:0,
            title:["提示",'margin-top:0px;background-color: #3c91c7; color:#fff;']
        });
        return;
    }
    var push ={};
    push.name = $.trim($("#form_th_name").val());
    push.card= $.trim($("#form_th_card").val());
    push.phone= $.trim($("#form_th_phone").val());
    push.interview =Interview;
    /*start others*/
    var eleArr=[];
    $(".th_input").each(function(){
        var obj={};
        obj.thId =$(this).data('thid')*1;
        obj.text= $(this).val();
        eleArr.push(obj);
    });
    $(".th_radio").each(function(){
        var obj={};
        obj.thId = $(this).data('thid')*1;
        obj.text = $(this).find('input:checked').val();
        eleArr.push(obj);
        console.log(obj);
    });
    push.elements = eleArr;
    console.log(push);
    $.ajax({
        url:"../../enter/entry.do",
        type:"POST",
        data:JSON.stringify(push),
        dataType:"JSON",
        contentType: "application/json",
        success:function(data){
        	if(data.success){
        		 layer.open({
                     content:data.info,
                     closeBtn:0,
                     title:["提示",'margin-top:0px;background-color: #3c91c7; color:#fff;'],
                     btn:"好的",
                     shadeClose:false,
                     yes:function(index){
                         window.location.href="result.jsp?form="+FormId;
                         layer.close(index);
                         LAYER=layer.open({type:2});
                     }
                 });	
        	}else{
        		 layer.open({
                     content:data.info,
                     closeBtn:0,
                     title:["提示",'margin-top:0px;background-color: #3c91c7; color:#fff;']
                 })
        	}
           
        },
        error:function (){
            layer.open({
                content:"网络错误",
                closeBtn:0,
                title:["提示",'margin-top:0px;background-color: #3c91c7; color:#fff;']
            })
        }
    })
}

function loadQCode(){
    $("#qCode_modal").modal();
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
function addValidate(){
    $('.form-horizontal.col-xs-12.cmxform').validate({
        rules:{
            name:"required",
            card:{
                required:true,
                digits:true
            },
            phone:{
                required:true,
                Phone:true
            }
        },
        errorPlacement: function (error, element) {
            if (element.is(":radio"))
                error.appendTo(element.closest(".icheck"));
            else
                error.appendTo(element.closest('.form-group'));
        }
    });
}
function validate(){
    var result = true;
    result&=$('.form-horizontal.col-xs-12.cmxform').valid();
    $('.required').each(function(){
        result&=$(this).valid();
    });
    return result;
}
function bindRadio(){
    $(document).on('ifChecked','.required', function(e){
       $(this).valid();
    });
}