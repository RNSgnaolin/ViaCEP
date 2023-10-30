package cepapi.main;

import java.util.Scanner;

import cepapi.http.Request;
import cepapi.service.validation.ValidateCep;
import cepapi.models.Endereco;

public class App {
    public static void main(String[] args) {

        Request http = new Request();
        boolean menu = true;
        ValidateCep cep = new ValidateCep();
        Scanner keyboard = new Scanner(System.in);

        System.out.println("========== PROCURAR POR CEP ==========");
        System.out.println("1 - Procurar");
        System.out.println("2 - Sair");

        while(menu) {

            System.out.printf("Opção: ");
            String opcao = keyboard.nextLine();
            if (!opcao.matches("\\d"))
                opcao = "99";
            
            switch(Integer.parseInt(opcao)) {
                
                case 1:
                System.out.printf("CEP: ");
                String input = keyboard.nextLine();

                if (!cep.validate(input)) {
                    System.out.println("CEP inválido.");
                    break;
                }

                Endereco endereco = http.search(input);

                if (endereco.getStreet() == null) {
                    System.out.println("CEP não encontrado.");
                    break;
                }

                System.out.println(endereco);

                break;

                case 2:
                System.out.println("Saindo do sistema.");
                menu = false;
                break;

                default:
                System.out.println("Opção inválida, tente novamente.");
                break;

            }  
        }
        keyboard.close();
    }
}
