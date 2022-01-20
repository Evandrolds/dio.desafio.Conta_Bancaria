package com.dio.desafio.contabancaria.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Evandro
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    private final String poupanca = "Conta Poupança";
    private final String corrente = "Conta Corrente";
    private String nome;
    private String tipoConta;

}
