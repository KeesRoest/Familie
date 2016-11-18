/* menubalk aan de bovenkant van het scherm fixeren */
$("document").ready(function($){
    var nav = $('#menus');

    $(window).scroll(function () {
        if ($(this).scrollTop() > 200) {
            nav.addClass("f-nav");
        } else {
            nav.removeClass("f-nav");
        }
    });
});

