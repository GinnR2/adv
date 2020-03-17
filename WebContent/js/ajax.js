function _alert(str, mod) {
		$('div.alert-warning').text(str);
		$('div.alert-warning').show();
}

$(document).ready(()=>{
		$('div.alert-warning').hide();	
})

$("button.create").click(function() {

	let name = $("form.create_product input.p_name").val();
	let desc = $("form.create_product input.p_desc").val();
	let price = $("form.create_product input.price").val();
	
	if (name == undefined || desc == undefined || price == undefined) {
		alert("Something went wrong..."+name+" "+desc+" "+price);
	}
	
	let product = {
		name : name,
		desc : desc,
		price : price
	};

	$.post("product", product, function(data) {

		_alert(data);
	});

});

$("button.buy-product").click(function() {
	var productId = jQuery(this).attr("product-id");
	
	
	$.post("bucket", {'productId':productId},
			function(data) {
				if (data.split(" ")[0] == 'Added') {
					$('#buyProductModal').modal('hide');
					
				}
				alert(data);
			});
});