import swal from 'sweetalert2'
import moment from 'moment'

export default class ListController {

    constructor(VacaServico, Notification) {
        this.filterField = 'nome'
        this.filterValue = ''
        this.order = 'nome'
        this.records = []
        this._service = VacaServico
        this._notify = Notification
        this.load()
    }

    load() {
        this._service.findAll(this.filterField, this.filterValue, this.order)
          .then(data => {
              moment.locale('pt-BR');
              for(var i=0; i < data.length; i++){
                data[i].dtNascimento = moment(data[i].dtNascimento).format('L');
              }
              this.records = data
          })
          .catch(error => {
              console.log(error)
          })
    }

    excluir(id) {
        swal({
            title: 'Remover registro',
            text: 'Deseja realmente remover o registro',
            type: 'warning',
            showConfirmButton: true,
            showCancelButton: true,
            confirmButtonText: 'Sim!',
            cancelButtonText: 'Não obrigado'
        }).then(resp => {
            return resp.value ? 
              this._service.remove(id) :
              Promise.reject({type: 'warning', message: 'Operação cancelada!'})
        }).then(response => {
            this.load()
            this._notify.success('Registro excluído com sucesso')
        }).catch(erro => {
            this._notify({message: erro.message || 'Problemas ao excluir o registro'}, erro.type || 'error')
        }) 
    }
}

ListController.$inject = ['VacaServico', 'Notification']
