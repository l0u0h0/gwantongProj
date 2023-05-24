import { createApp } from "vue";
import { createPinia } from "pinia";
import App from "./App.vue";
import router from "./router";
import VueCookies from "vue-cookies";

import materialKit from "./material-kit";

const app = createApp(App);

app.use(VueCookies);
app.$cookies.config("7d");
app.use(createPinia());
app.use(router);
app.use(materialKit);
app.mount("#app");