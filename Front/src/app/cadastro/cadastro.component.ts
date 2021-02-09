import { Component, OnInit } from '@angular/core';
import { EmailValidator } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../model/User';
import { AlertasService } from '../service/alertas.service';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {

  user: User= new User
  confirmarSenha: string
  cod: string

  constructor(
    private authService: AuthService,
    private router: Router,
    private alertas: AlertasService
  ) { }

  ngOnInit(){
    window.scroll(0,0)
  }

  confirmSenha(event: any){
    this.confirmarSenha = event.target.value
  }

  codAdmin(event: any) {
    this.cod = event.target.value
    if(this.cod == 'admin123') {
      this.cod = 'adm'
    } else {
      this.cod = 'normal'
    }
  }
  
  cadastrar(){
    
    this.user.tipo = this.cod

    if(this.user.nome.length < 1){
      this.alertas.showAlertDanger('Nenhum nome inserido. Por favor, insira um nome!')
      return
    }

    if(this.user.foto == '') {
      this.alertas.showAlertDanger('Link da imagem está vazio. Por favor, insira um link!')
      return
    }

    if(this.user.senha != this.confirmarSenha){
      this.alertas.showAlertDanger('As senhas não conferem, favor verificar se as senhas são iguais')
    }else{
      this.authService.cadastrar(this.user).subscribe((resp: User) =>{
        this.user = resp
        this.router.navigate(['/login'])
        this.alertas.showAlertSuccess('Usuário cadastrado com sucesso!')
      },erro=>{
        if(erro.status == 400){
          this.alertas.showAlertDanger('Email em uso ou email incorreto, favor inserir um e-mail válido! Ex: usario@email.com')

        }
      })
    }
  }
}
