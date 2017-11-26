<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Usuário</title>
<c:url var="url_base" value="/"/>
<link rel="stylesheet" href="${url_base}css/bootstrap-lumen.min.css">
<link rel="stylesheet" href="${url_base}css/estilos.css">
</head>
<body>
	<jsp:include page="cabecalho.jsp" />
	<section id="menu-principal">
		<div class="container">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel">
					<div class="panel-heading">
						<h4 class="text-center">Editar perfil</h4>
					</div>
					<div class="panel-body">
						<jsp:include page="form_usuario.jsp"/>			
					</div>
				</div>
			</div>
		</div>
	</section>

	
	<script src="${url_base}js/jquery.min.js"></script>
	<script src="${url_base}js/bootstrap.min.js"></script>

</body>
</html>