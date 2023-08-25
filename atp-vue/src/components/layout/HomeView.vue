<script setup lang="ts">
import LayoutSider from '@/components/layout/sider/LayoutSider.vue'
import { RouterView } from 'vue-router'
</script>

<template>
  <a-layout class="layout">
    <layout-sider />
    <a-layout>
      <a-layout-header class="layout-header"> 面包屑 </a-layout-header>
      <a-layout-content> <RouterView /> </a-layout-content>
    </a-layout>
  </a-layout>
</template>

<style scoped>
.layout {
  height: 100%;
  width: 100%;
}

.layout-header {
  background-color: #ffffff;
}
</style>
