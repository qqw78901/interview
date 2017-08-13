<%@page import="com.jeff.util.ResultMap"%>
<%@page import="com.jeff.po.Form"%>
<%@page import="com.jeff.controller.FormController"%>
<%@page import="com.jeff.controller.EnterDataController"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.jeff.common.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/image/favicon.ico" type="image/png">
    <title><%=mConst.serverName%></title>
    <jsp:include page="../include/adminex_css.jsp"></jsp:include>
    <%--页面专用css--%>
    <style type="text/css">
        .panel.blue-box {
            background: none repeat scroll 0 0 #DFDFDF;
        }

        span.month {
            font-size: 12px;
        }

        .panel-heading.blue-box {
            background-color: #1F7A8E;
            color: #ffffff;
        }
        .panel-heading.blue-box > h3{
            font-weight: bolder;
            margin-top: 10px;
            margin-bottom: 10px;
            font-family: Arial, "Open Sans", "Helvetica Neue", Helvetica, sans-serif;
            font-size: 20px;
        }
        #entry_form,#null_form{
            display: none;
        }
        @media (max-width: 340px) {
            .qCode{
                width:100%;
            }
        }
        td{
            background-color: white!important;
        }
        /*   @media (min-width: 301px) {
               .qCode{
                 width: auto;
               }
           }*/
        @media (max-width: 768px) {
            .wrapper{
                padding-left: 0;
                padding-right: 0;
            }

        }

    </style>
    <%--页面专用css--%>
    <link href="../resources/bootstrap-table/bootstrap-table.css" rel="stylesheet">


</head>
<body data-formid="<%=request.getParameter("form")%>">
<section>
    <%-- section不可少 少了会横向滚动--%>
    <div>
        <!--body wrapper start-->
        <%if(request.getParameter("form")!=null){%>
        <div class="wrapper">
            <div class="row">
                <div class="col-xs-12 col-lg-6 col-lg-offset-3">
                    <div class="">
                        <section class="panel panel-default">
                            <%--放一个表格--%>
                                <header class="panel-heading blue-box">
                                    <h3 class="text-center" id=""><span id="th_view_title">查询报名结果</span></h3>
                                </header>
                            <div class="panel-body">
                                <table id="table"></table>
                                <div id="toolbar">
                                    <form class="form-horizontal" id="search_inputs">
                                        <div class="col-sm-10 col-md-9">
                                            <div class="input-group m-bot15">
                                                <span class="input-group-addon"><i class="fa fa-male fa-lg icon"></i></span>
                                                <input type="text" class="form-control" placeholder="姓名" name="name">
                                                <span class="input-group-addon">&</span>
                                                <input type="text" class="form-control" placeholder="学号" name="card">
                                                <span class="input-group-addon"><i class="fa fa-book fa-lg icon"></i></span>
                                            </div>
                                        </div>
                                        <div class="col-sm-2 col-md-3">
                                            <button class="btn btn-default" type="button" name="refresh" title="查找" id="search_btn"><i class="fa fa-search"></i>
                                                <span class="hidden-sm hidden-md">查找</span>
                                            </button>
                                            <button class="btn btn-default" type="button" name="search" title="刷新" id="refresh_btn"><i class="fa fa-refresh"></i>
                                                <span class="hidden-sm hidden-md">重置</span>
                                            </button>
                                        </div>
                                    </form>


                                </div>
                            </div>
                        </section>
                    </div>
                    <section name="modal">
                        <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal-1" class="modal fade" data-backdrop="static" data-keyboard="false">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <%--<button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>--%>
                                        <h4 class="modal-title">选择招新活动（面试组）</h4>
                                    </div>
                                    <div class="modal-body">
                                        <table id="interview_table"></table>
                                    </div>
                                    <div class="modal-footer">
                                        <button data-dismiss="modal" class="btn btn-primary" type="button" id="interview_btn" disabled="disabled">确定</button>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </section>
                </div>
            </div>
        </div>

        <%} else{%>
        <h1>参数出错</h1>
        <%} %>
        <!--body wrapper end-->
        <jsp:include page="../include/adminex_footer.jsp"></jsp:include>
    </div>
</section>
<%--js start--%>
<%--<jsp:include page="../include/adminex_js.jsp">
    <jsp:param name="currMenu" value="<%=request.getRequestURI() %>" />
</jsp:include>--%>
<!--[if lt IE 9]>
<script src="<%=request.getContextPath()%>/adminex/js/html5shiv.js"></script>
<script src="<%=request.getContextPath()%>/adminex/js/respond.min.js"></script>
<![endif]-->

<!-- Placed js at the end of the document so the pages load faster -->
<script src="<%=request.getContextPath()%>/adminex/js/jquery-1.10.2.min.js"></script>
<script src="<%=request.getContextPath()%>/adminex/js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="<%=request.getContextPath()%>/adminex/js/jquery-migrate-1.2.1.min.js"></script>
<script src="<%=request.getContextPath()%>/adminex/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/adminex/js/modernizr.min.js"></script>
<script src="<%=request.getContextPath()%>/adminex/js/jquery.nicescroll.js"></script>
<script src="<%=request.getContextPath()%>/adminex/js/jquery.validate.min.js"></script>
<script src="<%=request.getContextPath()%>/adminex/js/validation-init.js"></script>
<script type="text/javascript">
    if('ontouchstart' in window) {
        document.write("<link rel='stylesheet' href='<%=request.getContextPath()%>/pages/resources/layer/mobile/need/layer.css'/>");
        document.write("<script src='<%=request.getContextPath()%>/pages/resources/layer/mobile/layer.js'>"+"<"+"/script>");

    }
    else
        document.write("<script src='<%=request.getContextPath()%>/pages/resources/layer/layer.js'>"+"<"+"/script>");
</script>
<!--common scripts for all pages-->
<%--icheck--%>
<script src="<%=request.getContextPath()%>/adminex/js/iCheck/jquery.icheck.js"></script>
<!--icheck -->
<script src="<%=request.getContextPath()%>/adminex/js/scripts.js"></script>
<script src="<%=request.getContextPath()%>/pages/js/common.js"></script>
<%--user js--%>
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
<script type="application/javascript" src="../js/entry/result.js"></script>

</body>
</html>
