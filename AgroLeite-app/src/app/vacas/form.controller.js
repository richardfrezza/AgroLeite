import moment from 'moment'

export default class FormController {

    constructor($stateParams, $state, VacaServico, Notification) {
        this.record = {}
        this.title = 'Adicionando registro'
        this._service = VacaServico
        if ($stateParams.id) {
            this.title = 'Editando registro'
            this._service.findById($stateParams.id)
                .then(data => {
                    moment.locale('es');
                    data.dtNascimento = new Date(data.dtNascimento)
                    this.record = data
                })
        }
        this._state = $state
        this._notify = Notification
    }

    save() {
        this._service.save(this.record)
            .then(resp => {
                this._notify.success('Registro salvo com sucesso!')
                this._state.go('vaca.list')
            }).catch(erro => {
                this._notify.error('Erro ao salvar o registro!')
            })
    }
}

FormController.$inject = ['$stateParams', '$state', 'VacaServico', 'Notification']
