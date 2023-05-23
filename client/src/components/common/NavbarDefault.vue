<script setup>
import { RouterLink } from "vue-router";
import { ref, watch, defineProps } from "vue";
import { useWindowsWidth } from "../../assets/js/useWindowsWidth";

const props = defineProps({
  action: {
    type: Object,
    route: String,
    color: String,
    label: String,
    default: () => ({
      route: "/singin",
      color: "bg-gradient-secondary",
      label: "로그인",
    }),
  },
  transparent: {
    type: Boolean,
    default: false,
  },
  light: {
    type: Boolean,
    default: false,
  },
  dark: {
    type: Boolean,
    default: false,
  },
  sticky: {
    type: Boolean,
    default: false,
  },
  darkText: {
    type: Boolean,
    default: false,
  },
  user: String,
});

let textDark = ref(props.darkText);
const { type } = useWindowsWidth();

if (type.value === "mobile") {
  textDark.value = true;
} else if (type.value === "desktop" && textDark.value == false) {
  textDark.value = false;
}

watch(
  () => type.value,
  (newValue) => {
    if (newValue === "mobile") {
      textDark.value = true;
    } else {
      textDark.value = false;
    }
  }
);
// let user = "hi";
/**
 * 로그인되면 유저 정보 세션에 넣기
 */
</script>
<template>
  <nav
    class="navbar navbar-expand-lg top-0"
    :class="{
      'z-index-3 w-100 shadow-none navbar-transparent position-absolute my-3':
        props.transparent,
      'my-3 blur border-radius-lg z-index-3 shadow py-0 px-6 start-0 end-0 mx-4 position-absolute mt-4':
        props.sticky,
      'navbar-light bg-white py-3': props.light,
      ' navbar-dark bg-gradient-dark z-index-3 py-3': props.dark,
    }"
  >
    <div
      :class="
        props.transparent || props.light || props.dark
          ? 'container'
          : 'container-fluid px-0'
      "
    >
      <RouterLink
        class="trip-logo navbar-brand d-none d-md-block"
        :class="[
          (props.transparent && textDark.value) || !props.transparent
            ? 'text-dark font-weight-bolder ms-sm-3'
            : 'text-white font-weight-bolder ms-sm-3',
        ]"
        :to="{ name: 'about' }"
        rel="tooltip"
        title="Designed and Coded by DAMP"
        data-placement="bottom"
      >
        <img class="damp_logo" src="@/assets/img/logo_damp.png" />
      </RouterLink>
      <RouterLink
        class="navbar-brand d-block d-md-none"
        :class="
          props.transparent || props.dark
            ? 'text-white'
            : 'font-weight-bolder ms-sm-3'
        "
        :to="{ name: 'about' }"
        rel="tooltip"
        title="Designed and Coded by DAMP"
        data-placement="bottom"
      >
        <img class="damp_logo_mobile" src="@/assets/img/logo_damp.png" />
      </RouterLink>
      <div
        class="collapse navbar-collapse w-100 pt-3 pb-2 py-lg-0"
        id="navigation"
      >
        <ul class="header-text navbar-nav navbar-nav-hover ms-auto">
          <li class="nav-item dropdown dropdown-hover mx-2">
            <router-link
              :to="{ name: 'trip' }"
              class="nav-link d-flex cursor-pointer align-items-center"
              >지역별 관광지
            </router-link>
          </li>
          <li class="nav-item dropdown dropdown-hover mx-2">
            <router-link
              :to="{ name: 'board' }"
              class="nav-link d-flex cursor-pointer align-items-center"
            >
              나의 여행계획
            </router-link>
          </li>
          <li class="nav-item dropdown dropdown-hover mx-2">
            <router-link
              :to="{ name: 'board' }"
              class="nav-link d-flex cursor-pointer align-items-center"
            >
              여행 게시판
            </router-link>
          </li>
        </ul>
        <ul
          v-if="user"
          class="header-text navbar-nav navbar-nav-hover ms-3"
        >
          <li class="nav-item dropdown dropdown-hover mx-2">
            <router-link
              class="nav-link d-flex cursor-pointer align-items-center"
              :to="{ name: 'mypage' }"
            >
              내 정보
            </router-link>
          </li>
          <li class="nav-item">
            <a
              :href="action.route"
              class="btn btn-sm mb-0 font-size-lg"
              :class="action.color"
              >{{ action.label }}</a
            >
          </li>
        </ul>
        <ul v-else class="header-text navbar-nav navbar-nav-hover ms-3">
          <li class="nav-item dropdown dropdown-hover mx-2">
            <router-link
              class="nav-link d-flex cursor-pointer align-items-center"
              :to="{ name: 'signup' }"
            >
              회원가입
            </router-link>
          </li>
          <li class="nav-item">
            <a
              :href="action.route"
              class="btn btn-sm mb-0 font-size-lg"
              :class="action.color"
              >{{ action.label }}</a
            >
          </li>
        </ul>
      </div>
    </div>
  </nav>
  <!-- End Navbar -->
</template>
