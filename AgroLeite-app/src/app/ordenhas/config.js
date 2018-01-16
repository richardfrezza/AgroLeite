import ListController from './list.controller'
import FormController from './form.controller'

import OrdenhaServico from './servico'

export const ordenhaConfig = (modulo) => {

  modulo.service('OrdenhaServico', OrdenhaServico)
  
  return ['$stateProvider', '$urlRouterProvider', 
   ($stateProvider, $urlRouterProvider) => {
    $stateProvider
      .state('ordenha', {
        template: require('@views/default.html'),
        url: '/ordenhas',
        onEnter: ['$state', function($state) {
          $state.go('ordenha.list')
        }]
      })
      .state('ordenha.list', {
        template: require('@views/ordenhas/list.html'),
        url: '/list',
        controller: ListController,
        controllerAs: 'vm'
      })
      .state('ordenha.new', {
        template: require('@views/ordenhas/form.html'),
        url: '/new',
        controller: FormController,
        controllerAs: 'vm'
      })
      .state('ordenha.edit', {
        template: require('@views/ordenhas/form.html'),
        url: '/{id}',
        controller: FormController,
        controllerAs: 'vm'
      });
  }]
}
