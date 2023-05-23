import axios from "axios";

function ServerApi() {
  const instance = axios.create({
    // env 로 빼야하나?
    baseURL: "http://localhost:3000/",
    header: {
      "Content-Type": "application/json;charset=utf-8",
    },
  });
  return instance;
}

export { ServerApi };