<template>
  <div id="menuLogo" class="menu-logo">
    <span v-show="!collapsed">通用后台</span>
  </div>
  <a-menu>
    <menu-item :router="item" v-for="item in menuRouter" :key="item.id"></menu-item>
  </a-menu>
</template>
<script lang="ts">
import {defineComponent, toRef} from "vue";
  import MenuItem from "@/components/layout/sider/MenuItem";
  import useMenuStores from '@/stores/system/menu'

 export default defineComponent({
   components: {MenuItem},

   setup(){
    const menuStores = useMenuStores()

     return {menuStores}
   },
   props:{
     collapsed:{
       required:true,
       type:Boolean
     }
   },
   computed:{
     menuRouter() {
       return this.menuStores.getMenuInfos;
     }
   }
 })
</script>

<style scoped lang="scss">
  .menu-logo{
    display: flex;
    align-items: center;
    padding-left: 24px;
    height: 64px;
    line-height: 64px;
    overflow: hidden;
    white-space: nowrap;
  }
</style>
