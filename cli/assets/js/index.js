$(document).ready(function(){
	$("#btn1").click(function(){
		$.ajax({
			url: "http://localhost:8080/tags",
			type: "GET",
			dataType: "json",
			success: function (response){
				console.log(response);
			},
			error: function(response) {
				console.log("Что-то пошло не так", error);
			}
		});
	});
	
	$("#tag-create-button").click(async function(){
		let varData = {
			"name": document.getElementById("tag-name").value,
			"slug": document.getElementById("tag-slug").value
		};
		let response = await fetch("http://localhost:8080/tags", {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json;charset=utf-8'
			},
			body: JSON.stringify(varData)
		});
	});

	$(document).ready(function(){
		$.ajax({ url: "/cli/tag/info.html",
				context: document.body,
				success: function(){
				   alert("done");
				}});
		});
});