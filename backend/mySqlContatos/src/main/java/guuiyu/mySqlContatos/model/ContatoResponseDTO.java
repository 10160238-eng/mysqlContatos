package guuiyu.mySqlContatos.model;

public record ContatoResponseDTO(String nome, String email, String telefone) {
    public ContatoResponseDTO(Contato contato){
        this(contato.getNome(), contato.getEmail(), contato.getTelefone());
    }
}
