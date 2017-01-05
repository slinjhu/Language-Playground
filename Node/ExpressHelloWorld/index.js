var express = require('express');
var app = express();

app.use(express.static('static'));

app.get('/', function (req, res) {
    // Send static file
    res.sendFile( __dirname + 'static/index.html');
});

app.get('/echo', function(req, res){
    console.log(req.query);
    response = {
        message: req.query.message
    };
    res.send(response);
});

var server = app.listen(8081, function () {
    console.log(server.address());
})
