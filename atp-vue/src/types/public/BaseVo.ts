export interface BaseResponse<D>{
  code:string,
  message:string|null|undefined,
  data:D
}
