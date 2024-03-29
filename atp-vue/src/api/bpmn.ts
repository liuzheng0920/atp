import Request from '@/utils/request'
import type { SaveBpmnXmlVo } from '@/types/bpmn/SaveBpmnXmlVo'

export const queryNewDiagram = () => {
  return Request.get<string>('/bpmn/newDiagram')
}

export const saveBpmnXml = (data: SaveBpmnXmlVo) => {
  return Request.postFormDate<any>('/deployment-flow/deployment-xml-str', data, {
    baseURL: 'http://localhost:27080/atp-work-flow'
  })
}
