const express = require('express');
const cors = require('cors');
const app = express();

const apiPostRouter = require("./controller/routingapi"); 
const PORT = 3000 || process.env.PORT;

app.use(express.json()); 
app.use(cors());

app.use("/sanskar/post", apiPostRouter); 
app.listen(PORT, () => console.log(`Express server currently running on port ${PORT}`));
