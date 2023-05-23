// login, logout, memberInsert, modify, delete

import { getServerApi } from "./index";

const api = getServerApi();

async function login(user, success, fail) {
  await api.post(`/login`, JSON.stringify(user)).then(success).catch(fail);
}

async function logout(id, success, fail) {
  await api.get(`/logout/${id}`).then(success).catch(fail);
}

async function memberInsert(user, success, fail) {
  await api.post(`/memberInsert`, JSON.stringify(user)).then(success).catch(fail);
}

async function memberModify(user, success, fail) {
  await api.put(`/modify`, JSON.stringify(user)).then(success).catch(fail);
}

async function memberDelete(id, success, fail) {
  await api.delete(`/delete/${id}`).then(success).catch(fail);
}

export { login, logout, memberInsert, memberModify, memberDelete };