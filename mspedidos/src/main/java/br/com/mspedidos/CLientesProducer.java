package br.com.mspedidos;

import br.com.mspedidos.model.ClientesBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "clientes", url = "http://localhost:8280")
public interface CLientesProducer {

    @GetMapping(value = "/clientes/{id}")
    ClientesBean getCliente(@RequestParam("id") Long id);
}
