/**
 * 
 */
function overOns() {
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
	  xhttp.open("GET", "rest/person", true);
//	  xhttp.open("GET", "namenLijst.json", true);
	  xhttp.send();
	}
function persGeg() {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("mainpage").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("GET", "persGeg.html", true);
	  xhttp.send();
	}
function test() {
	 if(document.naam.tekstregel.value == "") { 
		 window.alert("Jammer, even een tekstje invullen -.-'") 
		 }else{ 
		 window.alert(document.naam.tekstregel.value) 
		 }
 }