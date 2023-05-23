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
              color="secondary"
              icon="chair"
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
                image="https://velog.velcdn.com/images/rlawogks2468/post/ad73ae1a-a736-4bb8-bf46-4461a47feb60/image.gif"
                icon="touch_app"
                title="카카오맵 <br /> 지도를 이용한"
                description="카카오맵 지도를 이용한 전국 지역별 관광지와 유형별 관광지 검색"
              />

              <RotatingCardBack
                image="https://t1.kakaocdn.net/kakaocorp/corp_thumbnail/Kakao.png"
                title=""
                description=""
                :action="[
                  {
                    route: '/trip',
                    label: '관광지 검색',
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
