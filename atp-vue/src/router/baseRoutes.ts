import type { RouteRecordRaw } from 'vue-router'

export const constantRouters: RouteRecordRaw[] = [
  {
    path: '/layout',
    name: 'layout',
    component: () => import('@/components/layout/Layout.vue')
  }
]
