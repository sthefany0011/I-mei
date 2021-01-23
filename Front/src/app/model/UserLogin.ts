export class UserLogin{
    public id: number // foi adicionado no arquivo tsconfig.json : strictPropertyInitialization": false,
    // para que as variaveis não necessitem serem inicializadas.
    public nome: string
    public email: string
    public senha: string
    public token: string
    public pessoa: string
    public foto: string
    public tipo: string
        
}