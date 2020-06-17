import React, { useEffect, useState } from "react";
import axios from "axios";
import "./App.css";

function App() {
  const [message, setMessage] = useState();

  useEffect(() => {
    async function fetchData() {
      const loginResponse = await axios.post("/api/login", {
        userName: "dima",
        password: "secret",
      });
      const pingResponse = await axios.get("/api/ping", {
        headers: {
          Authorization: "Bearer " + loginResponse.data.token,
        },
      });
      setMessage(pingResponse.data);
    }
    fetchData();
  }, []);

  return (
    <div className="App">
      <header className="App-header">
        <p> Message: {message}</p>
      </header>
    </div>
  );
}

export default App;
