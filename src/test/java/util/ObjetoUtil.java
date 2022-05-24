package util;

import br.com.cafecomdeploy.aplicacao.dto.ClienteDTO;
import br.com.cafecomdeploy.aplicacao.model.Cliente;

public class ObjetoUtil {

    public static Cliente salvarCliente(){
        return Cliente.builder()
                .nome("Lorena")
                .sobrenome("Fernandes")
                .email("lorena@email.com")
                .status(true)
                .build();
    }

    public static Cliente salvarClienteComErro(){
        return Cliente.builder()
                .nome("")
                .sobrenome("Fernandes")
                .email("lorena@email.com")
                .build();
    }

    public static ClienteDTO salvarClienteDTO(){
        return ClienteDTO.builder()
                .nome("Lorena")
                .sobrenome("Fernandes")
                .email("lorena@email.com")
                .build();
    }

    public static Cliente clienteValido(){
        return Cliente.builder()
                .nome("Lorena")
                .sobrenome("Fernandes")
                .email("lorena@email.com")
                .status(true)
                .build();
    }

    public static Cliente cliente(){
        return Cliente.builder()
                .id(1L)
                .nome("Lorena")
                .sobrenome("Fernandes")
                .email("lorena@email.com")
                .status(true)
                .build();
    }
}
