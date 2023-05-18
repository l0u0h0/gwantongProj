<!-- eslint-disable no-unused-vars -->
<script setup>
import { ref } from "vue";
import TripMap from "./TripMap.vue"
import MaterialButton from "@/components/Material/MaterialButton.vue";
import Table from "@/components/common/tables/TripTable.vue";

let showDropdownSido = ref(false);
let showDropdownGugun = ref(false);

const charger = [];
</script>
<template>
  <section class="py-7">
    <div class="container">
      <div class="row align-items-center">
        <div class="section-header text-center mt-n3">
          <h2 class="text-dark">관관관자놀이</h2>
        </div>
        <div class="row col-lg-2 text-center">
          <div class="dropdown mt-3">
            <MaterialButton
              variant="gradient"
              color="secondary"
              class="dropdown-toggle"
              :class="{ show: showDropdownSido }"
              @focusout="showDropdownSido = false"
              id="dropdownMenuButton"
              data-bs-toggle="dropdown"
              :area-expanded="showDropdownSido"
              @click="showDropdownSido = !showDropdownSido"
            >
              시 / 도
            </MaterialButton>

            <ul
              class="dropdown-menu px-2 py-3"
              :class="{ show: showDropdownSido }"
              aria-labelledby="dropdownMenuButton"
            >
              <li>
                <a class="dropdown-item border-radius-md" href="javascript:;"
                  >서울</a
                >
              </li>
              <li>
                <a class="dropdown-item border-radius-md" href="javascript:;"
                  >경기도</a
                >
              </li>
              <li>
                <a class="dropdown-item border-radius-md" href="javascript:;"
                  >인천</a
                >
              </li>
            </ul>
          </div>
          <div class="dropdown mt-3">
            <MaterialButton
              variant="gradient"
              color="secondary"
              class="dropdown-toggle"
              :class="{ show: showDropdownGugun }"
              @focusout="showDropdownGugun = false"
              id="dropdownMenuButton"
              data-bs-toggle="dropdown"
              :area-expanded="showDropdownGugun"
              @click="showDropdownGugun = !showDropdownGugun"
            >
              구 / 군
            </MaterialButton>

            <ul
              class="dropdown-menu px-2 py-3"
              :class="{ show: showDropdownGugun }"
              aria-labelledby="dropdownMenuButton"
            >
              <li>
                <a class="dropdown-item border-radius-md" href="javascript:;"
                  >강남구</a
                >
              </li>
              <li>
                <a class="dropdown-item border-radius-md" href="javascript:;"
                  >마포구</a
                >
              </li>
              <li>
                <a class="dropdown-item border-radius-md" href="javascript:;"
                  >수정구</a
                >
              </li>
            </ul>
          </div>
        </div>
        <div class="col-lg-10 ms-auto mt-lg-0">
          <div class="position-relative">
            <trip-map class="mt-4" :chargers="charger"></trip-map>
          </div>
        </div>
      </div>
      <div class="h4 bg-gradient-secondary mx-6 mt-5 py-2 shadow-dark border-radius-lg text-white text-center">~ 관광지 리스트 ~</div>
      <!-- List Table 들어갈 자리 -->
      <Table class="mt-n5 pb-6" v-bind="tableData" />
    </div>
  </section>
</template>
