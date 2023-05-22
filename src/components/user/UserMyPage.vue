<script setup>
import { onMounted, onUnmounted } from "vue";
import router from "@/router";

//example components
import DefaultNavbar from "@/components/common/NavbarDefault.vue";
import DefaultFooter from "@/components/common/FooterDefault.vue";

//Vue Material Kit 2 components
import MaterialInput from "@/components/Material/MaterialInput.vue";
import MaterialButton from "@/components/Material/MaterialButton.vue";
// material-input
import setMaterialInput from "@/assets/js/material-input";

//image
import bg from "@/assets/img/bg9.jpg";

//dep
import Typed from "typed.js";

const body = document.getElementsByTagName("body")[0];
//hooks
onMounted(() => {
  body.classList.add("about-us");
  body.classList.add("bg-gray-200");

  setMaterialInput();

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

onMounted(() => {

});

const deleteUser = () => {
  alert("회원탈퇴 진행해야함");
  router.push("/");
};

const modifyUser = () => {
  alert("회원수정 진행해야함");
  router.push("/");
};

onUnmounted(() => {
  body.classList.remove("about-us");
  body.classList.remove("bg-gray-200");
});
</script>
<script>
export default {
  data() {
    return {
      percent: 0,
      name: "",
      id: "",
      password: "",
      email: "",
      area: {
        sido: "",
        gugun: "",
      },
      check: {
        name: false,
        id: false,
        password: false,
        email: false,
        area: false,
      },
    };
  },
  watch: {
    name() {
      if (this.name != null && !this.check.name) {
        this.check.name = true;
        document.getElementById("namediv").setAttribute("class", "input-group input-group-outline my-3 is-valid");
      } else if (this.name == "" && this.check.name) {
        this.check.name = false;
        document.getElementById("namediv").setAttribute("class", "input-group input-group-outline my-3 is-invalid");
      }
    },
    id() {
      if (this.id.length >= 8 && !this.check.id) {
        this.check.id = true;
        document.getElementById("iddiv").setAttribute("class", "input-group input-group-outline my-3 is-valid");
      } else if (this.id.length < 8 && this.check.id) {
        this.check.id = false;
        document.getElementById("iddiv").setAttribute("class", "input-group input-group-outline my-3 is-invalid");
      }
    },
    password() {
      if (
        this.password.length >= 8 &&
        !this.check.password
      ) {
        this.check.password = true;
        document.getElementById("passworddiv").setAttribute("class", "input-group input-group-outline my-3 is-valid");
      } else if (this.password.length < 8 && this.check.password) {
        this.check.password = false;
        document.getElementById("passworddiv").setAttribute("class", "input-group input-group-outline my-3 is-invalid");
      }
    },
    email() {
      if (this.email != null && !this.check.email) {
        this.check.email = true;
        document.getElementById("emaildiv").setAttribute("class", "input-group input-group-outline my-3 is-valid");
      } else if (this.email == "" && this.check.email) {
        this.check.email = false;
        document.getElementById("emaildiv").setAttribute("class", "input-group input-group-outline my-3 is-invalid");
      }
    },
  },
};
</script>
<template>
  <div>
    <!-- 로그인 하기 전 상태 -->
    <DefaultNavbar :action="{
      route: '/user/signin',
      label: '로그인',
      color: 'btn-dark',
    }" :sticky="true" />
    <!-- // 로그인 한 상태
          <DefaultNavbar
            :action="{
              route: '/user/logout',
              label: '로그아웃',
              color: 'btn-dark',
            }"
            :sticky="true"
          /> -->
    <header class="bg-gradient-dark">
      <div class="page-header min-vh-45" :style="{ backgroundImage: `url(${bg})` }">
        <span class="mask bg-gradient-dark opacity-8"></span>
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-lg-8 text-center mx-auto my-auto">
              <h1 class="text-white">
                <span class="text-white text-sans-serif" id="typed"></span>
              </h1>
              <div id="typed-strings">
                <h1>My Page</h1>
              </div>
            </div>
          </div>
        </div>
      </div>
    </header>
    <div class="container my-auto mt-n6">
      <div class="row">
        <div class="card z-index-0 fadeIn3 fadeInBottom">
          <div class="col-lg-4 col-md-8 col-12 mx-auto card-header p-0 position-relative mt-n4 mx-3 z-index-2">
            <div class="bg-gradient-secondary shadow-dark border-radius-lg py-3 pe-1">
              <h4 class="text-white font-weight-bolder text-center mt-2 mb-0">
                정보 수정
              </h4>
            </div>
          </div>
          <div class="card-body">
            <form role="form" class="col-lg-4 col-md-8 col-12 mx-auto text-start" onsubmit="return false;">
              <p class="lead">username</p>
              <MaterialInput v-model.lazy="name" id="name" class="input-group-outline my-3" :label="{
                text: '이름을 입력해주세요.',
                class: 'form-label',
              }" type="text" ref="name" />
              <hr />
              <p class="lead">userid</p>
              <MaterialInput v-model.lazy="id" id="id" class="input-group-outline my-3" :label="{
                text: '아이디를 입력해주세요.',
                class: 'form-label',
              }" type="text" />
              <hr />
              <p class="lead">userpassword</p>
              <MaterialInput
                    v-model.lazy="password"
                    id="password"
                    class="input-group-outline mb-3"
                    :label="{
                      text: '비밀번호를 입력해주세요.',
                      class: 'form-label',
                    }"
                    type="password"
                  />
              <hr />
              <p class="lead">useremail</p>
              <MaterialInput v-model="email" id="email" class="input-group-outline my-3" :label="{
                text: '이메일을 입력해주세요.',
                class: 'form-label',
              }" type="email" />
              <div class="form-group d-flex justify-content-between">
                <div class="col m-2">
                  <label class="input-group text-dark" for="sido">시/도</label>
                  <select v-model="area.sido" class="form-select input-group-outline" id="sido" name="sido">
                    <option selected value="basicSelect">
                      선택하기...
                    </option>
                    <option value="1">서울특별시</option>
                    <option value="2">대구특별시</option>
                    <option value="3">제주특별시</option>
                  </select>
                </div>
                <div class="col m-2">
                  <label class="input-group text-dark" for="gugun">구/군</label>
                  <select v-model="area.gugun" class="form-select input-group-outline" id="gugun" name="gugun">
                    <option selected value="basicSelect">
                      선택하기...
                    </option>
                    <option value="1">강동구</option>
                    <option value="2">남양군</option>
                    <option value="3">시흥군</option>
                  </select>
                </div>
              </div>
              <div class="text-center d-flex justify-content-between">
                <MaterialButton class="mx-3 my-4 mb-2" variant="gradient" color="secondary" size="lg" @click="modifyUser()">
                  정보수정</MaterialButton>
                <MaterialButton class="mx-3 my-4 mb-2" variant="gradient" color="secondary" size="lg" @click="deleteUser()">
                  회원탈퇴</MaterialButton>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
    <DefaultFooter />
  </div>
</template>
