import { MockMethod } from 'vite-plugin-mock'
import {BaseMenuInfo} from "../src/types/system/MenuVo";
export default [
  {
    url:'/apt-system/menuInfo',
    method: 'get',
    response: () => {
      return {
        code: '1',
        message: '成功',
        data: [
          {
            id:"@guid",
            path:"/",
            component:"Layout",
            redirect:"/layout/home",
            title:"基础布局",
            children:[
              {
                id:"@guid",
                path:"/layout/home",
                title:"主页",
                component:"/HomeView/index",
                icon:""
              }
            ]
          }
        ] as BaseMenuInfo[]
      }
    }
  }

] as MockMethod[]
