import { defineStore } from "pinia";
import { computed, ref } from "vue";
import {
  searchByType,
  searchByaddress,
} from "@/service/area";

// 얘를 전역으로 관리하는게 맞을까??
// 과연/?????

export const useAreaStore = defineStore("area", () => {
  let sidoList = ref([{}]);
  let gugunList = ref([{}]);

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
    SearchByAddress,
    SearchByType,
  };
});
