import AbstractCrudService from "../abstract.crud.service";

export default class VacaServico extends AbstractCrudService {

  constructor($http) {
    super($http, 'http://localhost:8080/AgroLeite-web/api/vacas')
  }

}

VacaServico.$inject = ['$http']
