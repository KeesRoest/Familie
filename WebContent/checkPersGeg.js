/**
 * 
 */
function checkPersGeg(id) {
	switch (id) {
    case "doopnaam":
		var x = document.getElementById(id);
		x.value = x.value.toUpperCase();
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