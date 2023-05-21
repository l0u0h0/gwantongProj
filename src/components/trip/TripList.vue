<!-- eslint-disable no-unused-vars -->
<script setup>
import { onMounted, ref } from "vue";
import axios from "axios";

import TripMap from "./TripMap.vue";
import MaterialButton from "@/components/Material/MaterialButton.vue";
import Table from "@/components/common/tables/TripTable.vue";

// 드롭다운 상태 변수 생성
let showDropdownArea = ref(false);
let showDropdownType = ref(false);

let area_val = 0;
let area_detail_val = 0;
let content_id_val = 0;

const charger = [];

function setAreaVal(code) {
  console.log(code);
}

function test() {
  console.log("hi");
}

onMounted(async () => {
  const areaUrl =
    "https://apis.data.go.kr/B551011/KorService1/areaCode1?serviceKey=" +
    process.env.VUE_APP_AREA_API_KEY +
    "&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json";

  await axios.get(areaUrl).then((data) => makeOption(data));

  function makeOption(data) {
    const areas = data.data.response.body.items.item;

    let sel = document.getElementById("search-area");
    areas.forEach((area) => {
      // let li = document.createElement("li");
      // let opt = document.createElement("button");
      // opt.setAttribute("id", `${area.code}`);
      // opt.appendChild(document.createTextNode(area.name));
      // li.appendChild(opt);
      // sel.appendChild(li);
      let opt = document.createElement("option");
      opt.setAttribute("value", area.code);
      opt.setAttribute("class", "dropdown-item border-radius-md");
      opt.appendChild(document.createTextNode(area.name));
      sel.appendChild(opt);
    });
  }
  document.getElementById("search-area").addEventListener("selected", () => {
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
      console.log(areas);
      let sel = document.getElementById("search-area-detail");

      sel.innerHTML = '<option value="0" selected>검색 할 지역 선택</option>';
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
</script>
<template>
  <section class="py-7">
    <div class="container">
      <div class="row align-items-center">
        <div class="row col-lg-3 text-center">
          <h4 class="mt-n6">Filter</h4>
          <div class="dropdown mt-n3">
            <MaterialButton
              variant="gradient"
              color="dark"
              class="dropdown-toggle"
              :class="{ show: showDropdownArea }"
              @focusout="showDropdownArea = false"
              id="dropdownMenuButton"
              data-bs-toggle="dropdown"
              :area-expanded="showDropdownArea"
              @click="showDropdownArea = !showDropdownArea"
            >
              지역별
            </MaterialButton>

            <ul
              class="dropdown-menu px-2 py-3"
              :class="{ show: showDropdownArea }"
              aria-labelledby="dropdownMenuButton"
            >
              <li>
                <select id="search-area" class="dropdown-item border-radius-md">
                  <option value="0" selected>검색 할 시/도 선택</option>
                </select>
              </li>
              <li>
                <select
                  id="search-area-detail"
                  class="dropdown-item border-radius-md"
                >
                  <option value="0" selected>검색 할 구/군 선택</option>
                </select>
              </li>
            </ul>
          </div>
          <div class="dropdown mt-3">
            <MaterialButton
              variant="gradient"
              color="dark"
              class="dropdown-toggle"
              :class="{ show: showDropdownType }"
              @focusout="showDropdownType = false"
              id="dropdownMenuButton"
              data-bs-toggle="dropdown"
              :area-expanded="showDropdownType"
              @click="showDropdownType = !showDropdownType"
            >
              유형별
            </MaterialButton>

            <ul
              class="dropdown-menu px-2 py-3"
              :class="{ show: showDropdownType }"
              aria-labelledby="dropdownMenuButton"
            >
              <li>
                <a class="dropdown-item border-radius-md" href="javascript:;"
                  >관광지</a
                >
              </li>
              <li>
                <a class="dropdown-item border-radius-md" href="javascript:;"
                  >문화시설</a
                >
              </li>
              <li>
                <a class="dropdown-item border-radius-md" href="javascript:;"
                  >축제공연행사</a
                >
              </li>
              <li>
                <a class="dropdown-item border-radius-md" href="javascript:;"
                  >여행코스</a
                >
              </li>
              <li>
                <a class="dropdown-item border-radius-md" href="javascript:;"
                  >레포츠</a
                >
              </li>
              <li>
                <a class="dropdown-item border-radius-md" href="javascript:;"
                  >숙박</a
                >
              </li>
              <li>
                <a class="dropdown-item border-radius-md" href="javascript:;"
                  >쇼핑</a
                >
              </li>
              <li>
                <a class="dropdown-item border-radius-md" href="javascript:;"
                  >음식점</a
                >
              </li>
            </ul>
          </div>
        </div>
        <div class="col-lg-9 ms-auto mt-lg-0">
          <div class="position-relative">
            <trip-map class="mt-4" :chargers="charger"></trip-map>
          </div>
        </div>
      </div>
      <div
        class="h4 bg-gradient-secondary mx-6 mt-5 py-2 shadow-dark border-radius-lg text-white text-center"
      >
        ~ 관광지 리스트 ~
      </div>
      <!-- List Table 들어갈 자리 -->
      <Table class="mt-n5 pb-6" v-bind="tableData" />
    </div>
  </section>
</template>
