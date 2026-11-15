package mz.hoteis.hoteis.Model;

import java.util.ArrayList;
public abstract class Servico {
    protected double precoBase;

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
