<script setup lang="ts">
import { ref } from 'vue'
import layoutMenu from '@/components/layout/sider/Menu.vue'
import {MenuUnfoldOutlined,MenuFoldOutlined} from '@ant-design/icons-vue'
console.info(12345)
const collapsed = ref<boolean>(false)
</script>

<template>
  <a-layout>
    <a-layout-sider
      class="a-layout-side-custom"
      v-model:collapsed="collapsed"
      :trigger="null"
      collapsible
    >
      <layout-menu collapsed></layout-menu>
    </a-layout-sider>

    <a-layout>
      <a-layout-header class="a-layout-header-custom">
        <menu-unfold-outlined
          v-if="collapsed"
          class="trigger"
          @click="() => (collapsed = !collapsed)"
        />
        <menu-fold-outlined v-else class="trigger" @click="() => (collapsed = !collapsed)" />
        <a-breadcrumb class="a-breadcrumb-custom">
          <a-breadcrumb-item>Home</a-breadcrumb-item>
        </a-breadcrumb>
      </a-layout-header>
      <a-layout-content class="a-layout-content-custom">
        <router-view/>
      </a-layout-content>
    </a-layout>
  </a-layout>
</template>

<style lang="scss" scoped>
.a-layout-side-custom {
  background: #ffffff;
}
.a-layout-header-custom {
  background-color: #fff;
  display: flex;
  align-items: center;
  line-height: $header-height;
  .trigger {
    cursor: pointer;
    font-size: 18px;
    transition: color 0.3s;
    &:hover {
      color: #1890ff;
    }
  }
  .a-breadcrumb-custom {
    padding-left: 18px;
  }
}
.a-layout-content-custom {
  height: $content-height;
}
</style>
