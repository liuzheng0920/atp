import Request from '@/utils/request'
import type { BaseMenuInfo } from '@/types/system/MenuVo'

export const queryMenuList = (params?: any) => {
  return Request.get<BaseMenuInfo[]>('/apt-system/menuInfo', { params })
}
