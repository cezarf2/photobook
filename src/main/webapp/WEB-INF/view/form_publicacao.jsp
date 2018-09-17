<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form method="post" modelAttribute="publicacao" action="${url_base}${acao}" enctype="multipart/form-data">

	<form:input path="id" type="hidden" />
	
	<c:if test="${acao eq '/photobook/publicacao/newpublicacao'}">
		<input id="elemFile" type="file" name="imagem" accept="image/*">
		<a href="#" id="selectFile" role="button" class="btn btn-info">Selecione a imagem</a>
		<div id="viewImage"></div>
	</c:if>
	<c:if test="${acao eq '/photobook/publicacao/update'}">
		<div id="viewImage">
			<img src="${publicacao.caminhoImagem}" class="img-responsive">
		</div>
	</c:if>
	
	<spring:bind path="nome">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:input path="nome" type="hidden"/>
			<form:errors path="nome" />
		</div>
	</spring:bind>
	<spring:bind path="caminhoImagem">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:input path="caminhoImagem" type="hidden"/>
			<form:errors path="caminhoImagem" />
		</div>
	</spring:bind>
	<spring:bind path="legenda">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:label path="legenda">Legenda</form:label>
			<form:textarea path="legenda" type="text" rows="5" cols="50" maxlength="255" cssClass="form-control"/>
			<form:errors path="legenda"/>
		</div>
	</spring:bind>
	
	<form:input path="usuario" type="hidden" />
	
	<input type="submit" class="btn btn-primary pull-right" value="Salvar"/>
</form:form>