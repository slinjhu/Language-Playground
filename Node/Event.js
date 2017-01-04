var events = require('events');

// Create an eventEmitter object
var eventEmitter = new events.EventEmitter();

eventEmitter.on('start', function(){
    console.log('Server started\n');
});

eventEmitter.emit('start');
