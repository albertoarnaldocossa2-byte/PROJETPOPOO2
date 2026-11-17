package mz.hoteis.hoteis.Model;
import jakarta.persistence.*;


@Entity
@Table(name = "Lavandaria")
@PrimaryKeyJoinColumn(name = "IdServico")

public class Lavandaria extends Servico {

    @Column(name = "quantPecas")
      private int quantPecas ;


    public Lavandaria(){}

    public Lavandaria(int quantPecas, double precoBase) {
        super(precoBase);
        this.quantPecas = quantPecas;
        this.precoBase = precoBase;
    }

    public int getQuantPecas() {
        return quantPecas;
    }

    public void setQuantPecas(int quantPecas) {
        this.quantPecas = quantPecas;
    }

    @Override
    public double calcularServico(){
        double total;
        total = this.quantPecas * this.precoBase;
        return total;
    }

}
