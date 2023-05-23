// login, logout, memberInsert, modify, delete

import { ServerApi } from "./index";

const api = ServerApi();

async function login(user, success, fail) {
  await api.post(`/login`, JSON.stringify(user)).then(success).catch(fail);
}

async function logout(success, fail) {
  await api.get(`/logout`).then(success).catch(fail);
}

async function memberInsert(user, success, fail) {
  await api.post(`/register`, JSON.stringify(user)).then(success).catch(fail);
}

async function memberModify(user, success, fail) {
  await api
    .post(`/updateMember`, JSON.stringify(user))
    .then(success)
    .catch(fail);
}

async function memberDelete(success, fail) {
  await api.get(`/deleteMember`).then(success).catch(fail);
}

export { login, logout, memberInsert, memberModify, memberDelete };
