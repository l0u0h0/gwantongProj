<script setup>
import { onMounted, onUnmounted } from "vue";

// common components
import DefaultNavbar from "@/components/common/NavbarDefault.vue";
import DefaultFooter from "@/components/common/FooterDefault.vue";

// typed.js import
import Typed from "typed.js";

// trip components
import TripList from "@/components/trip/TripList.vue";

// pinia
import { useUserStore } from "@/store/modules/userStore";
import { storeToRefs } from "pinia";

const store = useUserStore();

const { userinfo } = storeToRefs(store);

const body = document.getElementsByTagName("body")[0];

//hooks
onMounted(() => {
  body.classList.add("about-us");
  body.classList.add("bg-gray-200");

  if (document.getElementById("typed")) {
    // eslint-disable-next-line no-unused-vars
    var typeds = new Typed("#typed", {
      stringsElement: "#typed-strings",
      typeSpeed: 90,
      backSpeed: 90,
      backDelay: 200,
      startDelay: 500,
      loop: true,
    });
  }
});
let user =
  sessionStorage.getItem("logged") != null
    ? sessionStorage.getItem("logged")
    : null;
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
    />
    <header class="bg-gradient-dark">
      <div
        class="page-header min-vh-50"
        :style="{ backgroundImage: `url(https://wimg.mk.co.kr/meet/neds/2020/12/image_readtop_2020_1263248_16074725144464348.jpg)` }"
      >
        <span class="mask bg-gradient-dark opacity-6"></span>
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-lg-8 text-center mx-auto my-auto">
              <h1 class="text-white">
                <span class="text-white" id="typed"></span> 관광지
              </h1>
              <div id="typed-strings">
                <h1>지역별</h1>
                <h1>유형별</h1>
              </div>
              <p class="lead mb-4 text-white opacity-8">== 관광지 검색 ==</p>
            </div>
          </div>
        </div>
      </div>
    </header>
    <div class="card card-body shadow-xl mx-3 mx-md-4 mt-n6">
      <TripList />
    </div>
    <DefaultFooter />
  </div>
</template>
