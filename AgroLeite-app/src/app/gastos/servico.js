import AbstractCrudService from "../abstract.crud.service";

export default class GastoServico extends AbstractCrudService {

  constructor($http) {
    super($http, 'http://localhost:8080/AgroLeite-web/api/gastos')
  }

}

GastoServico.$inject = ['$http']
