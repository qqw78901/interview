$(function () {
    //validateAdd();
    $("form").find("input").on("keydown",function(e){
        if(e.keyCode==13){
            e.preventDefault();
            $("#add_btn").click();
        }
    })
    $('#table').bootstrapTable({
        url: '../../dept/page.do',
        pagination: true,
        cache:false,
        pageSize: 5,
        pageList: [5, 10, 15, 20],
        showRefresh: true,
        toolbar: "#toolbar",
        search: true,
        formatSearch:function(){return "精准搜索名称"},
        sidePagination: 'server',
        columns: [{
            field: 'id',
            title: 'ID',
            visible: false
        }, {
            field: 'name',
            title: '社团名称',
            editable: true,
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
                url: "../../dept/update.do",
                data: row,
                dataType: 'JSON',
                success: function (data, status) {
                    if (status == "success") {
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
    $("#add_btn").click(function () {

        var $fm = $(this).closest('form');
        if (!$fm.valid())return;
        var dt = $fm.serialize();
        $.ajax({
            url: '../../dept/add.do',
            data: dt,
            success: function (data) {
                $("#myModal-1").modal('hide');
                $fm[0].reset();
                layer.msg(data.info);
                refresh();
            }
        })
    });
});

function validateAdd() {

   // validate signup form on keyup and submit
    var validator = $("#add_form").validate({
        rules: {
            name: {
                required: true,
                remote: {
                    url: "../../dept/check.do",         //后台处理程序
                    type: "post",                             //数据发送方式
                    dataType: "json",                     //接受数据格式
                    data: {                                         //要传递的数据，默认已传递应用此规则的表单项
                        name: function () {
                            return $.trim($("#name").val());
                        }
                    }
                }
            }
        },
        messages:{
            name:{
                remote: "用户名重复"
            }
        }
    });
}
window.operateEvent = {
    'click .remove': function (e, value, row, index) {
        layer.confirm("确定要删除?", function () {
            $.ajax({
                url: "../../dept/remove.do",
                type: "post",
                data: {id: row.id},
                success: function (data) {
                    layer.alert(data.info);
                    refresh();
                }

            })
        })
    }
};


function refresh() {
    $("#table").bootstrapTable("refresh");
}
