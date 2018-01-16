import AbstractCrudService from "../abstract.crud.service";

export default class OrdenhaServico extends AbstractCrudService {

  constructor($http) {
    super($http, 'http://localhost:8080/AgroLeite-web/api/ordenhas')
  }

}

OrdenhaServico.$inject = ['$http']
