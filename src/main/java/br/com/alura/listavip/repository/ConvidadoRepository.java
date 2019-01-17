package br.com.alura.listavip.repository;

import br.com.alura.listavip.model.Convidado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConvidadoRepository extends JpaRepository<Convidado, Long> {

}
