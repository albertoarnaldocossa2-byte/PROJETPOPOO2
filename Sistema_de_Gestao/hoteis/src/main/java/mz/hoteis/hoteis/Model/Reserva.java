package mz.hoteis.hoteis.Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Reserva {
    private int idReserva;
    private LocalDate dataReserva;
    private LocalDate CheckIn;
    private LocalDate CheckOut;
    private EstadoReserva EstadoReserva;
    private Quarto quarto;
    private Cliente cliente;


    public Reserva(int idReserva, Cliente cliente, Quarto quarto, LocalDate CheckIn, LocalDate CheckOut){
        this.idReserva = idReserva;
        this.dataReserva = LocalDate.now();
        this.CheckIn = CheckIn;
        this.CheckOut = CheckOut;
        this.EstadoReserva = EstadoReserva.PENDENTE;
        this.quarto = quarto;
        this.cliente = cliente;


    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getIdReserva() {
        return idReserva;
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

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
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
        this.EstadoReserva = EstadoReserva;
    }

    public EstadoReserva getEstadoReserva() {
        return EstadoReserva;
    }

    public Quarto getQuarto() {
        return quarto;
    }

}

