import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/model/User';
import { AuthService } from 'src/app/service/auth.service';
import { environment } from 'src/environments/environment.prod';

@Component({
  selector: 'app-user-edit',
  templateUrl: './user-edit.component.html',
  styleUrls: ['./user-edit.component.css']
})
export class UserEditComponent implements OnInit {

  user: User = new User()
  idUser: number
  confirmarSenha: string
  tipoP: string

  constructor(
    private authService: AuthService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    window.scroll(0,0)

    if(environment.token == ''){
      alert('sua sessão expirou, faça login novamente.')
      this.router.navigate(['/login'])
    }

    this.idUser = this.route.snapshot.params['id']
    this.findByIdUser(this.idUser)
  }

  confirmSenha(event: any){
    this.confirmarSenha = event.target.value
  }

  tipoPessoa(event: any){
    this.tipoP = event.target.value
  }

  atualizar(){
    this.user.pessoa = this.tipoP
    this.user.tipo = 'normal'

    if(this.user.senha != this.confirmarSenha){
      alert('As senhas não conferem, favor verificar se as senhas são iguais')
    }else{
      this.authService.atualizar(this.user).subscribe((resp: User) =>{
        this.user = resp
        this.router.navigate(['/inicio'])
        alert('Usuário atualizado com sucesso, faça login novamente!')
        environment.foto = ''
        environment.nome = ''
        environment.token = ''
        environment.id = 0
        this.router.navigate(['/login'])
      })
    }
  }

  findByIdUser(id: number){
    this.authService.getByIdUser(id).subscribe((resp: User)=>{
      this.user = resp
    })
  }

}
