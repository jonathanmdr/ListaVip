package br.com.alura.listavip.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConvidadoDTO {

    private Long id;
    private String nome;
    private String email;
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
