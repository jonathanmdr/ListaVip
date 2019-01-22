package br.com.alura.listavip.service;

import br.com.alura.listavip.dto.ConvidadoDTO;
import br.com.alura.listavip.repository.ConvidadoRepository;
import br.com.alura.listavip.model.Convidado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvidadoService {

    @Autowired
    private ConvidadoRepository repository;

    public Iterable<Convidado> findAll() {
        return repository.findAll();
    }

    public Convidado findById(Long id) {
        return repository.findById(id).get();
    }

    public void salvar(Convidado convidado) {
        if (convidado != null) {
            repository.saveAndFlush(convidado);
        }
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public Convidado dtoToConvidado(ConvidadoDTO dto) {
        return new Convidado(dto);
    }

    public ConvidadoDTO convidadoToDto(Convidado convidado) {
        return new ConvidadoDTO(convidado);
    }

    public boolean sendEmail(ConvidadoDTO dto) {
        return dto.getId() == null ? true : false;
    }

}
