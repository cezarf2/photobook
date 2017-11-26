<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Photobook</title>
<c:url var="url_base" value="/"/>
<link rel="stylesheet" href="${url_base}css/bootstrap-lumen.min.css">
<link rel="stylesheet" href="${url_base}css/estilos.css">
</head>
<body>
	
	<section id="menu-principal">
		<div class="container">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel">
					<div class="panel-heading">
						<h1 class="text-center"><strong>Photobook</strong></h1>
						<h4 class="text-center">Cadastre-se para ver e compartilhar fotos com seus amigos.</h4>
					</div>
					<div class="panel-body">
						<jsp:include page="form_usuario.jsp"/>			
					</div>
				</div>
				<div class="panel">
					<div class="panel-body">
						<p class="text-center">
							Já tem conta? <a href="${url_base}loginForm">Faça login</a>
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