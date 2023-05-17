<script setup>
defineProps({
  headers: {
    type: Array,
    default: () => ["글번호", "제목", "작성자", "작성일", "조회수"],
  },
  rows: {
    type: Array,
    required: true,
    no: Number,
    title: String,
    author: String,
    date: String,
    view: Number
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
                      class="text-uppercase text-dark text-lg text-center font-weight-bolder opacity-9"
                      :class="{ 'ps-2': index == 1 }">
                      {{ header }}
                    </th>
                  </tr>
                </thead>
                <tbody>
                  <tr v-for="(
                        {
                          no,
                          title,
                          author,
                          date,
                          view,
                        },
                          index
                      ) of rows" :key="index">
                    <td>
                      <div class="d-flex px-2 py-1">
                          <h6 class="mb-0 text-s">
                            <a :href="route" data-toggle="tooltip"
                              data-original-title="Edit user">
                              {{ no }}
                            </a>
                          </h6>
                      </div>
                    </td>
                    <td>
                      <div class="d-flex px-2 py-1">
                          <h6 class="mb-0 text-s">{{ title }}</h6>
                      </div>
                    </td>
                    <td>
                      <div class="d-flex px-2 py-1">
                          <h6 class="mb-0 text-s">{{ author }}</h6>
                      </div>
                    </td>
                    <td>
                      <div class="d-flex px-2 py-1">
                          <h6 class="mb-0 text-s">{{ date }}</h6>
                      </div>
                    </td>
                    <td>
                      <div class="d-flex px-2 py-1">
                          <h6 class="mb-0 text-s">{{ view }}</h6>
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
