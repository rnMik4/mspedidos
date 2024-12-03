package br.com.msclientes.msclientes.repository;

import br.com.msclientes.msclientes.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Clientes, Long> {

}
