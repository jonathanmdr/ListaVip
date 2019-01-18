package br.com.alura.listavip.dto;

import br.com.alura.listavip.model.Convidado;
import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConvidadoDTO {

    private Long id;

    @Column(nullable = false, length = 255)
    @NotBlank(message = "Nome é obrigatório!")
    private String nome;

    @Column(nullable = false, length = 255)
    @NotBlank(message = "E-mail é obrigatório!")
    private String email;

    @Column(nullable = false, length = 11)
    @NotBlank(message = "Telefone é obrigatório!")
    private String telefone;

    public ConvidadoDTO() {
    }

    public ConvidadoDTO(Convidado convidado) {
        this.id = convidado.getId();
        this.nome = convidado.getNome();
        this.email = convidado.getEmail();
        this.telefone = convidado.getTelefone();
    }
}
