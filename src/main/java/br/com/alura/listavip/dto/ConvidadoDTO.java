package br.com.alura.listavip.dto;

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

    public ConvidadoDTO(Long id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }
}
