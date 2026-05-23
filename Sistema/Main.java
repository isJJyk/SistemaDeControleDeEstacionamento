package Sistema;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Estacionamento estacionamento = new Estacionamento();
        System.out.print("Digite sua placa: ");
        String placa = sc.nextLine().toUpperCase();
        System.out.print("Carro ou moto?  ");
        String tipo = sc.nextLine().toUpperCase();
        System.out.println("Que Horas são agora? ");
        int horas = sc.nextInt();
        System.out.println("Qual o horário da saída? ");
        int horas2 = sc.nextInt();
        Veiculo veiculo = new Veiculo(placa, tipo);
        Calculadora calculadora = new Calculadora(horas, horas2);


        estacionamento.registrarEntrada(placa, tipo);

        estacionamento.exibirStatus();

        estacionamento.calcularTempo(horas, horas2);
        System.out.println("Qual a forma de pagamento? ");
        estacionamento.resposta = sc.nextLine();
        sc.nextLine();
        estacionamento.formaPagamento();
        estacionamento.registrarSaida(placa, tipo);


        estacionamento.exibirStatus();

    }
}
