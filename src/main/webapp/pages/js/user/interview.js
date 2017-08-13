var Pid;//增加下一轮面试的follow_by
var Current_tg;
var public_source = [{value: "T", text: "已激活"}, {value: "F", text: "未激活"}];
$(function () {
    //validateAdd();

    $("form").find("input").on("keydown",function(e){
        if(e.keyCode==13){
            e.preventDefault();
           $(this).closest('form').find('.form_add_btn').click();
        }
    });
    $('#table').bootstrapTable({
        url: '../../interview/page.do',
        pagination: true,
        pageSize: 5,
        cache:false,
        //striped:true,
        rowStyle:rowStyle,
        pageList: [5, 10, 15, 20],
        showRefresh: true,
        toolbar: "#toolbar",
        //search: true,
        //queryParams: { followBy:''},
        //formatSearch:function(){return "精准搜索名称"},
        strictSearch:false,
        detailView: true,//父子表
        sidePagination: 'server',
        columns: [{
            field: 'id',
            title: 'ID',
            visible: false
        }, {
            field: 'title',
            title: '面试名称',
            editable: {
                validate: function (value){
                    if(!value)return "不能为空";
                }
            },
            align: 'center'
        }, {
            field: 'isPublic',
            title: '状态',
            align: 'center',
            editable: {
                type: 'select',
                title: '只能激活一个',
                source: public_source
            }
        },{
            field: 'operate_i',
            title: '增加下轮',
            formatter: addNextFormatter,
            events: operateEvent,
            align: 'center'
        },{
            field: 'operate_in',
            title: '被面试者',
            formatter: intervieweeFormatter,
            events: operateEvent,
            align: 'center'
        },{
            field: 'operate_out',
            title: '导出',
            formatter: exportFormatter,
            events: operateEvent,
            align: 'center'
        },{
            field: 'operate_d',
            title: '删除',
            formatter: deleteFormatter,
            events: operateEvent,
            align: 'center'
        }],
        onEditableSave: function (field, row, oldValue, $el) {
            $.ajax({
                type: "post",
                url: "../../interview/change.do",
                data: row,
                dataType: 'JSON',
                success: function (data, status) {
                    if (data.success) {
                        layer.msg(data.info);
                    } else {
                        layer.alert(data.info);
                    }
                    refresh();
                },
                error: function () {
                    layer.alert('编辑失败');
                    refresh();
                }

            });
        },
        //注册加载子表的事件。注意下这里的三个参数！
        onExpandRow: function (index, row, $detail) {
            oInit.InitSubTable(index, row, $detail);
        }
    });
    $("#add_btn").click(function () {

        var $fm = $(this).closest('form');
        if (!$fm.valid())return;
        var dt = $fm.serialize();
        $.ajax({
            url: '../../interview/add.do',
            data: dt,
            success: function (data) {
                $("#myModal-1").modal('hide');
                $fm[0].reset();
                if (data.success)
                    layer.msg(data.info);
                else
                    layer.alert(data.info);
                refresh();//这个要刷新大表
            }
        })
    });
    $("#add_next_btn").click(function () {
        var $fm = $(this).closest('form');
        if (!$fm.valid())return;
        var dt = {id: Pid};
        dt.title = $.trim($("#next_title").val());
        $.ajax({
            url: '../../interview/addnext.do',
            type: "post",
            dataType: 'JSON',
            data: dt,
            success: function (data) {

                $("#myModal-2").modal('hide');
                $fm[0].reset();
                if (data.success)
                    layer.msg(data.info);
                else
                    layer.alert(data.info);
                refreshCurrent(Current_tg);
            }
        })

    })
});
//验证规则 紧接着下一轮只能有一场面试
function validateAdd() {
    /*    // validate signup form on keyup and submit
     var validator = $("#add_form").validate({
     rules: {
     name: "required"
     },
     errorPlacement: function (error, element) {
     if (element.is(":radio"))
     error.appendTo(element.closest(".icheck"));
     else
     error.appendTo(element.parent());
     }
     });*/
}
window.operateEvent = {
    'click .remove': function (e, value, row, index) {
        layer.confirm("确定要删除?", function () {
            $.ajax({
                url: "../../interview/remove.do",
                type: "post",
                data: {id: row.id},
                success: function (data) {
                    layer.alert(data.info);
                    if(data.success)
                    refreshCurrent(e.target);
                }

            })
        })
    },
    'click .addnext':function(e,value,row,index){
        $("#myModal-2").modal('show');
        $("#add_next_form")[0].reset();
        Pid = row.id;
        Current_tg = e.target;
        $("#add_next_header").html(row.title);
    },
    'click .jump2interviewee':function(e,value,row,index){
        window.location.href="show_interview_result.jsp?interview="+row.id;
    },
    'click .export_interview':function(e,value,row,index){
        window.location.href="../../result/export.do?interview="+row.id;
    }
};


