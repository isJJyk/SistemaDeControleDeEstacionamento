package Sistema.entidades.enums;

public enum Pagamento {
    Pix("pix"),
    Cartão("tarde"),
    Dinheiro("dinheiro");

    private String formasPagamento;

    Pagamento(String formasPagamento) {
        this.formasPagamento = formasPagamento;
    }

    public String getDescricao(String formasPagamento) {
        return formasPagamento;
    }
}
