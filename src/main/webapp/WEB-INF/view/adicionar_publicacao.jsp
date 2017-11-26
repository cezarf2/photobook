<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Photobook</title>
<c:url var="url_base" value="/"/>
<link rel="stylesheet" href="${url_base}css/bootstrap-lumen.min.css">
<link rel="stylesheet" href="${url_base}css/estilos.css">
<link rel="stylesheet" href="${url_base}css/publicacao.css">
</head>
<body>
	<jsp:include page="cabecalho.jsp" />
	<section id="menu-principal">
		<div class="container">
			<div class="col-md-10 col-md-offset-1">
				<div class="panel">
					<div class="panel-body">
						<jsp:include page="form_publicacao.jsp"/>			
					</div>
				</div>
			</div>

		</div>
	</section>
	
	<script src="${url_base}js/jquery.min.js"></script>
	<script src="${url_base}js/bootstrap.min.js"></script>
	<script src="${url_base}js/image.js"></script>
</body>
</html>