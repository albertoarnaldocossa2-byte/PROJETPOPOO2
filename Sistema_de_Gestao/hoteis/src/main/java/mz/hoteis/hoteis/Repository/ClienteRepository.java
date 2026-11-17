package mz.hoteis.hoteis.Repository;

import mz.hoteis.hoteis.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
}
