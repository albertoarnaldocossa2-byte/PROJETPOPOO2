package mz.hoteis.hoteis.Model;
import jakarta.persistence.*;


@Entity
@Table(name = "Restaurante")
@PrimaryKeyJoinColumn(name = "IdServico")

public class Restaurante extends Servico {

    @Column(name = "TipoRefeicao")
      private String TipoRefeicao;


    public Restaurante(){}

    public Restaurante(String TipoRefeicao, double precoBase) {
        super(precoBase);
        this.TipoRefeicao = TipoRefeicao;
    }

    public String getTipoRefeicao() {
        return TipoRefeicao;
    }

    public void setTipoRefeicao(String TipoRefeicao) {
        this.TipoRefeicao = TipoRefeicao;
    }

    @Override
    public double calcularServico(){
        return this.precoBase;
    }
}
