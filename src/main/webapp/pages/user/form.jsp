<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.jeff.common.*"%>
<%@ include file="../Common.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="#" type="image/png">
    <title><%=mConst.serverName%></title>
    <jsp:include page="../include/adminex_css.jsp"></jsp:include>
    <%--页面专用css--%>
    <link href="../resources/bootstrap-table/bootstrap-table.css" rel="stylesheet">
    <link href="../resources/bootstrap-table/extensions/editable/css/bootstrap-editable.css" rel="stylesheet">
    <%--pickers--%>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/adminex/js/bootstrap-datepicker/css/datepicker-custom.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/adminex/js/bootstrap-timepicker/css/timepicker.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/adminex/js/bootstrap-colorpicker/css/colorpicker.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/adminex/js/bootstrap-daterangepicker/daterangepicker-bs3.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/adminex/js/bootstrap-datetimepicker/css/datetimepicker-custom.css" />

    <%--pickers--%>
    <style type="text/css">
        .panel.grey-box {
            background: none repeat scroll 0 0 #DFDFDF;
        }
        span.month{
            font-size: 12px;
        }
        @media (max-width: 360px) {
            .qCode{
                width:100%;
            }
        }
        #form_url{
            width:80%;
            height:210px;
        }

    </style>


</head>
<body class="sticky-header">
<section>
    <%--mdzz section都不可少 少了会横向滚动--%>
<jsp:include page="../include/adminex_left.jsp"></jsp:include>
<div class="main-content">
    <jsp:include page="../include/adminex_top.jsp"></jsp:include>
    <!-- page heading start-->
    <div class="page-heading">
        <h3>
            报名表管理
        </h3>
        <ul class="breadcrumb">
            <li><a href="main.jsp">主页</a></li>
            <li class="active">报名表</li>
        </ul>
    </div>
    <!-- page heading end-->
    <!--body wrapper start-->
    <div class="wrapper">
        <div class="row">
            <div class="col-xs-12">
                <section class="panel grey-box">
                    <header class="panel-heading custom-tab dark-tab">
                        <ul class="nav nav-tabs">
                            <li class="active">
                                <a href="#manage_form" data-toggle="tab">
                                    <i class="fa fa-wrench"></i>
                                    管理
                                </a>
                            </li>
                            <li>
                                <a href="#creat_form" data-toggle="tab">
                                    <i class="fa fa-plus-circle"></i>
                                    增加
                                </a>
                            </li>

                        </ul>
                    </header>
                    <div class="panel-body">
                        <div class="tab-content">
                            <%--manage--%>
                            <div class="tab-pane active" id="manage_form">
                                <section class="panel">
                                    <div class="panel-body">
                                        <table id="table"></table>
                                        <div id="toolbar">
