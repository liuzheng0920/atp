<template>
  <a-menu>
    <menu-item :router="item" v-for="item in menuRouter" :key="item.id"></menu-item>
  </a-menu>
</template>
<script lang="ts">
  import {defineComponent} from "vue";
  import MenuItem from "@/components/layout/sider/MenuItem";
  import useMenuStores from '@/stores/system/menu'

 export default defineComponent({
   components: {MenuItem},

   setup(){
     console.log(11223344)
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

<style scoped>

</style>
