package br.com.cafecomdeploy.aplicacao.repository;

import br.com.cafecomdeploy.aplicacao.exceptions.ObjectNotFoundException;
import br.com.cafecomdeploy.aplicacao.model.Cliente;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.web.client.HttpClientErrorException;
import util.ObjetoUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DisplayName("Testes do repositório de Clientes")
public class ClienteRepositoryTest {
    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    @DisplayName("Salvar Cliente com sucesso")
    void salvar_Cliente_Sucesso(){
        Cliente clienteparaSalvar = ObjetoUtil.salvarCliente();
        Cliente clienteSalvo  = clienteRepository.save(clienteparaSalvar);

        Assertions.assertThat(clienteSalvo).isNotNull();
        Assertions.assertThat(clienteSalvo.getId()).isNotNull();
        Assertions.assertThat(clienteSalvo.getNome()).isEqualTo(clienteparaSalvar.getNome());
    }

    @Test
    @DisplayName("Buscar lista de Clientes com sucesso")
    void buscar_ListadeClientes_Sucesso(){
        Cliente clienteparaSalvarUm = ObjetoUtil.salvarCliente();
        Cliente clienteparaSalvarDois = ObjetoUtil.salvarCliente();
        Cliente clienteSalvoUm  = clienteRepository.save(clienteparaSalvarUm);
        Cliente clienteSalvoDois  = clienteRepository.save(clienteparaSalvarDois);

        List<Cliente> clienteList = clienteRepository.findAll();

        Assertions.assertThat(clienteList)
                .isNotEmpty()
                .contains(clienteSalvoUm)
                .contains(clienteSalvoDois)
                .size().isEqualTo(2);
    }

    @Test
    @DisplayName("Buscar Cliente pelo email com sucesso")
    void buscar_ClientePeloEmail_Sucesso(){
        Cliente clienteparaSalvar = ObjetoUtil.salvarCliente();
        Cliente clienteSalvo  = clienteRepository.save(clienteparaSalvar);

        String email = "lorena@email.com";
        Cliente cliente_encontradoPeloEmail = clienteRepository.findByEmail(email);

        Assertions.assertThat(cliente_encontradoPeloEmail).isNotNull();
        Assertions.assertThat(cliente_encontradoPeloEmail.getEmail()).isEqualTo(clienteparaSalvar.getEmail());
    }

    @Test
    @DisplayName("Buscar Cliente pelo email com falha")
    void buscar_ClientePeloEmail_Falha(){
        Cliente clienteparaSalvar = ObjetoUtil.salvarCliente();
        Cliente clienteSalvo =  clienteRepository.save(clienteparaSalvar);

        String email = "lorena@erro.com";

        Cliente encontrado = clienteRepository.findByEmail(email);

        Assertions.assertThat(encontrado).isNull();

    }


}