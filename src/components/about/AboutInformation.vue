<script setup>
// example components
import DefaultInfoCard from "@/components/common/cards/DefaultInfoCard.vue";

</script>
<template>
  <section class="py-7">
    <div class="container">
      <div class="row align-items-center">
        <div class="col-lg-6">
          <div class="row justify-content-start">
            <DefaultInfoCard
              color="info"
              icon="public"
              title="안정감"
              description="안정감을 느낄 수 있는 여행코스를 제공합니다."
            />
            <DefaultInfoCard
              color="info"
              icon="payments"
              title="빠른 신청"
              description="간단한 신청서 만으로 여행을 떠나보세요!"
            />
          </div>
          <div class="row justify-content-start mt-4">
            <DefaultInfoCard
              color="info"
              icon="apps"
              title="레스토랑 & 카페"
              description="현재 지역을 중심으로 유명한 카페들을 추천합니다."
            />
            <DefaultInfoCard
              color="info"
              icon="3p"
              title="24/7 지원"
              description="저희 서비스는 24시간 서비스로 항상 열려있습니다."
            />
          </div>
        </div>
        <div class="col-lg-4 ms-auto mt-lg-0 mt-6">
          <div class="position-relative">
            <img
              class="max-width-50 w-100 position-relative z-index-2"
              src="@/assets/img/sample_home.png"
              alt="image"
            />
          </div>
        </div>
      </div>
    </div>
  </section>
</template>
