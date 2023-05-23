// getSido, getGugun, searchByAddress, searchByType

import { ServerApi } from "./index";

const api = ServerApi();

async function getSido(success, fail) {
  await api.get(`/getSido`).then(success).catch(fail);
}

async function getGugun(sido, success, fail) {
  await api.get(`/getGugun/${sido}`).then(success).catch(fail);
}

async function searchByaddress(area, success, fail) {
  const sido = area.sido;
  const gugun = area.gugun;
  await api
    .get(`/searchByAddress&sido=${sido}&gugun=${gugun}`)
    .then(success)
    .catch(fail);
}

async function searchByType(type, success, fail) {
  await api.get(`/searchByType/${type}`).then(success).catch(fail);
}

export { getSido, getGugun, searchByaddress, searchByType };
