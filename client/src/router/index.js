import { createRouter, createWebHistory } from "vue-router";

// import views
import AboutView from "@/views/AboutView.vue";
import UserView from "@/views/UserView.vue";
import TripView from "@/views/TripView.vue";
import BoardView from "@/views/BoardView.vue";

// import component
import UserSignin from "@/components/user/UserSignin.vue";
import UserSignup from "@/components/user/UserSignup.vue";
import BoardList from "@/components/board/BoardList.vue";
import BoardDetail from "@/components/board/BoardDetail.vue";
import BoardWrite from "@/components/board/BoardWrite.vue";
import BoardModify from "@/components/board/BoardModify.vue";
import UserMyPage from "@/components/user/UserMyPage.vue";

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
          component: UserMyPage,
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
      redirect: "/board/list",
      component: BoardView,
      children: [
        {
          path: "list",
          name: "list",
          component: BoardList,
        },
        {
          path: "boardview/:no",
          name: "boardview",
          component: BoardDetail,
        },
        {
          path: "boardwrite",
          name: "boardwrite",
          component: BoardWrite,
        },
        {
          path: "boardmodify/:no",
          name: "boardmodify",
          component: BoardModify,
        },
      ],
    },
  ],
});

export default router;
