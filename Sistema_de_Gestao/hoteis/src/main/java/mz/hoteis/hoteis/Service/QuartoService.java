package mz.hoteis.hoteis.Service;


import mz.hoteis.hoteis.Repository.QuartoRepository;
import org.springframework.stereotype.Service;
import mz.hoteis.hoteis.Model.Quarto;
import java.util.List;

@Service
public class QuartoService {
    private final QuartoRepository quartoRepository;

    public QuartoService(QuartoRepository quartoRepository){
        this.quartoRepository = quartoRepository;
    }

    public Quarto guardar(Quarto quarto){
        return quartoRepository.save(quarto);
    }

    public List<Quarto> listarTodos(){
        return quartoRepository.findAll();
    }

    public void eliminar(Integer numeroQuarto){
        quartoRepository.deleteById(numeroQuarto);
    }
}
