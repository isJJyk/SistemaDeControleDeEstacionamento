package Sistema.entidades.classes;

public class Calculadora {
    private int horas;
    private int horas2;

    public Calculadora(int horas,int horas2){
        this.horas = horas;
        this.horas2 = horas2;
    }
    private int getHoras() {
        return horas;
    }

    private int getHoras2() {
        return horas2;
    }
}
