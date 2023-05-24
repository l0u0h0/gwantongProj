<script setup>
// Material component
import Table from "@/components/common/tables/BoardTable.vue";
import { onMounted } from "vue";
import MaterialButton from "../Material/MaterialButton.vue";

// typed.js import
import Typed from "typed.js";

onMounted(() => {

  if (document.getElementById("typeds")) {
    // eslint-disable-next-line no-unused-vars
    var typed = new Typed("#typeds", {
      stringsElement: "#typed-string",
      typeSpeed: 90,
      backSpeed: 90,
      backDelay: 200,
      startDelay: 500,
      loop: true,
    });
  }
})

// table data
const tableData = {
  headers: ["글번호", "제목", "작성자", "작성일", "조회수"],
  rows: [
    {
      no: 1,
      title: ["Manager"],
      author: true,
      date: "23/04/18",
      view: { label: "Edit", route: "/" },
    },
    {
      no: 2,
      title: ["Manager"],
      author: true,
      date: "23/04/18",
      view: { label: "Edit", route: "/" },
    },
    {
      no: 3,
      title: ["Manager"],
      author: true,
      date: "23/04/18",
      view: { label: "Edit", route: "/" },
    },
    {
      no: 4,
      title: ["Manager"],
      author: true,
      date: "23/04/18",
      view: { label: "Edit", route: "/" },
    },
    {
      no: 5,
      title: ["Manager"],
      author: true,
      date: "23/04/18",
      view: { label: "Edit", route: "/" },
    },
  ],
};
</script>
<template>
  <div class="boardlist">
    <div class="table-title mb-n6 font-weight-bolder">
      <span class="text-dark" id="typeds"></span>
      <div id="typed-string">
        <h1>Q&A 게시판</h1>
      </div>
      <h6>-======================-</h6>
    </div>

    <Table class="pb-6" v-bind="tableData" />
    <div class="mt-n5 mb-6">
      <MaterialButton variant="gradient" color="secondary" size="lg" class="btn-icon mx-2 hao" @click="$router.push({ name: 'boardwrite' })">
        <div class="d-flex align-items-center">
          글쓰기
          <i class="material-icons ms-2" aria-hidden="true">favorite</i>
        </div>
      </MaterialButton>
    </div>
  </div>
</template>