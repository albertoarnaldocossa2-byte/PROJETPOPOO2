package mz.hoteis.hoteis.Model;

public class Lavandaria extends Servico {

    private int quantPecas ;

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
