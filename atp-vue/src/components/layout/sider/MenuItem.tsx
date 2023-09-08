import { defineComponent } from 'vue'
import type { Slots } from 'vue'
import type { BaseMenuInfo } from '@/types/system/MenuVo'
import aIcon from '@/components/icon/aIcon.vue'

export default defineComponent({
  name: 'MenuItem',
  components: aIcon,
  props: {
    router: {
      type: Object,
      require: true
    }
  },
  render() {
    console.log(this.router);
    const menuSub = (router: BaseMenuInfo) => {
      const subSlots: Slots = {
        title: () => [<span>{router.title}</span>],
        icon: () => [<aIcon type={router.icon}></aIcon>]
      }

      return <a-sub-menu v-solt={subSlots} key={router.path}>
        {
          router.children?.map(item => menuCreate(item))
        }
      </a-sub-menu>
    }

    const menuItem = (router: BaseMenuInfo) => {
      const itemSlots: Slots = {
        icon: () => router.icon ? [<aIcon type= { router.icon || '' } />] : []
      }
      return (
        <a-menu-item v-slots={ itemSlots } key={ router.path }>
          <router-link to={ router.path }>{ router.title }</router-link>
        </a-menu-item>
      )
    }
    const menuCreate = (router: BaseMenuInfo) => {
      if (router.children && !router.hidden) {
        return menuSub(router)
      } else if (!router.hidden) {
        return menuItem(router)
      }
    }

    return menuCreate(this.router as BaseMenuInfo)
  },
})