<%--                                            <button class="btn btn-default" type="button"
                                                    title="Add account"  href="#myModal-1" data-toggle="modal"><i
                                                    class="fa fa-plus"></i></button>--%>
                                        </div>

                                    </div>

                                </section>
                            </div>
                                <%--add--%>
                                <div class="tab-pane " id="creat_form">
                                    <div class="row">
                                        <section class="col-lg-6">
                                            <div class="panel panel-default">
                                                <header class="panel-heading">
                                                    <h5 class="panel-title">
                                                        操作
                                                    </h5>
                                                </header>
                                                <div class="panel-body">
                                                    <form class="form-horizontal col-xs-12 cmxform" role="form" id="add_th_form">
                                                        <div class="form-group">
                                                        <%--    <button class="btn  btn-default m-bot15"
                                                                    id="add_form_th" type="button">
                                                                <i class="fa fa-plus-circle"></i>
                                                                添加一个空
                                                            </button>--%>
                                                            <div class="btn-group">
                                                                <button class="btn  btn-default m-bot15 "
                                                                        id="add_form_th" type="button">
                                                                    <i class="fa fa-plus-circle"></i>
                                                                    添加默认
                                                                </button>
                                                                <button data-toggle="dropdown" class="btn btn-default dropdown-toggle" type="button">
                                                                    <span class="caret"></span>
                                                                </button>
                                                                <ul role="menu" class="dropdown-menu">
                                                                    <li><a href="javascript:" id="add_form_radio">单选</a></li>
                                                                    <li><a href="javascript:" id="add_form_check">多选</a></li>
                                                                    <li><a href="javascript:" id="add_form_selec">下拉</a></li>
                                                                </ul>
                                                            </div><!-- /btn-group -->
                                                            <button class="btn  btn-default m-bot15"
                                                                    id="del_form_th" type="button">
                                                                <i class="fa fa-trash"></i>
                                                                删除一个空
                                                            </button>
                                                            <button class="btn  btn-default m-bot15"
                                                                    id="apply_form_th" type="button">
                                                                <i class="fa fa-gavel"></i>
                                                                应用
                                                            </button>
                                                            <button class="btn  btn-default m-bot15"
                                                                    id="submit_form_th" type="button">
                                                                <i class="fa fa-paper-plane"></i>
                                                                提交
                                                            </button>
                                                        </div>
                                                        <div class="form-group">
                                                            <input type="text" class="form-control add_th_theme need_rq" id="add_input_theme" name="theme" placeholder="在此输入表格标题">
                                                        </div>
                                                        <div class="form-group">
                                                            <textarea  class="form-control add_th_theme" id="add_input_ps" name="ps" placeholder="在此输入社团描述"></textarea>
                                                        </div>
                                                        <div id="th-add-body">
                                                                 <%-- <div class="form-group">
                                                                      <div class="input-group m-bot15">
                                                                          <input type="text" class="form-control">
                                                                          <div class="input-group-btn">
                                                                              <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">Action <span class="caret"></span></button>
                                                                              <ul class="dropdown-menu pull-right">
                                                                                  <li><a >Action1</a></li>
                                                                                  <li><a >Another action2</a></li>
                                                                                  <li><a >Something else here</a></li>
                                                                              </ul>
                                                                          </div>
                                                                      </div>
                                                                  </div>
                                                            <div class="form-group">
                                                                <div class="input-group m-bot15">
                                                                    <input type="text" class="form-control">
                                                                        <span class="input-group-addon is_required"
                                                                              data-placement="top" title="是否必填">
                                                                            <div class=" minimal-blue single-row">
                                                                                <input type="checkbox" checked>
                                                                            </div>
                                                                        </span>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                      <div class="input-group m-bot15">
                                                                          <input type="text" class="form-control">
                                                                          <div class="input-group-btn">
                                                                              <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">Action <span class="caret"></span></button>
                                                                              <ul class="dropdown-menu pull-right">
                                                                                  <li><a href="#">Action</a></li>
                                                                                  <li><a href="#">Another action</a></li>
                                                                                  <li><a href="#">Something else here</a></li>
                                                                                  <li class="divider"></li>
                                                                                  <li><a href="#">Separated link</a></li>
                                                                              </ul>
                                                                          </div>
                                                                      </div>
                                                                  </div>
                                                                  <div class="form-group">
                                                                      <input type="text" class="form-control add_th_input" id="add_imput2" name="th_detail" placeholder="在此输入问题标题">
                                                                  </div>
                                                                  <div class="form-group">
                                                                      <input type="text" class="form-control add_th_input" id="add_imput3" name="th_detail"  placeholder="在此输入问题标题">
                                                                  </div>--%>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </section>
                                        <div class="col-lg-6">
                                            <section class="panel panel-default">
                                                <header class="panel-heading ">
                                                    <h5 class="panel-title">预览</h5>
                                                </header>
                                                <div class="panel-body">
                                                    <form class="form-horizontal col-xs-12">
                                                        <div id="add_th_preview_theme">
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="form_th_name">姓名 </label>
                                                            <input type="text" class="form-control" id="form_th_name">

                                                        </div>
                                                        <div class="form-group">
                                                            <label for="form_th_name">学号</label>
                                                            <input type="text" class="form-control" id="form_th_card">

                                                        </div>
                                                        <div class="form-group">
                                                            <label for="form_th_name">电话</label>
                                                            <input type="text" class="form-control" id="form_th_phone">
                                                        </div>
                                                        <div id="add_th_preview"></div>
                                        <%--                <div class="form-group icheck">
                                                            <div class="square-green">
                                                                <div class="radio"><label>
                                                                    <input tabindex="3" type="radio" name="demo-radio">
                                                                   Green Radio </label>
                                                                </div>
                                                            </div>
                                                            <div class="square-green">
                                                                <div class="radio"><label>
                                                                    <input tabindex="3" type="radio" name="demo-radio">
                                                                   12 </label>
                                                                </div>
                                                            </div>
                                                        </div>--%>

                                                    </form>

                                                </div>
                                            </section>
                                        </div>
                                    </div>
                                </div>

                        </div>
                    </div>
                </section>

                <section name="modal">
                    <div aria-hidden="true" data-backdrop="false"  aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal-1" class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                                    <h4 class="modal-title">时间设置</h4>
                                </div>
                                <div class="modal-body">
                                    <table id="interview_table"></table>
                                    <form action="#" class="form-horizontal cmxform" id="validate_time">
                                        <div class="form-group">
                                            <label class="control-label col-md-4">时间限制</label>
                                            <div class="col-md-6">
                                                <select class="form-control" id="is_time_limit">
                                                    <option value="T">限制时间</option>
                                                    <option value="F">不限时间</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div id="time_limit_input" class="">
                                            <div class="form-group">
                                                <label class="control-label col-md-4">接受报名</label>
                                                <div class="col-md-6">
                                                    <div class="input-group">
                                                        <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                                        <input class="form-control date-range-picker" type="text" name="start_Dt" id="start_Dt" readonly/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label col-md-4">截止报名</label>
                                                <div class="col-md-6">
                                                    <div class="input-group">
                                                        <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                                        <input class="form-control date-range-picker" type="text" name="end_Dt" id="end_Dt" readonly/>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                    </form>
                                </div>
                                <div class="modal-footer">
                                    <button class="btn btn-primary" type="button" id="add_form" disabled="disabled"><i class="fa fa-plus"></i>增加</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="qCode_modal" class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                                    <h4 class="modal-title">生成报名表</h4>
                                </div>
                                <div class="modal-body">
                                    <div class="row">
                                        <div class="col-xs-12 col-sm-6 text-center">
                                            <img src="" class="qCode">
                                            <br class="visible-xs">
                                            <span>二维码</span>
                                        </div>
                                        <div class="col-xs-12 col-sm-6">
                                            <div class="form-group">
                                                <label class="control-label">报名链接</label>
                                                <textarea class="form-control" id="form_url"></textarea>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button data-dismiss="modal" class="btn btn-primary" type="button" >确定</button>
                                </div>
                            </div>
                        </div>
                    </div>

                </section>
            </div>
        </div>
    </div>
    <!--body wrapper end-->
    <jsp:include page="../include/adminex_footer.jsp"></jsp:include>
