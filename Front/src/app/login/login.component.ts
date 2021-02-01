import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { UserLogin } from '../model/UserLogin';
import { AlertasService } from '../service/alertas.service';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userLogin: UserLogin = new UserLogin()
  constructor(
    private auth: AuthService,
    private router: Router,
    private alertas: AlertasService
  ) { }

  ngOnInit(){
    window.scroll(0,0)
  }
  entrar(){
    this.auth.entrar(this.userLogin).subscribe((resp: UserLogin)=>{
      this.userLogin = resp

      environment.token = this.userLogin.token
      environment.nome = this.userLogin.nome
      environment.foto = this.userLogin.foto
      environment.id = this.userLogin.id
      environment.tipo = this.userLogin.tipo

      // descomente o código abaixo para fazer testes no console, pra saber se após clicar em logar as variaveis estaos sendo passadas:
      console.log(environment.token)
      console.log(environment.nome)
      console.log(environment.foto)
      console.log(environment.id)



      this.userLogin.foto

      this.router.navigate(['/inicio'])
      
    },erro=>{
      if(erro.status == 500){
        this.alertas.showAlertDanger('Usuário ou senha incorretos')
      }
    })
  }

}
