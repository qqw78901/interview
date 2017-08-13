/**
 * Created by King-z on 2016/10/15 0015.
 */
var Formid = $("body").data("formid")||"gdut";
$(function(){
    $('#table').bootstrapTable({
        url: '../../interviewee/selectee.do',
        pagination: true,
        pageSize: 10,
        cache:false,
        pageList: [5, 10,15, 20],
        showRefresh: true,
        toolbar: "#toolbar",
        search: true,
        queryParams: function (params) {
            params.id=Formid;
            console.log(params);
            return params;
        },
        queryParamsType:'limit',

        //formatSearch:function(){return "精准搜索账号"},
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
            field: 'phone',
            title: '手机号',
            sortable: true,
            align: 'center'
        }, {
            field: 'operate_r',
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
        },
        onClickRow:function(field, el, row, $element){
            detail(field);
            $(el).parent().find('tr').removeClass('selected');
            $(el).addClass('selected');
        }
    });
});
function refresh() {
    $("#table").bootstrapTable("refresh");
}

window.operateEvent = {
    'click .remove': function (e, value, row, index) {
    layer.confirm("确定要删除?", function () {
        $.ajax({
            url: "../../result/remove.do",
            type: "post",
            data: {interviewee: row.id},
            success: function (data) {
                if(data.success){
                    layer.msg(data.info);
                }else{
                    layer.alert(data.info);
                }
                refresh();
            }

        })
    })
}
};

function detail(field){
    var table="<tbody>";
    var tr1="<tr>"; var tr2="</tr>";
    var th1="<th>";var th2="</th>";
    var td1="<td>";var td2="</td>";
    table+=tr1+th1+"姓名"+th2+td1+field.name+td2+tr2;
    table+=tr1+th1+"学号"+th2+td1+field.card+td2+tr2;
    table+=tr1+th1+"手机号"+th2+td1+field.phone+td2+tr2;
    var elements;
    $.ajax({
        url:"../../enter/detail.do",
        data:{interviewee:field.id},
        async:false,
        success:function(data){
            elements=data.data;
        }
    });
    $(elements).each(function(){
        table+=tr1+th1+this.name+th2+td1+this.text+td2+tr2;
    });
    table+="</tbody>";
    $("#detail_table").html(table);
}