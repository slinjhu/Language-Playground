var express = require('express');
var app = express();

app.use(express.static('static'));

app.get('/', function (req, res) {
    res.send('Hello World');
})

var server = app.listen(8081, function () {
    console.log(server.address());
})
