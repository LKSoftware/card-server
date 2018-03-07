const express = require('express');
const expressLogging = require('express-logging');
const path = require('path');
const app = express();
const port = 7789;

app.use(expressLogging(console));

app.get('/index', (req,res) => {
    res.sendFile(path.resolve('./index.html'))
});
app.post('/game', (req,res) => {
    console.log('LOL')
    if(req.body.sessionName != null) {
        res.sendFile(path.resolve('./game.html'))
    }
});

app.listen(port, () =>{
    console.log("CardGame Server listening on " + port)
});
