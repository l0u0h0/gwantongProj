import axios from "axios";

function ServerApi() {
  const instance = axios.create({
    headers: {
      "Content-Type": "application/json;charset=utf-8",
    },
  });
  return instance;
}

export { ServerApi };
