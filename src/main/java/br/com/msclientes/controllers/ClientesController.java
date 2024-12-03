package br.com.msclientes.msclientes.controllers;

import br.com.msclientes.msclientes.model.Clientes;
import br.com.msclientes.msclientes.services.ClientesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClientesController {
    @Autowired
    private final ClientesService clientesService;

    @PostMapping
    public ResponseEntity<Clientes> addCliente(@RequestBody Clientes cliente) {
        return new ResponseEntity<>(clientesService.addCliente(cliente), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Clientes>> getAllClientes() {
        return ResponseEntity.ok().body(clientesService.findAllClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clientes> getClienteById(@PathVariable Long id) {
        return ResponseEntity.ok().body(clientesService.findCliente(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clientes> updateCliente(@RequestBody Clientes cliente, @PathVariable Long id) {
        return new ResponseEntity<>(clientesService.updateCliente(cliente, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable Long id) {
        clientesService.deleteCliente(id);
        return new ResponseEntity<>("Cliente deletado com sucesso", HttpStatus.OK);
    }
}
