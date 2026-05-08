package guuiyu.mySqlContatos.model;

import jakarta.validation.constraints.NotBlank;

public record ContatoRequestDTO(@NotBlank String nome, @NotBlank String email, @NotBlank String telefone) {
}
