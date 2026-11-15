package mz.hoteis.hoteis.Service;


import mz.hoteis.hoteis.Model.Cliente;
import mz.hoteis.hoteis.Model.Reserva;
import mz.hoteis.hoteis.Model.Servico;

import java.time.LocalDate;
import java.util.ArrayList;
import java.time.temporal.ChronoUnit;


public class ClienteHospede implements RegrasFatura {

    private LocalDate CheckIn;
    private LocalDate CheckOut;
    private ArrayList<Servico> servico;
    private Cliente cliente;
    private Reserva reserva;

    public ClienteHospede(LocalDate checkIn, LocalDate checkOut, Cliente cliente, Reserva reserva) {
        this.CheckIn = CheckIn;
        this.CheckOut = CheckOut;
        this.cliente = cliente;
        this.servico = new ArrayList<>();
        this.reserva = reserva;
    }

    public LocalDate getCheckIn() {
        return CheckIn;
    }

    public void setCheckIn(LocalDate CheckIn) {
        this.CheckIn = CheckIn;
    }

    public LocalDate getCheckOut() {
        return CheckOut;
    }

    public void setCheckOut(LocalDate CheckOut) {
        this.CheckOut = CheckOut;
    }

    public Reserva getReserva() {
        return reserva;
    }
    public void adicionarServico(Servico serv) {
        this.servico.add(serv);
    }
    public long calcularDiferencaDias(LocalDate dataSaida,LocalDate Entrada) {
        long dias = ChronoUnit.DAYS.between(Entrada,dataSaida);
        if (dias == 0) {
            return 1;
        }
        return dias;
    }

    public double calcularTotalConsumos() {
        double total = 0.0;
        for (Servico s : this.servico) {
            total += s.calcularServico();
        }
        return total;
    }

    public double calcularValorHospedagem(LocalDate dataSaida,LocalDate dataEntrada) {
        long dias = calcularDiferencaDias(dataSaida,dataEntrada);
        double precoQuarto = this.reserva.getQuarto().getPrecoDiario();

        return (dias * precoQuarto) + calcularTotalConsumos();
    }

    @Override
    public double calcularDesconto(long diasHospedagem, double valorBase) {

        if (diasHospedagem > 7) {
            return valorBase * 0.10;
        }

        return 0.0;
    }
}
