
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*"%>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
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
<script src="<%=request.getContextPath()%>/pages/resources/layer/layer.js"></script>
<%--icheck--%>
<script src="<%=request.getContextPath()%>/adminex/js/iCheck/jquery.icheck.js"></script>
<script src="<%=request.getContextPath()%>/adminex/js/icheck-init.js"></script>
<!--icheck -->
<!--tags input-->
<script src="<%=request.getContextPath()%>/adminex/js/jquery-tags-input/jquery.tagsinput.js"></script>
<!--common scripts for all pages-->
<script src="<%=request.getContextPath()%>/adminex/js/scripts.js"></script>
<script src="<%=request.getContextPath()%>/pages/js/common.js"></script>

<script type="application/javascript">
    var currMenu = '${param.currMenu}';
        $(".nav").find("a").each(function() {
            if ($(this).attr('href') == currMenu) {
            	 if ($(this).parent().parent().hasClass('sub-menu-list')) {
                     $(this).closest('.menu-list').addClass('nav-active');
                 }
                $(this).closest('li').addClass('active');
               
            }
        });
        $(".Logout_btn").click(function(){
        	layer.open({
        		content:"确认注销?",
        		btn:["确认","取消"],
        		yes:function(index){
            		layer.close(index);
            		$.ajax({
            			url:"<%=request.getContextPath()%>/admin/logout.do",
            			success:function(){
            				window.location.reload();
            			},
            			error:function(){
            				layer.open({
            					title:"网络连接失败",
            					content:"请检查你的网络连接"
            				});
            			
            			}
            		})
            	}
        	})
        	
        });
	layer.config({
	skin: 'layui-layer-molv', //样式类名
	closeBtn:0
    });
</script>
