import zh_CN from "@/i18n/zh_CN";

const languages = {
  zh_CN
}

export function customTranslate(template: string, replacements?: Record<string, string>){
  const translations = languages['zh_CN']

  template = translations.elements[template] || template
  return template.replace(/{([^}]+)}/g, function (_, key) {
    return replacements![key] || '{' + key + '}'
  })
}

export default {
  translate: ['value', customTranslate]
}
