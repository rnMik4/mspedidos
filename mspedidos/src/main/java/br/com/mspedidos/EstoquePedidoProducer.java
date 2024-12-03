package br.com.mspedidos;

import br.com.mspedidos.model.ProdutosBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "estoque", url = "http://localhost:8180")
public interface EstoquePedidoProducer {

    @PostMapping(value = "/api/consumer-remova-estoque")
    void removerEstoque(RemoverEstoqueRequest removerEstoqueRequest);

    @GetMapping(value = "/produtos/{id}")
    ProdutosBean getProdutos(@RequestParam("id") Long id);

}
