package Sistema.entidades.classes;

public class Veiculo {
    private String placa;
    private String tipo;

    public Veiculo(String placa, String tipo) {
        this.placa = placa;
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }


    public String toString() {
        return "Tipo de veículo: " + tipo + " Placa: " + placa;
    }
}
