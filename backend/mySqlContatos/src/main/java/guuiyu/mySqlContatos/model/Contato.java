package guuiyu.mySqlContatos.model;


import jakarta.persistence.*;
import lombok.*;

@Table(name = "Contato")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 100)
    private String nome;
    @Column(length = 150)
    private String email;
    @Column(length = 30)
    private String telefone;
}
