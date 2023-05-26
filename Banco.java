public class Banco {
    User primeiro;
    User ultimo;
    int tamanho;
    User atual;

    public void setAtual(User atual){
        this.atual = atual;
    }
    public User getAtual(){
        return atual;
    }

    public Banco() {
        this.tamanho = 0;
    }

    public User getPrimeiro() {
        return this.primeiro;
    }

    public void setPrimeiro(User primeiro) {
        this.primeiro = primeiro;
    }

    public User getUltimo() {
        return this.ultimo;
    }

    public void setUltimo(User ultimo) {
        this.ultimo = ultimo;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void criarConta(String email, String senha){
        User novaConta = new User(email);
        for(int i = 0; i < this.tamanho; i++){
            if(get(i).getEmail().equals(novaConta.getEmail())){
                System.out.println("Essa conta já existe!");
                return;
            }
            novaConta.getProximo();
        }
        if (this.primeiro == null & this.ultimo == null) {
            this.primeiro = novaConta;
            this.ultimo = novaConta;

        } else {
            this.ultimo.setProximo(novaConta);
            this.ultimo = novaConta;

        }
        if(novaConta.getSenha() == null){
            novaConta.setSenha(senha);
        }
        this.tamanho++;
    }

    public boolean verificaConta(String email, String senha ){
        User anterior = null;
        User atual = this.primeiro;

        for(int i = 0; i <= this.getTamanho(); i++){
            if(atual.getEmail().equals(email) && atual.getSenha().equals(senha)){
                setAtual(atual);
                return true;
            }
            anterior = atual;
            atual = atual.getProximo();
        }
        return false;
    }

    public void sacar(Double sacar){
        User atual = getAtual();
        double newSaldo = atual.getSaldo()-sacar;

        atual.setSaldo(newSaldo);
        System.out.println("Seu saldo atual: " + atual.getSaldo());
    }

    public void depositar(double deposito) {
        User atual = getAtual();

        double newSaldo = atual.getSaldo()+deposito;

        atual.setSaldo(newSaldo);
        System.out.println("Seu saldo atual: " + atual.getSaldo());
    }

    public String verSaldo(){
        User atual = getAtual();
        return "Seu saldo atual é: " + atual.getSaldo() + "\n";
    }

    public User get(int posicao) {
        User atual = this.primeiro;
        for (int i = 0; i < posicao; i++) {
            if (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
        }

        return atual;
    }

    public void pix(String conta, Double valor){

        User atual = getAtual();
        User inicio = this.primeiro;
        atual.setSaldo(atual.getSaldo() - valor);
        // for (int i = 0; i < posicao; i++) {
        //     if (atual.getProximo() != null) {
        //         atual = atual.getProximo();
        //     }
        // }
        while(inicio != null){
            if(inicio.getEmail().equals(conta)){
                inicio.setSaldo(inicio.getSaldo() + valor);
                break;
            }
            inicio = inicio.getProximo();
        }
    }
}
