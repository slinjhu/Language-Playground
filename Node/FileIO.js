var fs = require('fs');

fs.readFile('HelloWorld.js', function(err, data){
    if (err) return console.error(err);
    console.log(data.toString());
});

console.log('Asynchronously read file:\n');
