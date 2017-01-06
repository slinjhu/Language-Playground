import React from 'react';
import Like from './like.js';
import {render} from 'react-dom';

function App(props) {
    return (
            <div>
            <p> Hello { props.name }!</p>
            <Like/>
            </div>
    );
}

render(<App name='Sen'/>, document.getElementById('app'));
