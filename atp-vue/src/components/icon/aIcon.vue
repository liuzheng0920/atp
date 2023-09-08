<script lang="ts">
import * as antIcons from '@ant-design/icons-vue'
import { defineComponent } from 'vue'

export default defineComponent({
  name: 'aIcon',
  components: antIcons,
  props: {
    type: {
      required: true,
      type: String
    }
  }
})
</script>

<template>
  <component :is="type"></component>
</template>
