import { createRouter, createWebHistory } from 'vue-router';

// import views
import AboutView from "@/views/AboutView.vue";
import UserView from "@/views/UserView.vue";

// import component
import UserSignin from "@/components/user/UserSignin.vue";
import UserSignup from "@/components/user/UserSignup.vue";

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "about",
      component: AboutView,
    },
    {
      path: "/user",
      name: "user",
      redirect: "/user/signin",
      component: UserView,
      children: [
        {
          path: "signin",
          name: "signin",
          component: UserSignin
        },
        {
          path: "signup",
          name: "signup",
          component: UserSignup
        }
      ]
    }
    // {
    //   path: "/pages/landing-pages/about-us",
    //   name: "about",
    //   component: AboutView,
    // },
    // {
    //   path: "/sections/page-sections/page-headers",
    //   name: "about",
    //   component: AboutView,
    // },
  ],
});

export default router;
