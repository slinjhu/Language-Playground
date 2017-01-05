var express = require('express');
var app = express();

app.use(express.static('static'));

var bodyParser = require('body-parser');
var multer  = require('multer');
app.use(bodyParser.urlencoded({extended: false}));
app.use(multer({dest:'static/upload/'}).any());


app.get('/', function (req, res) {
    // Send static file
    res.sendFile( __dirname + 'static/index.html');
});

app.get('/echo', function(req, res){
    console.log(req.query);
    var response = {
        message: req.query.message
    };
    res.send(response);
});

app.post('/upload', function (req, res) {
    var files = req.files;
    for(var i = 0; i < files.length; i++){
        console.log(files[i]);
    }
})

var server = app.listen(8081, function () {
    console.log(server.address());
})
