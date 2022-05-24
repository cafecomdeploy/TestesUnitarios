package br.com.cafecomdeploy.aplicacao.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class Erro {

    @JsonFormat(pattern ="yyyy-MM-dd")
    private LocalDate horario;
    private Integer status;
    private String error;
    private String messagem;
    private String local;

    public Erro(LocalDate horario, Integer status, String error, String messagem, String local) {
        this.horario = horario;
        this.status = status;
        this.error = error;
        this.messagem = messagem;
        this.local = local;
    }
}
