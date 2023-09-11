
export interface BaseMenuInfo{
  id:string,
  path:string ,
  title:string,
  icon?:string,
  component:string,
  keepAlive?:boolean,
  hidden?:boolean,
  children?:BaseMenuInfo[],
  redirect?:string|undefined
}

export type MenuStore = {
  menuInfos:BaseMenuInfo[] | undefined;
  menuId:string | undefined;
}
