package br.com.mspedidos.services.Impl;

import br.com.mspedidos.CLientesProducer;
import br.com.mspedidos.EstoquePedidoProducer;
import br.com.mspedidos.RemoverEstoqueRequest;
import br.com.mspedidos.model.ClientesBean;
import br.com.mspedidos.model.Pedidos;
import br.com.mspedidos.model.ProdutosBean;
import br.com.mspedidos.model.ResumoPedidoBean;
import br.com.mspedidos.repositorys.PedidoRepository;
import br.com.mspedidos.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidosServiceImpl implements PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    private EstoquePedidoProducer estoquePedido;

    @Autowired
    private CLientesProducer clientesProducer;

    @Override
    public Pedidos novoPedido(Pedidos pedido) {

        try {
            pedido.getItems().forEach(p -> {
                    this.estoquePedido.removerEstoque(
                                    new RemoverEstoqueRequest(
                                            p.getIdProduto(),
                                            p.getQuantidade()
                                    )
                            );
                    pedido.setValorTotal(pedido.getValorTotal() + (Float.valueOf(this.estoquePedido.getProdutos(p.getIdProduto()).getPreco())* p.getQuantidade()));
                }
            );

            return pedidoRepository.save(pedido);
        }catch (Exception e) {
            throw new UnsupportedOperationException("Fora de estoque");
        }
    }

    @Override
    public ResumoPedidoBean resumoPedido(Long id) {
        ResumoPedidoBean resumoPedidoBean = new ResumoPedidoBean();
        Pedidos pedido = pedidoRepository.findById(id).orElse(null);
        if(pedido != null) {
            resumoPedidoBean.setDataRegistro(pedido.getDataRegistro());
            resumoPedidoBean.setValorTotal(pedido.getValorTotal());
            ClientesBean cliente = this.clientesProducer.getCliente(pedido.getIdCliente());
            resumoPedidoBean.setCliente(cliente);
            List<ProdutosBean> lstProdutosPedido = new ArrayList<ProdutosBean>();
            pedido.getItems().forEach(p -> {
                lstProdutosPedido.add(this.estoquePedido.getProdutos(p.getIdProduto()));
            });
            resumoPedidoBean.setProdutos(lstProdutosPedido);
        }
        return resumoPedidoBean;
    }
}
