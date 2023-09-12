<script setup lang="ts">
import 'bpmn-js/dist/assets/diagram-js.css'
import 'bpmn-js/dist/assets/bpmn-js.css'
import 'bpmn-js/dist/assets/bpmn-font/css/bpmn-codes.css'
import 'bpmn-js/dist/assets/bpmn-font/css/bpmn-embedded.css'
import 'bpmn-js/dist/assets/bpmn-font/css/bpmn.css'

import BpmnModeler from 'bpmn-js/lib/Modeler'
import { queryNewDiagram } from '@/api/bpmn'
import { onMounted, ref } from 'vue'
import type { BaseResponse } from '@/types/public/BaseVo'
import Translate from '@/components/bpmn/additionalModules/Translate'
import { downloadFile, setEncoded } from '@/utils/files'

let modeler: BpmnModeler

const canvas = ref<HTMLDivElement | null>(null)
const initModeler = () => {
  modeler = new BpmnModeler({
    container: canvas.value as HTMLDivElement,
    additionalModules: [Translate]
  })
  queryNewDiagram().then((response: BaseResponse<string>) => {
    modeler.importXML(response.data)
  })
}

const exportXml = async () => {
  const { xml } = await modeler.saveXML({})
  const { href, filename } = setEncoded('xml'.toUpperCase(), 'bpmn.xml', xml!)
  downloadFile(href, filename)
}

const exportSvg = async () => {
  const { svg } = await modeler.saveSVG()
  const { href, filename } = setEncoded('svg'.toUpperCase(), 'bpmn.svg', svg)
  downloadFile(href, filename)
}

onMounted(() => {
  initModeler()
})
</script>

<template>
  <div class="modelerView">
    <div class="modelerView-button">

      <a-button type="primary" @click="exportXml">导出Xml</a-button>

      <a-button type="primary" @click="exportSvg">导出Svg</a-button>

    </div>
    <div class="canvas" ref="canvas"></div>
  </div>
</template>

<style scoped lang="scss">
.modelerView {
  position: relative;
  height: 100%;
  width: 100%;
  .modelerView-button {
    position: absolute;
    display: flex;
    flex-direction: row;
    gap: 20px;
    padding: 8px 0;
    top: 10px;
    left: 150px;
    z-index: 1;
    button{
      flex: 1;
    }
  }
  .canvas {
    height: 100%;
    width: 100%;
  }
}
</style>