function refresh() {
    $("#table").bootstrapTable("refresh");
}
function refreshCurrent(target){
    $(target).closest('table').bootstrapTable("refresh");

}
function addNextFormatter(value, row, index){
    return [
        '<a class="addnext" href="javascript:void(0)" title="增加下一轮">',
        '<i class="fa fa-plus"></i>',
        '</a>'].join('');
}
function intervieweeFormatter(value, row, index){
    return [
        '<a class="jump2interviewee" href="javascript:void(0)" title="查看/管理面试人员">',
        '<i class="fa fa-users"></i>',
        '</a>'].join('');
}


function exportFormatter(value, row, index){
    return [
        '<a class="export_interview" href="javascript:void(0)" title="导出面试人员">',
        '<i class="fa fa-cloud-download"></i>',
        '</a>'].join('');
}
//初始化子表格(无限循环)
var oInit={};
oInit.InitSubTable = function (index, row, $detail) {
    var parentid = row.id;
    var cur_table = $detail.html('<table></table>').find('table');
    $(cur_table).bootstrapTable({
        url:'../../interview/page.do',
        method: 'get',
        queryParams: { followBy: parentid },
        //ajaxOptions: { strParentID: parentid },
        clickToSelect: true,
        detailView: true,//父子表
        cache:false,
        sidePagination: 'server',
        uniqueId: "id",
        pageSize: 1,
        pageList: [1, 2],
        columns: [{
            field: 'id',
            title: 'ID',
            visible: false
        }, {
            field: 'title',
            title: '下轮面试',
            editable: true,
            align: 'center'
        }, {
            field: 'isPublic',
            title: '状态',
            align: 'center',
            editable: {
                type: 'select',
                title: '只能激活一个',
                source: public_source
            }
        },{
            field: 'operate_i',
            title: '增加下轮',
            formatter: addNextFormatter,
            events: operateEvent,
            align: 'center'
        },{
            field: 'operate_in',
            title: '被面试者',
            formatter: intervieweeFormatter,
            events: operateEvent,
            align: 'center'
        },{
            field: 'operate_out',
            title: '导出',
            formatter: exportFormatter,
            events: operateEvent,
            align: 'center'
        },{
            field: 'operate_d',
            title: '删除',
            formatter: deleteFormatter,
            events: operateEvent,
            align: 'center'
        }],
        //无线循环取子表，直到子表里面没有记录
        onExpandRow: function (index, row, $Subdetail) {
            oInit.InitSubTable(index, row, $Subdetail);
        },
        onEditableSave: function (field, row, oldValue, $el) {
            $.ajax({
                type: "post",
                url: "../../interview/change.do",
                data: row,
                dataType: 'JSON',
                success: function (data, status) {
                    if (data.success) {
                        layer.msg(data.info);
                    } else {
                        layer.alert(data.info);
                    }
                    refresh();
                },
                error: function () {
                    layer.alert('编辑失败');
                    refresh();
                }

            });
        }
    });
};
