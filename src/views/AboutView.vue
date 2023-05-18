<script setup>
import { onMounted, onUnmounted } from "vue";

//example components
import DefaultNavbar from "@/components/common/NavbarDefault.vue";
import DefaultFooter from "@/components/common/FooterDefault.vue";

//image
import bg0 from "@/assets/img/rock_grandpa.jpg";

//dep
import Typed from "typed.js";

//sections
import Information from "@/components/about/AboutInformation.vue";
import AboutBlock from "@/components/about/AboutBlock.vue";
import Featuring from "@/components/about/AboutFeaturing.vue";

const body = document.getElementsByTagName("body")[0];
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
});

onUnmounted(() => {
  body.classList.remove("about-us");
  body.classList.remove("bg-gray-200");
});
</script>
<template>
  <div>
    <!-- 로그인 하기 전 상태 -->
    <DefaultNavbar
      :action="{
        route: '/user/signin',
        label: '로그인',
        color: 'btn-secondary',
      }"
      :sticky="true"
      :transparent="false"
    />
    <!-- // 로그인 한 상태
    <DefaultNavbar
      :action="{
        route: '/user/logout',
        label: '로그아웃',
        color: 'btn-secondary',
      }"
      transparent
    /> -->
    <header class="bg-gradient-dark">
      <div
        class="page-header min-vh-75"
        :style="{ backgroundImage: `url(${bg0})` }"
      >
        <span class="mask bg-gradient-dark opacity-6"></span>
        <div class="container">
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
                관광지 정보 검색 및 커뮤니티
              </p>
            </div>
          </div>
        </div>
      </div>
    </header>
    <div class="card card-body shadow-xl mx-3 mx-md-4 mt-n6">
      <Information />
      <AboutBlock />
      <Featuring />
    </div>
    <DefaultFooter />
  </div>
</template>
