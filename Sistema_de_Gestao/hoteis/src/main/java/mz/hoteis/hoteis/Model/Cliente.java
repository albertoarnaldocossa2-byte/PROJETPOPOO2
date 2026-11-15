package mz.hoteis.hoteis.Model;

import jakarta.persistence.*;
import mz.hoteis.hoteis.Service.ClienteHospede;
import java.util.ArrayList;

@Entity
@Table(name = "Cliente")
@PrimaryKeyJoinColumn(name = "IdPessoa")

public class Cliente extends Pessoa {

    @Column(name = "Nacionalidade")
      private String nacionalidade;

    private ArrayList <Quarto> quarto;
    private ArrayList <Reserva> reserva;
    private ArrayList <ClienteHospede> ClienteHospeda;

    public Cliente(int idPessoa,String nome, String contacto, String endereco, String sexo, String documentoIdentificacao, String nacionalidade){
        super(idPessoa,nome, contacto, endereco, sexo, documentoIdentificacao);
        this.nacionalidade = nacionalidade;
        this.quarto = new ArrayList<>();
        this.reserva = new ArrayList<>();
        this.ClienteHospeda= new ArrayList<>();
    }

    public Cliente(){}


    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getnacionalidade(String nacionalidade){
        return nacionalidade;
    }
    public void setnacionalidade(String nacionalidade){
        this.nacionalidade = nacionalidade;
    }
}

