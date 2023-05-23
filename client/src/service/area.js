// getSido, getGugun, getMarker

import { ServerApi } from "./index";

const api = ServerApi();

async function getSido(success, fail) {
  await api.get(`/getSido`).then(success).catch(fail);
}

async function getGugun(id, success, fail) {
  await api.get(`/getGugun/${id}`).then(success).catch(fail);
}

async function getMarker(area, success, fail) {
  await api.post(`/getMarker`, JSON.stringify(area)).then(success).catch(fail);
}

export { getSido, getGugun, getMarker };