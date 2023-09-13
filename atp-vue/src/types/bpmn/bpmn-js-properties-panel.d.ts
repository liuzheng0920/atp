declare module 'bpmn-js-properties-panel' {
  export type Entry = any
  export type GroupDefinition = any
  export type ListGroupDefinition = any
  declare namespace index$3 {
    let __depends__: any[]
    let __init__: string[]
    let propertiesPanel: (string | typeof BpmnPropertiesPanelRenderer)[]
  }
  declare namespace index$2 {
    let __init___1: string[]
    export { __init___1 as __init__ }
    export let bpmnPropertiesProvider: (string | typeof BpmnPropertiesProvider)[]
  }
  declare namespace index {
    let __init___2: string[]
    export { __init___2 as __init__ }
    export let camundaPlatformPropertiesProvider: (
      | string
      | typeof CamundaPlatformPropertiesProvider
    )[]
  }
  declare namespace index$1 {
    let __init___3: string[]
    export { __init___3 as __init__ }
    export let zeebePropertiesProvider: (string | typeof ZeebePropertiesProvider)[]
  }
  declare const TooltipProvider: {
    'group-assignmentDefinition': (element: any) => preact.VNode<any>
    'group-condition': (element: any) => preact.VNode<any>
    'group-businessRuleImplementation': (element: any) => preact.VNode<any>
    'group-scriptImplementation': (element: any) => preact.VNode<any>
    'group-form': (element: any) => preact.VNode<any>
    'group-message': (element: any) => preact.VNode<any>
    'group-calledElement': (element: any) => preact.VNode<any>
    'group-taskDefinition': (element: any) => preact.VNode<any>
    'group-multiInstance': (element: any) => preact.VNode<any>
    'group-error': (element: any) => preact.VNode<any>
    'group-inputs': (element: any) => preact.VNode<any>
    'group-outputs': (element: any) => preact.VNode<any>
  }
  export function useService(type: any, strict: any): any
  /**
   * @typedef { import('@bpmn-io/properties-panel').GroupDefinition } GroupDefinition
   * @typedef { import('@bpmn-io/properties-panel').ListGroupDefinition } ListGroupDefinition
   * @typedef { { getGroups: (ModdleElement) => (Array{GroupDefinition|ListGroupDefinition}) => Array{GroupDefinition|ListGroupDefinition}) } PropertiesProvider
   */
  declare class BpmnPropertiesPanelRenderer {
    constructor(config: any, injector: any, eventBus: any)
    _eventBus: any
    _injector: any
    _layoutConfig: any
    _descriptionConfig: any
    _tooltipConfig: any
    _container: any
    /**
     * Attach the properties panel to a parent node.
     *
     * @param {HTMLElement} container
     */
    attachTo(container: HTMLElement): void
    /**
     * Detach the properties panel from its parent node.
     */
    detach(): void
    /**
     * Register a new properties provider to the properties panel.
     *
     * @param {Number} [priority]
     * @param {PropertiesProvider} provider
     */
    registerProvider(priority?: number, provider: PropertiesProvider): void
    /**
     * Updates the layout of the properties panel.
     * @param {Object} layout
     */
    setLayout(layout: any): void
    _getProviders(): any
    _render(element: any): void
    _destroy(): void
  }
  declare namespace BpmnPropertiesPanelRenderer {
    let $inject: string[]
  }
  declare class BpmnPropertiesProvider {
    constructor(propertiesPanel: any, injector: any)
    _injector: any
    getGroups(element: any): (groups: any) => any
  }
  declare namespace BpmnPropertiesProvider {
    let $inject_1: string[]
    export { $inject_1 as $inject }
  }
  /**
   * Provides `camunda` namespace properties.
   *
   * @example
   * ```javascript
   * import BpmnModeler from 'bpmn-js/lib/Modeler';
   * import {
   *   BpmnPropertiesPanelModule,
   *   BpmnPropertiesProviderModule,
   *   CamundaPlatformPropertiesProviderModule
   * } from 'bpmn-js-properties-panel';
   *
   * const modeler = new BpmnModeler({
   *   container: '#canvas',
   *   propertiesPanel: {
   *     parent: '#properties'
   *   },
   *   additionalModules: [
   *     BpmnPropertiesPanelModule,
   *     BpmnPropertiesProviderModule,
   *     CamundaPlatformPropertiesProviderModule
   *   ]
   * });
   * ```
   */
  declare class CamundaPlatformPropertiesProvider {
    constructor(propertiesPanel: any, injector: any)
    _injector: any
    getGroups(element: any): (groups: any) => any
    _getGroups(element: any): (
      | {
          label: any
          id: string
          component: any
          entries: {
            id: string
            component: typeof HistoryTimeToLive
            isEdited: any
          }[]
        }
      | {
          component: typeof ProcessVariablesEntry
          shouldSort: boolean
          label: any
          id: string
        }
      | {
          items: any
          add: (event: any) => void
          label: any
          id: string
          component: any
        }
    )[]
  }
  declare namespace CamundaPlatformPropertiesProvider {
    let $inject_2: string[]
    export { $inject_2 as $inject }
  }
  declare class ZeebePropertiesProvider {
    constructor(propertiesPanel: any, injector: any)
    _injector: any
    getGroups(element: any): (groups: any) => any
    _getGroups(element: any): (
      | {
          id: string
          label: string
          entries: {
            id: string
            component: typeof FormType$1
            isEdited: any
          }[]
          component: any
        }
      | {
          items: any
          add: (event: any) => void
          shouldSort: boolean
          label: string
          id: string
          component: any
        }
    )[]
  }
  declare namespace ZeebePropertiesProvider {
    let $inject_3: string[]
    export { $inject_3 as $inject }
  }
  import preact = require('@bpmn-io/properties-panel/preact')
  declare function HistoryTimeToLive(props: any): any
  declare function ProcessVariablesEntry(props: any): preact.VNode<any>
  declare function FormType$1(props: any): any
  export {
    index$3 as BpmnPropertiesPanelModule,
    index$2 as BpmnPropertiesProviderModule,
    index as CamundaPlatformPropertiesProviderModule,
    index$1 as ZeebePropertiesProviderModule,
    TooltipProvider as ZeebeTooltipProvider
  }
}
