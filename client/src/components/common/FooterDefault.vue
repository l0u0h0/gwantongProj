<script setup>
import logoDark from "@/assets/img/ssafy_logo.png";
import { defineProps } from "vue";

defineProps({
  brand: {
    type: Object,
    name: String,
    logo: String,
    route: "",
    default: () => ({
      name: "Enjoy Trip",
      logo: logoDark,
      route: "/"
    })
  },
  socials: {
    type: Array,
    icon: String,
    link: String,
    default: () => [
      {
        icon: '<i class="fab fa-facebook text-lg opacity-8"></i>',
        link: "https://github.com/suhwan2004"
      },
      {
        icon: '<i class="fab fa-github text-lg opacity-8"></i>',
        link: "https://github.com/suhwan2004"
      },
      {
        icon: '<i class="fab fa-youtube text-lg opacity-8"></i>',
        link: "https://www.youtube.com/@jamandwon/featured"
      }
    ]
  },
  menus: {
    type: Array,
    name: String,
    items: {
      type: Array,
      name: String,
      href: String
    },
    default: () => [
      {
        name: "company",
        items: [
          {
            name: "about us",
            href: "https://edu.ssafy.com/"
          },
          {
            name: "freebies",
            href: "https://github.com/suhwan2004"
          },
          {
            name: "premium tools",
            href: "https://github.com/suhwan2004"
          },
          { name: "blog", href: "https://github.com/suhwan2004" }
        ]
      },
      {
        name: "resources",
        items: [
          { name: "illustrations", href: "https://github.com/suhwan2004" },
          {
            name: "bits & snippets",
            href: "https://github.com/suhwan2004"
          },
          {
            name: "affiliate program",
            href: "https://github.com/suhwan2004"
          }
        ]
      },
      {
        name: "help & support",
        items: [
          {
            name: "contact us",
            href: "https://github.com/suhwan2004"
          },
          {
            name: "knowledge center",
            href: "https://github.com/suhwan2004"
          },
          {
            name: "custom development",
            href: "https://github.com/suhwan2004"
          },
          {
            name: "sponsorships",
            href: "https://github.com/suhwan2004"
          }
        ]
      },
      {
        name: "legal",
        items: [
          {
            name: "terms & conditions",
            href: "https://github.com/suhwan2004"
          },
          {
            name: "privacy policy",
            href: "https://github.com/suhwan2004"
          },
          {
            name: "licenses (YouYoung)",
            href: "https://github.com/suhwan2004"
          }
        ]
      }
    ]
  }
});
</script>
<template>
  <footer class="footer pt-5 mt-5">
    <div class="container">
      <div class="row">
        <div class="col-md-3 mb-4 ms-auto">
          <div>
            <a :href="brand.route">
              <img :src="brand.logo" class="mb-3" alt="main_logo" />
            </a>
            
          </div>
          <div>
            <ul class="d-flex flex-row ms-n3 nav">
              <li class="nav-item">
                <h6 class="font-weight-bolder mb-4">{{ brand.name }}</h6>
              </li>
              <li
                class="nav-item"
                v-for="{ icon, link } of socials"
                :key="link"
              >
                <a
                  class="nav-link pe-1"
                  :href="link"
                  target="_blank"
                  v-html="icon"
                >
                </a>
              </li>
            </ul>
          </div>
        </div>
        <div
          class="col-md-2 col-sm-6 col-6 mb-4"
          v-for="{ name, items } of menus"
          :key="name"
        >
          <h6 class="text-sm">{{ name }}</h6>
          <ul class="flex-column ms-n3 nav">
            <li class="nav-item" v-for="item of items" :key="item.name">
              <a class="nav-link" :href="item.href" target="_blank">
                {{ item.name }}
              </a>
            </li>
          </ul>
        </div>

        <div class="col-12">
          <div class="text-center">
            <p class="text-dark my-4 text-sm font-weight-normal">
              All rights reserved. Copyright ©
              {{ new Date().getFullYear() }}
              SSAFY by
              <a href="https://www.edu.ssafy.com" target="_blank"
                >JinA Kim & SeungSu Park & JiYoung Park.</a
              >.
            </p>
          </div>
        </div>
      </div>
    </div>
  </footer>
</template>
