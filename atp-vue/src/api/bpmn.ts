import Request from '@/utils/request'

export const queryNewDiagram = () =>{
    return Request.get<string>("/bpmn/newDiagram")
}
