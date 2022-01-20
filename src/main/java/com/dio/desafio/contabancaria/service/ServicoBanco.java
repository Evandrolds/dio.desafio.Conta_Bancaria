
package com.dio.desafio.contabancaria.service;


import com.dio.desafio.contabancaria.entities.Conta;


/**
 *
 * @author Evandro
 */
public interface ServicoBanco {
    void sacar(double value);
    void depositar(double value);
    void transfencia(Conta contaDestino, double value);
    void estrato();
    
}
