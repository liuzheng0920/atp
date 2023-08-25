<script setup lang="ts">
import BpmnViewer from 'bpmn-js'

const bpmnViewer = new BpmnViewer({
  container: '#canvas',
  moddleExtensions:{

  }
})
</script>

<template>
  <div id="canvas"></div>
</template>

<style scoped></style>
