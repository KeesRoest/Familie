/**
 * 
 */
function activeMenuItem(menuItem) {
	var x = document.getElementById("topmenu").getElementsByClassName("active");
	x[0].className = "inactive";
	document.getElementById(menuItem).className = "active";
}

function home() {
	activeMenuItem("home")
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("mainpage").innerHTML = this.responseText;
		}
	};
	xhttp.open("GET", "home.html", true);
	xhttp.send();
}

function overOns() {
	activeMenuItem("overons")
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("mainpage").innerHTML = this.responseText;
		}
	};
	xhttp.open("GET", "rest/overOns", true);
	// xhttp.open("GET", "overOns.html", true);
	xhttp.send();
}

function namenLijst() {
	activeMenuItem("namenlijst")
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var json = JSON.parse(this.responseText)
			var text = '<div id="namen">';
			for (var i = 0; i < json.length; i++) {
				text += '<p class="bg' + i % 2 + '">'
						+ '<a href="#" onclick="persoon(' + json[i].id + ')"'
						+ '>' + json[i].roepnaam + " " + json[i].tussenvoegsel
						+ " " + json[i].achternaam + "</a></p>";
			}
			text += "</div>";
			document.getElementById("mainpage").innerHTML = text;
		}
	};
	xhttp.open("GET", "rest/person/all", true);
	// xhttp.open("GET", "namenLijst.json", true);
	xhttp.send();
}

function persoon(id) {
	var text = '<table id="detail">';
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var json = JSON.parse(this.responseText);
			text += "<tr><th>ID: </th><th>" + json.id + "</th></tr>";
			text += "<tr><th></th><th></th></tr>";
			text += "<tr><td>Geslacht        : </td><td>" + json.geslacht
					+ "</td></tr>";
			text += "<tr><td>Doopnaam        : </td><td>" + json.doopnaam
					+ "</td></tr>";
			text += "<tr><td>Roepnaam        : </td><td>" + json.roepnaam
					+ "</td></tr>";
			text += "<tr><td>Tussenvoegsel   : </td><td>" + json.tussenvoegsel
					+ "</td></tr>";
			text += "<tr><td>Achternaam      : </td><td>" + json.achternaam
					+ "</td></tr>";
			text += "<tr><td>Straatnaam      : </td><td>" + json.straatnaam
					+ "</td></tr>";
			text += "<tr><td>Huisnummer      : </td><td>" + json.huisnr
					+ "</td></tr>";
			text += "<tr><td>Huisnr toev.    : </td><td>" + json.huisnrtoev
					+ "</td></tr>";
			text += "<tr><td>Postcode        : </td><td>" + json.postcode
					+ "</td></tr>";
			text += "<tr><td>Plaatsnaam      : </td><td>" + json.plaatsnaam
					+ "</td></tr>";
			text += "<tr><td>Staat           : </td><td>" + json.staat
					+ "</td></tr>";
			text += "<tr><td>Land            : </td><td>" + json.land
					+ "</td></tr>";
			text += "<tr><td>Telefoon        : </td><td>" + json.telefoon
					+ "</td></tr>";
			text += "<tr><td>Geboortedatum   : </td><td>" + json.geboortedatum
					+ "</td></tr>";
			text += "<tr><td>Geboorteplaats  : </td><td>" + json.geboorteplaats
					+ "</td></tr>";
			text += "<tr><td>Datum Overlijden: </td><td>" + json.overlijdensdatum
					+ "</td></tr>";
			text += "<tr><td>E-mail adres    : </td><td>" + json.email
					+ "</td></tr>";
		}
	}
	xhttp.open("GET", "rest/person/one/" + id, true);
	xhttp.send();

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var json = JSON.parse(this.responseText);
			text += "<tr><td>Burgerlijke staat : </td><td>Gehuwd met : " + json.roepnaam + " "
					+ json.tussenvoegsel + " " + json.achternaam + "</td></tr>";
			text += '<tr><td><button type="button">Wijzigen</button></td></tr></table>';
			document.getElementById("mainpage").innerHTML = text;
		} else if (this.readyState == 4 && this.status == 412) {
			text += "<tr><td>Burgerlijke staat : </td><td>Ongehuwd</td></tr>";
			text += '<tr><td><button type="button">Wijzigen</button></td></tr></table>';
			document.getElementById("mainpage").innerHTML = text;
		}
	}
	xhttp.open("GET", "rest/relation/partner/" + id, true);
	xhttp.send();

}

