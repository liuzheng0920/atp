import tasks from '@/i18n/zh_CN/elements/task'
import other from '@/i18n/zh_CN/elements/other'
import events from '@/i18n/zh_CN/elements/events'
import gateway from '@/i18n/zh_CN/elements/gateway'
import userTask from '@/i18n/zh_CN/elements/userTask'

export default {
  elements: {
    ...events,
    ...gateway,
    ...tasks,
    ...other,
    ...userTask
  }
}
