var popupStatus = 0;
    
$(function() {      
    disablePopup();  
    $("#popupContentClose").click(function() {  
        disablePopup();  
    });  

    $("#popupBackground").click(function() {  
        disablePopup();  
    });
});
    

function showPopup() {
    centerPopup();
    loadPopup();
}

function loadPopup() {
    if (popupStatus == 0) {
        $("#popupBackground").css({
            "opacity": "0.7"
        });  
        $("#popupBackground").fadeIn("slow");  
        $("#popupContent").fadeIn("slow");  
        popupStatus = 1;
    }
}
    
function disablePopup() {
    if(popupStatus == 1){  
        $("#popupBackground").fadeOut("slow");  
        $("#popupContent").fadeOut("slow");  
        popupStatus = 0;  
    }  
}
   
function centerPopup() {
    var windowWidth = document.documentElement.clientWidth;  
    var windowHeight = document.documentElement.clientHeight;  
    var popupHeight = $("#popupContent").height();  
    var popupWidth = $("#popupContent").width();  

    $("#popupContent").css({  
        "position": "absolute",  
        "top": windowHeight/2 - popupHeight/2,  
        "left": windowWidth/2 - popupWidth/2  
    });  
         
    $("#popupBackground").css({  
        "height": windowHeight  
    });  
}