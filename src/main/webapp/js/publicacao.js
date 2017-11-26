$(document).ready(function() {
	$(".panel-foto button").hide();
	
	$(".panel-foto figure").click(function() {
		var publicacao = $(this);
		var id_publicacao = publicacao.attr("id").split("-")[1];
		$.get("/publicacao/" + id_publicacao);
		publicacao.siblings("button").click();
	});
});
