<script setup>
import { onMounted, onUnmounted } from "vue";

//example components
import DefaultNavbar from "@/components/common/NavbarDefault.vue";
import DefaultFooter from "@/components/common/FooterDefault.vue";

//image
import bg from "@/assets/img/bg9.jpg";

//dep
import Typed from "typed.js";

//sections
import BoardList from "@/components/board/BoardList.vue";

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
        color: 'btn-white',
      }"
      transparent
    />
    <!-- // 로그인 한 상태
    <DefaultNavbar
      :action="{
        route: '/user/logout',
        label: '로그아웃',
        color: 'btn-white',
      }"
      transparent
    /> -->
    <header class="bg-gradient-dark">
      <div
        class="page-header min-vh-45"
        :style="{ backgroundImage: `url(${bg})` }"
      >
        <span class="mask bg-gradient-dark opacity-8"></span>
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-lg-8 text-center mx-auto my-auto">
              <h1 class="text-white">
                Hello World! <span class="text-white" id="typed"></span>
              </h1>
              <div id="typed-strings">
                <h1>Park</h1>
                <h1>Ji</h1>
                <h1>Young</h1>
              </div>
              <p class="lead mb-4 text-white opacity-8">== 게시판 페이지 ==</p>
            </div>
          </div>
        </div>
      </div>
    </header>
    <div class="card card-body shadow-xl mx-3 mx-md-4 mt-n6">
      <router-view />
    </div>
    <DefaultFooter />
  </div>
</template>
