const express= require("express");
const cors= require('cors');

const app=express();
const posts=require("./data/Posts");
const postApi= require("./routes/api/posts");

app.use(cors());
app.use(express.json());


app.listen(5000, () =>{
    console.log("Application started on port 5000");
})

app.use((req,res,next)=>{
    console.log("Request", req);
    next()
})
app.use("/api", postApi);

