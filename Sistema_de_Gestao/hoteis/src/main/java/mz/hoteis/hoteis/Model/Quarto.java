package mz.hoteis.hoteis.Model;


import java.util.ArrayList;
public class Quarto {

    private int numeroQuarto;
    private String tipoQuarto;
    private double precoDiario;
    private EstadoQuarto EstadoQuarto;


    public Quarto(int numeroQuarto, String tipoQuarto, double precoDiario, EstadoQuarto EstadoQuarto) {

        this.numeroQuarto = numeroQuarto;
        this.tipoQuarto = tipoQuarto;
        this.precoDiario = precoDiario;
        this.EstadoQuarto = EstadoQuarto.DISPONIVEL;


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

