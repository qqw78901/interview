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
            background-color: #3c91c7;
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
     /*   @media (min-width: 301px) {
            .qCode{
              width: auto;
            }
        }*/

    </style>


</head>
<body data-formid="<%=request.getParameter("form")%>">
<%=request.getRequestURL()%>
<%=request.getRequestURI()%>
<section>
    <%-- section不可少 少了会横向滚动--%>
<div>
    <!--body wrapper start-->
    <%if(request.getParameter("form")!=null){%>
    <div class="wrapper">
        <div class="row">
            <div class="col-xs-12 col-sm-8 col-sm-push-2 col-md-6 col-md-push-3 col-lg-8 col-lg-push-2" id="entry_form">
                <section class="panel">
                    <header class="panel-heading blue-box">
                        <h3 class="text-center" id=""><span id="th_view_title">报名资料填写</span>
                            <span class="tools pull-right">
                                <a href="javascript:;" data-toggle="tooltip" data-placement="bottom" title="二维码分享" class="fa fa-qrcode"></a>
                            </span>
                        </h3>

                    </header>
                    <div class="panel-body">
                        <form class="form-horizontal col-xs-12 cmxform">
                            <div id="th_view_theme">
                            </div>
                            <div class="form-group">
                                <label for="form_th_name">姓名&nbsp;(必填)</label>
                                <input type="text" class="form-control" id="form_th_name" name="name">

                            </div>
                            <div class="form-group">
                                <label for="form_th_name">学号&nbsp;(必填)</label>
                                <input type="text" class="form-control" id="form_th_card" name="card">

                            </div>
                            <div class="form-group">
                                <label for="form_th_name">手机号码&nbsp;(必填)</label>
                                <input type="text" class="form-control" id="form_th_phone" name="phone">
                            </div>
                            <div id="th_view"></div>

                        </form>

                    </div>
                    <div class="panel-footer">
                        <div class="row">
                            <div class="col-sm-8 col-sm-push-2 col-md-6 col-md-push-3 col-lg-4 col-lg-push-4">
                                <button class="btn btn-primary btn-block" type="button" id="submit_btn">
                                    提交
                                </button>
                            </div>
                        </div>
                    </div>
                </section>
                <section name="modal">
                    <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="qCode_modal" class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                                    <h4 class="modal-title">扫一扫手机报名</h4>
                                </div>
                                <div class="modal-body text-center">
                                    <img src="" class="qCode" >
                                </div>
                                <div class="modal-footer">
                                    <a  class="btn btn-primary" type="button" id="download_btn" href="<%=request.getContextPath()%>/qcode/download.do?form=<%=request.getParameter("form")%>">下载</a>
                                    <button data-dismiss="modal" class="btn btn-primary" type="button" >关闭</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
            <div class="col-xs-12 col-sm-8 col-sm-push-2 col-md-6 col-md-push-3 col-lg-8 col-lg-push-2" id="null_form">
                <section class="panel panel-default" style="margin-top: 30%">
                    <div class="panel-body">
                        <h1 class="text-center mbt-15">获取数据失败，请确认链接无误</h1>
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
<script type="application/javascript" src="<%=request.getContextPath()%>/pages/js/entry/entry.js"></script>

</body>
</html>
