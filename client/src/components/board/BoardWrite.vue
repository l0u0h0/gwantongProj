<script setup>
import { onMounted } from "vue";

// Material components
import MaterialInput from "@/components/Material/MaterialInput.vue";
import MaterialTextArea from "../Material/MaterialTextArea.vue";
import MaterialButton from "@/components/Material/MaterialButton.vue";

// material-input
import setMaterialInput from "@/assets/js/material-input";

let title = "";
let author = "";
let content = "";

onMounted(() => {
  setMaterialInput();
});

const reset = () => {
  this.title = "";
  this.author = "";
  this.content = "";
  alert("초기화 구현해야함");
};
</script>
<template>
  <div class="container my-auto mb-6">
    <div class="row">
      <div class="col-lg-8 col-md-8 col-12 mx-auto">
        <div class="card z-index-0 fadeIn3 fadeInBottom">
          <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
            <div class="bg-gradient-secondary shadow-dark border-radius-lg py-3 pe-1">
              <h4 class="text-white font-weight-bolder text-center mt-2 mb-0">
                글작성하기
              </h4>
            </div>
          </div>
          <div class="card-body">
            <form role="form" class="text-start" onsubmit="return false;">
              <div class="form-group d-flex justify-content-between">
                <div class="col m-2">
                  <MaterialInput id="writer" class="input-group-outline my-3" :label="{
                    text: '작성자',
                    class: 'form-label',
                  }" type="text" />
                </div>
                <div class="col m-2">
                  <MaterialInput id="title" class="input-group-outline my-3" :label="{
                    text: '제목',
                    class: 'form-label',
                  }" type="text" />
                </div>
              </div>
              <label for="content" class="text-dark mb-n5">내용</label>
              <MaterialTextArea id="content" class="input-group-outline my-3" :label="{
                class: 'form-label',
              }" placeholder="내용을 입력해주세요."></MaterialTextArea>
              <hr />

              <div class="text-center d-flex">
                <MaterialButton class="m-5 my-4 mb-2" variant="gradient" color="secondary" size="lg" fullWidth
                  @click="$router.push({ name: 'list' })">글작성</MaterialButton>

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
