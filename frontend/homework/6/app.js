const express = require('express')
const path = require('path')
const api = require('./routes/api/post')

const app = express();

app.use(express.json());
app.use("/api/posts",api);


const port = process.env.PORT || 4000;
app.listen(port,() => {
    console.log(`Application started on port ${port}`);
})