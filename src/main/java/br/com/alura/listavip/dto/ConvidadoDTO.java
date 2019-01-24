package br.com.alura.listavip.dto;

import br.com.alura.listavip.model.Convidado;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConvidadoDTO {

    private Long id;

    @Size(min = 10, max = 255)
    @NotBlank(message = "Nome é obrigatório!")
    private String nome;

    @Email
    @Size(min = 10, max = 255)
    @NotBlank(message = "E-mail é obrigatório!")
    private String email;

    @Size(min = 10, max = 11)
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
