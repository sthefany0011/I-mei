import { Postagem } from "./Postagem"

export class User{
    public id: number // foi adicionado no arquivo tsconfig.json : strictPropertyInitialization": false,
    // para que as variaveis não necessitem serem inicializadas.
    public email: string
    public nome: string
    public senha: string
    public foto: string
    public pessoa: string
    public tipo: string
    public postagem: Postagem[]
        
}