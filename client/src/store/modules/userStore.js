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
  const userCookie = ref("");

  const setUserCookie = computed((str) => {
    userCookie.value = str;
  });
  const deleteCookie = computed(() => {
    userCookie.value = "";
  });

  function Login(id, password) {
    const user = { memberId: id, password, name: "", email: "", address: "" };
    login(
      user,
      (data) => {
        if (data.data === "OK") {
          // 로그인 성공
          alert("로그인 성공!!");
          const userCookie = document.cookie.split("=");
          setUserCookie(userCookie[0]);
          sessionStorage.setItem(`${userCookie[0]}`, `${userCookie[1]}`);
        } else {
          // 로그인 실패
          alert("로그인 실패!!");
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
        if (data.data === "OK") {
          // 로그아웃 성공
          sessionStorage.removeItem("");
          deleteCookie();
          router.push("/");
        } else {
          // 로그아웃 실패
          alert("로그아웃 실패!!");
        }
      },
      (error) => {
        console.error(error);
      }
    );
  }
  function MemberInsert(name, id, pw, email, area) {
    const user = {
      memberId: id,
      password: pw,
      name,
      email,
      address: `${area.sido} ${area.gugun}`,
    };
    memberInsert(
      user,
      (data) => {
        if (data.data === "OK") {
          // 회원가입 성공
          alert("회원가입 성공!!");
          router.push("/");
        } else {
          // 회원가입 실패
          alert("회원가입 실패!!");
        }
      },
      (error) => {
        console.error(error);
      }
    );
  }
  function MemberModify(name, id, pw, email, area) {
    const user = {
      memberId: id,
      password: pw,
      name,
      email,
      address: `${area.sido} ${area.gugun}`,
    };
    memberModify(
      user,
      (data) => {
        if (data.data === "OK") {
          // 회원수정 성공
          alert("회원 정보 수정 성공!!");
          router.push("/user/mypage");
        } else {
          // 회원수정 실패
          alert("회원 정보 수정 실패!!");
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
        if (data.data === "OK") {
          // 회원탈퇴 성공
          alert("회원 탈퇴 성공!!");
          Logout();
        } else {
          // 회원탈퇴 실패
          alert("회원 탈퇴 실패!!");
        }
      },
      (error) => {
        console.error(error);
      }
    );
  }

  return {
    userCookie,
    setUserCookie,
    deleteCookie,
    Login,
    Logout,
    MemberInsert,
    MemberModify,
    MemberDelete,
  };
});
