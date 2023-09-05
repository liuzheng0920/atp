import axios from 'axios'
import type { AxiosInstance ,AxiosRequestConfig, AxiosResponse, InternalAxiosRequestConfig} from 'axios'

// 导出Request，可以用来自定义传递配置来创建实例

export class Request {
  // axios 实例
  instance: AxiosInstance
  // 基础配置，url和超时时间
  baseConfig: AxiosRequestConfig = {
    baseURL: import.meta.env.VITE_BASE_URL,
    timeout: 60000
  }
  constructor(config: AxiosRequestConfig) {
    // 使用axios.create创建axios实例，配置为基础配置和我们传递进来的配置
    this.instance = axios.create(Object.assign(this.baseConfig, config))
    this.instance.interceptors.request.use(
      (config: InternalAxiosRequestConfig) => {
        // 一般会请求拦截里面加token，用于后端的验证
        const token = localStorage.getItem('token') as string
        if (token) {
          config.headers.Authorization = token
        }
        return config
      },
      (err: any) => {
        // 请求错误，这里可以用全局提示框进行提示
        return Promise.reject(err)
      }
    )

    this.instance.interceptors.response.use(
      (res: AxiosResponse) => {
        return res
      },
      (err: any) => {
        return Promise.reject(err.response)
      }
    )
  }

  // 定义请求方法
  public request(config: AxiosRequestConfig): Promise<AxiosResponse> {
    return this.instance.request(config)
  }
}

export default new Request({})
