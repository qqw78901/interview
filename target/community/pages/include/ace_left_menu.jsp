<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*"%>

			<!-- #section:basics/sidebar 左菜单-->
			<div id="sidebar" class="sidebar  responsive">
				<script type="text/javascript">
					try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
				</script>
				<!-- 顶部图片按钮-->
				<div class="sidebar-shortcuts" id="sidebar-shortcuts"  > 
					<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
						<button class="build btn btn-success " data-rel="tooltip" title="功能开发中..." data-placement="top">
							<i class="ace-icon fa fa-signal"></i>
						</button>
						<button class="build btn btn-info" data-rel="tooltip" title="功能开发中..." data-placement="top">
							<i class="ace-icon fa fa-pencil"></i>
						</button>

						<!-- #section:basics/sidebar.layout.shortcuts -->
						<button class="build btn btn-warning" data-rel="tooltip" title="功能开发中..." data-placement="top">
							<i class="ace-icon fa fa-users"></i>
						</button>

						<button id="saleBtn" class="build btn btn-danger" data-rel="tooltip" title="功能开发中..." data-placement="top">
							<i class="ace-icon fa fa-cogs"></i>
						</button>

						<!-- /section:basics/sidebar.layout.shortcuts -->
					</div>

					<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
						<span class="btn btn-success"></span>

						<span class="btn btn-info"></span>

						<span class="btn btn-warning"></span>

						<span class="btn btn-danger"></span>
					</div>
				</div><!-- /.sidebar-shortcuts -->
				<!-- 左菜单开始 active open -->
				<ul id="leftMenu" class="nav nav-list">
					<%-- <li class="active">
						<a href="<%=request.getContextPath()%>/index.jsp" >
							<i class="menu-icon fa fa-tachometer"></i>
							<span class="menu-text">首页</span>
						</a>
						<b class="arrow"></b>
					</li> 
					<li class="active">
						<a href="<%=request.getContextPath()%>/index.jsp" >
							<i class="menu-icon fa fa-tachometer"></i>
							<span class="menu-text">首页</span>
						</a>
						<b class="arrow"></b>
					</li>  --%>

				</ul><!-- /.nav-list -->

				<!-- #section:basics/sidebar.layout.minimize -->
				<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
					<i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>

				<!-- /section:basics/sidebar.layout.minimize -->
				<script type="text/javascript">
					try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
				</script>
			</div>
 
			<!-- /section:basics/sidebar --> 	 
			