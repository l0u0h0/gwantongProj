import { defineStore } from "pinia";
import router from "@/router";
import {
  login,
  logout,
  memberInsert,
  memberModify,
  memberDelete,
} from "@/service/user";

export const useUserStore = defineStore("user", () => {

  function Login(id, password) {
    const user = { memberId: id, password, name: "", email: "", address: "" };
    let flag = false;
    login(
      user,
      (data) => {
        console.log(data);
        if (data.data === "OK") {
          // 로그인 성공
          alert("로그인 성공!!");
          sessionStorage.setItem("logged", document.cookie);
          flag = true;
        } else {
          // 로그인 실패
          alert("로그인 실패!!");
        }
      },
      (error) => {
        console.error(error);
      }
    );
    if (!flag) {
      router.push("/");
    }
  };
  
  function Logout() {
    logout(
      (data) => {
        if (data.data === "OK") {
          // 로그아웃 성공
          sessionStorage.removeItem("logged");
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
    Login,
    Logout,
    MemberInsert,
    MemberModify,
    MemberDelete,
  };
});
