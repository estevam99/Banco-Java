public class User{
    String email;
    User proximo;
    String senha;
    double saldo;


    public User(String novoValor) {
        this.email = novoValor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getProximo() {
        return proximo;
    }

    public void setProximo(User proximo){
        this.proximo = proximo;
    }

    public String getSenha(){
        return senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public double getSaldo(){
        return saldo;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
}