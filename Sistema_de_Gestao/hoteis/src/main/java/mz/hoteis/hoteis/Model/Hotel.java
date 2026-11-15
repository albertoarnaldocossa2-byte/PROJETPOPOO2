package mz.hoteis.hoteis.Model;
import mz.hoteis.hoteis.Service.ClienteHospede;

import java.util.ArrayList;
import java.time.LocalDate;

public class Hotel {

    private ArrayList<Quarto> quartos;
    private ArrayList<Reserva> reservas;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<ClienteHospede> hospedagensAtivas;


    public Hotel() {
        this.quartos = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
        this.hospedagensAtivas = new ArrayList<>();
    }

    public void adicionarQuarto(Quarto novoQuarto) {
        this.quartos.add(novoQuarto);
    }

    public void cadastrarReserva(Reserva novaReserva) {
        this.reservas.add(novaReserva);
    }

    public void realizarCheckIn(Reserva reserva) {
        if (reserva.getEstadoReserva() == EstadoReserva.PENDENTE) {

            reserva.getQuarto().setEstadoQuarto(EstadoQuarto.OCUPADO);

            reserva.setEstadoReserva(EstadoReserva.ATIVA);

            ClienteHospede novaHospedagem = new ClienteHospede(reserva.getCheckIn(),reserva.getCheckOut(), reserva.getCliente(), reserva);

            this.hospedagensAtivas.add(novaHospedagem);

            System.out.println("Check-in realizado com sucesso para o quarto: " + reserva.getQuarto().getNumeroQuarto() + " agora esta ocupado");
        } else {

            System.out.println(" Esta reserva nao esta pendente");
        }}

    public void adicionarFuncionario(Funcionario f) {
        this.funcionarios.add(f);
    }
    public boolean removerFuncionario(int id) {

        return this.funcionarios.removeIf(f -> f.getidPessoa() == id);
    }


    public ArrayList<Quarto> getQuartos() { return quartos; }
    public ArrayList<Reserva> getReservas() { return reservas; }
    public ArrayList<Funcionario> getFuncionarios() { return funcionarios; }
    public ArrayList<ClienteHospede> getHospedagensAtivas() { return hospedagensAtivas; }

}

