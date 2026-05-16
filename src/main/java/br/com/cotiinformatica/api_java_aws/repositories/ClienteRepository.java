package br.com.cotiinformatica.api_java_aws.repositories;

import br.com.cotiinformatica.api_java_aws.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
