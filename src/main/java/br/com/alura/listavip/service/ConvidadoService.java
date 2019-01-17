package br.com.alura.listavip.service;

import br.com.alura.listavip.dto.ConvidadoDTO;
import br.com.alura.listavip.repository.ConvidadoRepository;
import br.com.alura.listavip.model.Convidado;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvidadoService {

    @Autowired
    private ConvidadoRepository repository;

    public Iterable<Convidado> findAll() {
        Iterable<Convidado> convidados = repository.findAll();

        return convidados;
    }

    public Convidado findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void salvar(Convidado convidado) {
        if (convidado != null) {
            System.out.println("ID:" + convidado.getId());
            repository.saveAndFlush(convidado);
        }
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public Convidado dtoToConvidado(ConvidadoDTO dto) {
        System.out.println("dtoToConvidado:" + dto);
        return new Convidado(dto.getId(), dto.getNome(), dto.getEmail(), dto.getTelefone());
    }

    public ConvidadoDTO convidadoToDto(Convidado convidado) {
        return new ConvidadoDTO(convidado.getId(), convidado.getNome(), convidado.getEmail(), convidado.getTelefone());
    }

    public boolean sendEmail(ConvidadoDTO dto) {
        return dto.getId() == null ? true : false;
    }

}
