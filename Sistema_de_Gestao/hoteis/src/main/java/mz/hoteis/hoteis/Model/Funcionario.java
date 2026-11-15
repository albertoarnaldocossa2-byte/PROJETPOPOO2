package mz.hoteis.hoteis.Model;

import java.util.ArrayList;

public class Funcionario extends Pessoa{

    private String cargo ;
    private int horarioTrabalho;
    private String nivelPermissao;
    private double salario;


    public Funcionario(int idPessoa, String nome, String contacto, String endereco, String sexo, String documentoIdentificacao, String cargo, int horarioTrabalho, String nivelPermissao,double salario){
        super (idPessoa, nome, contacto, endereco, sexo, documentoIdentificacao);
        this.horarioTrabalho = horarioTrabalho;
        this.cargo = cargo;
        this.nivelPermissao = nivelPermissao;
        this.salario = salario;

    }
    public String getcargo(){
        return cargo;
    }
    public double getsalario(){
        return salario;
    }
    public int gethorarioTrabalho(int horarioTrabalho){
        return horarioTrabalho;
    }
    public String getnivelpermissao(String nivelpermissao){
        return nivelpermissao;
    }

    public void setcargo(String cargo){
        this.cargo = cargo;
    }
    public void setsalario(double salario){
        this.salario = salario;
    }
    public void sethorarioTrabalho(int horarioTrabalho){
        this.horarioTrabalho = horarioTrabalho;
    }
    public void setnivelPermissao(String nivelPermissao){
        this.nivelPermissao = nivelPermissao;
    }



}
