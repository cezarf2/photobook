<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Photobook</title>
<c:url var="url_base" value="/" />
<link rel="stylesheet" href="${url_base}css/bootstrap-lumen.min.css">
<link rel="stylesheet" href="${url_base}css/estilos.css">
</head>
<body>

	<section id="menu-principal">
		<div class="container">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel">
					<div class="panel-heading">
						<h1 class="text-center">
							<strong>Photobook</strong>
						</h1>
					</div>
					<div class="panel-body">
						<c:if test="${not empty msgSucesso}">
							<div class="alert alert-success alert-dismissible" role="alert">
								<button type="button" class="close" data-dismiss="alert"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<p>${msgSucesso}</p>
							</div>
						</c:if>
						<c:if test="${not empty msg}">
							<div class="alert alert-danger alert-dismissible" role="alert">
								<button type="button" class="close" data-dismiss="alert"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<p>${msg}</p>
							</div>
						</c:if>
						<form:form action="${url_base}loginExecuta" method="post"
							modelAttribute="usuario">
							<spring:bind path="login">
								<div class="form-group">
									<div class="input-group">
										<div class="input-group-addon">
											<span class="glyphicon glyphicon-user"></span>
										</div>
										<form:input path="login" type="text" 
											cssClass="form-control" placeholder="Nome de usuário"/>
									</div>
								</div>
							</spring:bind>
							<spring:bind path="senha">
								<div class="form-group">
									<div class="input-group">
										<div class="input-group-addon">
											<span class="glyphicon glyphicon-lock"></span>
										</div>
										<form:input path="senha" type="password"
											cssClass="form-control" placeholder="Senha"/>
									</div>
								</div>
							</spring:bind>

							<input class="btn btn-primary pull-right" type="submit"
								value="Entrar">
						</form:form>
					</div>
				</div>
				<div class="panel">
					<div class="panel-body">
						<p class="text-center">
							Você não possui conta? <a href="${url_base}users/add">Cadastre-se</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</section>

	<script src="${url_base}js/jquery.min.js"></script>
	<script src="${url_base}js/bootstrap.min.js"></script>
</body>
</html>