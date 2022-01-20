package com.dio.desafio.contabancaria.entities;

import com.dio.desafio.contabancaria.service.ServicoBanco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *
 * @author Evandro
 */

@NoArgsConstructor
@Data
public abstract class Conta implements ServicoBanco {

    private static int AGENCIA = 1277;
    private static int DIGITO = 1;
    private static long CONTA = 44664L;

    protected Cliente cliente;
    protected Long conta;
    protected Integer digito;
    protected Integer agencia;
    protected Double saldo = 0d;
    protected String tipoConta;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.agencia = AGENCIA++;
        this.conta = CONTA++;
        this.digito = DIGITO++;
    }

    @Override
    public void sacar(double value) {
        if (value <= saldo) {
            this.saldo -= value;

        } else {
            System.out.println(" Saldo insuficiente! \n");

        }
    }

    @Override
    public void depositar(double value) {
        if (value >= 1) {
            this.saldo += value;

        } else {
            System.out.println(" Deposito inválido! ");
            System.out.println(" Você não pode realizar deposito menor que R$ 1,00 \n");
        }
    }

    @Override
    public void transfencia(Conta contaDestino, double value) {
        if (contaDestino.cliente.getNome() == null) {
            System.out.println(" Está conta não esxiste! ");

        } else if (value > saldo) {
            System.out.println(" Você não possue saldo suficiente para esse  valor para transferencia!\n ");

        } else {

            this.sacar(value);
            contaDestino.depositar(value);

        }
    }

    @Override
    public void estrato() {

        System.out.println(" Agencia: " + this.agencia);
        System.out.println(" Numero:" + this.conta);
        System.out.println(" Digito: " + this.digito);
        System.out.println(" Saldo R$: " + String.format("%.2f", this.saldo) + "\n");

    }

}
