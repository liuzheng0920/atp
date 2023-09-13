<script setup lang="ts">
import 'bpmn-js/dist/assets/diagram-js.css'
import 'bpmn-js/dist/assets/bpmn-js.css'
import 'bpmn-js/dist/assets/bpmn-font/css/bpmn-codes.css'
import 'bpmn-js/dist/assets/bpmn-font/css/bpmn-embedded.css'
import 'bpmn-js/dist/assets/bpmn-font/css/bpmn.css'
import '@bpmn-io/properties-panel/assets/properties-panel.css'

import BpmnModeler from 'bpmn-js/lib/Modeler'
import { queryNewDiagram } from '@/api/bpmn'
import { onMounted, ref } from 'vue'
import type { BaseResponse } from '@/types/public/BaseVo'
import Translate from '@/components/bpmn/additionalModules/Translate'
import { downloadFile, setEncoded } from '@/utils/files'

import { BpmnPropertiesPanelModule, BpmnPropertiesProviderModule,CamundaPlatformPropertiesProviderModule } from 'bpmn-js-properties-panel';

import CamundaExtensionModule from 'camunda-bpmn-moddle/resources/camunda.json'

let modeler: BpmnModeler

const canvas = ref<HTMLDivElement | null>(null)
const panel = ref<HTMLDivElement | null > (null)
const initModeler = () => {
  modeler = new BpmnModeler({
    container: canvas.value as HTMLDivElement,
    additionalModules: [Translate,BpmnPropertiesPanelModule,BpmnPropertiesProviderModule,CamundaPlatformPropertiesProviderModule],
    propertiesPanel:{
      parent:panel.value as HTMLDivElement
    },
    moddleExtensions:{'camunda':CamundaExtensionModule}
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
    <div class="main-content">
      <div class="canvas" ref="canvas"></div>
      <div class="panel" ref="panel"></div>
    </div>
  </div>
</template>

<style scoped lang="scss">
.modelerView {
  display: flex;
  overflow: hidden;
  position: relative;
  flex-direction: column;
  height: 100%;
  width: 100%;
  .modelerView-button {
    width: 100%;
    padding: 8px 30px;
    display: flex;
    align-items: center;
    gap: 10px;
  }
  .main-content {
    display: flex;
    flex: 1;
    flex-direction: row;
  }
  .canvas{
    flex: 1;
  }
  .panel {
    width: 480px;
  }
}
</style>
