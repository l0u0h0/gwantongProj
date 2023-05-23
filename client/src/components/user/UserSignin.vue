<script setup>
import { onMounted, onUpdated } from "vue";
import router from "@/router";

// example components
import HeaderDefault from "@/components/common/HeaderDefault.vue";

//Vue Material Kit 2 components
import MaterialInput from "@/components/Material/MaterialInput.vue";
import MaterialSwitch from "@/components/Material/MaterialSwitch.vue";
import MaterialButton from "@/components/Material/MaterialButton.vue";

// material-input
import setMaterialInput from "@/assets/js/material-input";

// pinia
import { useUserStore } from "@/store/modules/userStore";
import { storeToRefs } from "pinia";

const store = useUserStore();

const { userid, userpw, testUser } = storeToRefs(store);

onMounted(() => {
  setMaterialInput();
});
</script>
<script>
export default {
  data() {
    return {
      id: "",
      password: "",
      percent: 0,
      check: {
        id: false,
        password: false,
      }
    }
  },
  watch: {
    id() {
      if (this.id.length > 0 && !this.check.id) {
        this.percent += 5;
        this.check.id = true;
      } else if (this.id == "" && this.check.id) {
        this.percent -= 5;
        this.check.id = false;
      }
    },
    password() {
      if (this.password.length > 0 && !this.check.password) {
        this.percent += 5;
        this.check.password = true;
      } else if (this.password == "" && this.check.password) {
        this.percent -= 5;
        this.check.password = false;
      }
    }
  }
}
</script>
<template>
  <nav class="navbar navbar-expand-lg top-0 z-index-3 w-100 shadow-none navbar-transparent position-absolute my-3">
    <div class="container">
      <RouterLink class="trip-logo navbar-brand d-none d-md-block text-white font-weight-bolder ms-sm-3"
        :to="{ name: 'about' }" rel="tooltip" title="Designed and Coded by Creative Tim" data-placement="bottom">
        Enjoy Trip
      </RouterLink>
    </div>
  </nav>
  <HeaderDefault>
    <div class="page-header align-items-start min-vh-100" :style="{
      backgroundImage:
        'url(https://a.cdn-hotels.com/gdcs/production102/d1023/e3c18663-14e2-49e3-b9f0-bd7a029a661f.jpg)',
    }" loading="lazy">
      <span class="mask bg-gradient-dark opacity-6"></span>
      <div class="container my-auto">
        <div class="row">
          <div class="col-lg-4 col-md-8 col-12 mx-auto">
            <div class="card z-index-0 fadeIn3 fadeInBottom">
              <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                <div class="bg-gradient-secondary shadow-dark border-radius-lg py-3 pe-1">
                  <h4 class="text-white font-weight-bolder text-center mt-2 mb-0">
                    Sign in
                  </h4>
                </div>
              </div>
              <div class="card-body">
                <form role="form" class="text-start">
                  <MaterialInput v-model="id" id="id" class="input-group-outline my-3" :label="{
                    text: '아이디를 입력해주세요.',
                    class: 'form-label',
                  }" type="text" />
                  <MaterialInput v-model="password" id="password" class="input-group-outline mb-3" :label="{
                    text: '비밀번호를 입력해주세요.',
                    class: 'form-label',
                  }" type="password" />
                  <MaterialSwitch class="d-flex align-items-center mb-3" id="rememberMe" labelClass="mb-0 ms-3" checked>ID
                    저장</MaterialSwitch>

                  <div class="text-center">
                    <MaterialButton class="my-4 mb-2" variant="gradient" color="secondary" fullWidth
                      :disabled="percent != 10" @click="store.testSetUser(id, password)">로그인</MaterialButton>
                  </div>
                  <p class="mt-4 text-sm text-center">
                    계정이 있으신가요 ?
                    <router-link :to="{ name: 'signup' }" class="text-info text-gradient font-weight-bold">
                      회원가입
                    </router-link>
                  </p>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
      <footer class="footer position-absolute bottom-2 py-2 w-100">
        <div class="container">
          <div class="row align-items-center justify-content-lg-between">
            <div class="col-12 col-md-6 my-auto">
              <div class="copyright text-center text-sm text-white text-lg-start">
                © {{ new Date().getFullYear() }}, made with by
                <a href="https://www.creative-tim.com" class="font-weight-bold text-white" target="_blank">JinAh Kim</a>
                for a better web.
              </div>
            </div>
            <div class="col-12 col-md-6">
              <ul class="nav nav-footer justify-content-center justify-content-lg-end">
                <li class="nav-item">
                  <a href="https://www.creative-tim.com" class="nav-link text-white" target="_blank">JinAh Kim</a>
                </li>
                <li class="nav-item">
                  <a href="https://www.creative-tim.com/presentation" class="nav-link text-white" target="_blank">About
                    Us</a>
                </li>
                <li class="nav-item">
                  <a href="https://www.creative-tim.com/blog" class="nav-link text-white" target="_blank">Blog</a>
                </li>
                <li class="nav-item">
                  <a href="https://www.creative-tim.com/license" class="nav-link pe-0 text-white"
                    target="_blank">License</a>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </footer>
    </div>
  </HeaderDefault>
</template>