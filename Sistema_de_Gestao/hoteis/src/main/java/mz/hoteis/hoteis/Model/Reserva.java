package mz.hoteis.hoteis.Model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;


@Entity
@Table(name =  "reserva")

public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name =  "idReserva")
       private int idReserva;

    @Column(name = "dataReserva")
      private LocalDate dataReserva;

    @Column(name = "ChekIn")
      private LocalDate CheckIn;

    @Column(name = "CheckOut")
      private LocalDate CheckOut;

    @Enumerated(EnumType.STRING)
    @Column(name = "Estadoreserva")
      private EstadoReserva EstadoReserva;

    @ManyToOne
    @JoinColumn(name = "numeroQuarto", referencedColumnName = "numeroQuarto")
      private Quarto quarto;

    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "idPessoa")
      private Cliente cliente;


    public Reserva( Cliente cliente, Quarto quarto, LocalDate CheckIn, LocalDate CheckOut){
        this.dataReserva = LocalDate.now();
        this.CheckIn = CheckIn;
        this.CheckOut = CheckOut;
        this.EstadoReserva = EstadoReserva.PENDENTE;
        this.quarto = quarto;
        this.cliente = cliente;


    }

    public Reserva(){}

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public LocalDate getCheckIn() {
        return CheckIn;
    }

    public LocalDate getCheckOut() {
        return CheckOut;
    }

    public EstadoReserva getEstadoReserva() {
        return EstadoReserva;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }

    public void setCheckIn(LocalDate dataCheckIn) {
        this.CheckIn = dataCheckIn;
    }

    public void setCheckOut(LocalDate dataCheckOut) {
        this.CheckOut = dataCheckOut;
    }

    public void setEstadoReserva(EstadoReserva estadoReserva) {
        this.EstadoReserva = estadoReserva;
    }

    public void setQuarto (Quarto quarto){
        this.quarto = quarto;
    }



}

