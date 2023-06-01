<script setup lang="ts">
import { ref, h } from "vue";
import type { Component } from "vue";

import { NIcon } from "naive-ui";
import type { MenuOption } from "naive-ui";
import { BookOutline as BookIcon } from "@vicons/ionicons5";

function renderIcon(icon: Component) {
  return () => h(NIcon, null, { default: () => h(icon) });
}

const collapsed = ref<boolean>(true);
const activeKey = ref<string>("");
const menuOptions: MenuOption[] = [
  {
    label: "首页",
    key: "1",
    icon: renderIcon(BookIcon),
  },
  {
    label: "系统管理",
    key: "2",
    icon: renderIcon(BookIcon),
  },
];
</script>
<template>
  <n-layout-sider
    bordered
    collapse-mode="width"
    :collapsed-width="64"
    :width="240"
    :collapsed="collapsed"
    show-trigger
    @collapse="collapsed = true"
    @expand="collapsed = false"
  >
    <n-menu
      v-model:value="activeKey"
      :collapsed="collapsed"
      :collapsed-width="64"
      :collapsed-icon-size="22"
      :options="menuOptions"
    />
  </n-layout-sider>
</template>

<style scoped></style>
