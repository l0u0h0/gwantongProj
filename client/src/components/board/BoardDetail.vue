<script setup>
import { onMounted } from "vue";
import router from "@/router";

// Material components
import MaterialButton from "@/components/Material/MaterialButton.vue";

// material-input
import setMaterialInput from "@/assets/js/material-input";

onMounted(() => {
  setMaterialInput();
});

const Delete = () => {
  alert("글 삭제 진행해야함");
  router.push("/board/list");
};
</script>
<template>
  <div class="container my-auto">
    <div class="row">
      <div class="col-lg-8 col-md-8 col-12 mx-auto mb-6">
        <div class="card z-index-0 fadeIn3 fadeInBottom">
          <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
            <div class="bg-gradient-secondary shadow-dark border-radius-lg py-3 pe-1 mx-6 mt-n4">
              <h4 class="text-white font-weight-bolder text-center mt-2 mb-0">
                {{ no }} : {{ title }}(게시글 제목 들어갈 곳)
              </h4>
              <div class="row mt-1">
                <h6 class="text-white text-center mt-0 mb-0">{{ writer }}(게시글 작성자 들어갈 곳)</h6>
              </div>
            </div>
          </div>
          <div class="card-body">
            <form role="form" class="text-start" onsubmit="return false;">
              <div class="m-4 mb-5">
                <h5>제목</h5>
                <h6>(제목 들어갈 곳){{ title }}</h6>
              </div>
              <div class="m-4 mb-5">
                <h5>작성자</h5>
                <h6>(작성자 들어갈 곳) {{ author }}</h6>
              </div>
              <div class="m-4 mb-5">
                <h5>내용</h5>
                <h6>(내용 들어갈 곳){{ content }}</h6>
              </div>
              <div class="m-4 d-flex">
                <h5>작성 일자 - {{ date }}&nbsp;&nbsp;&nbsp;</h5>
                <h5>조회수 : {{ view }}</h5>
              </div>

              <div class="text-center d-flex">
                <MaterialButton class="m-5 my-4 mb-2" variant="gradient" color="secondary" size="lg" fullWidth
                  @click="$router.push({ name: 'boardmodify' })">글수정</MaterialButton>

                <MaterialButton class="m-5 my-4 mb-2" variant="gradient" color="secondary" size="lg" fullWidth
                  @click="Delete()">글삭제</MaterialButton>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
