<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
	window.jQuery
			|| document
					.write("<script src='<%=this.getServletContext().getContextPath()%>/assets/js/jquery.min.js'>"
							+ "<"+"/script>");
</script>
<!-- <![endif]-->
<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='<%=this.getServletContext().getContextPath()%>/assets/js/jquery1x.min.js'>"+"<"+"/script>");
</script>
<![endif]-->
<script type="text/javascript">
	if ('ontouchstart' in document.documentElement)
		document
				.write("<script src='<%=this.getServletContext().getContextPath()%>/assets/js/jquery.mobile.custom.min.js'>"
						+ "<"+"/script>");
</script>
<script
	src="<%=this.getServletContext().getContextPath()%>/assets/js/bootstrap.min.js"></script>
<!-- page specific plugin scripts -->
<!-- ace scripts -->
<script
	src="<%=this.getServletContext().getContextPath()%>/assets/js/ace-elements.min.js"></script>
<script
	src="<%=this.getServletContext().getContextPath()%>/assets/js/ace.min.js"></script>