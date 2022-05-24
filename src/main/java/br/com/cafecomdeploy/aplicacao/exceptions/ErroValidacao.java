package br.com.cafecomdeploy.aplicacao.exceptions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ErroValidacao extends Erro{

    private List<CamposMensagem> erros = new ArrayList<>();

    public ErroValidacao(LocalDate horario, Integer status, String error, String messagem, String local ) {
        super(horario, status, error, messagem, local);
    }

    public List<CamposMensagem> getErros(){
        return erros;
    }

    public void addError(String fieldName, String messagem) {
        erros.add(new CamposMensagem(fieldName, messagem));
    }
}
