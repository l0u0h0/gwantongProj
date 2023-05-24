import axios from "axios";

function ServerApi() {
  const instance = axios.create({
    // env 로 빼야하나?
    header: {
      "Content-Type": "application/json;charset=utf-8",
    },
  });
  return instance;
}

export { ServerApi };
