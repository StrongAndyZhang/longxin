<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
	var deleteProductId;
    $(function () {
		$('#searchTable1').bootstrapTable({
			
		}).on('dbl-click-row.bs.table', function (e, row, $element) {
			//location.href="./edit/"+row.id;
        });
	});
    function showDailog(productId){
    	//deleteProductId = productId;
    	//$('#myModal').modal('show');
    }
    function deleteProduct(){
    	$.post('./delete/'+deleteProductId);
    	location.href="./search";
    }
    
    function update(){
    	$("#updateForm").fadeIn("fast");
    }
    
    function addComponent(){
    	$("#addComponentForm").fadeIn("fast");
    }
    
    function cancel(){
		$("#addComponentForm").fadeOut("fast");	
	};
    
</script>

<form:form method="POST" modelAttribute="product" role="form"
	class="form-horizontal" id="viewProductForm">

	<fieldset>
		<legend>${module.moduleName} &nbsp;&nbsp;&nbsp;&nbsp;<a href="../diagram/${module.id}"><span class="glyphicon glyphicon-indent-left"></span></a></legend>
		
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">模块名称：</label>
			<div class="col-sm-5 control-label">${module.moduleName}</div>
		</div>
		<div class="form-group">
			<label for="description" class="col-sm-2 control-label">描述：</label>
			<div class="col-sm-5 control-label">${module.description}</div>
		</div>
		<div class="form-group" align="right">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="button" onclick="update()" class="btn btn-primary start-example" value="编辑本模块" />&nbsp;&nbsp;
					<input type="button" onclick="addComponent()" class="btn btn-primary start-example" value="添加新模块" />&nbsp;&nbsp;
				</div>
			</div>
	</fieldset>
	<br>
	<table data-toggle="table" data-cache="false" data-height="350" data-pagination="true" id="searchTable1">
		<thead>
	        <tr class="success">
				<th data-field="name"  data-sortable="true">模块名称</th>
				<th data-field="description"  data-sortable="true">模块描述</th>
	            <th data-sortable="false">操作</th>
	        </tr>
   	 	</thead>
   	 	<tbody>
   	 		<c:forEach items="${l1components}" var="l1component">  
            <tr>  
                <td>${l1component.name}</td> 
                <td>${l1component.description}</td>  
                <td>
                <a href="../../l1component/view/${l1component.id}"  data-toggle="popover" title="查看"><span class="glyphicon glyphicon-th" aria-hidden="true"></span></a>
                &nbsp;&nbsp;
                <a href="javascript:void(0);" onclick="showDailog(${l1component.id})"  data-toggle="popover" title="删除该组件"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
   	 			&nbsp;&nbsp;
            </tr>  
       		</c:forEach>
   	 	</tbody>
	</table>
</form:form>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">确认框</h4>
			</div>
			<div class="modal-body">确认要删除该产品？</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary"
					onclick="deleteProduct()">确定</button>
				<button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
			</div>
		</div>
	</div>
</div>

<div class="entry-form" id="updateForm">
	<form name="updateModule" id="updateModule" method="POST" modelAttribute="module" action="../update/${module.id}">
		<table width="100%" border="0" cellpadding="4" cellspacing="0">
			<tr>
			</tr>
			<tr>
				<td>模块名称：</td>
				<td><input type="text" name="moduleName" value="${module.moduleName}"></td>
			</tr>
			<tr>
				<td>描述：</td>
				<td><input type="text" name="description" value="${module.description}"></td>
			</tr>
			<tr>
				<td align="right"></td>
				<td><input type="submit" value="保存" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" value="取消" id="cancel" class="btn btn-primary"></td>
			</tr>
		</table>
	</form>
</div>

<div class="entry-form" id="addComponentForm">
	<form name="addL1Component" id="addL1Component" method="POST" modelAttribute="l1Component" action="./${module.id}/add/component">
		<table width="100%" border="0" cellpadding="4" cellspacing="0">
			<tr>
				<td>模块名称：</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>描述：</td>
				<td><input type="text" name="description"></td>
			</tr>
			<tr>
				<td align="right"></td>
				<td><input type="submit" value="保存" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" value="取消" onclick="cancel()" class="btn btn-primary"></td>
			</tr>
		</table>
	</form>
</div>