</div>
    </section>
<%--js start--%>
<jsp:include page="../include/adminex_js.jsp">
    <jsp:param name="currMenu" value="<%=request.getRequestURI() %>" />
</jsp:include>
<%--页面专用插件js--%>
<%--picker--%>
<!--pickers plugins-->
<script type="text/javascript" src="<%=request.getContextPath()%>/adminex/js/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/adminex/js/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/adminex/js/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/adminex/js/bootstrap-daterangepicker/moment.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/adminex/js/bootstrap-daterangepicker/daterangepicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/adminex/js/bootstrap-colorpicker/js/bootstrap-colorpicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/adminex/js/bootstrap-timepicker/js/bootstrap-timepicker.js"></script>
<%--picker--%>
<script type="application/javascript" src="../resources/bootstrap-table/bootstrap-table.js"></script>
<script type="application/javascript" src="../resources/bootstrap-table/extensions/editable/bootstrap-table-editable.js"></script>
<script type="application/javascript" src="../resources/bootstrap-table/bootstrap-editable.js"></script>

<%--locale files after bootstrap-table.js--%>
<script type="application/javascript" src="../resources/bootstrap-table/bootstrap-table-zh-CN.js"></script>
<%--user js--%>
<script type="application/javascript" src="../js/user/creatform.js"></script>
<script type="application/javascript" src="../js/user/manage_form.js"></script>

</body>
</html>
