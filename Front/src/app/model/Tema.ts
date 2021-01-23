import { Postagem } from "./Postagem"

export class Tema{
    public id: number // foi adicionado no arquivo tsconfig.json : strictPropertyInitialization": false,
    // para que as variaveis não necessitem serem inicializadas.
    public categoria: string
    public tipoVenda: boolean
    public descricao: string
    public postagem: Postagem[]
        
}