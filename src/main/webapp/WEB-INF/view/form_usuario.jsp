<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form method="post" modelAttribute="usuario" action="${url_base}${acao}">

	<form:input path="id" type="hidden" />

	<spring:bind path="nome">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:label path="nome">Nome</form:label>
			<form:input path="nome" type="text" cssClass="form-control"/>
			<form:errors path="nome" />
		</div>
	</spring:bind>
	<spring:bind path="email">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:label path="email">Email</form:label>
			<form:input path="email" type="email" cssClass="form-control" placeholder="usuario@exemplo.com"/>
			<form:errors path="email"/>
		</div>
	</spring:bind>
	<spring:bind path="login">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:label path="login">Login</form:label>
			<form:input path="login" type="text" cssClass="form-control"/>
			<form:errors path="login"/>
		</div>
	</spring:bind>
	<spring:bind path="senha">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:label path="senha">Senha</form:label>
			<form:input path="senha" type="${tipo_input_senha}" cssClass="form-control"/>
			<form:errors path="senha"/>
		</div>
	</spring:bind>
	
	<form:input path="biografia.id" type="hidden" />
	<spring:bind path="biografia">
		<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:label path="biografia.descricaoBiografia">Biografia</form:label>
			<form:textarea path="biografia.descricaoBiografia" rows="5" cols="50" maxlength="255" cssClass="form-control"/>
			<form:errors path="biografia.descricaoBiografia" />
		</div>
	</spring:bind>
	
	<input type="submit" class="btn btn-primary pull-right" value="Salvar"/>
</form:form>