function setup(jsonData) {
    var latlng = new google.maps.LatLng(google.loader.ClientLocation.latitude,
        google.loader.ClientLocation.longitude);
    var myOptions = {
        zoom: 10,
        center: latlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    var map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
     
    var paths = new Array(jsonData.regions.length);
        
    for (var i = 0; i < jsonData.regions.length; i++) {
         var hull = new Array(jsonData.regions[i].length);
         for (var j = 0; j < jsonData.regions[i].length; j++) {
            var hullPos = new google.maps.LatLng(jsonData.regions[i][j].x, jsonData.regions[i][j].y);
            hull[j] = hullPos;
        }
        paths[i] = hull;
    }
        
    for (var i = 0; i < jsonData.locations.length; i++) {
        var locPos = new google.maps.LatLng(jsonData.locations[i].latitude, jsonData.locations[i].longitude);
        var marker = new google.maps.Marker({
             position: locPos,
             map: map, 
             title: jsonData.locations[i].name
        });
    }
    var polygon = new google.maps.Polygon({
        paths: paths,
        strokeColor: "#FF0000",
        strokeOpacity: 0.8,
        strokeWeight: 2,
        fillColor: "#FF0000",
        fillOpacity: 0.35
    });
        
    polygon.setMap(map)
        
}