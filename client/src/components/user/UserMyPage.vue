<script setup>
import { onMounted, onUnmounted } from "vue";
import axios from "axios";

// common components
import DefaultNavbar from "@/components/common/NavbarDefault.vue";
import DefaultFooter from "@/components/common/FooterDefault.vue";

// Material components
import MaterialInput from "@/components/Material/MaterialInput.vue";
import MaterialButton from "@/components/Material/MaterialButton.vue";
// material-input
import setMaterialInput from "@/assets/js/material-input";

// bg image
import bg from "@/assets/img/bg9.jpg";

// typed.js import
import Typed from "typed.js";

// pinia
import { useUserStore } from "@/store/modules/userStore";

const store = useUserStore();

const body = document.getElementsByTagName("body")[0];
//hooks
onMounted(async () => {
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

  const areaUrl =
    "https://apis.data.go.kr/B551011/KorService1/areaCode1?serviceKey=" +
    process.env.VUE_APP_AREA_API_KEY +
    "&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json";

  await axios.get(areaUrl).then((data) => makeOption(data));

  function makeOption(data) {
    const areas = data.data.response.body.items.item;

    let sel = document.getElementById("search-area");
    areas.forEach((area) => {
      let opt = document.createElement("option");
      opt.setAttribute("value", area.code);
      opt.setAttribute("class", "dropdown-item border-radius-md");
      opt.appendChild(document.createTextNode(area.name));
      sel.appendChild(opt);
    });
  }
  document.getElementById("search-area").addEventListener("click", () => {
    let areaCode = document.getElementById("search-area").value;
    let areaUrl =
      "https://apis.data.go.kr/B551011/KorService1/areaCode1?serviceKey=" +
      process.env.VUE_APP_AREA_API_KEY +
      "&numOfRows=30&pageNo=1&MobileOS=ETC&areaCode=" +
      areaCode +
      "&MobileApp=AppTest&_type=json";

    axios.get(areaUrl).then((data) => makeOption(data));

    function makeOption(data) {
      let areas = data.data.response.body.items.item;
      let sel = document.getElementById("search-area-detail");

      sel.innerHTML = '<option value="0" selected>검색 할 구/군 선택</option>';
      areas.forEach((area) => {
        let opt = document.createElement("option");
        opt.setAttribute("value", area.code);
        opt.setAttribute("class", "dropdown-item border-radius-md");

        opt.appendChild(document.createTextNode(area.name));

        sel.appendChild(opt);
      });
    }
  });
});

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
      id: "default",
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
        document
          .getElementById("namediv")
          .setAttribute(
            "class",
            "input-group input-group-outline my-3 is-valid"
          );
      } else if (this.name == "" && this.check.name) {
        this.check.name = false;
        document
          .getElementById("namediv")
          .setAttribute(
            "class",
            "input-group input-group-outline my-3 is-invalid"
          );
      }
    },
    id() {
      if (this.id.length >= 8 && !this.check.id) {
        this.check.id = true;
        document
          .getElementById("iddiv")
          .setAttribute(
            "class",
            "input-group input-group-outline my-3 is-valid"
          );
      } else if (this.id.length < 8 && this.check.id) {
        this.check.id = false;
        document
          .getElementById("iddiv")
          .setAttribute(
            "class",
            "input-group input-group-outline my-3 is-invalid"
          );
      }
    },
    password() {
      if (this.password.length >= 8 && !this.check.password) {
        this.check.password = true;
        document
          .getElementById("passworddiv")
          .setAttribute(
            "class",
            "input-group input-group-outline my-3 is-valid"
          );
      } else if (this.password.length < 8 && this.check.password) {
        this.check.password = false;
        document
          .getElementById("passworddiv")
          .setAttribute(
            "class",
            "input-group input-group-outline my-3 is-invalid"
          );
      }
    },
    email() {
      if (this.email != null && !this.check.email) {
        this.check.email = true;
        document
          .getElementById("emaildiv")
          .setAttribute(
            "class",
            "input-group input-group-outline my-3 is-valid"
          );
      } else if (this.email == "" && this.check.email) {
        this.check.email = false;
        document
          .getElementById("emaildiv")
          .setAttribute(
            "class",
            "input-group input-group-outline my-3 is-invalid"
          );
      }
    },
  },
};
</script>
<template>
  <div>
    <!-- 로그인 하기 전 상상태 -->
    <DefaultNavbar
      v-if="!user"
      :user="user"
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
      :user="user"
      :action="{
        route: '/user/logout',
        label: '로그아웃',
        color: 'btn-dark',
      }"
      :sticky="true"
    />
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
          <div
            class="col-lg-4 col-md-8 col-12 mx-auto card-header p-0 position-relative mt-n4 mx-3 z-index-2"
          >
            <div
              class="bg-gradient-secondary shadow-dark border-radius-lg py-3 pe-1"
            >
              <h4 class="text-white font-weight-bolder text-center mt-2 mb-0">
                정보 수정
              </h4>
            </div>
          </div>
          <div class="card-body">
            <form
              role="form"
              class="col-lg-4 col-md-8 col-12 mx-auto text-start"
              onsubmit="return false;"
            >
              <p class="lead">이름</p>
              <MaterialInput
                v-model.lazy="name"
                id="name"
                class="input-group-outline my-3"
                :label="{
                  text: '이름을 입력해주세요.',
                  class: 'form-label',
                }"
                type="text"
                ref="name"
              />
              <hr />
              <span class="lead">야이디</span
              ><span class="text-xs">는 변경불가</span>
              <MaterialInput
                v-model.lazy="id"
                id="id"
                class="input-group-outline my-3"
                :label="{
                  text: ``,
                  class: 'form-label',
                }"
                type="text"
                is-disabled="true"
              />
              <hr />
              <p class="lead">비밀번호!</p>
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
              <p class="lead">이메일</p>
              <MaterialInput
                v-model="email"
                id="email"
                class="input-group-outline my-3"
                :label="{
                  text: '이메일을 입력해주세요.',
                  class: 'form-label',
                }"
                type="email"
              />
              <div class="form-group d-flex justify-content-between">
                <div class="col m-2">
                  <select
                    id="search-area"
                    class="dropdown-item border-radius-md"
                  >
                    <option value="0" selected>검색 할 시/도 선택</option>
                  </select>
                </div>
                <div class="col m-2">
                  <select
                    id="search-area-detail"
                    class="dropdown-item border-radius-md"
                  >
                    <option value="0" selected>검색 할 구/군 선택</option>
                  </select>
                </div>
              </div>
              <div class="text-center d-flex justify-content-between">
                <MaterialButton
                  class="mx-3 my-4 mb-2"
                  variant="gradient"
                  color="secondary"
                  size="lg"
                  @click="store.MemberModify(name, id, pw, email, area)"
                >
                  정보수정</MaterialButton
                >
                <MaterialButton
                  class="mx-3 my-4 mb-2"
                  variant="gradient"
                  color="secondary"
                  size="lg"
                  @click="store.MemberDelete()"
                >
                  회원탈퇴</MaterialButton
                >
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
    <DefaultFooter />
  </div>
</template>
