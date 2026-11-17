package mz.hoteis.hoteis.Repository;

import mz.hoteis.hoteis.Model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
}
