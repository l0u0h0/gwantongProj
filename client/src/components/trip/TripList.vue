<!-- eslint-disable no-unused-vars -->
<script setup>
import { onMounted, ref } from "vue";
import axios from "axios";

// kakaoMap import
import TripMap from "@/components/trip/TripMap.vue";
// Material import
import MaterialButton from "@/components/Material/MaterialButton.vue";
// listTable import
import Table from "@/components/common/tables/TripTable.vue";

// import TripService
import { searchByaddress, searchByType } from "@/service/area";

// 드롭다운 상태 변수 생성
let showDropdownArea = ref(false);
let showDropdownType = ref(false);

// list dummy data
let tableDatas = [];

let datas = [];

async function search() {
  datas = [];
  let areaCode = document.getElementById("search-area").value;
  let areaDetailCode = document.getElementById("search-area-detail").value;
  let typeCode = document.getElementById("search-type").value;

  if (areaDetailCode == 0 || areaCode == 0) {
    await searchByType(
      typeCode,
      (res) => {
        datas = res.data;
      },
      (error) => {
        console.error(error);
      }
    );
  } else {
    await searchByaddress(
      { sido: areaCode, gugun: areaDetailCode },
      (res) => {
        datas = res.data;
      },
      (error) => {
        console.error(error);
      }
    );
  }
  tableDatas = [];

  if (datas.length > 10) {
    for (let i = 0; i < 10; i++) {
      tableDatas.push(datas[i]);
      // tableDatas[i].img = datas[i].first_image != null ? datas[i].first_image : "";
      // tableDatas[i].title = datas[i].title;
      // tableDatas[i].address = datas[i].addr1 + " " + datas[i].addr2;
      // tableDatas[i].tel = datas[i].tel;
    }
  } else {
    for (let i = 0; i < datas.length; i++) {
      tableDatas.push(datas[i]);
      // tableDatas[i].img = datas[i].first_image != null ? datas[i].first_image : "";
      // tableDatas[i].title = datas[i].title;
      // tableDatas[i].address = datas[i].addr1 + " " + datas[i].addr2;
      // tableDatas[i].tel = datas[i].tel;
    }
  }
  console.log(datas);
  console.log(tableDatas);
};

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
        <div class="row col-lg-2 text-center">
          <h2 class="text-sans-serif mt-n6">Filter</h2>
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
                <select id="search-type" class="dropdown-item border-radius-md">
                  <option value="0" selected>관광지 유형</option>
                  <option value="12">관광지</option>
                  <option value="14">문화시설</option>
                  <option value="15">축제공연행사</option>
                  <option value="25">여행코스</option>
                  <option value="28">레포츠</option>
                  <option value="32">숙박</option>
                  <option value="38">쇼핑</option>
                  <option value="39">음식점</option>
                </select>
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
            <trip-map class="mb-4" :places="datas" :key="datas"></trip-map>
          </div>
        </div>
      </div>
      <div
        class="h4 mx-6 mt-5 py-3 shadow-dark bg-gradient-info border-radius-lg text-white text-center"
      >
        ~ 관광지 리스트 ~
      </div>
      <!-- List Table 들어갈 자리 -->
      <Table class="mt-n5 pb-6" :rows="tableDatas" />
    </div>
  </section>
</template>
