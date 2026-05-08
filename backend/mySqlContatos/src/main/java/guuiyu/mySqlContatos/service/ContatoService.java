package guuiyu.mySqlContatos.service;


import guuiyu.mySqlContatos.model.Contato;
import guuiyu.mySqlContatos.model.ContatoRepository;
import guuiyu.mySqlContatos.model.ContatoRequestDTO;
import guuiyu.mySqlContatos.model.ContatoResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {
    private final ContatoRepository repository;
    ContatoService(ContatoRepository repository){
        this.repository = repository;
    }
    public List<ContatoResponseDTO> findAll(){
        return repository.findAll().stream().map(ContatoResponseDTO::new).toList();
    }

    public ContatoResponseDTO create(ContatoRequestDTO newContato) {
        Contato contato = new Contato();
        contato.setNome(newContato.nome());
        contato.setEmail(newContato.email());
        contato.setTelefone(newContato.telefone());
        Contato contatoSalvo = repository.save(contato);
        return new ContatoResponseDTO(contatoSalvo.getNome(), contatoSalvo.getEmail(), contatoSalvo.getTelefone());
    }

}
