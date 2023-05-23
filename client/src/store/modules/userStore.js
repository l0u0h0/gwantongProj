import jwtDecode from "jwt-decode";
import { defineStore } from "pinia";
import { computed, ref } from "vue";
import router from "@/router";
import {
  login,
  logout,
  memberInsert,
  memberModify,
  memberDelete,
} from "@/service/user";

export const useUserStore = defineStore("user", () => {
  const userid = ref("default");
  const userpw = ref("");

  const testUser = computed(() => userid.value + " " + userpw.value);

  function testSetUser(getId, getPw) {
    userid.value = getId;
    userpw.value = getPw;
  }

  function Login(id, pw) {
    const user = { id, pw, name: "", email: "", address: "" };
    login(
      user,
      (data) => {
        if (data.message === "OK") {
          // 로그인 성공
          // data.response.getCookies??
        } else {
          // 로그인 실패
        }
      },
      (error) => {
        console.error(error);
      }
    );
  }
  function Logout() {
    logout(
      (data) => {
        if (data.message === "OK") {
          // 로그아웃 성공
        } else {
          // 로그아웃 실패
        }
      },
      (error) => {
        console.error(error);
      }
    );
  }
  function MemberInsert(name, id, pw, email, area) {
    const user = { id, pw, name, email, address: `${area.sido} ${area.gugun}` };
    memberInsert(
      user,
      (data) => {
        if (data.message === "OK") {
          // 회원가입 성공

          router.push("/");
        } else {
          // 회원가입 실패
        }
      },
      (error) => {
        console.error(error);
      }
    );
  }
  function MemberModify(name, id, pw, email, area) {
    const user = { id, pw, name, email, address: `${area.sido} ${area.gugun}` };
    memberModify(
      user,
      (data) => {
        if (data.message === "OK") {
          // 회원수정 성공
        } else {
          // 회원수정 실패
        }
      },
      (error) => {
        console.error(error);
      }
    );
  }
  function MemberDelete() {
    memberDelete(
      (data) => {
        if (data.message === "ok") {
          // 회원탈퇴 성공
        } else {
          // 회원탈퇴 실패
        }
      },
      (error) => {
        console.error(error);
      }
    );
  }

  return {
    userid,
    userpw,
    testUser,
    testSetUser,
    Login,
    Logout,
    MemberInsert,
    MemberModify,
    MemberDelete,
  };
});
