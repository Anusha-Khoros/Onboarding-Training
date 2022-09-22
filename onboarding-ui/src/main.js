var http = require('http');
var https = require('https');
const path = require('path');
var fs = require('fs');
const bodyParser = require('body-parser');

const express = require("express");
const app = express();

console.log(path.join(__dirname,'../public'));
const staticPath = path.join(__dirname,'../public');
app.use(express.static(staticPath));

app.get("/",(req,res)=>{
    res.send("hello world from the anusha");
});
app.listen(9000,()=>{
    console.log("listing the port at 9000");
});

