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
//	  xhttp.open("GET", "overOns.html", true);
	  xhttp.send();
	}

function namenLijst() {
	  activeMenuItem("namenlijst")
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	var json = JSON.parse(this.responseText)
	      var text = ""
	      for (var i = 0; i < json.length; i++) {
	        text += '<a href="#" onclick="persoon(' + json[i].id + ')"' + '>'  + json[i].roepnaam + " " + json[i].achternaam + "</a><br>";
	      }
	    document.getElementById("mainpage").innerHTML = text;
	    }
	  };
	  xhttp.open("GET", "rest/person/all", true);
//	  xhttp.open("GET", "namenLijst.json", true);
	  xhttp.send();
	}

function persoon(id) {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	if (this.readyState == 4 && this.status == 200) {
		var json = JSON.parse(this.responseText);
		var text = "<p>" + json.id + ' '  + json.roepnaam + " " + json.achternaam + "</p>";
	    document.getElementById("mainpage").innerHTML = text;
	}
  }
	xhttp.open("GET", "rest/person/one/" + id, true);
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
    	alert("doopnaam");
    	document.getElementById("foutDoopnaam").innerHTML = "";
    	var y = document.getElementById(id).value.trim();
		if (y == null | y == ""){document.getElementById("foutDoopnaam").innerHTML = "Doopnaam invullen s.v.p.";break}
		alert("y:'" + y + "'");
		var x = document.getElementById(id);
		x.value = x.value.trim();
		document.getElementById(id).style.textTransform = "capitalize"
		break;
    case "roepnaam":
    	document.getElementById("foutRoepnaam").innerHTML = "";
    	var y = document.getElementById(id).value;
		if (y == null | y == ""){document.getElementById("foutRoepnaam").innerHTML = "Roepnaam invullen s.v.p.";break}

		var x = document.getElementById(id);
		x.value = x.value.trim();
		document.getElementById(id).style.textTransform = "capitalize"
		break;
    case "tussenvoegsel":
    	document.getElementById("foutTussenvoegsel").innerHTML = "";

		var x = document.getElementById(id);
		x.value = x.value.trim();
		document.getElementById(id).style.textTransform = "capitalize"
		break;
    case "achternaam":
    	document.getElementById("foutAchternaam").innerHTML = "";
    	var y = document.getElementById(id).value;
		if (y == null | y == ""){document.getElementById("foutAchternaam").innerHTML = "Achternaam invullen s.v.p.";break}

		var x = document.getElementById(id);
		x.value = x.value.trim();
		document.getElementById(id).style.textTransform = "capitalize"
		break;
    case "straatnaam":
    	document.getElementById("foutStraatnaam").innerHTML = "";
    	var y = document.getElementById(id).value;
		if (y == null | y == ""){document.getElementById("foutStraatnaam").innerHTML = "Straatnaam invullen s.v.p.";break}

		var x = document.getElementById(id);
		x.value = x.value.trim();
		document.getElementById(id).style.textTransform = "capitalize"
		break;
    case "huisnr":
    	document.getElementById("foutHuisnr").innerHTML = "";
    	var y = document.getElementById(id).value;
		if (y == null | y == ""){document.getElementById("foutHuisnr").innerHTML = "Huisnummer invullen s.v.p.";break}
		var x = document.getElementById(id);
		x.value = x.value.trim();
		if (isNaN(y)){document.getElementById("foutHuisnr").innerHTML = "Huisnummer mag alleen cijfers bevatten.";break}
		break;
    case "huisnrToev":
    	document.getElementById("foutHuisnrToev").innerHTML = "";

		var x = document.getElementById(id);
		x.value = x.value.trim();
		document.getElementById(id).style.textTransform = "capitalize"
		break;
    case "postcode":
    	document.getElementById("foutPostcode").innerHTML = "";
    	var y = document.getElementById(id).value;
		if (y == null | y == ""){document.getElementById("foutPostcode").innerHTML = "Postcode invullen s.v.p.";break}

		var x = document.getElementById(id);
		x.value = x.value.trim();
		document.getElementById(id).style.textTransform = "uppercase"
		break;
    case "plaatsnaam":
    	document.getElementById("foutPlaatsnaam").innerHTML = "";
    	var y = document.getElementById(id).value;
		if (y == null | y == ""){document.getElementById("foutPlaatsnaam").innerHTML = "Plaatsnaam invullen s.v.p.";break}

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
		if (y == null | y == ""){document.getElementById("foutLand").innerHTML = "Land invullen s.v.p.";break}

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
		if (y == null | y == ""){document.getElementById("foutGeboortedatum").innerHTML = "Geboortedatum invullen s.v.p.";break}

		var x = document.getElementById(id);
		x.value = x.value.trim();
		break;
    case "geboorteplaats":
    	document.getElementById("foutGeboorteplaats").innerHTML = "";
    	var y = document.getElementById(id).value;
    	alert("y:'" + y + "'");
		if (y == null | y == ""){document.getElementById("foutGeboorteplaats").innerHTML = "Geboorteplaats invullen s.v.p.";break}

		var x = document.getElementById(id);
		x.value = x.value.trim();
		document.getElementById(id).style.textTransform = "capitalize"
		break;
    case "overlijdensdatum":
    	document.getElementById("foutGeboortedatum").innerHTML = "";
    	var y = document.getElementById(id).value;

		var x = document.getElementById(id);
		x.value = x.value.trim();
		break;
    case "email":
    	document.getElementById("foutEmail").innerHTML = "";
    	var y = document.getElementById(id).value;
		if (y == null | y == ""){document.getElementById("foutEmail").innerHTML = "E-mail adres invullen s.v.p.";break}

		var x = document.getElementById(id);
		x.value = x.value.trim();
		break;
    case "password":
    	document.getElementById("foutPassword").innerHTML = "";
    	var y = document.getElementById(id).value;
		if (y == null | y == ""){document.getElementById("foutPassword").innerHTML = "Wachtwoord invullen s.v.p.";break}

		var x = document.getElementById(id);
		x.value = x.value.trim();
		if (x.length < 6){document.getElementById("foutPassword").innerHTML = "Wachtwoord moet minimaal 6 karakters bevatten.";break}
		break;
    case "password2":
    	document.getElementById("foutPassword2").innerHTML = "";
    	var y = document.getElementById(id).value;
		if (y == null | y == ""){document.getElementById("foutPassword2").innerHTML = "Wachtwoord herhalen s.v.p.";break}

		var x = document.getElementById(id);
		x.value = x.value.trim();
		break;
	}
}
function controlePersgeg(){
	alert("controle");
	checkPersGeg("doopnaam");
	return true
}
function setPersgeg() {
	if (controlePersgeg() == true) {};
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
		if (this.readyState == 4 && this.status == 200) {
			var json = JSON.parse(this.responseText)
			var text = ""
				for (var i = 0; i < json.length; i++) {
					text += "<p>" + json[i].geslacht + " " +   json[i].doopnaam + " " +   json[i].roepnaam + " " + json[i].tussenvoegsel + " " + 
					  				json[i].achternaam + " " + json[i].straatnaam + " " + json[i].huisnr + " " +   json[i].huisnrtoev + " " + 
					  				json[i].postcode + " " +   json[i].plaatsnaam + " " + json[i].staat + " " +    json[i].land + "</p>"
				}
			  	document.getElementById("mainpage").innerHTML = text;
		}
	};
	xhttp.open("POST", "rest/person/add", true);
	xhttp.setRequestHeader("Content-Type", "application/json");
	xhttp.send(JSON.stringify({geslacht:geslacht, doopnaam:doopnaam, roepnaam:roepnaam, tussenvoegsel:tussenvoegsel, achternaam:achternaam, straatnaam:straatnaam, huisnr:huisnr, huisnrtoev:huisnrtoev, postcode:postcode, plaatsnaam:plaatsnaam, staat:staat, land:land}));
}
