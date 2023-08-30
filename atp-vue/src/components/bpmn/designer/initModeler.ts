import type { Ref } from 'vue'
import modelerStore from '@/stores/modeler'
import Modeler from 'bpmn-js/lib/Modeler'
import type { BaseViewerOptions } from 'bpmn-js/lib/BaseViewer'
import { markRaw } from 'vue'

export default async function (designer: Ref<HTMLDivElement | null>, modelerModules: any, emit:any) {
  const store = modelerStore()
  const options: BaseViewerOptions = {
    container: designer.value as HTMLElement
  }

  if (store.getModeler) {
    store.getModeler.destroy()
    store.setModeler(undefined)
  }

  const modeler = new Modeler(options)
  //markRaw 不会代理 vue
  store.setModeler(markRaw(modeler))

  modeler.on('commandStack.changed', async (event) => {
    try {
      const { xml } = await modeler.saveXML({ format: true })
      emit('update:xml', xml)
      emit('command-stack-changed', event)
    } catch (error) {
      console.error(error)
    }
  })
}
