package guuiyu.mySqlContatos.controller;

import guuiyu.mySqlContatos.model.ContatoRequestDTO;
import guuiyu.mySqlContatos.model.ContatoResponseDTO;
import guuiyu.mySqlContatos.service.ContatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
)
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

    @PostMapping
    public ResponseEntity<ContatoResponseDTO> create(@RequestBody ContatoRequestDTO newContato){
        ContatoResponseDTO contato = service.create(newContato);
        System.out.println(newContato);
        return ResponseEntity.status(HttpStatus.CREATED).body(contato);
    }
}
