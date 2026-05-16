package br.com.cotiinformatica.api_java_aws.controllers;

import br.com.cotiinformatica.api_java_aws.dtos.ClienteRequest;
import br.com.cotiinformatica.api_java_aws.entities.Cliente;
import br.com.cotiinformatica.api_java_aws.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClientesController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public ResponseEntity<?> post(@RequestBody ClienteRequest request) {

        Cliente cliente = new Cliente();
        cliente.setNome(request.nome());
        cliente.setEmail(request.email());

        clienteRepository.save(cliente);

        return ResponseEntity
                .status(201)
                .body(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(
            @PathVariable Integer id,
            @RequestBody ClienteRequest request) {

        Optional<Cliente> consulta = clienteRepository.findById(id);

        if (consulta.isEmpty()) {
            return ResponseEntity
                    .status(404)
                    .body("Cliente não encontrado.");
        }

        Cliente cliente = consulta.get();
        cliente.setNome(request.nome());
        cliente.setEmail(request.email());

        clienteRepository.save(cliente);

        return ResponseEntity
                .status(200)
                .body(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {

        Optional<Cliente> consulta = clienteRepository.findById(id);

        if (consulta.isEmpty()) {
            return ResponseEntity
                    .status(404)
                    .body("Cliente não encontrado.");
        }

        Cliente cliente = consulta.get();

        clienteRepository.delete(cliente);

        return ResponseEntity
                .status(200)
                .body("Cliente excluído com sucesso.");
    }

    @GetMapping
    public ResponseEntity<?> getAll() {

        return ResponseEntity
                .status(200)
                .body(clienteRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {

        Optional<Cliente> consulta = clienteRepository.findById(id);

        if (consulta.isEmpty()) {
            return ResponseEntity
                    .status(404)
                    .body("Cliente não encontrado.");
        }

        return ResponseEntity
                .status(200)
                .body(consulta.get());
    }
}