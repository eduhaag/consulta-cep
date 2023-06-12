import br.com.eh.buscaCep.models.Address;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        API api = new API();
        Scanner scanner = new Scanner(System.in);

        String cep = "";

        do {
            System.out.printf("Digite o cep que deseja buscar ou SAIR para encerrar:");
            cep = scanner.next();

            if(cep.equalsIgnoreCase("sair")){
                break;
            }

            Address address;

            if(cep.length()!=8){
                System.out.println("Cep inválido. Tente novamente");
            }else{
                address = api.getAddress(cep);

                System.out.println("************************");
                if(address.getCep()!=null){
                    System.out.println(address);
                }else {
                    System.out.println("Endereço não encontrado pelo CEP informado;");
                }
                System.out.println("************************");
            }
        }while (!cep.equalsIgnoreCase("sair"));

        System.out.println("Aplicação encerrada.");
    }
}