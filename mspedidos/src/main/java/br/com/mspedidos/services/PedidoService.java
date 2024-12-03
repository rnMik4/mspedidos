package br.com.mspedidos.services;

import br.com.mspedidos.model.Pedidos;
import br.com.mspedidos.model.ResumoPedidoBean;


public interface PedidoService {

    Pedidos novoPedido(Pedidos pedido);
    ResumoPedidoBean resumoPedido(Long id);

}
