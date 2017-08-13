<%@ page import="com.jeff.common.mConst" %>
<%@ page import="com.jeff.common.BaseInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- left side start-->
<div class="left-side sticky-left-side">
<!--logo and iconic logo start-->
	<div class="logo">
		<a href="<%=request.getContextPath()%>/pages/admin/main.jsp"
			class="navbar-brand"> <small> <small> <i
					class="fa fa-cloud smaller"></i> <%=mConst.serverName%>
			</small>
		</small>
		</a>
	</div>

	<div class="logo-icon text-center">
            <a href="main.jsp"><i class="fa fa-cloud fa-3x"></i></a>
        </div>
        <!--logo and iconic logo end-->

        <div class="left-side-inner">

            <!-- visible to small devices only -->
            <div class="visible-xs hidden-sm hidden-md hidden-lg">
                <div class="media logged-user">
                    <img alt="" src="<%=request.getContextPath()%>/adminex/images/photos/user-avatar.png" class="media-object">
                    <div class="media-body">
                        <h4><a href="#"><%=BaseInfo.GetName(request) %></a></h4>
                        <span>"欢迎你   <%=BaseInfo.GetUserName(request) %>"</span>
                    </div>
                </div>

                <h5 class="left-nav-title">个人信息</h5>
                <ul class="nav nav-pills nav-stacked custom-nav">
                  <li><a href="#"><i class="fa fa-user"></i> <span>详细资料</span></a></li>
                  <li><a href="#"><i class="fa fa-cog"></i> <span>设置</span></a></li>
                  <li><a href="#" class="Logout_btn"><i class="fa fa-sign-out"></i> <span>注销</span></a></li>
                </ul>
            </div>

        <!--sidebar nav start-->
        <%
            if(BaseInfo.GetUserGradeId(request).equals("1")){
        %>
        <ul class="nav nav-pills nav-stacked custom-nav">
            <li><a href="<%=request.getContextPath()%>/pages/admin/main.jsp"><i class="fa fa-home"></i> <span>主页</span></a></li>
            <li class="menu-list"><a href=""><i class="fa fa-laptop"></i> <span>管理</span></a>
                <ul class="sub-menu-list "><!--nav-active -->
                    <li><a href="<%=request.getContextPath()%>/pages/admin/dept_management.jsp">社团管理</a></li>
                    <li><a href="<%=request.getContextPath()%>/pages/admin/man_management.jsp">人员管理</a></li>
                </ul>
            </li>
            <li><a href="<%=request.getContextPath()%>/adminex/blank_page.html"><i class="fa fa-bell"></i> <span>demoPage</span></a></li>



        </ul>
        <% }else if(BaseInfo.GetUserGradeId(request).equals("2")){ %>
        
          <ul class="nav nav-pills nav-stacked custom-nav">
            <li><a href="<%=request.getContextPath()%>/pages/user/main.jsp"><i class="fa fa-home"></i> <span>主页</span></a></li>
            <li><a href="<%=request.getContextPath()%>/pages/user/man_management.jsp"><i class="fa fa-users"></i> <span>子账号</span></a></li>
            <li><a href="<%=request.getContextPath()%>/pages/user/interview.jsp"><i class="fa fa-coffee"></i> <span>面试</span></a></li>
            <li><a href="<%=request.getContextPath()%>/pages/user/form.jsp"><i class="fa fa-laptop"></i> <span>报名表</span></a></li>
       	<%--	<li class="menu-list"><a href=""><i class="fa fa-laptop"></i> <span>报名表</span></a>
                <ul class="sub-menu-list "><!--nav-active -->
                    <li><a href="<%=request.getContextPath()%>/pages/user/form.jsp">管理报名表</a></li>
                    <li><a href="<%=request.getContextPath()%>/pages/user/show_result.jsp">管理报名信息</a></li>
                </ul>
            </li>--%>
            <li class="menu-list"><a href=""><i class="fa fa-bell"></i><span>结果管理</span></a>
            <ul class="sub-menu-list">
                <li><a href="<%=request.getContextPath()%>/pages/user/record_result.jsp">结果录入</a></li>
                <li><a href="<%=request.getContextPath()%>/pages/user/search_result.jsp">快速查询</a></li>
                <li><a href="">统计报表</a></li>
            </ul>
            </li>
        </ul>

        <%  }else if(BaseInfo.GetUserGradeId(request).equals("3")){
        %>
              <ul class="nav nav-pills nav-stacked custom-nav">
                  <li><a href="<%=request.getContextPath()%>/pages/user/record_result.jsp"><i class="fa fa-bell"></i><span>结果录入</span></a></li>
                  <li><a href="<%=request.getContextPath()%>/pages/user/search_result.jsp"><i class="fa fa-users"></i><span>快速查询</span></a></li>
                  <li><a href=""><i class="fa fa-pie-chart"></i><span>统计报表</span></a></li>
              </ul>
        
        <%} %>
        <!--sidebar nav end-->

    </div>
</div>
<!-- left side end-->