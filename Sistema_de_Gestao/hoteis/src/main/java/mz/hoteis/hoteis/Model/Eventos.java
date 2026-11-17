package mz.hoteis.hoteis.Model;
import jakarta.persistence.*;

@Entity
@Table(name = "Eventos")
@PrimaryKeyJoinColumn(name = "IdServico")

public class Eventos extends Servico{

    @Column(name = "numeroDias")
      private int numeroDias;

    public Eventos(){}

    public Eventos(int numeroDias, double precoBase) {
        super(precoBase);
        this.numeroDias = numeroDias;
    }

    public int getNumeroDias() {
        return numeroDias;
    }

    public void setNumeroDias(int numeroDias) {
        this.numeroDias = numeroDias;
    }

    @Override
    public double calcularServico(){
        double total;
        total = this.numeroDias * this.precoBase;
        return total;
    }
}
