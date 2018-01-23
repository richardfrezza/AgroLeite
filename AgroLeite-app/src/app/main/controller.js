import swal from 'sweetalert2'

export default class MainController {

    constructor(GastoServico, Notification, OrdenhaServico) {
        this.filterField = 'descricao'
        this.filterValue = ''
        this.order = 'descricao'
        this.records = []
        this.recordsOrdenha = []
        this._service = GastoServico
        this._serviceOrdenha = OrdenhaServico
        this._notify = Notification
        this.valorTotal = 0;
        this.quantidadeTotal = 0;
        this.load()
    }

    load() {
        this._service.findAll(this.filterField, this.filterValue, this.order)
          .then(data => {
              this.records = data
              var valorSomado = 0;
              for (var i = 0; i < this.records.length; i++) {
                valorSomado = valorSomado + this.records[i].preco;
              }
              this.valorTotal = valorSomado;
          })
          .catch(error => {
              console.log(error)
          })

        this._serviceOrdenha.findAll()
          .then(data => {
          this.recordsOrdenha = data

          var quantidadeSomada = 0;
          for (var i = 0; i < this.recordsOrdenha.length; i++) {
            quantidadeSomada = quantidadeSomada + this.recordsOrdenha[i].litros;
          }
          this.quantidadeTotal = quantidadeSomada;
      })
      
    }
  
      
}

MainController.$inject = ['GastoServico', 'Notification', 'OrdenhaServico']
