<script setup lang="ts">
import Sider from "./sider/Index.vue";
import Content from './content/Index.vue';
</script>

<template>
  <n-layout class="layout-main">
    <n-layout-header class="layout-header">后台管理系统</n-layout-header>
    <n-layout has-sider class="layout-center">
      <Sider />
      <Content />
    </n-layout>
  </n-layout>
</template>

<style scoped>
.layout-main {
}

.layout-header {
  height: var(--header-height);
}
.layout-center {
  height: calc(100% - var(--header-height));
}
</style>
