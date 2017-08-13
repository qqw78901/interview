<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!--静态引入  -->
<%@ include file="/pages/common/head.jsp"%>
<script type="text/javascript" src="../../js/vue-table.js"></script>
<script type="text/javascript">
	window.onload = function() {
		window.vm = new Vue({
			el : "#vm-context",
			data : {
				table1 : new DataGrid({
					url : '../../user/page.do',
					title : '测试标题',
					columns:[{header:"登陆名",field:"loginName",order:1},
					         {header:"密码",field:"password",order:-1},
					         {header:"地址",field:"address"}],
					operations:[{name:'更新',icon:'',handler:function(row,tableContext,vmContext){alert("更新")}},
					            {name:'删除',icon:'trash',handler:function(row,tableContext,vmContext){alert("删除")}}],
					add:function($parent,$root){alert("添加")}
				})
			},
		});
	}
</script>
</head>
<body class="no-skin">
	<!--动态引入  -->
	<jsp:include page="/pages/common/navbar.jsp" />
	<div class="main-container" id="main-container">
		<!--动态引入  -->
		<jsp:include page="/pages/common/sidebar.jsp" />
		<div class="main-content">
			<!--动态引入  -->
			<jsp:include page="/pages/common/breadcrumbs.jsp" />
			<div class="page-content" id="vm-context">
				<div class="page-content-area">
					<div class="row">
						<div class="col-xs-12">
							<vue-table :grid="table1">
					       <div slot="queryData">
                    <input type="text" class="input-sm nav-search-input" placeholder="用户名" v-model="table1.queryData.loginName" />
                    <input type="text" class="input-sm nav-search-input" placeholder="密码" v-model="table1.queryData.password" />
                    <input type="text" class="input-sm nav-search-input" placeholder="地址" v-model="table1.queryData.address" />
                    <select class="nav-search-input" v-model="table1.queryData.test">
                      <option value="" selected>下拉选择</option>
                      <option value="1">下拉选择1</option>
                      <option value="2">下拉选择2</option>
                    </select>
					       </div>	       
							</vue-table>
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.page-content-area -->
			</div>
			<!-- /.page-content -->

		</div>
		<!--静态引入  -->
		<%@ include file="/pages/common/footer.jsp"%>
	</div>
	<!--静态引入  -->
	<%@ include file="/pages/common/end.jsp"%>
</body>
</html>