import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/User';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {

  user: User= new User
  confirmarSenha: string
  tipoP: string

  constructor(
    private authService: AuthService,
    private router: Router
  ) { }

  ngOnInit(){
    window.scroll(0,0)
  }

  confirmSenha(event: any){
    this.confirmarSenha = event.target.value
  }

  tipoPessoa(event: any){
    this.tipoP = event.target.value
  }

  cadastrar(){
    this.user.pessoa = this.tipoP
    this.user.tipo = 'normal'

    if(this.user.senha != this.confirmarSenha){
      alert('As senhas não conferem, favor verificar se as senhas são iguais')
    }else{
      this.authService.cadastrar(this.user).subscribe((resp: User) =>{
        this.user = resp
        this.router.navigate(['/login'])
        alert('Usuário cadastrado com sucesso!')
      })
    }


  }

}
