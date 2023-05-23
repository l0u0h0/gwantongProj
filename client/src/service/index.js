import axios from "axios";

function getServerApi() {
  const instance = axios.create({
    // env 로 빼야하나?
    baseURL: "http://localhost:8080",
    header: {
      "Content-Type": "application/json;charset=utf-8",
    },
  });
  return instance;
}

export { getServerApi };