<%@page import="com.jeff.common.BaseInfo"%>
<%@page import="com.jeff.common.mConst"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="ThemeBucket">
  <link rel="shortcut icon" href="#" type="image/png">

  <title><%=mConst.serverName%></title>

  <link href="<%=request.getContextPath()%>/adminex/css/style.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/adminex/css/style-responsive.css" rel="stylesheet">

  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="<%=request.getContextPath()%>/adminex/js/html5shiv.js"></script>
  <script src="<%=request.getContextPath()%>/adminex/js/respond.min.js"></script>
  <![endif]-->
</head>

<body class="error-page">

<section>
    <div class="container ">

        <section class="error-wrapper text-center">
            <h1><img alt="" src="<%=request.getContextPath()%>/adminex/images/404-error.png"></h1>
            <h2>无法找到网页</h2>
            <h3>页面走丢了...</h3>
            <p><%=request.getRequestURL()%></p>
            <a class="back-btn" href="<%=request.getContextPath()%>/pages/admin/index.jsp"> 回到首页</a>
        </section>

    </div>
</section>

<!-- Placed js at the end of the document so the pages load faster -->
<script src="<%=request.getContextPath()%>/adminex/js/jquery-1.10.2.min.js"></script>
<script src="<%=request.getContextPath()%>/adminex/js/jquery-migrate-1.2.1.min.js"></script>
<script src="<%=request.getContextPath()%>/adminex/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/adminex/js/modernizr.min.js"></script>


<!--common scripts for all pages-->
<!--<script src="<%=request.getContextPath()%>/adminex/js/scripts.js"></script>-->

</body>
</html>
