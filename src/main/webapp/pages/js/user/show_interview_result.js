/**
 * Created by King-z on 2016/10/15 0015.
 */
var Interviewid = $("body").data("interview");
$(function(){
      var result_source = [{value: "T", text: "通过"}, {value: "F", text: "未通过"}, {value: "", text: "未决定"}];
    $.ajax({
        url:"../../interview/getbyId.do",
        data:{interview:Interviewid},
        success:function(data){
            if(data.data)
            $("#interview_title").html(data.data.title);
            else
                $("#interview_title").html("面试者");
        }
    });
    $('#table').bootstrapTable({
        url: '../../result/showAllbyPage.do',
        pagination: true,
        pageSize: 5,
        cache:false,
        pageList: [5, 10,15, 20],
        showRefresh: true,
        toolbar: "#toolbar",
        search: true,
        queryParams: function (params) {
            params.interviewId=Interviewid;
            console.log(params);
            return params;
        },
        queryParamsType:'limit',
        sidePagination: 'server',
        columns: [{
            field: 'id',
            title: 'ID',
            visible: false
        }, {
            field: 'name',
            title: '姓名',
            align: 'center'
        }, {
            field: 'phone',
            title: '手机号',
            sortable: true,
            align: 'center'
        }, {
            field: 'card',
            title: '学号',
            sortable: true,
            align: 'center'
        }, {
            field: 'result',
            title: '结果',
            sortable: true,
            align: 'center',
            formatter:resultFormat
        }, {
            field: 'operate_d',
            title: '操作',
            formatter: operate_resultFormatter,
            events: operateEvent,
            align: 'center'
        }],
        onEditableSave: function (field, row, oldValue, $el) {
           /* $.ajax({
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

            });*/
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
    'click .set_result': function (e, value, row, index) {
        /*row.id*/
        layer.open({
            title:"操作结果",
            content:row.name+"是否能通过该轮面试？",
            btn:["通过","未通过","取消"],
            yes:function(index){
                console.log(1);
                setResult("T",row);
                layer.close(index);
            },
            btn2:function(index){
                setResult("F",row);
                console.log(2);
                refresh()


            },
            btn3:function(index){
                console.log(3);

                layer.close(index);
            }

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
        data:{interviewee:field.interviewee},
        async:false,
        success:function(data){
            elements=data.data;
        }
    });
    $(elements).each(function(i,value){
        table+=tr1+th1+this.name+th2+td1+this.text+td2+tr2;
    });
    table+="</tbody>";
    $("#detail_table").html(table);
}

function operate_resultFormatter(value, row, index) {
    return [
        '<a class="set_result" href="javascript:void(0)" title="操作结果">',
        '<i class="glyphicon glyphicon-pencil"></i>',
        '</a>'].join('');
}

function setResult(result,row){
    $.ajax({
        url:"../../result/set.do",
        data:{
            id:row.id,
            result:result
        },
        success:function(data){
            if(data.success){
                layer.msg(data.info);
            }else{
                layer.alert(data.info);
            }
            refresh();
        }
    });
}