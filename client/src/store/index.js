import { defineStore } from "pinia";
import bootstrap from "bootstrap/dist/js/bootstrap.min.js";

import useUserStore from "@/store/modules/userStore";
import useAreaStore from "@/store/modules/areaStore";

import createPersistedState from "vuex-persistedstate";

export const useAppStore = defineStore("storeId", {
  state: () => ({
    bootstrap,
  }),
  modules: {
    useUserStore,
    useAreaStore,
  },
  plugins: [
    createPersistedState({
      storage: sessionStorage,
    }),
  ],
});
