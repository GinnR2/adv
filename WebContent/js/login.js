
$('div.alert-warning').hide();


function _alert(str, mod) {

	if (mod == "r") {
		$('div.alert-warning').text(str);
		$('div.alert-warning').show();
	} else if (mod == "l") {
		$('div.alert-warning').text(str);
		$('div.alert-warning').show();
	} else {
		alert(str)
	}
}

function tolog(){
	$('form[action="login"]').show()
	$('form[action="register"]').hide()
	$('h3').text('login')
}

function toreg(){
	$('form[action="login"]').hide()
	$('form[action="register"]').show()
	$('h3').text('register')
}

$( document ).ready(function(){
	tolog()
})

$('form[action="register"] a').click(tolog)

$('form[action="login"] a').click(toreg)

$("button.register").click(
		function() {
			var name = $("form[action='register'] div input.name").val();
			var surname = $("form[action='register'] div input.surname").val();
			var email = $("form[action='register'] div input.email").val();
			var password = $("form[action='register'] div input.password").val();
			var cpassword = $("form[action='register'] div input.cpassword").val();

			console.log(name, surname, email, password)

			if (name == '' || surname == '' || email == '' || password == '' || cpassword == '') {
				_alert("Please fill all fields.", "r");
			} else if (name == undefined || surname == undefined || email == undefined || password == undefined || cpassword == undefined) {
				_alert("Something went wrong...", "r");
			} else if ((password.length) < 8) {
				_alert("Password should atleast 8 character in length.", "r");
			} else if (!(password).match(cpassword)) {
				_alert("Your passwords don't match. Try again?", "r");
			} else {
				var userRegistration = {
					name : name,
					surname : surname,
					email : email,
					password : password
				};

				$.post("register", userRegistration, function(data) {
					_alert(data, "r")
				});
			}
		});

$("button.login").click(function() {
	var email = $("form[action='login'] div input.email").val();
	var password = $("form[action='login'] div input.password").val();
	
	console.log(email, password)
	
	if (email == '' || password == '') {
		_alert("Please fill all forms!", "l");
	} else if (email == undefined || password == undefined) {
		_alert("Something went wrong", "r");
	} else {
		var userLogin = {
			email : email,
			password : password
		};

		$.post("login", userLogin, function(data) {
			if(typeof data == 'object'){
				var customUrl = '';
				var urlContent = window.location.href.split('/');
				for (var i = 0; i < urlContent.length-1; i++) {
					customUrl+=urlContent[i]+'/'
				}
				customUrl+=data.destinationUrl;
				window.location = customUrl;
				//$("h1 span").text(email)
				return
			}
			_alert(data, "l");
		});
	}
});