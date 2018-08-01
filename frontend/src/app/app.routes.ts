import { Routes, RouterModule } from '@angular/router';
import { ModuleWithProviders } from '@angular/core';

import { LoginComponent } from './login/login.component';
import { LoginSuccessComponent } from './login-success/login-success.component';
import { LogoutComponent } from './logout/logout.component';
import { DiarioErrosComponent } from './diario-erros/diario-erros.component';

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'login-success', component: LoginSuccessComponent },
  { path: 'logout', component: LogoutComponent },
  { path: 'diario-erros', component: DiarioErrosComponent },
  { path: 'unidadeHospitalar', loadChildren: 'app/unidade-hospitalar/unidade-hospitalar.module#CadastrosbasicosUnidadeHospitalarModule' },
  { path: 'usuario', loadChildren: 'app/usuario/usuario.module#CadastrosbasicosUsuarioModule' },
  { path: 'preCadastro', loadChildren: 'app/pre-cadastro/pre-cadastro.module#CadastrosbasicosPreCadastroModule' },
  { path: 'perfil', loadChildren: 'app/perfil/perfil.module#CadastrosbasicosPerfilModule' },
  { path: 'especialidade', loadChildren: 'app/especialidade/especialidade.module#CadastrosbasicosEspecialidadeModule' },
  { path: 'anexo', loadChildren: 'app/anexo/anexo.module#CadastrosbasicosAnexoModule' },
  { path: 'tipoPergunta', loadChildren: 'app/tipo-pergunta/tipo-pergunta.module#CadastrosbasicosTipoPerguntaModule' },
  { path: 'paciente', loadChildren: 'app/paciente/paciente.module#PacientesPacienteModule' },
  { path: 'tipoResposta', loadChildren: 'app/tipo-resposta/tipo-resposta.module#CadastrosbasicosTipoRespostaModule' },
  { path: 'funcionalidade_acao', loadChildren: 'app/funcionalidade-acao/funcionalidade-acao.module#CadastrosbasicosFuncionalidade_acaoModule' },
  { path: 'perfil_funcionalidade_acao', loadChildren: 'app/perfil-funcionalidade-acao/perfil-funcionalidade-acao.module#CadastrosbasicosPerfil_funcionalidade_acaoModule' },
  /* jhipster-needle-add-lazy-module - JHipster will add lazy modules here */
];

export const AppRoutes: ModuleWithProviders = RouterModule.forRoot(routes);