function persGeg() {
	activeMenuItem("persoonsgegevens")
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("mainpage").innerHTML = this.responseText;
		}
	};
	xhttp.open("GET", "persGeg.html", true);
	xhttp.send();
}

function checkPersGeg(id) {
	switch (id) {
	case "doopnaam":
		document.getElementById("foutDoopnaam").innerHTML = "";
		var y = document.getElementById(id).value.trim();
		if (y == null | y == "") {
			document.getElementById("foutDoopnaam").innerHTML = "Doopnaam invullen s.v.p.";
			return "1";
			break;
		}
		var x = document.getElementById(id);
		x.value = capitalize(y)
	case "roepnaam":
		document.getElementById("foutRoepnaam").innerHTML = "";
		var y = document.getElementById(id).value.trim();
		if (y == null | y == "") {
			document.getElementById("foutRoepnaam").innerHTML = "Roepnaam invullen s.v.p.";
			return "1";
			break;
		}
		var x = document.getElementById(id);
		x.value = capitalize(y)
		break;
	case "tussenvoegsel":
		document.getElementById("foutTussenvoegsel").innerHTML = "";
		var x = document.getElementById(id).value;
		x.value = x.trim();
		x.value = x.toLowerCase();
		break;
	case "achternaam":
		document.getElementById("foutAchternaam").innerHTML = "";
		var y = document.getElementById(id).value;
		if (y == null | y == "") {
			document.getElementById("foutAchternaam").innerHTML = "Achternaam invullen s.v.p.";
			return "1";
			break;
		}
		var x = document.getElementById(id);
		x.value = capitalize(y)
		break;
	case "straatnaam":
		document.getElementById("foutStraatnaam").innerHTML = "";
		var y = document.getElementById(id).value;
		if (y == null | y == "") {
			document.getElementById("foutStraatnaam").innerHTML = "Straatnaam invullen s.v.p.";
			return "1";
			break;
		}

		var x = document.getElementById(id);
		x.value = x.value.trim();
		document.getElementById(id).style.textTransform = "capitalize";
		break;
	case "huisnr":
		document.getElementById("foutHuisnr").innerHTML = "";
		var y = document.getElementById(id).value;
		if (y == null | y == "") {
			document.getElementById("foutHuisnr").innerHTML = "Huisnummer invullen s.v.p.";
			return "1";
			break;
		}
		var x = document.getElementById(id);
		x.value = x.value.trim();
		if (isNaN(y)) {
			document.getElementById("foutHuisnr").innerHTML = "Huisnummer mag alleen cijfers bevatten.";
			return "1";
			break;
		}
		if (y <= 0) {
			document.getElementById("foutHuisnr").innerHTML = "Huisnummer moet groter zijn dan nul.";
			return "1";
			break;
		}
	case "huisnrToev":

		var x = document.getElementById(id);
		x.value = x.value.trim();
		document.getElementById(id).style.textTransform = "capitalize";
		break;
	case "postcode":
		document.getElementById("foutPostcode").innerHTML = "";
		var y = document.getElementById(id).value;
		if (y == null | y == "") {
			document.getElementById("foutPostcode").innerHTML = "Postcode invullen s.v.p.";
			return "1";
			break;
		}

		var x = document.getElementById(id);
		x.value = x.value.trim();
		document.getElementById(id).style.textTransform = "uppercase";
		break;
	case "plaatsnaam":
		document.getElementById("foutPlaatsnaam").innerHTML = "";
		var y = document.getElementById(id).value;
		if (y == null | y == "") {
			document.getElementById("foutPlaatsnaam").innerHTML = "Plaatsnaam invullen s.v.p.";
			return "1";
			break;
		}

		var x = document.getElementById(id);
		x.value = x.value.trim();
		document.getElementById(id).style.textTransform = "capitalize"
		break;
	case "staat":
		document.getElementById("foutStaat").innerHTML = "";

		var x = document.getElementById(id);
		x.value = x.value.trim();
		document.getElementById(id).style.textTransform = "capitalize"
		break;
	case "land":
		document.getElementById("foutLand").innerHTML = "";
		var y = document.getElementById(id).value;
		if (y == null | y == "") {
			document.getElementById("foutLand").innerHTML = "Land invullen s.v.p.";
			return "1";
			break;
		}

		var x = document.getElementById(id);
		x.value = x.value.trim();
		document.getElementById(id).style.textTransform = "capitalize"
		break;
	case "telefoon":
		document.getElementById("foutTelefoon").innerHTML = "";
		var y = document.getElementById(id).value;

		var x = document.getElementById(id);
		x.value = x.value.trim();
		break;
	case "geboortedatum":
		document.getElementById("foutGeboortedatum").innerHTML = "";
		var y = document.getElementById(id).value;
		if (y == null | y == "") {
			document.getElementById("foutGeboortedatum").innerHTML = "Geboortedatum invullen s.v.p.";
			return "1";
			break;
		}

		var x = document.getElementById(id);
		x.value = x.value.trim();
		break;
	case "geboorteplaats":
		document.getElementById("foutGeboorteplaats").innerHTML = "";
		var y = document.getElementById(id).value;
		if (y == null | y == "") {
			document.getElementById("foutGeboorteplaats").innerHTML = "Geboorteplaats invullen s.v.p.";
			return "1";
			break;
		}

		var x = document.getElementById(id);
		x.value = x.value.trim();
		document.getElementById(id).style.textTransform = "capitalize"
		break;
	case "overlijdensdatum":
		document.getElementById("foutOverlijdensdatum").innerHTML = "";
		var y = document.getElementById(id).value;

		var x = document.getElementById(id);
		x.value = x.value.trim();
		break;
	case "email":
		document.getElementById("foutEmail").innerHTML = "";
		var y = document.getElementById(id).value;
		if (y == null | y == "") {
			document.getElementById("foutEmail").innerHTML = "E-mail adres invullen s.v.p.";
			return "1";
			break;
		}
		var email = document.forms["persgeg"]["email"].value;
		var atpos = email.indexOf("@");
		var dotpos = email.lastIndexOf(".");
		if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= email.length) {
			document.getElementById("foutEmail").innerHTML = "Ongeldig e-mail adres.";
			return "1";
			break;
		}

		var x = document.getElementById(id);
		x.value = x.value.trim();
		break;
	case "password":
		document.getElementById("foutPassword").innerHTML = "";
		var y = document.getElementById(id).value;
		if (y == null | y == "") {
			document.getElementById("foutPassword").innerHTML = "Wachtwoord invullen s.v.p.";
			return "1";
			break;
		}

		var x = document.getElementById(id);
		x.value = x.value.trim();
		if (x.length < 6) {
			document.getElementById("foutPassword").innerHTML = "Wachtwoord moet minimaal 6 karakters bevatten.";
			break
		}
		break;
	case "password2":
		document.getElementById("foutPassword2").innerHTML = "";
		var y = document.getElementById(id).value;
		if (y == null | y == "") {
			document.getElementById("foutPassword2").innerHTML = "Wachtwoord herhalen s.v.p.";
			return "1";
			break;
		}

		var x = document.getElementById(id);
		x.value = x.value.trim();
		break;
	}
}

