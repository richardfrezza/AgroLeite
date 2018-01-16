import moment from 'moment'

export default class FormController {

    constructor($stateParams, $state, OrdenhaServico, Notification, VacaServico) {
        this.record = {}
        this.recordVacas = {}
        this.title = 'Adicionando registro'
        this._service = OrdenhaServico
        this._serviceVaca = VacaServico;
        if ($stateParams.id) {
            this.title = 'Editando registro'
            this._service.findById($stateParams.id)
                .then(data => {
                    moment.locale('es');
                    data.dtOrdenha = new Date(data.dtOrdenha)
                    this.record = data
                })
        }
        this._state = $state
        this._notify = Notification

        //Busca vacas para amostragem
        this._serviceVaca.findAll()
            .then(data => {
            this.recordVacas = data
        })

    }

    save() {
        this._service.save(this.record)
            .then(resp => {
                this._notify.success('Registro salvo com sucesso!')
                this._state.go('ordenha.list')
            }).catch(erro => {
                this._notify.error('Erro ao salvar o registro!')
            })
    }
}

FormController.$inject = ['$stateParams', '$state', 'OrdenhaServico', 'Notification', 'VacaServico']
