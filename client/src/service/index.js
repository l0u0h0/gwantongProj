import axios from "axios";

function ServerApi() {
  const instance = axios.create({
    // baseURL: 'http://localhost:3000',
    headers: {
      "Content-Type": "application/json;charset=utf-8",
    },
  });
  return instance;
}

export { ServerApi };
