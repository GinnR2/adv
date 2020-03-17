$(function() {
     $('.leftmenutrigger').on('click', function(e) {
     $('.side-nav').toggleClass("open");
     e.preventDefault();
    });
});

$("a.logout").click(function() {
	
	$.get("logout", function(data) {
		if (data !== '') {
			var customUrl = '';
			var urlContent = window.location.href.split('/');
			for (var i = 0; i < urlContent.length - 1; i++) {
				customUrl += urlContent[i] + '/'
			}
			customUrl += data;
			window.location = customUrl;
		}
	});

});

let me = null;

$.get("me", function(data) {
	if (data !== '') {
		me = data;
	}
}).done(function() { 

	
	if(me=="null"){
		$("a.login").show()
		$("a.addPeriod").hide()
		$("a.bucket").hide()
		$("a.profile").hide()
		return;
	}
	me = JSON.parse(me)
	if(me[1]==="USER"){
		$("a.addPeriod").hide()
	}
	if(me[1]==="ADMIN"){
		$("a.bucket").hide()
	}
	$(".status h6").html(me[0]+" "+me[1])
	$("a.logout").show()
});