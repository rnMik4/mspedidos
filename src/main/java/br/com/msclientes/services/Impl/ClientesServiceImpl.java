package br.com.msclientes.msclientes.services.Impl;

import br.com.msclientes.msclientes.model.Clientes;
import br.com.msclientes.msclientes.repository.ClienteRepository;
import br.com.msclientes.msclientes.services.ClientesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientesServiceImpl implements ClientesService {

    @Autowired
    ClienteRepository repository;

    @Override
    public Clientes addCliente(Clientes cliente) {
        return repository.save(cliente);
    }

    @Override
    public Clientes findCliente(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Clientes updateCliente(Clientes cliente, Long id) {
        Clientes clienteExistente = findCliente(id);
        if (clienteExistente != null) {
            BeanUtils.copyProperties(cliente, clienteExistente, "id");
            return repository.save(clienteExistente);
        }else{
            throw new RuntimeException("Cliente não existente");
        }
    }

    @Override
    public void deleteCliente(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Clientes> findAllClientes() {
        return repository.findAll();
    }
}
