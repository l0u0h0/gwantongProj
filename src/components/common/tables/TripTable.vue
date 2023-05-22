<script setup>
defineProps({
  headers: {
    type: Array,
    default: () => ["。","이름", "주소", "유형", "전화번호"],
  },
  rows: {
    type: Array,
    required: true,
    img: String,
    title: String,
    address: String,
    type: String,
    tel: Number
  },
});
</script>
<template>
  <section class="pt-5 mt-5">
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-lg-10">
          <div class="card">
            <div class="table-responsive">
              <table class="table align-items-center mb-0">
                <thead>
                  <tr>
                    <th v-for="(header, index) in headers" :key="header"
                      class="text-uppercase text-dark text-lg text-center font-weight-bolder"
                      :class="{ 'ps-2': index == 1 }">
                      {{ header }}
                    </th>
                  </tr>
                </thead>
                <tbody>
                  <tr class="text-center" v-for="(
                          {
                            img,
                            title,
                            address,
                            type,
                            tel,
                          },
                            index
                        ) of rows" :key="index">
                    <td>
                      <div class="px-3 py-2 opacity-9">
                        <img v-if="img" src="#" />
                      </div>
                    </td>
                    <td>
                      <div class="px-3 py-2 opacity-9">
                        <h6 class="mb-0 text-s">
                          {{ title }}
                        </h6>
                      </div>
                    </td>
                    <td>
                      <div class="px-3 py-2 opacity-9">
                        <h6 class="mb-0 text-s">{{ address }}</h6>
                      </div>
                    </td>
                    <td>
                      <div class="px-3 py-2 opacity-9">
                        <h6 class="mb-0 text-s">{{ type }}</h6>
                      </div>
                    </td>
                    <td>
                      <div class="px-3 py-2 opacity-9">
                        <h6 class="mb-0 text-s">{{ tel }}</h6>
                      </div>
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>
