import type {Router} from "vue-router";
import menuStore from '@/stores/system/menu'

const defaultPath:string = "/"
export const permission = (router:Router) => {
  router.beforeEach((to,from,next) =>{

    console.log(to)
    const store = menuStore()
    if(store.$state.menuInfos?.length == 0){
      store.initMenuInfos().then(routers => {
        console.log(routers);
        routers.forEach(item => router.addRoute(item))
        next({path:defaultPath})
      })
    }else{
      next()
    }
  })

}
