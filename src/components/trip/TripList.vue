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

const tableDatas = [
  {
    img: "#",
    title: "제주공항",
    address: "제주시 1번가",
    type: "관광지",
    tel: "010-2067-9786"
  },
]

let datas = null;

const search = () => {
  let areaCode = document.getElementById("search-area").value;
  let areaDetailCode = document.getElementById("search-area-detail").value;
  let contentTypeId = document.getElementById("search-content-id").value;
  console.log(areaCode);
  console.log(areaDetailCode);

  if (parseInt(areaCode)) searchUrl += `&areaCode=${areaCode}`;
  if (parseInt(areadetailCode))
    searchUrl += `&sigunguCode=${areadetailCode}`;
  if (parseInt(contentTypeId))
    searchUrl += `&contentTypeId=${contentTypeId}`;

  // axios.get(searchUrl)
  //   .then((data) => datas = data.data.response.items.item);
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
      console.log(areas);
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
</script>
<template>
  <section class="py-7">
    <div class="container">
      <div class="row align-items-center">
        <div class="row col-lg-3 text-center">
          <h3 class="mt-n6">Filter</h3>
          <div class="dropdown mt-n1">
            <MaterialButton
              variant="gradient"
              color="secondary"
              class="dropdown-toggle"
              :class="{ show: showDropdownArea }"
              fullWidth
              size="lg"
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
              color="secondary"
              class="dropdown-toggle"
              :class="{ show: showDropdownType }"
              fullWidth
              size="lg"
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
          <div>
            <MaterialButton
              color="dark"
              class="mt-3"
              fullWidth
              size="lg"
              @click="search()"
            >
              Search
            </MaterialButton>
          </div>
        </div>
        <div class="col-lg-9 ms-auto mt-lg-0">
          <div class="position-relative">
            <trip-map class="mb-4" :places="datas"></trip-map>
          </div>
        </div>
      </div>
      <div
        class="h4 mx-6 mt-5 py-3 shadow-dark bg-gradient-info border-radius-lg text-white text-center"
      >
        ~ 관광지 리스트 ~
      </div>
      <!-- List Table 들어갈 자리 -->
      <Table class="mt-n5 pb-6" :rows="datas != null ? datas : tableDatas" />
    </div>
  </section>
</template>
