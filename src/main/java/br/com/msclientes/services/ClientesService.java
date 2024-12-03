package br.com.msclientes.msclientes.services;

import br.com.msclientes.msclientes.model.Clientes;

import java.util.List;

public interface ClientesService {

    Clientes addCliente(Clientes cliente);
    Clientes findCliente(Long id);
    Clientes updateCliente(Clientes cliente, Long id);
    void deleteCliente(Long id);
    List<Clientes> findAllClientes();
}
