import { createRouter, createWebHistory } from 'vue-router'
import { permission } from '@/router/permission'
import { constantRouters } from '@/router/baseRoutes'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: constantRouters
})
permission(router)
export default router
