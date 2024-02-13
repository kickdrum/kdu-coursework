const uuid = require('uuid');

const posts = [
    {
        id: uuid.v4(),
        name: 'John Doe',
        email: 'john@example.com',
        content: 'This is the first post.'
    },
    {
        id: uuid.v4(),
        name: 'Alice Smith',
        email: 'alice@example.com',
        content: 'Hello from Alice!'
    },
    {
        id: uuid.v4(),
        name: 'Bob Johnson',
        email: 'bob@example.com',
        content: 'Another day, another post.'
    },
    {
        id: uuid.v4(),
        name: 'Emily Brown',
        email: 'emily@example.com',
        content: 'Just sharing some thoughts.'
    },
    {
        id: uuid.v4(),
        name: 'Michael Clark',
        email: 'michael@example.com',
        content: 'Feeling inspired today!'
    }
];

module.exports = posts;