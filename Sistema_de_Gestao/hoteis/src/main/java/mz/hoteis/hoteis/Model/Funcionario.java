package mz.hoteis.hoteis.Model;
import jakarta.persistence.*;


@Entity
@Table(name = "Funcionario")
@PrimaryKeyJoinColumn(name = "IdPessoa")

public class Funcionario extends Pessoa{

    @Column(name = "cargo")
      private String cargo ;

    @Column(name = "horarioTrabalho")
      private int horarioTrabalho;

    @Column(name = "nivelPermissao")
       private String nivelPermissao;

    @Column(name = "salario")
     private double salario;


    public Funcionario(){}


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

    public int gethorarioTrabalho(){
        return horarioTrabalho;
    }

    public String getnivelpermissao(){
        return nivelPermissao;
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
