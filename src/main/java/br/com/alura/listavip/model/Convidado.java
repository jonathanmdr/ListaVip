package br.com.alura.listavip.model;

import br.com.alura.listavip.dto.ConvidadoDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.web.context.annotation.SessionScope;

@Getter
@Setter
@Entity(name = "convidado")
@SessionScope
public class Convidado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;

    public Convidado() {
    }

    public Convidado(ConvidadoDTO dto) {
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.email = dto.getEmail();
        this.telefone = dto.getTelefone();
    }
}
