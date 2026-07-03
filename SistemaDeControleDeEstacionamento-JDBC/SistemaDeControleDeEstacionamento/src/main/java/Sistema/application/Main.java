package Sistema.application;

import Sistema.entidades.classes.Calculadora;
import Sistema.entidades.classes.Estacionamento;
import Sistema.entidades.classes.Veiculo;
import Sistema.entidades.enums.Pagamento;
import conexao.ClassConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        try {

            Connection conexao = ClassConnection.getConnection();

            Estacionamento estacionamento = new Estacionamento();
            System.out.print("Digite sua placa: ");
            String placa = sc.nextLine().toUpperCase();
            System.out.print("Carro ou moto?  ");
            String tipo = sc.nextLine().toUpperCase();

            String veiculos = "INSERT INTO VEICULOS (PLACA, TIPO) VALUES('" + placa + "', '" + tipo + "');";

            int horas = 0;
            int horas2 = 0;
            try {
                System.out.println("Que Horas são agora? ");
                horas = sc.nextInt();
                System.out.println("Qual o horário da saída? ");
                horas2 = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }

            String estadias = "INSERT INTO ESTADIAS (hora_entrada, hora_saida) VALUES('" + horas + "', '" + horas2 + "');";

            Veiculo veiculo = new Veiculo(placa, tipo);
            Calculadora calculadora = new Calculadora(horas, horas2);

            estacionamento.registrarEntrada(placa, tipo);

            estacionamento.exibirStatus();

            estacionamento.calcularTempo(horas, horas2);
            estacionamento.pagamentos();
            sc.nextLine();
            String pagamento = sc.nextLine();
            estacionamento.formaPagamento(pagamento);
            estacionamento.registrarSaida(placa, tipo);

            estacionamento.exibirStatus();

            String pagamentos = "INSERT INTO PAGAMENTOS (forma_pagamento) VALUES('" + pagamento + "');";
            Statement stmt = conexao.createStatement();
            stmt.execute(veiculos);
            stmt.execute(estadias);
            stmt.execute(pagamentos);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
