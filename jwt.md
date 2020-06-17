# Use JWT from javascript

## Test login

```js
var axios = require('axios');
var data = JSON.stringify({"userName":"dima","password":"secret"});

var config = {
  method: 'post',
  url: 'localhost:8080/api/login',
  headers: { 
    'Content-Type': 'application/json'
  },
  data : data
};

axios(config)
.then(function (response) {
  console.log(JSON.stringify(response.data));
})
.catch(function (error) {
  console.log(error);
});

```

## Test ping 

```js
var axios = require('axios');

var config = {
  method: 'get',
  url: 'http://localhost:8080/api/ping',
  headers: { 
    'Authorization': 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkaW1hIiwiaWF0IjoxNTkyMzkwMjQ1LCJleHAiOjE1OTIzOTM4NDV9.gZowN496k-9S9Rdh0xdXIBniZU8QjyL3L7Ic_Kx-cFE'
  }
};

axios(config)
.then(function (response) {
  console.log(JSON.stringify(response.data));
})
.catch(function (error) {
  console.log(error);
});
```