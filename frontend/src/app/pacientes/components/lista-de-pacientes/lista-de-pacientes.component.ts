import { Component, OnInit, OnDestroy, AfterViewInit } from '@angular/core';

import { BreadcrumbService } from '../../../breadcrumb/breadcrumb.service';
import { PacientesService } from '../../pacientes.service';
import { PacienteResumo } from '../../models/paciente-resumo';

@Component({
    selector: 'app-lista-de-pacientes',
    templateUrl: './lista-de-pacientes.component.html',
})
export class ListaDePacientesComponent implements OnInit, OnDestroy {
    pacientes: PacienteResumo[];

    constructor(private breadcrumbService: BreadcrumbService, private service: PacientesService) {}
    nome = '';

    pesquisar() {
        this.service
            .getListaDePacientesElastic(this.nome)
            .subscribe((dados) => (this.pacientes = dados.content));
        console.log(this.nome);
    }

    ngOnInit(): void {
        this.breadcrumbService.setItems([{ label: 'Pacientes' }]);

        this.service
            .getListaDePacientesElastic(this.nome)
            .subscribe((dados) => (this.pacientes = dados.content));
    }

    ngOnDestroy(): void {
        this.breadcrumbService.reset();
    }
}