import java.util.Scanner;

public class DesafioJava {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        double valor;
        double saldo = 1000;
        String nome;
        String tipoConta = "Poupança";
        boolean tipoContaValido = false;
        int operacao;
        boolean queroSair = false;
        boolean valorValido = false;


        System.out.println("Qual o seu nome?");
        nome = leitura.next();

        while (!tipoContaValido) {

            System.out.println("Qual o tipo da sua conta?");
            System.out.println("Digite 1 para Conta Corrente");
            System.out.println("Digite 2 para Conta Poupança");
            int tipoContaNumerico = leitura.nextInt();
            if (tipoContaNumerico == 1) {
                tipoConta = "Corrente";
                tipoContaValido = true;
            } else if (tipoContaNumerico == 2) {
                tipoConta = "Poupança";
                tipoContaValido = true;
            } else {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Voçê digitou um número incorreto!");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }
        }

        System.out.println("\n ********************************** \n");
        System.out.println("Proprietário da conta: " + nome);
        System.out.println("Tipo da conta: " + tipoConta);
        System.out.println("Saldo inicial: " + saldo);
        System.out.println("\n ********************************** \n");


        while (!queroSair) {
            System.out.println("""
                    \n                    
                    ------------------------------------
                    \n 
                    Operações
                                    
                    1 - Consultar saldo
                    2 - Depositar valor
                    3 - Sacar valor
                    4 - Sair
                    \n
                    ------------------------------------
                    \n                   
                    """);
            operacao = leitura.nextInt();

            switch (operacao) {
                case 1:
                    System.out.println("\n ------------------------------------ \n");
                    System.out.println("Seu saldo é: " + saldo);
                    System.out.println("\n ------------------------------------ \n");
                    break;
                case 2:
                    while (!valorValido) {
                        System.out.println("Quantos reais gostaria de depositar?");
                        valor = leitura.nextInt();

                        if (valor <= 0) {
                            System.out.println("""
                                     \n
                                     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                                     \n
                                     Você digitou um valor inválido!
                                     \n
                                     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                                     \n
                                    """);
                        } else {
                            saldo += valor;

                            System.out.println("\n ------------------------------------ \n");
                            System.out.println("Valor depositado com sucesso.");
                            System.out.println("Seu saldo atualizado é: " + saldo);
                            System.out.println("\n ------------------------------------ \n");

                            valorValido = true;
                        }
                    }

                    valorValido = false;
                    break;
                case 3:
                    while (!valorValido) {
                        System.out.println("Quantos reais gostaria de transferir?");
                        valor = leitura.nextInt();

                        if (valor <= 0) {
                            System.out.println("""
                                     \n
                                     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                                     \n
                                     Você digitou um valor inválido!
                                     \n
                                     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                                     \n
                                    """);
                        }else if (valor > saldo) {
                            System.out.println("""
                                     \n
                                     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                                     \n
                                     Saldo insuficiente para sacar!
                                     \n
                                     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                                     \n
                                    """);

                        } else {

                            saldo -= valor;

                            System.out.println("\n ------------------------------------ \n");
                            System.out.println("Valor sacado com sucesso.");
                            System.out.println("Seu saldo atualizado é: " + saldo);
                            System.out.println("\n ------------------------------------ \n");
                            valorValido = true;
                        }
                    }

                    valorValido = false;
                    break;
                case 4:
                    System.out.println("Opção 4");
                    queroSair = true;
                    break;
                default:
                    System.out.println("""
                               \n
                                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                                Operação inválida
                                Digite um número válido!
                                
                                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                                \n
                            """);
            }


        }


    }
}
