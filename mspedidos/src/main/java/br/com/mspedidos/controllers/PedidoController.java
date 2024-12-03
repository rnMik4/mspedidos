package br.com.mspedidos.controllers;

import br.com.mspedidos.model.Pedidos;
import br.com.mspedidos.model.ResumoPedidoBean;
import br.com.mspedidos.services.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    @Autowired
    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedidos> novoPedido(@RequestBody Pedidos pedido) {
        return new ResponseEntity<>(pedidoService.novoPedido(pedido), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResumoPedidoBean> buscarPedido(@PathVariable Long id) {
        return ResponseEntity.ok().body(pedidoService.resumoPedido(id));
    }
}
