/**
 * 
 */
$(document).ready(function(){
	$("#addCarBtn").click("submit",function(){
		var car = {regNo:$("#addRegNo").val(),
					owner:$("#addOwner").val(),
					model:$("#addModel").val()};
		alert("From Client "+JSON.stringify(car));
		$.ajax({
			type: "POST",
			url: "rest/cars",
			contentType: "application/json",
			data: {regNo:$("#addRegNo").val(),
					owner:$("#addOwner").val(),
					model:$("#addModel").val()},
			dataType: "json",
			success: function(data1) {
				alert("From Server" + JSON.stringify(data1));
				console.log(JSON.stringify(data1));
			}
		});	
	});
});

$(document).ready(function(){
	$("#viewAllCarBtn").click("submit",function(){
		alert("From Client");
		$.ajax({
			type: "GET",
			dataType: "json",
			url: "rest/cars",
			success: function(data1) {
				alert("From Server" + JSON.stringify(data1));
				console.log(JSON.stringify(data1));
			}
		});	
	});
});

$(document).ready(function(){
	$("#viewCarBtn").click("submit",function(){
		var regno = $("#viewRegNo").val();
					
		alert("From Client"+regno);
		$.ajax({
			type: "GET",
			dataType: "json",
			url: "rest/cars/"+regno,
			success: function(data1) {
				alert("From Server" + JSON.stringify(data1));
				console.log(JSON.stringify(data1));
			}
		});	
	});
});


$(document).ready(function(){
	$("#updateCarBtn").click("submit",function(){
		var car = {regNo:$("#updateRegNo").val(),
					owner:$("#updateOwner").val(),
					model:$("#updateModel").val()};
		alert("From Client"+car);
		$.ajax({
			type: "PUT",
			url: "rest/cars",
			contentType: "application/json",
			data: {regNo:$("#updateRegNo").val(),
					owner:$("#updateOwner").val(),
					model:$("#updateModel").val()},
			dataType: "json",
			success: function(data1) {
				alert("From Server" + JSON.stringify(data1));
				console.log(JSON.stringify(data1));
			}
		});	
	});
});

$(document).ready(function(){
	$("#deleteCarBtn").click("submit",function(){
		var regno = $("#deleteRegNo").val();
					
		alert("From Client"+regno);
		$.ajax({
			type: "DELETE",
			dataType: "text",
			url: ("rest/cars/"+regno),
			success: function(data1) {
				alert("From Server" +(data1));
				console.log(data1);
			}
		});	
	});
});

