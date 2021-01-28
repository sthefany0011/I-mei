import { Tema } from "./Tema"
import { User } from "./User"

export class Postagem{
    public id: number // foi adicionado no arquivo tsconfig.json : strictPropertyInitialization": false,
    // para que as variaveis não necessitem serem inicializadas.
    public titulo: string
    public campo: string
    public linkImagem: string
    public dataPost: Date
    public tema: Tema
    public usuario: User

}