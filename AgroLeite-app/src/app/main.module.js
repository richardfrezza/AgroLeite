import * as angular from 'angular'

import { default as uiRouter } from '@uirouter/angularjs'
import { default as uiNotification } from 'angular-ui-notification'
import { default as inputMasks } from 'angular-input-masks'
import { mainConfig } from './main/config'
import { vacaConfig } from './vacas/config'
import { gastoConfig } from './gastos/config'
import { ordenhaConfig } from './ordenhas/config'

require('angular-i18n/angular-locale_pt-br.js')

export const appModule = 'app'

var modulo = angular.module(appModule, [uiRouter, uiNotification, inputMasks])

modulo.config(mainConfig(modulo))
      .config(vacaConfig(modulo))
      .config(gastoConfig(modulo))
      .config(ordenhaConfig(modulo))
