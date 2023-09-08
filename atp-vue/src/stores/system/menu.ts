import { defineStore } from 'pinia'
import type {BaseMenuInfo, MenuStore} from '@/types/system/MenuVo'
import { queryMenuList } from '@/api/menu'
import { generatorRouter } from '@/utils/parsingRouter'

const state: MenuStore = {
  menuInfos: []
}
export default defineStore('system.menu', {
  state: () => state,
  getters: {
    getMenuInfos(state):BaseMenuInfo[]{
      return state.menuInfos
    }
  },
  actions: {
    initMenuInfos() {
      return new Promise<any[]>((resolve, reject) => {
        queryMenuList().then((response) => {
          const menuInfos = response.data
          this.$state.menuInfos = menuInfos
          resolve(generatorRouter(menuInfos))
        })
      })
    }
  }
})
