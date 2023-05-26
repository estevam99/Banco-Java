import java.util.Scanner;

public class main{
    public static void main(String[] args){
        Banco banco = new Banco();
        Scanner input = new Scanner(System.in);
        User Email = new User("");
        String email = "";
        String senha = "";

        while(true){
            System.out.print("[1]Criar conta\n[2]Login\n[0]Sair\n-> ");
            int escolha = input.nextInt();
            if(escolha == 1 ){
                
                System.out.println("=====CADASTRO=====");
                System.out.print("Email: ");
                String aa = input.nextLine();
                email = input.nextLine();
                
                System.out.print("Senha: ");
                senha = input.nextLine();

                banco.criarConta(email, senha);
            }
            if(escolha == 2){
                System.out.println("======LOGIN======");
                
                System.out.print("Email: ");
                String aa = input.nextLine();
                email = input.nextLine();
                
                System.out.print("Senha: ");
                senha = input.nextLine();
                
                if(banco.verificaConta(email, senha) == true){
                    System.out.println("LOGADO COM SUCESSO!");
                    while(true){
                        System.out.print("[1]Sacar\n[2]Depositar\n[3]Ver saldo\n[4]PIX\n[0]Sair\n-> ");
                        int opcao = input.nextInt();
                        if(opcao == 1){
                            System.out.print("Que valor deseja sacar?\n-> ");
                            Double sacar = input.nextDouble();
                            banco.sacar(sacar);
                        }
                        if(opcao == 2){
                            System.out.print("Que valor deseja depositar?\n-> ");
                            Double deposito = input.nextDouble();
                            banco.depositar(deposito);
                        }
                        if(opcao == 3){
                            System.out.print(banco.verSaldo());
                            
                        }
                        if(opcao == 4){
                            System.out.println("===Lista de Contas para transferencia===");
                            for(int i = 0; i<banco.getTamanho();i++){
                                System.out.println("["+(i+1)+"]"+"Produto: "+banco.get(i).getEmail());
                            }
                            System.out.println("========================================");
                            System.out.print("Para qual conta deseja fazer o pix?\n->");
                            String bb = input.nextLine();
                            String conta = input.nextLine();
                            System.out.print("Qual o valor da transferencia?\n-> ");
                            Double transferencia = input.nextDouble();
                            banco.pix(conta, transferencia);

                        }
                        if(opcao == 0){
                            break;
                        }
                    }
                }else{
                    System.out.println("Essa conta não existe!");
                }
            }            
        }
    }
}