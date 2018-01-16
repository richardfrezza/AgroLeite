import ListController from './list.controller'
import FormController from './form.controller'

import VacaServico from './servico'

export const vacaConfig = (modulo) => {

  modulo.service('VacaServico', VacaServico)
  
  return ['$stateProvider', '$urlRouterProvider', 
   ($stateProvider, $urlRouterProvider) => {
    $stateProvider
      .state('vaca', {
        template: require('@views/default.html'),
        url: '/vacas',
        onEnter: ['$state', function($state) {
          $state.go('vaca.list')
        }]
      })
      .state('vaca.list', {
        template: require('@views/vacas/list.html'),
        url: '/list',
        controller: ListController,
        controllerAs: 'vm'
      })
      .state('vaca.new', {
        template: require('@views/vacas/form.html'),
        url: '/new',
        controller: FormController,
        controllerAs: 'vm'
      })
      .state('vaca.edit', {
        template: require('@views/vacas/form.html'),
        url: '/{id}',
        controller: FormController,
        controllerAs: 'vm'
      });
  }]
}
