package br.com.alura.listavip;

import br.com.alura.listavip.model.Convidado;
import org.springframework.data.repository.CrudRepository;

public interface ConvidadoRepository extends CrudRepository<Convidado, Long> {

}
