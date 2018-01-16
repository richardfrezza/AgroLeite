import ListController from './list.controller'
import FormController from './form.controller'

import GastoServico from './servico'

export const gastoConfig = (modulo) => {

  modulo.service('GastoServico', GastoServico)
  
  return ['$stateProvider', '$urlRouterProvider', 
   ($stateProvider, $urlRouterProvider) => {
    $stateProvider
      .state('gasto', {
        template: require('@views/default.html'),
        url: '/gastos',
        onEnter: ['$state', function($state) {
          $state.go('gasto.list')
        }]
      })
      .state('gasto.list', {
        template: require('@views/gastos/list.html'),
        url: '/list',
        controller: ListController,
        controllerAs: 'vm'
      })
      .state('gasto.new', {
        template: require('@views/gastos/form.html'),
        url: '/new',
        controller: FormController,
        controllerAs: 'vm'
      })
      .state('gasto.edit', {
        template: require('@views/gastos/form.html'),
        url: '/{id}',
        controller: FormController,
        controllerAs: 'vm'
      });
  }]
}
