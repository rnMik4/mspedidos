package br.com.mspedidos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class ProdutosBean {
    private Long id;
    private String nome;
    private String descricao;
    private float preco;
    private String tamanho;
    private String cor;
}
