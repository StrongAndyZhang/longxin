<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	$().ready(function() {
		$("#addUserForm").validate({
			rules : {
				username : {
					required : true,
					minlength : 2,
					remote : {
						url : "../user/check",
						type : "get",
						contentType: "application/x-www-form-urlencoded; charset=utf-8", 
						data : {
							username : function() {
								return $("#username").val();
							}
						}
					}
				},
				telephone : {
					required : true,
					minlength : 7
				},
				password : {
					required : true,
					minlength : 5
				},
				passwordAgain : {
					required : true,
					minlength : 5,
					equalTo : "#password"
				}
			},
			messages : {
				username : {
					required : "请输入用户名",
					minlength : "用户名至少包含两个字符",
					remote : "该用户名已被使用"
				},
				password : {
					required : "请输入密码",
					minlength : "密码长度不能小于5位"
				},
				telephone : {
					required : "请输入电话号码",
					minlength : "电话长度不能小于7位"
				},
				passwordAgain : {
					required : "请输入确认密码",
					minlength : "密码长度不能小于5位",
					equalTo : "两次输入密码不一致"
				}
			},
		});
	});
</script>
<form:form method="POST" modelAttribute="users" role="form"
	class="form-horizontal" id="addUserForm">
	<div class="boxed-group">
		<h3>添加用户</h3>
		<div
			class="boxed-group-inner clearfix js-uploadable-container js-upload-avatar-image is-default">
			<br />
			<div class="form-group">
				<label for="username" class="col-sm-2 control-label">用户名：</label>
				<div class="col-sm-10">
					<form:input type="text" class="form-control" id="username"
						placeholder="输入用户名" path="username" />
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label">密码：</label>
				<div class="col-sm-10">
					<form:input type="password" class="form-control" id="password"
						placeholder="输入密码" path="password" />
				</div>
			</div>
			<div class="form-group">
				<label for="passwordagain" class="col-sm-2 control-label">重复密码：</label>
				<div class="col-sm-10">
					<form:input type="password" class="form-control" id="passwordagain"
						placeholder="再次输入密码" path="passwordAgain" />
				</div>
			</div>
			<div class="form-group">
				<label for="telephone" class="col-sm-2 control-label">电话号码：</label>
				<div class="col-sm-10">
					<form:input type="text" class="form-control" id="telephone"
						placeholder="电话号码" path="telephone" />
				</div>
			</div>
			<div class="form-group">
				<label for="role" class="col-sm-2 control-label">用户角色：</label>
				<div class="col-sm-10">
					<form:select path="role" class="form-control" id="role">
						<c:forEach var="item" items="${roles}">
							<form:option value="${item}">${item.description}</form:option>
						</c:forEach>
						<!--  <option value="ROLE_VISITOR">普通用户</option>
			  <option value="ROLE_TECHNICALSUPPORT">技术人员</option>
			  <option value="ROLE_SUPERTECHNICALSUPPORT">高级技术人员</option>
			  <option value="ROLE_ADMIN">管理员</option> -->
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<label for="department" class="col-sm-2 control-label">部门：</label>
				<div class="col-sm-10">
					<form:select path="department.id" class="form-control"
						id="department">
						<c:forEach var="department" items="${departments}">
							<option value="${department.id}">${department.departmentname}</option>
						</c:forEach>
					</form:select>
					<br />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" class="btn btn-primary" value="添加用户" /> <input
						type="reset" class="btn btn-primary" value="重置" />
					<button type="button" class="btn btn-primary"
						onclick="location='../user/search'">关闭</button>
				</div>
			</div>
		</div>
	</div>
</form:form>