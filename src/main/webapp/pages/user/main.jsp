<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.jeff.common.*"%>
<%@ include file="../Common.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<%--不可缺少 用于表示html5 缺少滚动条会不显示--%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="#" type="image/png">
    <title><%=mConst.serverName%></title>
    <jsp:include page="../include/adminex_css.jsp"></jsp:include>
</head>
<body class="sticky-header">
<section>
<jsp:include page="../include/adminex_left.jsp"></jsp:include>
<div class="main-content" >
    <jsp:include page="../include/adminex_top.jsp"></jsp:include>
    <!-- page heading start-->
    <div class="page-heading">
        <h3>
            欢迎页
        </h3>
        <ul class="breadcrumb">
            <li><a>主页</a></li>
            <li class="active">欢迎页</li>
        </ul>
    </div>
    <!-- page heading end-->
    <!--body wrapper start-->
    <div class="wrapper">
        <div class="row">
            <div class="col-xs-12">
                <div class="panel deep-purple-box">
                    <div class="panel-body">
                        <h1 class="text-center">欢迎回到<%=BaseInfo.GetUserDeptName(request)%>招新管理后台</h1>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <!--body wrapper end-->
    <jsp:include page="../include/adminex_footer.jsp"></jsp:include>
</div>
</section>

<%--js start--%>
<jsp:include page="../include/adminex_js.jsp">

    <jsp:param name="currMenu" value='<%=request.getRequestURI() %>'/>
</jsp:include>
</body>
</html>
