/**
 * Created by King-z on 2016/10/21 0021.
 */

$(function(){
    var InterviewId;
    $('#interview_table').bootstrapTable({
        url: '../../interview/page.do',
        pagination: true,
        cache:false,
        pageSize: 10,
        striped:true,
        pageList: [5, 10, 15, 20],
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
            $("#interview_btn").removeAttr("disabled");
        }
    });
    var $modal_1 =$('#myModal-1');
    $modal_1.on('shown.bs.modal', function () {
        $('#interview_table').bootstrapTable('resetView');
    });
    $modal_1.modal("show");
    $("#interview_btn").click(function(){
        var selected= $('#interview_table').bootstrapTable('getSelections');
        InterviewId=selected[0].id;
        interviewDetail(InterviewId);
        initResult(InterviewId);
    });
    $("#search_btn").click(function(){
        search(InterviewId);
    });
    $("#refresh_btn").click(function(){
        resetSearch(InterviewId);
    });
    bindKey();



});

function interviewDetail(id){
    $.ajax({
        url:"../../interview/getbyId.do",
        data:{interview:id},
        type:"POST",
        success:function(data){
            var interviewPo = data.data;
            $("#interview_title").html(interviewPo.title);
        }
    })
}

function initResult(interviewId){
    $('#table').bootstrapTable({
        url: '../../result/select.do',
        pagination: true,
        cache:false,
        pageSize: 5,
        striped:true,
        pageList: [5, 10, 15, 20],
        //showRefresh: true,
        toolbar: "#toolbar",
        toolbarAlign:"left",
        queryParams: function (para){
            para.interviewId = interviewId;
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

function search(interviewId){
    $('#table').bootstrapTable('refreshOptions', {
        queryParams: function (para){
            para.interviewId = interviewId;
            var arr = $("#search_inputs").serializeArray();
            $(arr).each(function(i,obj){
                para[obj.name] = obj.value;
            });
            return para;
        }
    });
}

function resetSearch(interviewId){
    $('#table').bootstrapTable('refreshOptions', {
        queryParams: function (para){
            para.interviewId = interviewId;
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