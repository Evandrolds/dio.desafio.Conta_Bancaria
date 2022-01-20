package com.dio.desafio.contabancaria.service;

import com.dio.desafio.contabancaria.entities.Banco;
import com.dio.desafio.contabancaria.entities.Cliente;
import com.dio.desafio.contabancaria.entities.Conta;
import com.dio.desafio.contabancaria.entities.ContaCorrente;
import com.dio.desafio.contabancaria.entities.ContaPoupanca;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Evandro
 */

public class TelaBanco {

    public static void window() {

        Banco b = new Banco();
        Cliente clienteCorrente = new Cliente();
        Cliente clientePoupanca = new Cliente();

        List<Cliente> listClienteCorrente = new ArrayList<>();
        List<Cliente> listClientePoupanca = new ArrayList<>();

        Conta cc = new ContaCorrente(clienteCorrente);
        Conta cp = new ContaPoupanca(clientePoupanca);
        List<Conta> listCantaCorrente = new ArrayList<>();
        List<Conta> listCantaPoupanca = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            String opcao = "0";
            do {

                System.out.println("\t");
                System.out.println(" ------------ Bem vindo ao [Banco Seu] ----------");
                System.out.println(" ----- [Aqui você escolhe o nome que quer dar ao seu banco] -----");
                System.out.println(" ------------ Digite [1] Abertura de conta ---------");
                System.out.println(" ------------ Digite [2] Realizar um deposito ------");
                System.out.println(" ------------ Digite [3] Realizar um saque -------");
                System.out.println(" ------------ Digite [4] Realizar uma tranferencia ------");
                System.out.println(" ------------ Digite [5] Ver estrato da conta -------");
                System.out.println(" ------------ Digite [6] Ver estrato das contas -------");
                System.out.println();
                System.out.println(" ------------ Digite [S]   PARA      [Sair] ----------\n");
                opcao = sc.nextLine();

                switch (opcao) {
                    case "1": {
                        System.out.println(" -------- Abertura de conta-------");
                        System.out.println(" -------- Digite [CC] Conta Correte ---------");
                        System.out.println(" -------- Digite [CP] Conta Poupança --------");
                        System.out.println("\n");
                        String n = sc.nextLine();

                        if (n.equalsIgnoreCase("cc")) {
                            System.out.println(" --------------- Conta corrente --------------- ");

                            System.out.println(" Nome do clinete....");
                            String nome = sc.nextLine();
                            clienteCorrente.setNome(nome);
                            clienteCorrente.setTipoConta(clienteCorrente.getCorrente());

                            listCantaCorrente.add(cc);
                            listClienteCorrente.add(clienteCorrente);
                            b.imprirContaCorrente(listCantaCorrente, listClienteCorrente);

                            break;

                        } else if (n.equalsIgnoreCase("cp")) {

                            System.out.println(" ---------------- Conta poupança ---------------");
                            System.out.println(" Nome do clinete....");
                            String nomeCliente = sc.nextLine();
                            clientePoupanca.setNome(nomeCliente);
                            clientePoupanca.setTipoConta(clientePoupanca.getPoupanca());

                            clientePoupanca.setNome(nomeCliente);
                            clientePoupanca.setTipoConta(clientePoupanca.getPoupanca());

                            listCantaPoupanca.add(cp);
                            listClientePoupanca.add(clientePoupanca);
                            b.imprirContaPoupanca(listCantaPoupanca, listClientePoupanca);

                            break;
                        } else {
                            System.out.println(" Opção inválida! digite apenas [CC] ou [CP] ");
                            break;
                        }

                    }
                    case "2": {

                        System.out.println(" ----------- Realizar um deposito ---------");
                        System.out.println(" ----------- [CC] para Conta Corrente ---------");
                        System.out.println(" ----------- [CP] para Conta Poupança ---------");
                        String n = sc.nextLine();

                        if (n.equalsIgnoreCase("cc")) {

                            System.out.println("  Deposito para Conta Corrente ");
                            System.out.println(" Nome do cliente");
                            String nomeCliente2 = sc.nextLine();

                            for (Cliente c : listClienteCorrente) {
                                if (nomeCliente2.equalsIgnoreCase(c.getNome())) {
                                    System.out.println("  Digite o valor R$...");
                                    double valor = Double.parseDouble(sc.nextLine());
                                    cc.depositar(valor);
                                    b.imprirContaPoupanca(listCantaCorrente, listClienteCorrente);
                                    break;
                                }
                                System.out.println(" Usuário não existe!");
                                break;
                            }

                            break;

                        } else if (n.equalsIgnoreCase("cp")) {

                            System.out.println("  Deposito para Conta Poupança ");

                            System.out.println(" Nome do cliente");
                            String nomeClinete1 = sc.nextLine();

                            for (Cliente c : listClientePoupanca) {
                                if (nomeClinete1.equalsIgnoreCase(c.getNome())) {
                                    System.out.println("  Digite o valor R$...");
                                    double valor = Double.parseDouble(sc.nextLine());
                                  
                                    cp.depositar(valor);
                                    b.imprirContaPoupanca(listCantaPoupanca, listClientePoupanca);
                                    break;
                                }
                                System.out.println(" Usuário não existe!");
                                break;
                            }

                            break;

                        } else {

                            System.out.println(" Opção inválida! opação [1] ou [2]");
                            break;
                        }

                    }
                    case "3": {
                        System.out.println(" ----------- Realizar um saque ----------");
                        System.out.println(" ----------- [CC] da Conta Corrente ---------");
                        System.out.println(" ----------- [CP] da Conta Poupança ---------");
                        String n = sc.nextLine();
                        if (n.equalsIgnoreCase("cc")) {

                            System.out.println(" Nome do cliente");
                            String cleintenNome = sc.nextLine();

                            for (Cliente c : listClienteCorrente) {
                                if (cleintenNome.equalsIgnoreCase(c.getNome())) {
                                    System.out.println("  Digite o valor R$...");
                                    double valor = Double.parseDouble(sc.nextLine());
                                    cc.sacar(valor);
                                    b.imprirContaCorrente(listCantaCorrente, listClienteCorrente);
                                    break;
                                }
                                System.out.println(" Usuário não existe!");
                                break;
                            }

                            break;

                        } else if (n.equalsIgnoreCase("cp")) {

                            System.out.println(" Nome do cliente");
                            String cleintenNome = sc.nextLine();

                            for (Cliente c : listClientePoupanca) {
                                if (cleintenNome.equalsIgnoreCase(c.getNome())) {
                                    System.out.println("  Digite o valor R$...");
                                    double valor = Double.parseDouble(sc.nextLine());
                                    cp.sacar(valor);
                                    b.imprirContaPoupanca(listCantaPoupanca, listClientePoupanca);
                                    break;
                                }
                                System.out.println(" Usuário não existe!");
                                break;
                            }

                            break;

                        } else {
                            System.out.println(" Opção Inválida! Tente [CC] ou [CP]");
                            break;
                        }
                    }
                    case "4": {
                        System.out.println(" -------------  Transferencia  ------------- ");
                        System.out.println(" ------ De qual conta você vai tranferir  ------ ");
                        System.out.println(" ----------- [CC] da Conta Corrente ---------");
                        System.out.println(" ----------- [CP] da Conta Poupança ---------");
                        String n = sc.nextLine();

                        if (n.equalsIgnoreCase("cc")) {

                            System.out.println(" Para qual conta ? ");
                            System.out.println(" [CC] para Conta Corrente ");
                            System.out.println(" [CP] para Conta Poupança ");
                            String nomeConta = sc.nextLine();

                            if (nomeConta.equalsIgnoreCase("cc")) {
                                System.out.println(" Nome do destinatario.... ");
                                String nome2 = sc.nextLine();
                                if (nome2.equalsIgnoreCase(clienteCorrente.getNome())) {
                                    System.out.println("  Digite o valor R$...");
                                    double valor = Double.parseDouble(sc.nextLine());
                                    cc.transfencia(cc, valor);

                                    b.imprirContaCorrente(listCantaCorrente, listClienteCorrente);
                                    break;
                                }

                                System.out.println(" Nome do destinatario não existe!.... ");
                                break;

                            } else {

                                System.out.println(" Nome do destinatário.... ");
                                String nome3 = sc.nextLine();
                                if (nome3.equalsIgnoreCase(clientePoupanca.getNome())) {
                                    System.out.println("  Digite o valor R$...");
                                    double valor = Double.parseDouble(sc.nextLine());

                                    cc.transfencia(cp, valor);
                                    b.imprirContaCorrente(listCantaCorrente, listClienteCorrente);
                                    b.imprirContaCorrente(listCantaPoupanca, listClientePoupanca);
                                    
                                    break;
                                }

                                System.out.println(" Nome do destinatario não existe!.... ");
                                break;

                            }
                        } else if (n.equalsIgnoreCase("cp")) {

                            System.out.println(" Nome do destinatário.... ");
                            String nome3 = sc.nextLine();
                            if (nome3.equalsIgnoreCase(clientePoupanca.getNome())) {
                                System.out.println(clientePoupanca.getNome());

                            }
                            System.out.println(" Para qual conta ? ");
                            System.out.println(" [CC] para Conta Corrente ");
                            System.out.println(" [CP] para Conta Poupança ");

                            String conta = sc.nextLine();

                            if (conta.equalsIgnoreCase("cc")) {

                                System.out.println(" Nome do destinatário.... ");
                                String nomeCorrente = sc.nextLine();

                                if (nomeCorrente.equalsIgnoreCase(clientePoupanca.getNome())) {
                                    System.out.println("  Digite o valor R$...");
                                    double valor = Double.parseDouble(sc.nextLine());

                                    cp.transfencia(cc, valor);
                                    b.imprirContaCorrente(listCantaCorrente, listClienteCorrente);
                                    b.imprirContaPoupanca(listCantaPoupanca, listClientePoupanca);
                                    break;
                                }
                                System.out.println(" Destinatário n]ao existe!");
                                break;

                            } else {
                                System.out.println(" Nome do destinatario.... ");
                                String nomePoupanca = sc.nextLine();
                                if (nomePoupanca.equalsIgnoreCase(clientePoupanca.getNome())) {

                                    System.out.println("  Digite o valor R$...");
                                    double valor = Double.parseDouble(sc.nextLine());
                                    cp.transfencia(cp, valor);
                                    b.imprirContaPoupanca(listCantaPoupanca, listClientePoupanca);
                                    break;
                                }
                                System.out.println(" Destinatário n]ao existe!");
                                break;
                            }

                        } else {
                            System.out.println(" Opção Inválida! [CC] para Conta corrente ou [CP] para conta Poupança....");
                            break;
                        }
                    }

                    case "5": {
                        System.out.println(" -----------    Estrato da conta    ------------");
                        System.out.println(" ----------- [CC] da Conta Corrente ---------");
                        System.out.println(" ----------- [CP] da Conta Poupança ---------");
                        String n = sc.nextLine();
                        if (n.equalsIgnoreCase("cc")) {
                            System.out.println(" Nome do cliente.... ");
                            String nome = sc.nextLine();
                            for (Cliente c : listClienteCorrente) {
                                if (nome.equalsIgnoreCase(c.getNome())) {

                                    b.imprirContaCorrente(listCantaCorrente, listClienteCorrente);
                                    break;
                                }
                                System.out.println(" Cleinte não esxiste!");
                                break;
                            }

                            break;
                        } else if (n.equalsIgnoreCase("cp")) {
                            System.out.println(" Nome do cliente.... ");
                            String nome1 = sc.nextLine();
                            for (Cliente c : listClientePoupanca) {
                                if (nome1.equalsIgnoreCase(c.getNome())) {

                                    b.imprirContaPoupanca(listCantaPoupanca, listClientePoupanca);
                                    break;
                                }
                                System.out.println(" Cleinte não esxiste!");
                                break;
                            }

                            break;

                        } else {
                            System.out.println(" Opção Inválida! [CC] para Conta corrente ou [CP] para conta Poupança  ....");
                            break;
                        }
                    }
                    case "6": {
                        System.out.println("------ Cleinte Conta Corrente ------");
                        System.out.println(" Nome do cliente.... ");
                        String nome = sc.nextLine();
                        if (nome.equalsIgnoreCase(clienteCorrente.getNome())) {
                            b.imprirContaCorrente(listCantaCorrente, listClienteCorrente);
                           
                        }
                        System.out.println("-----------------------------------\n");

                        System.out.println("------ Cliente Conta Poupnaca ------");
                        System.out.println(" Nome do cliente.... ");
                        String nomeCliente1 = sc.nextLine();
                        if (nomeCliente1.equalsIgnoreCase(clientePoupanca.getNome())) {
                            
                            b.imprirContaPoupanca(listCantaPoupanca, listClientePoupanca);
                            
                        }
                        break;
                    }
                    default:{
                        System.out.println(" Opção inválida, tente de 1 a 6 ...");
                    }
                }

            } while (!opcao.equalsIgnoreCase("s"));
        }

    }

}
