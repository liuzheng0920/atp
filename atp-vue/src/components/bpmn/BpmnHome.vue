<script setup lang="ts">
import Designer from '@/components/bpmn/designer/Designer.vue'
</script>

<template>
  <designer class="main-designer"></designer>
</template>

<style scoped>
.main-designer {
  width: 100%;
  flex: 1;
  overflow: hidden;
  display: flex;
  .designer {
    flex: 1;
  }
}
</style>
