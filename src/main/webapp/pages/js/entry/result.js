/**
 * Created by King-z on 2016/10/21 0021.
 */
$(function(){
    var formId = $("body").data("formid");
    initResult(formId);
    $("#search_btn").click(function(){
        search(formId);
    });
    $("#refresh_btn").click(function(){
        resetSearch(formId);
    });
    bindKey();



});

/*function interviewDetail(id){
    $.ajax({
        url:"../../interview/getbyId.do",
        data:{interview:id},
        type:"POST",
        success:function(data){
            var interviewPo = data.data;
            $("#interview_title").html(interviewPo.title);
        }
    })
}*/

function initResult(formId){
    $('#table').bootstrapTable({
        url: '../../result/know.do',
        pagination: true,
        cache:false,
        pageSize: 5,
        striped:true,
        cardView:true,
        pageList: [5, 10, 15, 20],
        //showRefresh: true,
        toolbar: "#toolbar",
        toolbarAlign:"left",
        queryParams: function (para){
            para.form = formId;
            para.name="******";
            para.card="******";
            return para;
        },
        strictSearch:false,
        detailView: false,//父子表
        clickToSelect:true,
        sidePagination: 'server',
        columns: [{
            field: 'id',
            title: 'ID',
            visible:false
        },{
            field: 'name',
            title: '姓名',
            align: 'center'

        }, {
            field: 'card',
            title: '学号',
            align: 'center'
        }, {
            field: 'phone',
            title: '手机号码',
            align: 'center'
        }, {
            field: 'title',
            title: '当前面试',
            align: 'center'
        }, {
            field: 'result',
            title: '状态',
            align: 'center',
            formatter:resultFormat
        }]
    });
}

function search(form){
    if(!$('input[name="name"]').val()||!$('input[name="card"]').val()){
        layer.open({
            content:"姓名和学号均为必填",
            closeBtn:0,
            title:["提示",'margin-top:0px;background-color: #1F7A8E; color:#fff;']
        });
        return;
    }
    $('#table').bootstrapTable('refreshOptions', {
        queryParams: function (para){
            para.form = form;
            var arr = $("#search_inputs").serializeArray();
            $(arr).each(function(i,obj){
                para[obj.name] = obj.value;
            });
            return para;
        }
    });
}

function resetSearch(form){
    $('#table').bootstrapTable('refreshOptions', {
        queryParams: function (para){
            para.form = form;
            para.name="******";
            para.card="******";
            return para;
        }
    });
}

function bindKey(){
    $("#search_inputs").find("input").on('keydown',function(e){
        if(e.keyCode ==13){
            $("#search_btn").click();
        }
    });
}