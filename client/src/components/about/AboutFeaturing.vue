<script setup>
// example component
import DefaultCounterCard from "@/components/common/cards/DefaultCounterCard.vue";
</script>
<template>
  <section class="pt-4 pb-6" id="count-stats">
    <div class="container">
      <div class="row mb-7">
        
      </div>
      <div class="row justify-content-center text-center">
        <div class="col-md-3">
          <DefaultCounterCard
            title="Projects"
            description="Of “high-performing” level are led by a certified project manager"
            :count="5234"
            :duration="3000"
          />
        </div>
        <div class="col-md-3">
          <DefaultCounterCard
            title="Hours"
            description="T기상청 API를 넣는다면 어떨까?s"
            :count="3400"
            suffix="+"
            :duration="3000"
          />
        </div>
        <div class="col-md-3">
          <DefaultCounterCard
            title="Support"
            description="Actively engage team members that finishes on time"
            :count="24"
            suffix="/7"
            :duration="4000"
          />
        </div>
      </div>
    </div>
  </section>
</template>
