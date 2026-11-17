package mz.hoteis.hoteis.Repository;

import mz.hoteis.hoteis.Model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}
