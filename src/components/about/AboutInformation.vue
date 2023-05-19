<script setup>
// example components
import DefaultInfoCard from "@/components/common/cards/DefaultInfoCard.vue";
import RotatingCardBack from "../common/cards/rotatingCards/RotatingCardBack.vue";
import RotatingCardFront from "../common/cards/rotatingCards/RotatingCardFront.vue";
import RotatingCard from "../common/cards/rotatingCards/RotatingCard.vue";
</script>
<template>
  <section class="py-7">
    <div class="container">
      <div class="row align-items-center">
        <div class="col-lg-8">
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
          <div
            class="position-relative max-width-50 w-100 position-relative z-index-2"
          >
            <RotatingCard>
              <RotatingCardFront
                image="https://images.unsplash.com/photo-1569683795645-b62e50fbf103?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=987&q=80"
                icon="touch_app"
                title="카카오맵 <br /> 지도를 이용한"
                description="KakaoMap 지도를 이용한 간편한 관광지 검색 바로가기"
              />

              <RotatingCardBack
                image="@/assets/img/sample_home.png"
                title="Discover More"
                description="You will save a lot of time going from prototyping to full-functional
                  code because all elements are implemented."
                :action="[
                  {
                    route: './/sections/page-sections/hero-sections.html',
                    label: 'Start with Headers',
                  },
                ]"
              />
            </RotatingCard>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>
