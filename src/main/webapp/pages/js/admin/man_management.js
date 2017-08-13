$(function () {
    var rs = getDeptList();
    var dept_source = loadDept(rs);
    var grade_source = [{value: "1", text: "超级管理员"}, {value: "2", text: "主要负责人"}, {value: "3", text: "次要负责人"}];
    var sex_source = [{value: "T", text: "男"}, {value: "F", text: "女"}];
    validateAdd();

    $('#table').bootstrapTable({
        url: '../../user/page.do',
        pagination: true,
        cache:false,
        pageSize: 5,
        pageList: [5, 10,15, 20],
        showRefresh: true,
        toolbar: "#toolbar",
        search: true,
        formatSearch:function(){return "精准搜索账号"},
        sidePagination: 'server',
        columns: [{
            field: 'id',
            title: 'ID',
            visible: false
        }, {
            field: 'name',
            title: '姓名',
            editable: true,
            align: 'center'
        }, {
            field: 'sex',
            title: '性别',
            sortable: true,
            editable: {
                type: 'select',
                title: '性别',
                source: sex_source
            },
            align: 'center'
        }, {
            field: 'loginName',
            title: '账号',
            align: 'center'
        }, {
            field: 'card',
            title: '证件号',
            editable: true,
            align: 'center'
        }, {
            field: 'phone',
            title: '手机',
            editable: true,
            align: 'center'
        }, {
            field: 'deptId',
            title: '所在社团',
            editable: {
                type: "select",
                title: "所在社团",
                source: dept_source
            },
            align: 'center'
        }, {
            field: 'gradeId',
            title: '系统角色',
            editable: {
                type: "select",
                title: "系统角色",
                source: grade_source
            },
            align: 'center'
        }, {
            field: 'operate_p',
            title: '密码',
            formatter: resetpswFormatter,
            events: operateEvent,
            align: 'center'
        }, {
            field: 'operate_d',
            title: '删除',
            formatter: deleteFormatter,
            events: operateEvent,
            align: 'center'
        }],
        onEditableSave: function (field, row, oldValue, $el) {
            $.ajax({
                type: "post",
                url: "../../user/update.do",
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
            url: '../../user/add.do',
            data: dt,
            success: function (data) {
                $("#myModal-1").modal('hide');
                $fm[0].reset();
                $('input').iCheck('update');
                layer.msg(data.info);
                refresh();
            }
        })
    });
});

function getDeptList() {
    var rs = [];
    $.ajax({
        url: "../../dept/list.do",
        type: "get",
        async: false,
        success: function (data) {
            rs = data.data;
        }
    });
    return rs;

}

function deptid2Name(value, rs) {
    var name = "";
    $(rs).each(function (i, val) {
        if (val.id == value)
            name = val.name;
    });
    return name;
}

function loadDept(rs) {
    var result = [];
    $(rs).each(function (i, val) {
        var newoptions = new Option(val.name, val.id);
        $("#dept")[0].options.add(newoptions);
        result.push({value: val.id, text: val.name});
    });
    return result;

}

function validateAdd() {
    // validate signup form on keyup and submit
    var validator = $("#add_form").validate({
        rules: {
            name: "required",
            sex: "required",
            loginName: {
                required: true,
                remote: {
                    url: "../../user/check.do",         //后台处理程序
                    type: "post",                             //数据发送方式
                    dataType: "json",                     //接受数据格式
                    data: {                                         //要传递的数据，默认已传递应用此规则的表单项
                        loginName: function () {
                            return $.trim($("#loginName").val());
                        }
                    }
                }
            }
        },
        messages: {
            loginName: {
                required: "用户名不能为空",
                remote: "用户名重复"
            },
            sex: "请选择性别"
        },
        errorPlacement: function (error, element) {
            if (element.is(":radio"))
                error.appendTo(element.closest(".icheck"));
            else
                error.appendTo(element.parent());
        }
    });
}

window.operateEvent = {
    'click .change_psw': function (e, value, row, index) {
        layer.prompt({
            formType: 1,
            title: "密码重置"
        }, function (val, ind, ele) {
            $.ajax({
                url: '../../user/update.do',
                data: {id: row.id, password: $.trim(val)},
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
            })
        })
    },
    'click .remove': function (e, value, row, index) {
        layer.confirm("确定要删除?", function () {
            $.ajax({
                url: "../../user/remove.do",
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
