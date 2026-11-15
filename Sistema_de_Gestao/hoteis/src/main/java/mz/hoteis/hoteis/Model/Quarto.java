package mz.hoteis.hoteis.Model;

import java.util.ArrayList;

import jakarta.persistence.*;

@Entity
@Table(name = "quarto")
public class Quarto {

    @Id
    @Column(name = "numeroQuarto")
       private int numeroQuarto;

    @Column(name = "tipoQuarto")
       private String tipoQuarto;

    @Column(name = "precoDiario")
       private double precoDiario;

    @Enumerated(EnumType.STRING)
    @Column(name = "EstadoQuarto")
    private EstadoQuarto EstadoQuarto;


    public Quarto(int numeroQuarto, String tipoQuarto, double precoDiario, EstadoQuarto EstadoQuarto) {

        this.numeroQuarto = numeroQuarto;
        this.tipoQuarto = tipoQuarto;
        this.precoDiario = precoDiario;
        this.EstadoQuarto = EstadoQuarto.DISPONIVEL;


    }

    public Quarto(){

    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(String tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public double getPrecoDiario() {
        return precoDiario;
    }

    public void setPrecoDiario(double precoDiario) {
        this.precoDiario = precoDiario;
    }

    public EstadoQuarto getEstadoQuarto() {
        return EstadoQuarto;
    }

    public void setEstadoQuarto(EstadoQuarto EstadoQuarto) {
        this.EstadoQuarto = EstadoQuarto;
    }
}

