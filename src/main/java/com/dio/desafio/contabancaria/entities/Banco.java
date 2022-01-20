package com.dio.desafio.contabancaria.entities;

import java.util.List;

/**
 *
 * @author Evandro
 */
public class Banco {

    private final String nome = "S.E.U";

    public void imprirContaPoupanca(List<Conta> contaPoupanca, List<Cliente> clientePoupanca) {

        clientePoupanca.stream().map(c -> {
            System.out.println(" Banco: " + nome);
            return c;
        }).map(c -> {
            System.out.println(" Nome: " + c.getNome());
            return c;
        }).forEachOrdered(c -> {
            System.out.println(" " + c.getTipoConta());
        });
        contaPoupanca.forEach(x -> x.estrato());

    }

    public void imprirContaCorrente(List<Conta> contaCorrente, List<Cliente> clienteCorrente) {

        clienteCorrente.stream().map(c -> {
            System.out.println(" Banco: " + nome);
            return c;
        }).map(c -> {
            System.out.println(" Nome: " + c.getNome());
            return c;
        }).forEachOrdered(c -> {
            System.out.println(" " + c.getTipoConta());

        });
        contaCorrente.forEach(x -> x.estrato());

    }
}
