<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<c:url var="url_base" value="/" />
</head>
<body>
	<header>
		<nav class="navbar navbar-inverse">
			<div class="container">
				<div class="navbar-header">
					<a href="${url_base}" class="navbar-brand">
						<div id="title">
							<span class="glyphicon glyphicon-home"></span> Photobook
						</div>
					</a>
				</div>
				<form id="formBusca" method="get" action="${url_base}users/" class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input type="text" class="form-control" name="username" placeholder="Buscar" /> 
					</div>
					<button type="submit" class="btn btn-link">
						<span class="glyphicon glyphicon-search"></span>
					</button>
				</form>
				
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${url_base}publicacao/add" role="button" class="btn btn-link navbar-btn">
							<span class="glyphicon glyphicon-camera"></span>
					</a></li>
					<li>
						<a href="${url_base}users/${usuarioLogado.login}" role="button" class="btn btn-link navbar-btn"> 
							<div id="usuario">
								<span class="glyphicon glyphicon-user"></span> ${usuarioLogado.nome}	
							</div>
							
						</a>
					</li>
					<li><a href="${url_base}logout" role="button"
						class="btn btn-link navbar-btn"> <span
							class="glyphicon glyphicon-log-out"></span>
					</a></li>

				</ul>
			</div>


		</nav>

	</header>
</body>
</html>