<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.jeff.common.*"%>
<%@ include file="../Common.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<body>
<jsp:include page="../include/adminex_left.jsp"></jsp:include>
<div class="main-content" >
    <jsp:include page="../include/adminex_top.jsp"></jsp:include>
    <!-- page heading start-->
    <div class="page-heading">
        Page Tittle goes here
    </div>
    <!-- page heading end-->
    <!--body wrapper start-->
    <div class="wrapper">
        Body contents goes here
    </div>
    <!--body wrapper end-->
    <jsp:include page="../include/adminex_footer.jsp"></jsp:include>
</div>

<%--js start--%>
<jsp:include page="../include/adminex_js.jsp"></jsp:include>
</body>
</html>
