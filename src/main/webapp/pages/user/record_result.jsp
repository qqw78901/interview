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
                录入面试结果
            </h3>
            <ul class="breadcrumb">
                <li><a href="main.jsp">主页</a></li>
                <li>结果</li>
                <li class="active">录入面试结果</li>
            </ul>
        </div>
        <!-- page heading end-->
        <!--body wrapper start-->
        <div class="wrapper">
            <div class="row">
                <div class="col-xs-12">
                    <div class="col-lg-6">
                        <section class="panel panel-default">
                            <%--放一个表格--%>
                            <header class="panel-heading">
                                <h5 class="panel-title" id="interview_title">&emsp;&emsp;</h5>
                            </header>
                            <div class="panel-body">
                                <table id="table"></table>
                                <div id="toolbar">
                                    <form class="form-horizontal" id="search_inputs">
                                        <div class="col-sm-6 ">
                                            <div class="input-group m-bot15">
                                                <span class="input-group-addon"><i class="fa fa-male fa-lg icon"></i></span>
                                                <input type="text" class="form-control" placeholder="姓名" name="name">
                                            </div>
                                        </div>
                                        <div class="col-sm-6 ">
                                            <div class="input-group m-bot15">
                                                <span class="input-group-addon"><i class="fa fa-book fa-lg icon"></i></span>
                                                <input type="text" class="form-control" placeholder="学号" name="card">
                                            </div>
                                        </div>
                                        <div class="col-sm-6 ">
                                            <div class="input-group m-bot15">
                                                <span class="input-group-addon"><i class="fa fa-phone fa-lg icon"></i></span>
                                                <input type="text" class="form-control" placeholder="手机号码" name="phone">
                                            </div>
                                        </div>
                                        <div class="col-sm-6 ">
                                            <button class="btn btn-default" type="button" name="refresh" title="查找" id="search_btn"><i class="fa fa-search"></i>
                                                <span class="hidden-sm hidden-md">查找</span>
                                            </button>
                                            <button class="btn btn-default" type="button" name="search" title="刷新" id="refresh_btn"><i class="fa fa-refresh"></i>
                                                <span class="hidden-sm hidden-md">刷新</span>

                                            </button>
                                        </div>
                                    </form>


                                </div>
                            </div>
                        </section>
                    </div>
                    <div class="col-lg-6">
                        <section class="panel  panel-default">
                            <header class="panel-heading">
                                <h5 class="panel-title">详细信息</h5>
                            </header>
                            <div class="panel-body">
                                <table class="table table-striped" id="detail_table">
                                    <tbody >
                                    </tbody>
                                </table>
                            </div>
                        </section>
                    </div>
                    <section name="modal">
                        <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal-1" class="modal fade">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                                        <h4 class="modal-title">时间设置</h4>
                                    </div>
                                    <div class="modal-body">
                                        <form action="#" class="form-horizontal">
                                            <div class="form-group">
                                                <label class="control-label col-md-4">时间限制</label>
                                                <div class="col-md-6">
                                                    <select class="form-control" id="is_time_limit">
                                                        <option value="T">限制时间</option>
                                                        <option value="F">不限时间</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div id="time_limit_input">
                                                <div class="form-group">
                                                    <label class="control-label col-md-4">接受报名</label>
                                                    <div class="col-md-6">
                                                        <div class="input-group">
                                                            <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                                            <input class="form-control" type="text" name="date-range-picker" id="start_Dt" readonly/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-4">截止报名</label>
                                                    <div class="col-md-6">
                                                        <div class="input-group">
                                                            <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                                            <input class="form-control" type="text" name="date-range-picker" id="end_Dt" readonly/>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                        </form>
                                    </div>
                                    <div class="modal-footer">
                                        <button data-dismiss="modal" class="btn btn-primary" type="button" id="add_form"><i class="fa fa-plus"></i>增加</button>
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
<script type="application/javascript" src="../js/user/record_result.js"></script>

</body>
</html>
