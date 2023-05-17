<script setup>
import { onMounted } from "vue";

//Vue Material Kit 2 components
import MaterialInput from "@/components/Material/MaterialInput.vue";
import MaterialButton from "@/components/Material/MaterialButton.vue";
import MaterialTextArea from "@/components/Material/MaterialTextArea.vue";

// material-input
import setMaterialInput from "@/assets/js/material-input";
onMounted(() => {
  setMaterialInput();
});
const reset = () => {
  alert("초기화 구현");
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
              <div class="m-2">
                <h5>제목</h5>
                <MaterialInput id="title" class="input-group-outline my-3" :label="{
                  text: '제목',
                  class: 'form-label',
                }" type="text" />
              </div>
              <div class="m-2">
                <h5>작성자</h5>
                <MaterialInput id="title" class="input-group-outline my-3" :label="{
                  text: '작성자',
                  class: 'form-label',
                }" type="text" />
              </div>
              <div class="m-2">
                <h5>내용</h5>
                <MaterialTextArea id="title" class="input-group-outline my-3" 
                type="text" />
              </div>

              <div class="text-center d-flex">
                <MaterialButton class="m-5 my-4 mb-2" variant="gradient" color="secondary" size="lg" fullWidth
                  @click="$router.push({ path: '/board/list' })">글수정</MaterialButton>

                <MaterialButton class="m-5 my-4 mb-2" variant="gradient" color="secondary" size="lg" fullWidth
                  @click="reset()">초기화</MaterialButton>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
