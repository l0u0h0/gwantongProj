import { defineStore } from "pinia";
import bootstrap from "bootstrap/dist/js/bootstrap.min.js";

import userStore from "@/store/modules/userStore";

import createPersistedState from "vuex-persistedstate";

export const useAppStore = defineStore("storeId", {
  state: () => ({
    bootstrap,
  }),
  modules: {
    userStore,
  },
  plugins: [
    createPersistedState({
      storage: sessionStorage,
    }),
  ],
});
