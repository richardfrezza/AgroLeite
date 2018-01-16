export default class FormController {
    
    constructor($stateParams, $state, GastoServico, Notification, VacaServico) {
        this.record = {}
        this.recordVacas = {}
        this.title = 'Adicionando registro'
        this._service = GastoServico
        this._serviceVaca = VacaServico;
        if ($stateParams.id) {
            this.title = 'Editando registro'
            this._service.findById($stateParams.id)
                .then(data => {
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
                this._state.go('gasto.list')
            }).catch(erro => {
                this._notify.error('Erro ao salvar o registro!')
                console.log(erro)
            })
    }
}

FormController.$inject = ['$stateParams', '$state', 'GastoServico', 'Notification', 'VacaServico']
    