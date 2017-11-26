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
<link rel="stylesheet" href="${url_base}css/publicacao.css">
</head>
<body>
	<jsp:include page="cabecalho.jsp" />
	<section id="menu-principal">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<c:if test="${not empty msgFalha}">
						<div class="alert alert-danger alert-dismissible" role="alert">
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<p>${msgFalha}</p>
						</div>
					</c:if>
					<c:if test="${not empty msgSucesso}">
						<div class="alert alert-success alert-dismissible" role="alert">
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<p>${msgSucesso}</p>
						</div>
					</c:if>
					<div class="panel">
						<div class="panel-body">
							<div class="col-md-8">
								<img src="${publicacaoAtual.caminhoImagem}"
									class="img-responsive">
							</div>
							<div class="col-md-4">
								<p id="foto-legenda">${publicacaoAtual.legenda}</p>
								<c:if test="${usuarioPublicacao.login eq usuarioLogado.login}">
									<a href="${url_base}publicacao/${publicacaoAtual.id}/update"
										class="btn btn-primary"> Editar publicação </a>
									<a href="${url_base}publicacao/${publicacaoAtual.id}/delete"
										class="btn btn-danger"> Remover publicação </a>
								</c:if>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<script src="${url_base}js/jquery.min.js"></script>
	<script src="${url_base}js/bootstrap.min.js"></script>
</body>
</html>