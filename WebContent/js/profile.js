let products = null;
let arr;
let userRole;
$.get("products", function(data) {
	if (data !== '') {
		products = data;
	}
}).done(function() {
	products = JSON.parse(products)
	let i = 0
	let cardsContent = "";
	
	products.forEach( value=>{
		i++
		cardsContent+="<div class='col'>" +
					  "<div class='card'>" +
					  "<div class='card-body'>" +
					  "<h5 class='card-title'>" + value.name + "</h5>"+
					  "<h6 class='card-subtitle mb-2 text-muted'>" + value.price + "</h6>"+
					  "<p class='card-text'>" + value.desc + "</p>"+
					  "<a href='product?id=" + value.id + "' class='card-link itemlink'>link</a>"+
					  "</div>" +
					  "</div>" +
					  "</div>" +
					  "</div>"
	});
	
	  $('#productCards').html(cardsContent);
	
}).done(function() {
	$.get("me", function(data) {
		if (data !== '') {
			userRole = data;
		}
	}).done(function() {
		let arr = JSON.parse(userRole)
		if(arr[1] === 'ADMIN' | userRole === "null"){
			$('.itemlink').hide();
		}
	});
});