package br.com.mspedidos;

public class RemoverEstoqueRequest {
    private Long id;
    private Integer quantidade;

    public RemoverEstoqueRequest(Long id, Integer quantidade) {
        this.id = id;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}
