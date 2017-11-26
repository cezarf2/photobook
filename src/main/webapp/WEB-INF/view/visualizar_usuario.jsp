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
							<div class="col-md-10 col-md-offset-1">
								<div class="col-md-5">
									<h2>${usuario.login}</h2>
								</div>
								<div class="col-md-5 menu-perfil">
									<c:if test="${usuario.login eq usuarioLogado.login}">
										<a href="${url_base}users/${usuario.id}/update"
											class="btn btn-primary"> Editar perfil </a>
										<button type="button" class="btn btn-danger"
											data-toggle="modal" data-target="#myModal">Remover
											perfil</button>
									</c:if>
								</div>
							</div>
							<div class="col-md-10  col-md-offset-1">
								<div class="col-md-5">
									<label>Nome</label>
									<p>${usuario.nome}</p>
									<label>Biografia</label>
									<p>${usuario.biografia.descricaoBiografia}</p>
								</div>
							</div>
						</div>
					</div>

				</div>


				<c:forEach var="publicacao" items="${listaPublicacoes}">
					<div class="col-md-4">
						<div class="panel">
							<div class="panel-body">
								<figure>
									<a href="${url_base}publicacao/${publicacao.id}"> <img
										src="${publicacao.caminhoImagem}" class="img-responsive">
									</a>
								</figure>
							</div>
						</div>
					</div>
				</c:forEach>

			</div>
		</div>
	</section>

	<!-- Modal Remover Conta-->
	<c:if test="${acao eq '/users/login'}">
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-body">
						<form:form method="post"
							action="${url_base}users/${usuario.id}/delete"
							modelAttribute="usuarioRemocao">

							<spring:bind path="senha">
								<div class="form-group">
									<form:label path="senha">Digite sua senha para confirmar</form:label>
									<form:input path="senha" type="password"
										cssClass="form-control" />
								</div>
							</spring:bind>

							<div id="btn-modal">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Cancelar</button>
								<input type="submit" class="btn btn-primary" value="Confirmar">
							</div>

						</form:form>
					</div>
				</div>
			</div>
		</div>
	</c:if>

	<script src="${url_base}js/jquery.min.js"></script>
	<script src="${url_base}js/bootstrap.min.js"></script>
</body>
</html>