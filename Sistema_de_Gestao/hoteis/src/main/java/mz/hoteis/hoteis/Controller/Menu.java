package mz.hoteis.hoteis.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.time.LocalDate;
import java.io.FileWriter;
import java.io.BufferedWriter;
import mz.hoteis.hoteis.Model.*;
import mz.hoteis.hoteis.Service.ClienteHospede;


public class Menu {

    private BufferedReader reader;
    Hotel meuHotel = new Hotel();

    public Menu() {
        this.meuHotel = new Hotel();
        this.reader = new BufferedReader(new InputStreamReader(System.in));

        carregarDadosIniciais();
    }
    private void carregarDadosIniciais() {
        meuHotel.adicionarQuarto(new Quarto(101, "Simples", 5000.0,EstadoQuarto.DISPONIVEL));
        meuHotel.adicionarQuarto(new Quarto(102, "Duplo", 8500.0,EstadoQuarto.DISPONIVEL));
        meuHotel.adicionarQuarto(new Quarto(201, "Suite Premium", 15000.0,EstadoQuarto.DISPONIVEL));
        meuHotel.adicionarQuarto(new Quarto(205, "Suite Premium", 15000.0, EstadoQuarto.DISPONIVEL));
    }
    public void comecar() {
        int perfil = -1;
        System.out.println("||| Bem-vindo ao Sistema de Gestao do Hotel |||");

        do {
            System.out.println("|| SELECIONE O SEU PERFIL |||");
            System.out.println("1. Sou Cliente");
            System.out.println("2. Sou Funcionario");
            System.out.println("3. Gerir Funcionarios");
            System.out.println("0. Sair do Sistema");

            try {
                perfil = Integer.parseInt(reader.readLine());

                switch (perfil) {
                    case 1:
                        menuCliente();
                        break;
                    case 2:
                        menuFuncionario();
                        break;
                    case 3 :
                        menuGerirFuncionario();
                    case 0:
                        System.out.println("Encerrando o sistema...");
                        break;
                    default:
                        System.out.println(" Opcao invalida ");
                        break;
                }
            } catch (Exception e) {
                System.out.println(" Entrada invalida");
                perfil = -1;
            }
        } while (perfil != 0);
    }
    private void menuCliente() {
        int opcao = -1;
        do {
            System.out.println("|| MENU CLIENTE ||");
            System.out.println("1. Listar Quartos Disponiveis");
            System.out.println("2. Fazer Nova Reserva");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");

            try {
                opcao = Integer.parseInt(reader.readLine());
                switch (opcao) {
                    case 1:
                        for (Quarto q : meuHotel.getQuartos()) {
                            System.out.println("Quarto " + q.getNumeroQuarto() + " | " + q.getTipoQuarto()+" | "+q.getEstadoQuarto());
                        }
                        break;
                    case 2:
                        System.out.println("|| Efetuar Nova Reserva ||");

                        try {
                            System.out.print("Digite o id do Cliente: ");
                            int id = Integer.parseInt(reader.readLine());
                            System.out.print("Digite o nome do Cliente: ");
                            String nome = reader.readLine();
                            System.out.print("Digite o contacto do Cliente: ");
                            String contacto = (reader.readLine());
                            System.out.print("Digite o endereco do Cliente: ");
                            String endereco=reader.readLine();
                            System.out.print("Digite o sexo do Cliente: ");
                            String sexo = reader.readLine();
                            System.out.print("Digite o Bi do Cliente: ");
                            String Bi =reader.readLine();
                            System.out.print("Digite a nacionalidade do Cliente: ");
                            String nacionalidade = reader.readLine();


                            int idAutomatico = meuHotel.getReservas().size() + 1;

                            Cliente cliente = new Cliente(id,nome,contacto,endereco,sexo,Bi,nacionalidade);
                            System.out.print("Digite o numero do quarto desejado: ");
                            int numeroQuarto = Integer.parseInt(reader.readLine());


                            Quarto quartoSelecionado = null;
                            for (Quarto q : meuHotel.getQuartos()) {
                                if (q.getNumeroQuarto() == numeroQuarto) {
                                    quartoSelecionado = q;
                                    break;
                                }
                            }
                            if (quartoSelecionado == null) {
                                System.out.println("Quarto nao encontrado no sistema");
                                break;
                            }
                            if (quartoSelecionado.getEstadoQuarto() != EstadoQuarto.DISPONIVEL) {
                                System.out.println("Este quarto ja esta ocupado ou reservado ");
                                break;
                            }

                            System.out.print("Data de Entrada (Ex: 2022-07-12): ");
                            String entradaStr = reader.readLine();
                            LocalDate dataEntrada = LocalDate.parse(entradaStr);

                            System.out.print("Data de Saida (Ex: 2022-07-12): ");
                            String saidaStr = reader.readLine();
                            LocalDate dataSaida = LocalDate.parse(saidaStr);

                            Reserva novaReserva = new Reserva( cliente, quartoSelecionado, dataEntrada, dataSaida);
                            meuHotel.cadastrarReserva(novaReserva);

                            System.out.println(" Reserva numero " + idAutomatico + " criada com sucesso para " + nome);
                            System.out.println("Quarto " + numeroQuarto + " bloqueado de " + dataEntrada + " ate " + dataSaida + ".");

                        } catch (java.time.format.DateTimeParseException e) {
                            System.out.println("Formato de data invalido use (Ex: 2026-06-15)");
                        } catch (NumberFormatException e) {
                            System.out.println("Digite um numero valido para o quarto");
                        }
                        break;

                    case 0:
                        System.out.println("Voltando...");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Erro no menu do cliente.");
            }
        } while (opcao != 0);
    }
    private void menuFuncionario() {
        int opcao = -1;
        do {
            System.out.println("|| MENU FUNCIONARIO ||");
            System.out.println("1. Realizar Check-in");
            System.out.println("2. Adicionar Consumo");
            System.out.println("3. Realizar Check-out");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");

            try {
                opcao = Integer.parseInt(reader.readLine());
                switch (opcao) {
                    case 1:
                        System.out.println("|| Realizar Check-in (Entrada de Hospede) ||");

                        try {
                            System.out.print("Digite o ID da Reserva: ");
                            int idProcurado = Integer.parseInt(reader.readLine());

                            Reserva reservaEncontrada = null;
                            for (Reserva r : meuHotel.getReservas()) {
                               /* if (r.getIdReserva() == idProcurado) {
                                    reservaEncontrada = r;
                                    break;
                                }*/
                            }
                            if (reservaEncontrada == null) {
                                System.out.println("Nenhuma reserva encontrada com o ID " + idProcurado);
                                break;
                            }
                            meuHotel.realizarCheckIn(reservaEncontrada);

                        } catch (NumberFormatException e) {
                            System.out.println("Digite um numero de ID valido");
                        } catch (IOException e) {
                            System.out.println("ao ler os dados do teclado");
                        }
                        break;

                    case 2:
                        System.out.println("|| Adicionar Consumo a Hospede ||");

                        try {

                            System.out.print("Digite o numero do quarto do hospede: ");
                            int numQuarto = Integer.parseInt(reader.readLine());

                            ClienteHospede hospedagemAtual = null;
                            for (ClienteHospede ch : meuHotel.getHospedagensAtivas()) {

                                if (ch.getReserva().getQuarto().getNumeroQuarto() == numQuarto) {
                                    hospedagemAtual = ch;
                                    break;
                                }
                            }

                            if (hospedagemAtual == null) {
                                System.out.println("Nao ha nenhum hospede registado neste quarto no momento ");
                                break;
                            }

                            System.out.println(" Adicionar consumo ");
                            System.out.println("1 - Restaurante");
                            System.out.println("2 - Lavandaria");
                            System.out.println("3 - Transporte");
                            System.out.println("0 - Cancelar");
                            System.out.print("Escolha: ");
                            int tipoServico = Integer.parseInt(reader.readLine());

                            if (tipoServico == 0) {
                                System.out.println("Operacao cancelada ");
                                break;
                            }

                            System.out.print("Digite o preco base do servico : ");
                            double precoBase = Double.parseDouble(reader.readLine());

                            Servico novoServico = null;

                            switch (tipoServico) {
                                case 1:
                                    System.out.print("Tipo de refeicao : ");
                                    String tipoRefeicao = reader.readLine();
                                    novoServico = new Restaurante(tipoRefeicao,precoBase);
                                    break;

                                case 2:
                                    System.out.print("Quantidade de pecas de roupa: ");
                                    int quantPecas = Integer.parseInt(reader.readLine());
                                    novoServico = new Lavandaria(quantPecas,precoBase);
                                    break;

                                case 3:
                                    System.out.print("Distancia percorrida (Km): ");
                                    double distancia = Double.parseDouble(reader.readLine());
                                    novoServico = new Transporte(precoBase, distancia);
                                    break;

                                default:
                                    System.out.println("Tipo de servico invalido.");
                                    break;
                            }
                            if (novoServico != null) {
                                hospedagemAtual.adicionarServico(novoServico);
                                System.out.println(" Consumo registado com sucesso na conta do quarto " + numQuarto);
                            }

                        } catch (NumberFormatException e) {
                            System.out.println("Digite apenas numeros nas opcoes, quartos e precos ");
                        } catch (IOException e) {
                            System.out.println("Erro de leitura ");
                        }
                        break;
                    case 3:
                        System.out.println("\n|| Realizar Check-out (Fatura) ||");

                        try {
                            System.out.print("Digite o numero do quarto para check-out: ");
                            int numQuarto = Integer.parseInt(reader.readLine());

                            ClienteHospede hospedagemFinalizar = null;
                            for (ClienteHospede ch : meuHotel.getHospedagensAtivas()) {
                                if (ch.getReserva().getQuarto().getNumeroQuarto() == numQuarto) {
                                    hospedagemFinalizar = ch;
                                    break;
                                }
                            }

                            if (hospedagemFinalizar == null) {
                                System.out.println(" Não há nenhum hospede registado no quarto " + numQuarto);
                                break;
                            }
                            System.out.print("Digite a data de Entrada ");
                            String Dataentrada = reader.readLine();
                            System.out.print("Digite a data de Saida :");
                            String dataSaidaStr = reader.readLine();

                            LocalDate dataCustomizada = LocalDate.parse(dataSaidaStr);
                            LocalDate dataCustomizada2 = LocalDate.parse(Dataentrada);


                            if (dataCustomizada.isBefore(hospedagemFinalizar.getReserva().getCheckIn())) {
                                System.out.println("  A data de saída nao pode ser anterior a data de check-in ");
                                break;
                            }

                            long diasHospedado = hospedagemFinalizar.calcularDiferencaDias(dataCustomizada,dataCustomizada2);
                            double totalConsumos = hospedagemFinalizar.calcularTotalConsumos();
                            double totalFatura = hospedagemFinalizar.calcularValorHospedagem(dataCustomizada,dataCustomizada2);
                            double valorDesconto = hospedagemFinalizar.calcularDesconto(diasHospedado, totalFatura);
                            double st = totalFatura-valorDesconto;



                            System.out.println("\n=============================================");
                            System.out.println("                FATURA FINAL                 ");
                            System.out.println("=============================================");
                            System.out.println("Quarto: " + numQuarto + " (" + hospedagemFinalizar.getReserva().getQuarto().getTipoQuarto() + ")");
                            System.out.println("Data Check-in:  " + hospedagemFinalizar.getReserva().getCheckIn());
                            System.out.println("Data Check-out: " + dataCustomizada);
                            System.out.println("---------------------------------------------");
                            System.out.println("Dias Faturados: " + diasHospedado);
                            System.out.println("Valor do Quarto/Dia:  " + hospedagemFinalizar.getReserva().getQuarto().getPrecoDiario());
                            System.out.println("Total Alojamento:     " + (diasHospedado * hospedagemFinalizar.getReserva().getQuarto().getPrecoDiario()));
                            System.out.println("Total Consumos Extra:  " + totalConsumos);
                            System.out.println("Desconto :  " +valorDesconto);
                            System.out.println("---------------------------------------------");
                            System.out.println("TOTAL A PAGAR:        " + st );
                            System.out.println("=============================================");

                            hospedagemFinalizar.getReserva().getQuarto().setEstadoQuarto(EstadoQuarto.DISPONIVEL);
                            meuHotel.getHospedagensAtivas().remove(hospedagemFinalizar);

                            System.out.println("\n Check-out concluido com sucesso! O quarto " + numQuarto + " esta novamente DISPONIVEL.");
                            Faturaficheiro(hospedagemFinalizar, totalFatura, valorDesconto, st);

                        } catch (java.time.format.DateTimeParseException e) {

                            System.out.println("Formato de data invalido! (Ex: 2026-06-15)");
                        } catch (NumberFormatException e) {
                            System.out.println("Digite um numero de quarto válido");
                        } catch (Exception e) {
                            System.out.println("Ocorreu um erro inesperado ao processar o check-out dod tipo: "+ e.getMessage());
                        }
                        break;

                    case 0:
                        System.out.println("Voltando...");
                        break;
                    default:
                        System.out.println("Digite uma opcao valida");

                }
            } catch (Exception e) {
                System.out.println("Erro no menu do funcionario.");
            }
        } while (opcao != 0);
    }
    private void menuGerirFuncionario(){
        int opcao = -1;
        do {
            System.out.println("\n|| GESTAO DE FUNCIONARIOS ||");
            System.out.println("1. Cadastrar Novo Funcionario");
            System.out.println("2. Visualizar Lista de Funcionarios");
            System.out.println("3. Remover Funcionario");
            System.out.println("0. Voltar ao Menu Principal");

            try {
                opcao = Integer.parseInt(reader.readLine());
                switch (opcao) {
                    case 1:
                        System.out.println("\n|| Cadastrar Funcionario ||");
                        System.out.print("Nome: ");
                        String nome = reader.readLine();
                        System.out.print("Sexo: ");
                        String sexo = reader.readLine();
                        System.out.print("Contacto: ");
                        String contacto = (reader.readLine());
                        System.out.print("Endereco: ");
                        String endereco = reader.readLine();
                        System.out.print("Documento de Bi: ");
                        String Bi = reader.readLine();
                        System.out.print("Nacionalidade: ");
                        String nacionalidade = reader.readLine();
                        System.out.print("Horas de Trabalho: ");
                        int  horarioTrabalho = Integer.parseInt(reader.readLine());
                        System.out.print("Nivel de Permissao: ");
                        String nivelPermissao =reader.readLine();


                        System.out.print("Cargo: ");
                        String cargo = reader.readLine();
                        System.out.print("Salario : ");
                        double salario = Double.parseDouble(reader.readLine());

                        int novoId = meuHotel.getFuncionarios().size() + 1;


                        Funcionario novoFunc = new Funcionario(novoId , nome, contacto, endereco, sexo, Bi,cargo,horarioTrabalho,nivelPermissao,salario);

                        meuHotel.adicionarFuncionario(novoFunc);
                        System.out.println(" Funcionario " + nome + " cadastrado com sucesso! ID: " + novoId);
                        break;

                    case 2:
                        System.out.println("\n|| Lista de Funcionarios Cadastrados ||");
                        if (meuHotel.getFuncionarios().isEmpty()) {
                            System.out.println("Nenhum funcionario cadastrado no sistema.");
                        } else {
                            System.out.println("---------------------------------------------------------");
                            for (Funcionario f : meuHotel.getFuncionarios()) {
                                System.out.println("ID: " + f.getidPessoa() +
                                        " | Nome: " + f.getnome() +
                                        " | Cargo: " + f.getcargo() +
                                        " | Salario: " + f.getsalario());
                            }
                            System.out.println("---------------------------------------------------------");
                        }
                        break;

                    case 3:
                        System.out.println("\n|| Remover Funcionario ||");
                        System.out.print("Digite o ID do funcionario a remover: ");
                        int idRemover = Integer.parseInt(reader.readLine());

                        boolean removido = meuHotel.removerFuncionario(idRemover);
                        if (removido) {
                            System.out.println(" Funcionario com ID " + idRemover + " foi removido com sucesso ");
                        } else {
                            System.out.println(" Nao foi encontrado nenhum funcionario com o ID " + idRemover);
                        }
                        break;

                    case 0:
                        break;
                    default:
                        System.out.println("Opcao invalida.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println(" Insira um valor numerico valido");
            } catch (IOException e) {
                System.out.println(" Erro de leitura de dados");
            }
        } while (opcao != 0);
    }
    private void Faturaficheiro(ClienteHospede hospedagem, double subtotal, double desconto, double totalFinal) {

        int numQuarto = hospedagem.getReserva().getQuarto().getNumeroQuarto();
        String nomeFicheiro =  "C:\\Users\\user\\Desktop\\STDT\\Fatura.txt";

        try (BufferedWriter gravador = new BufferedWriter(new FileWriter(nomeFicheiro))) {

            gravador.write("=============================================");
            gravador.newLine();
            gravador.write("                  FATURA                     ");
            gravador.newLine();
            gravador.write("=============================================");
            gravador.newLine();

            //gravador.write("Cliente: " + hospedagem.getReserva().getCliente().getnome());
            gravador.newLine();
            gravador.write("Quarto:  " + numQuarto);
            gravador.newLine();

            gravador.write("---------------------------------------------");
            gravador.newLine();

            gravador.write("Subtotal:  " + subtotal);
            gravador.newLine();
            gravador.write("Desconto:  " + desconto);
            gravador.newLine();

            gravador.write("---------------------------------------------");
            gravador.newLine();

            gravador.write("TOTAL A PAGAR:  " + totalFinal);
            gravador.newLine();
            gravador.write("=============================================");
            gravador.newLine();

            System.out.println("Fatura guardada no ficheiro: " + nomeFicheiro);

        } catch (IOException e) {
            System.out.println(" Houve um erro do tipo: " + e.getMessage());
        }
    }
}