function controlePersgeg() {
	var fout = false;
	if (checkPersGeg("password2") == "1") {
		document.getElementById("password2").focus();
		fout = true;
	}
	if (checkPersGeg("password") == "1") {
		document.getElementById("password").focus();
		fout = true;
	}
	if (checkPersGeg("email") == "1") {
		document.getElementById("email").focus();
		fout = true;
	}
	if (checkPersGeg("overlijdensdatum") == "1") {
		document.getElementById("overlijdensdatum").focus();
		fout = true;
	}
	if (checkPersGeg("geboorteplaats") == "1") {
		document.getElementById("geboorteplaats").focus();
		fout = true;
	}
	if (checkPersGeg("geboortedatum") == "1") {
		document.getElementById("geboortedatum").focus();
		fout = true;
	}
	if (checkPersGeg("telefoon") == "1") {
		document.getElementById("telefoon").focus();
		fout = true;
	}
	if (checkPersGeg("land") == "1") {
		document.getElementById("land").focus();
		fout = true;
	}
	if (checkPersGeg("staat") == "1") {
		document.getElementById("staat").focus();
		fout = true;
	}
	if (checkPersGeg("plaatsnaam") == "1") {
		document.getElementById("plaatsnaam").focus();
		fout = true;
	}
	if (checkPersGeg("postcode") == "1") {
		document.getElementById("postcode").focus();
		fout = true;
	}
	;
	if (checkPersGeg("huisnrtoev") == "1") {
		document.getElementById("huisnrtoev").focus();
		fout = true;
	}
	if (checkPersGeg("huisnr") == "1") {
		document.getElementById("huisnr").focus();
		fout = true;
	}
	if (checkPersGeg("straatnaam") == "1") {
		document.getElementById("straatnaam").focus();
		fout = true;
	}
	if (checkPersGeg("achternaam") == "1") {
		document.getElementById("achternaam").focus();
		fout = true;
	}
	if (checkPersGeg("tussenvoegsel") == "1") {
		document.getElementById("tussenvoegsel").focus();
		fout = true;
	}
	if (checkPersGeg("roepnaam") == "1") {
		document.getElementById("roepnaam").focus();
		fout = true;
	}
	if (checkPersGeg("doopnaam") == "1") {
		setFocus("doopnaam");
		fout = true;
	}
	if (fout == true) {
		return fout;
	}
	var geslacht = document.getElementById("geslacht").value;
	var doopnaam = document.getElementById("doopnaam").value;
	var roepnaam = document.getElementById("roepnaam").value;
	var tussenvoegsel = document.getElementById("tussenvoegsel").value;
	var achternaam = document.getElementById("achternaam").value;
	var straatnaam = document.getElementById("straatnaam").value;
	var huisnr = document.getElementById("huisnr").value;
	var huisnrtoev = document.getElementById("huisnrtoev").value;
	var postcode = document.getElementById("postcode").value;
	var plaatsnaam = document.getElementById("plaatsnaam").value;
	var staat = document.getElementById("staat").value;
	var land = document.getElementById("land").value;
	if ((staat != "" & land == "") | staat != "" & land == "Nederland") {
		document.getElementById("foutStaat").innerHTML = "Staat niet invullen bij 'Nederland'.";
		setFocus("staat");
		fout = true;
	}
	var telefoon = document.getElementById("telefoon").value;
	var geboortedatum = document.getElementById("geboortedatum").value;
	var geboorteplaats = document.getElementById("geboorteplaats").value;
	var overlijdensdatum = document.getElementById("overlijdensdatum").value;
	if (overlijdensdatum != "" & overlijdensdatum != null) {
		if (overlijdensdatum < geboortedatum) {
			document.getElementById("foutOverlijdensdatum").innerHTML = "Overlijdensdatum moet op of na geboortedatum liggen.";
			setFocus("overlijdensdatum");
			fout = true;
		}
	}
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	var password2 = document.getElementById("password2").value;
	if (password2 != password) {
		document.getElementById("foutPassword").innerHTML = "'Wachtwoord' en 'Herhaal wachtwoord' moeten gelijk zijn.";
		setFocus("password");
		fout = true;
	}
	return fout;
}

