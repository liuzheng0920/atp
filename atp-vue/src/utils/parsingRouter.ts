import type { BaseMenuInfo } from '@/types/system/MenuVo'
import type { BaseLayoutComponents } from '@/types/public/BaseLayoutComponents'
import Layout from '@/components/layout/Layout.vue'
import type { RouteDateItem } from '@/types/public/Router'

const modules = import.meta.glob('/src/views/**/*.vue')
const constantLayoutComponents: BaseLayoutComponents = { Layout }
export function generatorRouter(
  menuInfos: BaseMenuInfo[],
  parentRoute?: RouteDateItem
): RouteDateItem[] {
  return menuInfos.map((item) => {
    let path = item.path
    if (!path.startsWith('http')) {
      path = path.replace('//', '/')
    }

    const routeRecordRaw: RouteDateItem = {
      component:
        constantLayoutComponents[item.component || item.path] ||
        modules[`/src/views${item.component}.vue`],
      path: path,
      meta: {
        id: item.id,
        title: item.title,
        icon: item.icon,
        keepAlive: item.keepAlive ?? false,
        hidden: item.hidden ?? false
      },
      children: [],
      redirect: undefined
    }
    console.info(parentRoute)
    item.redirect && (routeRecordRaw.redirect = item.redirect)

    if (item.children && item.children.length > 0) {
      routeRecordRaw.children = generatorRouter(item.children, routeRecordRaw)
    }

    return routeRecordRaw
  })
}
