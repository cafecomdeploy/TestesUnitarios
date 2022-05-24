package br.com.cafecomdeploy.aplicacao.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CamposMensagem {

    private String campo;
    private String mensagem;
}
