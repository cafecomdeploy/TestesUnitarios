package br.com.cafecomdeploy.aplicacao.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionBase {

    protected String titulo;
    protected int status;
    protected String detalhes;
    protected String mensagem;
    protected LocalDate horario;
}
