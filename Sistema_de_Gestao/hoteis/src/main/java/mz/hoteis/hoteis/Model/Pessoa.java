package mz.hoteis.hoteis.Model;
import jakarta.persistence.*;


@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.JOINED)

public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPessoa")
        protected int idPessoa;


    @Column(name = "contacto")
        protected String contacto;

    @Column(name = "nome")
        protected String nome;

    @Column(name = "endereco")
        protected String endereco;

    @Column(name = "Sexo")
        protected String sexo;

    @Column(name = "documentoIdentificacao")
        protected String documentoIdentificacao;


    public Pessoa(){}

        public Pessoa(int idPessoa, String nome, String contacto, String endereco, String sexo, String documentoIdentificacao){
            this.idPessoa= idPessoa;
            this.nome = nome;
            this.contacto = contacto;
            this.endereco = endereco;
            this.sexo = sexo;
            this.documentoIdentificacao = documentoIdentificacao; }

        public int getidPessoa (){
            return this.idPessoa;
        }
        public String getnome (){
            return this.nome;
        }
        public String getcontacto (){
            return this.contacto;
        }
        public String getendereco (){
            return this.endereco;
        }
        public String getsexo (){
            return this.sexo;
        }
        public String getdocumentoIdentificacao (){
            return this.documentoIdentificacao;
        }


        public void setnome (String nome){
            this.nome = nome;
        }
        public void setcontacto (String contacto){
            this.contacto = contacto;
        }
        public void setendereco (String endereco){
            this.endereco = endereco;
        }


}

