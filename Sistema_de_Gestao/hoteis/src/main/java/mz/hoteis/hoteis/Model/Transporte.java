package mz.hoteis.hoteis.Model;
import jakarta.persistence.*;


@Entity
@Table(name = "Transporte")
@PrimaryKeyJoinColumn(name = "IdServico")

public class Transporte extends Servico{

    @Column(name = "distanciakm")
      private double distanciaKm;


    public Transporte(){}

    public Transporte(double distanciaKm, double precoBase) {
        super(precoBase);
        this.distanciaKm = distanciaKm;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    @Override
    public double calcularServico(){
        double total;
        total = this.precoBase* distanciaKm;
        return total;
    }

}
