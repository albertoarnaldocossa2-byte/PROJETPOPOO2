package mz.hoteis.hoteis.Model;


public class Transporte extends Servico{

    private double distanciaKm;

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
