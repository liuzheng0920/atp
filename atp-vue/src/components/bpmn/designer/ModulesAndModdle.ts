import type {ModuleDeclaration} from 'didi'
import type {Ref} from "vue";

export type ModulesAndModdles = [
  ModuleDeclaration[],
  { [key: string]: any },
  { [key: string]: unknown }
]
export default function (settings: Ref<any>): ModulesAndModdles {
  const module: ModuleDeclaration[] = [];

  const moddle: { [key: string]: any } = {}

  const options: { [key: string]: unknown } = {}


  return [module, moddle, options]
}
