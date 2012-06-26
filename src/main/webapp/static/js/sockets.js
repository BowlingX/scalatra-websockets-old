$(function(){

    var socket = $.atmosphere
    var request = new jQuery.atmosphere.AtmosphereRequest();
    request.url = "http://localhost:8080/at/status";
    request.contentType = "application/json";
    request.transport = "streaming"
    request.fallbackTransport = "long-polling"
    request.onMessage = function(response) {
        var message = response.responseBody;
        if("" !== message) {
            console.log(message);
        }
    };

    request.onError = function(response) {
        console.log(response);
    };


    var subSocket = socket.subscribe(request);

    $("#david").click(function(e){
        e.preventDefault();
        subSocket.push(JSON.stringify({user:"david"}))
    });

    $("#kristina").click(function(e){
        e.preventDefault();
        subSocket.push(JSON.stringify({user:"kristina"}))
    });

});

