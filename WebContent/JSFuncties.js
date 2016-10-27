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
	        text += '<a href="#" onclick="persoon(' + json[i].id + ')"' + '>'  + json[i].firstName + " " + json[i].lastName + "</a><br>";
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
		var text = "<p>" + json.id + ' '  + json.firstName + " " + json.lastName + "</p>";
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
		var x = document.getElementById(id);
//		x.value = x.value.toUpperCase();
        break;
    case 1:
        day = "Monday";
        break;
    case 2:
        day = "Tuesday";
        break;
    case 3:
        day = "Wednesday";
        break;
    case 4:
        day = "Thursday";
        break;
    case 5:
        day = "Friday";
        break;
    case 6:
        day = "Saturday";
	}
}
function setPersgeg() {
	  var firstName = document.getElementById("roepnaam").value;
	  var lastName = document.getElementById("achternaam").value;
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	var json = JSON.parse(this.responseText)
	      var text = ""
	      for (var i = 0; i < json.length; i++) {
	        text += "<p>" + json[i].firstName + " " + json[i].lastName + "</p>"
	      }
	    document.getElementById("mainpage").innerHTML = text;
	    }
	  };
	  xhttp.open("POST", "rest/person/add", true);
	  xhttp.setRequestHeader("Content-Type", "application/json");
	  xhttp.send(JSON.stringify({firstName:firstName, lastName:lastName}));
	}
