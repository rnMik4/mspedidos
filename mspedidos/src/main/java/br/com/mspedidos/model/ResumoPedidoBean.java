package br.com.mspedidos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class ResumoPedidoBean {
    private LocalDateTime dataRegistro;
    private float valorTotal;
    private List<ProdutosBean> produtos;
    private ClientesBean cliente;
}
