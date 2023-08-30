<script setup lang="ts">
import type { PropType } from 'vue'
import { toRefs, ref, onMounted } from 'vue'
import initModeler from '@/components/bpmn/designer/initModeler'
import { createNewDiagram } from '@/utils/Diagram'

let emits = defineEmits(['update:xml', 'command-stack-changed'])
let props = defineProps({
  xml: {
    type: String as PropType<string>,
    default: undefined
  }
})

const { xml } = toRefs(props)
const designer = ref<HTMLDivElement | null>(null)
onMounted(() => {
  console.log(1)
  const modelerModules = null
  initModeler(designer, modelerModules, emits)
  createNewDiagram(xml?.value)
})
</script>

<template>
  <div id="designer" ref="designer"></div>
</template>

<style lang="scss" scoped>
@use '@/styles/designer/index.scss';

</style>
