function checkIn() {
    var request = $.get("checkIn", {userId : ${session.user.id}, teamId : $("select#teamSelect").val(), 
        locationId : $("select#locSelect").val()}, function(data) {
            var jsonData = JSON.parse(request.responseText);
            if (jsonData.overtaken == "true") {
                showPopup();
            } 
            $("#thanks").append("Your current location: "  + jsonData.visit.location.name);
        });
    $("#checkIn").fadeOut("slow");
    $("#thanks").fadeIn("slow"); 
}