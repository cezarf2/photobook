var elemFile = $("#elemFile");
var selectFile = $("#selectFile");

selectFile.click(function(){
	if(elemFile){
		elemFile.click();
	}
});

$(document).ready(function(){
	$("#elemFile").change(function() {
		if(typeof (FileReader) !== "undefined"){
			var viewImage = $("#viewImage");
			viewImage.empty();
			
			var reader = new FileReader();
			reader.onload = function(e) {
				$("<img />", {
					"src": e.target.result,
					"class": "img-thumbnail"
				}).appendTo(viewImage);
			}
			viewImage.show();
			reader.readAsDataURL($(this)[0].files[0], "UTF-8");
		}
		else{
			alert("O navegador não suporta FileReader.");
		}
	});
	
	$("")
});