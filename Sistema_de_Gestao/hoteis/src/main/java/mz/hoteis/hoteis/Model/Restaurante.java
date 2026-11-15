package mz.hoteis.hoteis.Model;

public class Restaurante extends Servico {
    private String TipoRefeicao;

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
