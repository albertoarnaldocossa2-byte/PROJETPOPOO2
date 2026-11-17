package mz.hoteis.hoteis.Model;
import jakarta.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "Servico")
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdServico")
    protected int IdServico;

    @Column(name = "PrecoBase")
    protected double precoBase;

    public Servico(){}


    public Servico(double precoBase) {
        this.precoBase = precoBase;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }

    public abstract double calcularServico();



}
