<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<c:url var="url_base" value="/" />
<link rel="stylesheet" href="${url_base}css/bootstrap-lumen.min.css">
<link rel="stylesheet" href="${url_base}css/estilos.css">
<link rel="stylesheet" href="${url_base}css/publicacao.css">
</head>
<body>
	<jsp:include page="cabecalho.jsp" />
	<section id="menu-inicial">
		<div class="container">
			<c:if test="${not empty msgFalha}">
				<div class="alert alert-danger alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<p>${msgFalha}</p>
				</div>
			</c:if>
			<c:forEach var="publicacao" items="${listaPublicacoes}">
				<div class="col-md-8 col-md-offset-2">
					<div class="panel panel-default">
						<div class="panel-body panel-foto">
							<a href="${url_base}users/${publicacao.usuario.login}">
								${publicacao.usuario.login}
							</a>
							<figure>
								<img src="${publicacao.caminhoImagem}" class="img-responsive">
								<figcaption>${publicacao.legenda}</figcaption>
							</figure>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>

	<script src="${url_base}js/jquery.min.js"></script>
	<script src="${url_base}js/bootstrap.min.js"></script>
</body>
</html>
