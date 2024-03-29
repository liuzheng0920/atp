import { defineStore } from 'pinia'
import type { BaseMenuInfo, MenuStore } from '@/types/system/MenuVo'
import { queryMenuList } from '@/api/menu'
import { generatorRouter } from '@/utils/parsingRouter'

const state: MenuStore = {
  menuInfos: [],
  menuId: undefined
}
export default defineStore('system.menu', {
  state: () => state,
  getters: {
    getMenuInfos(state): BaseMenuInfo[] | undefined {
      return state.menuInfos
    }
  },
  actions: {
    initMenuInfos() {
      return new Promise<any[]>((resolve, reject) => {
        queryMenuList().then((response) => {
          const menuInfos = response.data
          this.$state.menuInfos = menuInfos[0]?.children
          this.$state.menuId = menuInfos[0]?.id
          resolve(generatorRouter(menuInfos))
        })
      })
    }
  }
})
