/**
 * Created by King-z on 2016/10/11 0011.
 */
$(function(){
    $(".nav.nav-tabs li a").on('shown.bs.tab',function(e){
        if(e.target.hash=="#manage_form")
            refresh();
    });
    loadForms();
});

function loadForms(){
    $('#table').bootstrapTable({
        url: '../../form/getFormByPage.do',
        pagination: true,
        pageSize: 10,
        cache:false,
        pageList: [5, 10,15, 20],
        showRefresh: true,
        toolbar: "#toolbar",
        sidePagination: 'server',
        columns: [{
            field: 'id',
            title: 'ID',
            visible: false
        }, {
            field: 'title',
            title: '表单名称',
            editable: false,
            align: 'center'
        }, {
            field: 'name',
            title: '所属面试',
            sortable: true,
            align: 'center'
        }, {
            field: 'timeLimit',
            title: '设定时间',
            //editable: true,
            align: 'center',
            formatter:whetherFormat
        }, {
            field: 'startTime',
            title: '开始时间',
            align: 'center',
            formatter:function(value){
                if(value)return moment.unix(value/1000).format('YYYY年MM月DD日h:mm');
            }
        }, {
            field: 'endTime',
            title: '结束时间',
            align: 'center',
            formatter:function(value){
                if(value)return  moment.unix(value/1000).format('YYYY年MM月DD日h:mm');
            }
        }, {
            field: 'operate_p',
            title: '预览',
            formatter: previewFormatter,
            events: operateEvent,
            align: 'center'
        },{
            field: 'operate_c',
            title: '链接',
            formatter: creatFormatter,
            events: operateEvent,
            align: 'center'
        }, {
            field: 'operate_l',
            title: '报名者',
            formatter: lookFormatter,
            events: operateEvent,
            align: 'center'
        }, {
            field: 'operate_e',
            title: '编辑',
            formatter: commonBtnFormatter('operate_e','编辑','pencil'),
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
                url: "../../form/update.do",
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
}
function refresh() {
    $("#table").bootstrapTable("refresh");
}

window.operateEvent = {
    'click .look_form': function (e, value, row, index) {
        console.log(row);
        window.location.href = "show_result.jsp?form_id=" + row.id;
    },
    'click .preview_form': function (e, value, row, index) {
        console.log(index);
        window.open("../entry/entry.jsp?form=" + row.id);
    },
    'click .remove': function (e, value, row, index) {
        layer.confirm("确定要删除?", function () {
            $.ajax({
                url: "../../form/remove.do",
                type: "post",
                data: {id: row.id},
                success: function (data) {
                    layer.alert(data.info);
                    refresh();
                }

            })
        })
    },
    'click .creat_form': function (e, value, row, index) {
        var url = "http://"+window.location.host + "/community/pages/entry/entry.jsp?form="+row.id;
        $("#form_url").val(url);
        $(".qCode").attr("src","../../qcode/getbyform.do?form="+url);
        $("#qCode_modal").modal();
    },
    'click .operate_e':function (e,val,row,index){
        layer.alert("功能开发中");
    }

};

function lookFormatter(value, row, index) {
    return [
        '<a class="look_form" href="javascript:void(0)" title="查看报名信息">',
        '<i class="glyphicon glyphicon-log-in"></i>',
        '</a>'].join('');
}
function previewFormatter(value, row, index) {
    return [
        '<a class="preview_form" href="javascript:void(0)" title="预览报名表">',
        '<i class="glyphicon glyphicon-log-in"></i>',
        '</a>'].join('');
}
function creatFormatter(value, row, index) {
    return [
        '<a class="creat_form" href="javascript:void(0)" title="生成报名表">',
        '<i class="glyphicon glyphicon-share"></i>',
        '</a>'].join('');
}

