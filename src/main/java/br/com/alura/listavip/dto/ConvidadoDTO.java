package br.com.alura.listavip.dto;

import br.com.alura.listavip.model.Convidado;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConvidadoDTO {

    private Long id;

    @Max(value = 255)
    @NotNull
    @NotBlank(message = "Nome é obrigatório!")
    private String nome;

    @Email
    @Max(value = 255)
    @NotNull
    @NotBlank(message = "E-mail é obrigatório!")
    private String email;

    @Max(value = 11)
    @NotNull
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
