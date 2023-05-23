import { defineStore } from "pinia";
import bootstrap from "bootstrap/dist/js/bootstrap.min.js";

import useUserStore from "@/store/modules/userStore";

import createPersistedState from "vuex-persistedstate";

export const useAppStore = defineStore("storeId", {
  state: () => ({
    bootstrap,
  }),
  modules: {
    useUserStore,
  },
  plugins: [
    createPersistedState({
      storage: sessionStorage,
    }),
  ],
});
