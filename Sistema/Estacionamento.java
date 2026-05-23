package Sistema;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    private int totalVagas = 15;
    private List<Veiculo> vagasOcupadas;
    public String resposta;


    public Estacionamento() {
        this.vagasOcupadas = new ArrayList<>();
    }

    public boolean vagaDisponivel() {
        return vagasOcupadas.size() < totalVagas;
    }

    public void registrarEntrada(String placa, String tipoVeiculo) {
        if (!vagaDisponivel()) {
            System.out.println("Estacionamento lotado.");
            return;
        }
        Veiculo novoVeiculo = new Veiculo(placa, tipoVeiculo);
        vagasOcupadas.add(novoVeiculo);
        System.out.println();
        System.out.println(tipoVeiculo + " de placa " + placa + " registrado.");
        System.out.println();
    }

    public boolean calcularTempo(int horas, int horas2) {
        int tempototal = (horas2 - horas);
        int cobranca;
        boolean pagar;
        if (tempototal <= 1) {
            cobranca = 10;
            System.out.println("Preço da estádia: " + cobranca);
            pagar = true;
        } else {
            cobranca = 10 + (5 * tempototal);
            System.out.println("Preço da estádia: " + cobranca);
            pagar = false;
        }
        Calculadora calculadora = new Calculadora(horas, horas2);
        return pagar;
    }

    public void formaPagamento() {
        if (resposta.equals(resposta)) {
            System.out.println("Pagamento aprovado");
            System.out.println();
        } else{
            System.out.println("Pagamento não Autorizado");
            System.out.println();
        }


    }

    //Ver se tem como usar Registro de saida sem do-while.
    //Aprendi, mas não compensa.
    public void registrarSaida(String placa, String tipoVeiculo) {
        Veiculo veiculoSaida = null;
        for (Veiculo veiculo : vagasOcupadas) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                veiculoSaida = veiculo;
                break;
            }
        }

        if (veiculoSaida != null) {
            vagasOcupadas.remove(veiculoSaida);
            System.out.println(tipoVeiculo + " de placa " + placa + " saiu.");
            System.out.println();
        } else {
            System.out.println("Veículo não encontrado no estacionamento.");
            System.out.println();
        }
    }


    public void exibirStatus() {
        System.out.println("Vagas ocupadas: " + vagasOcupadas.size() + "/" + totalVagas);
        System.out.println();
        for (Veiculo veiculo : vagasOcupadas) {
            System.out.println(veiculo);
            System.out.println();
        }
    }
}
