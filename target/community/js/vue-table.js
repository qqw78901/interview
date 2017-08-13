/**
 * http://usejsdoc.org/
 */
function DataGrid(opts){
		this.closable = true;
	    this.refreshable = true;
		this.queryData = {};
		for(var key in opts){
			this[key] = opts[key];
		}
	}
(function(Vue) {	
	Vue.component('vue-table', {
		template :'<div v-if="show">' 
				+'<slot name="queryData"></slot>'
				+'<div style="margin-top:5px;font-weight:bold" class="table-header">'
				+   '<span v-if="grid.closable" title="关闭表格" style="float:right;cursor:pointer;margin-top:5px;margin-right:10px;font-size:1.5em" class="glyphicon glyphicon-remove" @click="close($event)"></span>'
				+   '<span v-if="grid.refreshable" title="刷新数据" style="float:right;cursor:pointer;margin-top:5px;margin-right:15px;font-size:1.5em" class="glyphicon glyphicon-refresh" @click="refresh($event)"></span>'
				+   '<span v-if="grid.add" title="添加数据" style="float:right;cursor:pointer;margin-top:5px;margin-right:15px;font-size:1.5em" class="glyphicon glyphicon-plus" @click="add($parent,$root,$event)"></span>'
				+	'{{grid.title}}'
				+'</div>'
				+'<div class="dataTables_wrapper form-inline no-footer">'
				+	'<div class="row" style="padding-top:5px;padding-bottom:2px;">'
				+		'<div class="col-xs-12">'
				+			'<div class="dataTables_length pull-left" style="font-size:12px">'
				+				'<label>'
				+					'展示'
				+					'<select class="input-sm" v-model="pageSize">'
				+						'<option value="10">10</option>'
				+						'<option value="20">20</option>'
				+						'<option value="50">50</option>'
				+						'<option value="100">100</option>'
				+					'</select>'
				+					' 当前第{{currentPage}}/{{totalPage}}页，共{{total}}条记录'
				+				'</label>'
				+			'</div>'
				+		'</div>'
				+	'</div>'
				+	'<table class="table table-striped table-bordered table-hover dataTable no-footer">'
				+ 		'<thead><tr>'
				+			'<th v-for="column in grid.columns">'
				+				'<span v-if="column.order==1" title="升序" style="float:right;cursor:pointer;" class="glyphicon glyphicon-arrow-up" @click="sort($index,$event)"></span>'
				+				'<span v-if="column.order==-1" title="降序" style="float:right;cursor:pointer;" class="glyphicon glyphicon-arrow-down" @click="sort($index,$event)"></span>'
				+				'{{column.header}}'
				+			'</th>'
				+			'<th v-if="grid.operations">操作</th>'
				+		'</tr></thead>'
				+ 		'<tr v-for="row in rows">'
				+           '<td v-for="column in grid.columns">{{row[column.field]}}</td>'
				+			'<template v-if="grid.operations">'
				+				'<td>'
				+					'<div class="btn-group" style="font-size:10px;">'
				+						'<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">'
				+							'<span class="glyphicon glyphicon-list" style="margin-right:3px;"></span>'
				+							'选择操作'
				+							'<span class="caret" style="margin-top:3px;"></span>'
				+						'</button>'
				+						'<ul class="dropdown-menu">'
				+							'<template v-for="operation in grid.operations">'
				+								'<li>'
				+									'<a href="#" @click="operate($index,row,$parent,$root,$event)" style="font-size:15px;">'
				+										'<span class="glyphicon glyphicon-{{operation.icon||defaultIcon}}" style="margin-right:5px;"></span>'
				+										'{{operation.name}}'
				+									'</a>'
				+								'</li>'
				//+								'<li role="separator" class="divider"></li>'
				+							'</template>'
				+						'</ul>'
				+					'</div>'
				+				'</td>'
				+			'</template>'
				+		'</tr>'
				+ 	'</table>'
				+	'<div class="row" style="padding-top:5px;padding-bottom:3px;">'	
				+		'<div class="col-xs-12">'
				+			'<div class="dataTables_paginate paging_simple_numbers pull-right">'
				+				'<ul class="pagination">'
				+					'<li v-if="currentPage>1" class="paginate_button previous"><a title="转到上一页" href="#" @click="previous($event)">上一页</a></li>'
				+					'<li v-if="pOmit" class="paginate_button"><a title="转到第1页" href="#" @click="turnTo(1,$event)">1. . .</a></li>'
				+					'<template v-for="i in pages">'
				+						'<li v-if="currentPage==i" class="paginate_button active"><a title="当前第{{i}}页" href="#" @click="turnTo(i,$event)">{{i}}</a></li>'
				+						'<li v-else class="paginate_button"><a title="转到第{{i}}页" href="#" @click="turnTo(i,$event)">{{i}}</a></li>'
				+					'</template>'
				+					'<li v-if="bOmit" class="paginate_button"><a title="转到最后一页" href="#" @click="turnTo(totalPage,$event)">. . .{{totalPage}}</a></li>'
				+					'<li v-if="currentPage<totalPage" class="paginate_button next"><a title="转到下一页" href="#" @click="next($event)">下一页</a></li>'
				+				'</ul>'
				+			'</div>'
				+		'</div>'
				+	'</div>'
				+'</div>'
				+'</div>'
				,
		data : function() {
			return {
				rows : [],
				currentPage : 1,
				totalPage : 1,
				total : 1,
				pageSize : 10,
				pOmit:false,//前省略
				bOmit:false,//后省略
				show:true,
				orderData:{},
				forceComputed:0,//用来强制计算！！！
				defaultIcon:'question-sign'
			};
		},
		props : {
			grid : {
				type : Object,
				dafault : {}
			}
		},
		computed:{
			//orderData:function(){},
			ajaxData:{
				get:function(){
					this.forceComputed = !this.forceComputed;//用于强制computed
					var vm = this;
					var keys = Object.keys(this.orderData);
					//ECMA5标准
					var values = keys.map(function(v) { 
						if(vm.orderData[v] == 1) 
							return "ASC";
						else 
							return "DESC" });
					var orderData ={
							sort:keys.join(","),
							order:values.join(",")
						};
					var pageData = {
							pageSize :this.pageSize,
							offset : this.currentPage
						};
					return jQuery.extend(pageData,orderData,this.grid.queryData||{});
				}
			},
			pages:{
				get:function(){
					//1...234...10   1 2 3 4 5 1234...10   1...7 8 9 10
					if(this.totalPage<=0){
						this.pOmit = false;
						this.bOmit = false;
						return [];
					}else if(this.totalPage<=5){
						this.pOmit = false;
						this.bOmit = false;
						var pages = new Array();
						for(var i=1;i<=this.totalPage;i++){
							pages.push(i);
						}
						return pages;
					}else{
						if(this.currentPage<=2){
							this.pOmit = false;
							this.bOmit = true;
							return new Array(1,2,3,4);
						}else if(this.currentPage>=this.totalPage-2){
							this.pOmit = true;
							this.bOmit = false;
							return new Array(this.totalPage-3,this.totalPage-2,this.totalPage-1,this.totalPage);
						}else{
							this.pOmit = true;
							this.bOmit = true;
							return new Array(this.currentPage-1,this.currentPage,this.currentPage+1);
						}
					}
				}
			}
		},
		watch:{
			'pageSize':function(newVal, oldVal){
				//console.log('pageSize');
				this.makeAjax();
			},
			'grid.queryData':{
				handler:function(newVal,oldVal){
					//console.log('grid.queryData');
					for(key in newVal){
						if(typeof(newVal[key])=='string' && newVal[key].trim()==''){
							//console.log(key);
							newVal[key] = undefined;
							this.makeAjax();
							return;
						}else if(typeof(newVal[key])=='string'){
							this.makeAjax();
							return;
						}
					}
				},
				deep:true
			}
		},
		methods : {
			next:function($event){
				this.turnTo(++this.currentPage,$event);
			},
			previous:function($event){
				this.turnTo(--this.currentPage,$event);
			},
			turnTo:function(pageIndex,$event){
				if($event){
					$event.preventDefault();
				}
				this.currentPage = pageIndex;
				this.makeAjax();
			},
			makeAjax:function(){
				var vm = this;
				jQuery.ajax({
					url : this.grid.url,
					data : this.ajaxData,
					type : this.grid.ajaxType || 'post',
					cache : this.grid.ajaxCache || 'false',
					dataType : this.grid.ajaxDataType || 'json',
					success : function(page) {
						vm.rows = page.data.rows
						vm.currentPage = page.data.offset;
						vm.totalPage = page.data.totalPage;
						vm.total = page.data.total;
					}
				});
			},
			close:function($event){
				this.show = false;
			},
			refresh:function($event){
				this.makeAjax();
			},
			add:function($parent,$root,$event){
				this.grid.add($parent,$root);
			},
			sort:function($index,$event){
				this.forceComputed = !this.forceComputed;//修改此变量（非Object类型），强制vue重新compute ajaxData（在这里面也要修改此变量，因为如果在computed过程中所依赖到的vm上下文的属性都没变过，vue是不会重新compute这个属性（ajaxdata）的）
				var col = this.grid.columns[$index];
				this.orderData[col['field']] = -(col['order']);//修改vm上下文中的Object对象属性并不会触发vm重新computed
				col['order'] = -(col['order']);
				this.makeAjax();
			},
			operate:function($index,row,$parent,$root,$event){
				if($event){
					$event.preventDefault();
				}
				this.grid.operations[$index].handler(row,$parent,$root);
			}
		},
		events : {
			'reload':function(){
				this.makeAjax();
			}
		},
		ready:	function(){
			//ready的时候初始化一次orderData，从而避免将orderData设为computed，每次都要计算
			var col = null;
			for(var i=0;i<this.grid.columns.length;i++){
				col = this.grid.columns[i];
				if(col['order']){
					this.orderData[col['field']] = col['order'];
				}
			}
			this.makeAjax();
		}
	});
})(window.Vue);