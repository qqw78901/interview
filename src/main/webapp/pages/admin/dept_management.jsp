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
            社团管理
        </h3>
        <ul class="breadcrumb">
            <li><a href="index.jsp">主页</a></li>
            <li>管理</li>
            <li class="active">社团管理</li>
        </ul>
    </div>
    <!-- page heading end-->
    <!--body wrapper start-->
    <div class="wrapper">
        <div class="row">
            <div class="col-xs-12">
                <section class="panel">
                    <div class="panel-body">
                        <table id="table"></table>
                        <div id="toolbar">
                            <button class="btn btn-default" type="button"
                                    title="Add account"  href="#myModal-1" data-toggle="modal"><i
                                    class="fa fa-plus"></i></button>
                        </div>

                    </div>

                </section>
                <section name="modal">
                    <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal-1" class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                                    <h4 class="modal-title">增加社团</h4>
                                </div>
                                <div class="modal-body">

                                    <form class="form-horizontal cmxform" role="form" id="add_form">
                                        <div class="form-group">
                                            <label class="col-lg-2 col-sm-2 control-label">社团名称</label>
                                            <div class="col-lg-10">
                                                <input type="text" class="form-control" id="name" name="name" placeholder="社团名称" required="required">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-lg-offset-2 col-lg-10">
                                                <button type="button" class="btn btn-primary" id="add_btn"><i class="fa fa-plus-circle"></i>&nbsp;增加</button>
                                            </div>
                                        </div>
                                    </form>

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
<script type="application/javascript" src="../resources/bootstrap-table/bootstrap-table.js"></script>
<script type="application/javascript" src="../resources/bootstrap-table/extensions/editable/bootstrap-table-editable.js"></script>
<script type="application/javascript" src="../resources/bootstrap-table/bootstrap-editable.js"></script>
<%--locale files after bootstrap-table.js--%>
<script type="application/javascript" src="../resources/bootstrap-table/bootstrap-table-zh-CN.js"></script>
<%--user js--%>
<script type="application/javascript" src="../js/admin/dept_management.js"></script>
</body>
</html>
