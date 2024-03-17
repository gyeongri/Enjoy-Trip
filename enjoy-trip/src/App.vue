<script setup>
import { RouterView } from "vue-router";
import TheHeadingNavbar from "@/components/layout/TheHeadingNavbar.vue";
</script>

<template>
  <div>
    <TheHeadingNavbar />
    <router-view />
  </div>
</template>

<style scope></style>
