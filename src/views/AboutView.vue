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
import AboutTeam from "@/components/about/AboutTeam.vue";
import Featuring from "@/components/about/AboutFeaturing.vue";
// import Newsletter from "@/components/about/AboutNewsletter.vue";

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
  <DefaultNavbar
    :action="{
      route: '/user/signin',
      label: '로그인',
      color: 'btn-white',
    }"
    transparent
  />
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
              Hello World! <span class="text-white" id="typed"></span>
            </h1>
            <div id="typed-strings">
              <h1>Kim</h1>
              <h1>Jin</h1>
              <h1>Aaa</h1>
            </div>
            <h1 class="text-white">&</h1>
            <h1 class="text-white">
              Bye World! <span class="text-white" id="typed-s"></span>
            </h1>
            <div id="typed-strings-s">
              <h1>Park</h1>
              <h1>Seung</h1>
              <h1>Sooo</h1>
            </div>
            <p class="lead mb-4 text-white opacity-8">
              -- 뭐라고 슬까 == 
            </p>
          </div>
        </div>
      </div>
    </div>
  </header>
  <div class="card card-body shadow-xl mx-3 mx-md-4 mt-n6">
    <Information />
    <AboutTeam />
    <Featuring />
  </div>
  <DefaultFooter />
</div>
</template>
