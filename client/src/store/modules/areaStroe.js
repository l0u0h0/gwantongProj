import { defineStore } from "pinia";
import { computed, ref } from "vue";
import {
  getGugun,
  getSido,
  searchByType,
  searchByaddress,
} from "@/service/area";

export const useAreaStore = defineStore("area", () => {
  let sidoList = ref([{}]);
  let gugunList = ref([{}]);

  function GetSido() {
    getSido(
      (data) => {
        if (data.message === "OK") {
          // 시도 데이터 가져오기 성공
        } else {
          // 시도 데이터 가져오기 실패
        }
      },
      (error) => {
        console.error(error);
      }
    );
  }
  function GetGugun(sido) {
    getGugun(
      sido,
      (data) => {
        if (data.message === "OK") {
          // 구/군 데이터 가져오기 성공
        } else {
          // 구/군 데이터 가져오기 실패
        }
      },
      (error) => {
        console.error(error);
      }
    );
  }
  function SearchByAddress(sido, gugun) {
    const area = { sido, gugun };
    searchByaddress(
      area,
      (data) => {
        if (data.message === "OK") {
          // 지역 검색 성공
        } else {
          // 지역 검색 실패
        }
      },
      (error) => {
        console.error(error);
      }
    );
  }
  function SearchByType(type) {
    searchByType(
      type,
      (data) => {
        if (data.message === "OK") {
          // 유형 검색 성공
        } else {
          // 유형 검색 실패
        }
      },
      (error) => {
        console.error(error);
      }
    );
  }

  return {
    sidoList,
    gugunList,
    GetSido,
    GetGugun,
    SearchByAddress,
    SearchByType,
  };
});
