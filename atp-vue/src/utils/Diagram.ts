import modelerStore from '@/stores/modeler'
import EmptyXML from '@/utils/EmptyXML'
export const createNewDiagram = async function (newXml?: string, sttings?: any) {
  try {
    const store = modelerStore()

    const timestamp: number = Date.now()

    const newId: string = `Process_${timestamp}`
    const newName: string = `业务流程_${timestamp}`
    const xmlStr = newXml ?? EmptyXML(newId, newName)

    const modeler = store.getModeler

    const { warnings } = await modeler!.importXML(xmlStr)
    console.log(modeler);
    console.log(xmlStr)
    if (warnings?.length) {
      warnings.forEach((warn: string) => console.warn(warn))
    }
  } catch (e) {
    console.error(`[Process Designer Warn]: ${typeof e === 'string' ? e : (e as Error)?.message}`)
  }
}
