import { defineStore } from "pinia";
import {
  searchByType,
  searchByaddress,
} from "@/service/area";

export const useAreaStore = defineStore("area", () => {

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
    SearchByAddress,
    SearchByType,
  };
});
