import { createRouter, createWebHistory } from "vue-router";

// import views
import AboutView from "@/views/AboutView.vue";
import UserView from "@/views/UserView.vue";
import TripView from "@/views/TripView.vue";
import BoardView from "@/views/BoardView.vue";

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
          component: UserSignin,
        },
        {
          path: "signup",
          name: "signup",
          component: UserSignup,
        },
        {
          // MyPage 구현해야함
          path: "mypage",
          name: "mypage",
          component: UserSignin,
        },
      ],
    },
    {
      // 관광지 검색 뷰 구현해야함.
      path: "/trip",
      name: "trip",
      component: TripView,
    },
    {
      // 관통 게시판 뷰
      path: "/board",
      name: "board",
      component: BoardView,
    },
  ],
});

export default router;
