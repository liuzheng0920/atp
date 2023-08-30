import { defineStore } from 'pinia'
import type Canvas from 'diagram-js/lib/core/Canvas'
import type Modeler from 'bpmn-js/lib/Modeler'

type ModelerStore = {
  modeler: Modeler | undefined
  canvas: Canvas | undefined
}

const defaultState: ModelerStore = {
  modeler: undefined,
  canvas: undefined
}
export default defineStore('modeler', {
  state: (): ModelerStore => defaultState,
  getters: {
    getModeler: (state) => state.modeler,
    getCanvas: (state) => state.canvas
  },
  actions: {
    setModeler(modeler: Modeler | undefined) {
      this.modeler = modeler
      if (modeler) {
        this.canvas = modeler.get<Canvas>('canvas')
      } else {
        //后续增加不同组件 清除不同内容
        this.canvas = undefined
      }
    }
  }
})
