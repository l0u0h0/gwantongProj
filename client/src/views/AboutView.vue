<script setup>
import { onMounted, onUnmounted } from "vue";

// common components
import DefaultNavbar from "@/components/common/NavbarDefault.vue";
import DefaultFooter from "@/components/common/FooterDefault.vue";

// bg
import bg from "@/assets/img/rock_grandpa.jpg";

// typed
import Typed from "typed.js";

// about components
import Information from "@/components/about/AboutInformation.vue";
import Featuring from "@/components/about/AboutFeaturing.vue";
import TheCubeView from "@/components/about/TheCubeView.vue";

// pinia
import { useUserStore } from "@/store/modules/userStore";
import { storeToRefs } from "pinia";

const store = useUserStore();

const { userinfo } = storeToRefs(store);

const body = document.getElementsByTagName("body")[0];

let user = null;

//hooks
onMounted(() => {
  body.classList.add("about-us");
  body.classList.add("bg-gray-200");

  if (document.getElementById("typed")) {
    // eslint-disable-next-line no-unused-vars
    var typed = new Typed("#typed", {
      stringsElement: "#typed-strings",
      typeSpeed: 90,
      backSpeed: 90,
      backDelay: 200,
      startDelay: 500,
      loop: true,
    });
  }
  if (document.getElementById("typed-s")) {
    // eslint-disable-next-line no-unused-vars
    var typeds = new Typed("#typed-s", {
      stringsElement: "#typed-strings-s",
      typeSpeed: 90,
      backSpeed: 90,
      backDelay: 200,
      startDelay: 500,
      loop: true,
    });
  }
  console.log(sessionStorage.getItem("logged"));

  user =
  sessionStorage.getItem("logged") != null
    ? sessionStorage.getItem("logged")
      : null;
  if (sessionStorage.getItem("logged") != null) {
    store.setUserInfo(sessionStorage.getItem("logged"));
  } else store.setUserInfo(null);
});
console.log(user);

onUnmounted(() => {
  body.classList.remove("about-us");
  body.classList.remove("bg-gray-200");
});
</script>
<template>
  <div>
    <!-- 로그인 하기 전 상상태 -->
    <DefaultNavbar
      v-if="!userinfo"
      :user="userinfo"
      :action="{
        route: '/user/signin',
        label: '로그인',
        color: 'btn-dark',
      }"
      :sticky="true"
      :transparent="false"
    />
    <!-- 로그인 한 상태 -->
    <DefaultNavbar
      v-else
      :user="userinfo"
      :key="userinfo"
      :action="{
        route: '#',
        label: '로그아웃',
        color: 'btn-dark',
      }"
      :sticky="true"
      :transparent="false"
    />
    <header class="bg-gradient-dark">
      <div
        class="page-header min-vh-75"
        :style="{ backgroundImage: `url(${bg})` }"
      >
        <span class="mask bg-gradient-dark opacity-6"></span>
        <div class="container mt-3">
          <div class="row justify-content-center">
            <div class="col-lg-8 text-center mx-auto my-auto">
              <h1 class="text-white">
                DAMP<span class="text-white" id="typed"></span>
              </h1>
              <div id="typed-strings">
                <h1>roject</h1>
              </div>
              <h1 class="text-white opacity-5">&</h1>
              <h1 class="text-white">
                <span class="text-white" id="typed-s"></span>
              </h1>
              <div id="typed-strings-s">
                <h1>지역별 관광지</h1>
                <h1>나의 여행계획</h1>
                <h1>여행 게시판</h1>
              </div>
              <p class="lead mb-4 text-white opacity-8">
                관광지 정보 검색 서비스
              </p>
            </div>
          </div>
        </div>
      </div>
    </header>
    <div class="card card-body shadow-xl mx-3 mx-md-4 mt-n6">
      <Information />
      <TheCubeView />
      <Featuring />
    </div>
    <DefaultFooter />
  </div>
</template>