function setPersgeg() {
	if (controlePersgeg() == true) {
		return;
	}
	var geslacht = document.getElementById("geslacht").value;
	var doopnaam = document.getElementById("doopnaam").value;
	var roepnaam = document.getElementById("roepnaam").value;
	var tussenvoegsel = document.getElementById("tussenvoegsel").value;
	var achternaam = document.getElementById("achternaam").value;
	var straatnaam = document.getElementById("straatnaam").value;
	var huisnr = document.getElementById("huisnr").value;
	var huisnrtoev = document.getElementById("huisnrtoev").value;
	var postcode = document.getElementById("postcode").value;
	var plaatsnaam = document.getElementById("plaatsnaam").value;
	var staat = document.getElementById("staat").value;
	var land = document.getElementById("land").value;
	var telefoon = document.getElementById("telefoon").value;
	var geboortedatum = document.getElementById("geboortedatum").value;
	var geboorteplaats = document.getElementById("geboorteplaats").value;
	var overlijdensdatum = document.getElementById("overlijdensdatum").value;
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 204) {
			alert("Persoon opgeslagen");
		} else if (this.readyState == 4 && this.status == 412) {
			alert("Persoon komt al voor in database");
		}
	}
	xhttp.open("POST", "rest/person/add", true);
	xhttp.setRequestHeader("Content-Type", "application/json");
	xhttp.send(JSON.stringify({
		geslacht : geslacht,
		doopnaam : doopnaam,
		roepnaam : roepnaam,
		tussenvoegsel : tussenvoegsel,
		achternaam : achternaam,
		straatnaam : straatnaam,
		huisnr : huisnr,
		huisnrtoev : huisnrtoev,
		postcode : postcode,
		plaatsnaam : plaatsnaam,
		staat : staat,
		land : land,
		telefoon : telefoon,
		geboortedatum : geboortedatum,
		geboorteplaats : geboorteplaats,
		overlijdensdatum : overlijdensdatum,
		email : email,
		password : password
	}));
}

function setFocus(id) {
	var textbox = document.getElementById(id);
	textbox.focus();
	textbox.scrollIntoView();
}

function capitalize(string) {
	str = string.toLowerCase();
	var firstLetterRx = /(^|\s)[a-z]/g;
	return str.replace(firstLetterRx, upperCase);
}
function upperCase(str) {
	return str.toUpperCase();
}
