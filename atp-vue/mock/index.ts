import { MockMethod } from 'vite-plugin-mock'
export default [
  {
    url:'/api/test',
    method: 'get',
    response: () => {
      return{
        code: '1',
        message: '成功',
        data: null
      }
    }
  }

] as MockMethod[]
