import axios from "axios";

function getApi() {
  const instance = axios.create({
    // env 로 빼야하나?
    baseURL: "http://localhost:8080",
    header: {
      "Content-Type": "application/json;charset=utf-8",
    },
  });
  return instance;
}

// 관광지 공공데이터 API 사용하나? 전에 디비로 연동하지 않았나?

export { getApi };