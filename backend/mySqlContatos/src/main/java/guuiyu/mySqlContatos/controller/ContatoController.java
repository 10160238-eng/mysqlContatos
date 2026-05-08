package guuiyu.mySqlContatos.controller;

import guuiyu.mySqlContatos.model.ContatoResponseDTO;
import guuiyu.mySqlContatos.service.ContatoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {
    private final ContatoService service;
    ContatoController(ContatoService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ContatoResponseDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }
}
