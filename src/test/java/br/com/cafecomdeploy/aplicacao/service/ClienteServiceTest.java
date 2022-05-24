package br.com.cafecomdeploy.aplicacao.service;

import br.com.cafecomdeploy.aplicacao.model.Cliente;
import br.com.cafecomdeploy.aplicacao.repository.ClienteRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import util.ObjetoUtil;

import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepository;


    @BeforeEach
    void setUp() {
        BDDMockito.when(clienteRepository.save(ObjetoUtil.salvarCliente()))
                .thenReturn(ObjetoUtil.salvarCliente());

        BDDMockito.when(clienteRepository.findAll())
                .thenReturn(List.of(ObjetoUtil.clienteValido()));

        BDDMockito.when(clienteRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(ObjetoUtil.cliente()));

        BDDMockito.when(clienteRepository.findByEmail(ArgumentMatchers.anyString()))
                .thenReturn(ObjetoUtil.cliente());
    }

    @Test
    @DisplayName("save returns anime when successful")
    void salvar(){

        Cliente objetoCliente = ObjetoUtil.salvarCliente();
        Cliente cliente = clienteService.salvar(objetoCliente);

        System.out.println("OLHAAAAAAAAAA   -> -> " + cliente);
        Assertions.assertThat(cliente).isNotNull()
                .isEqualTo(ObjetoUtil.clienteValido());

    }

    @Test
    @DisplayName("Retorna lista de clientes")
    void lista_de_clientes_sucesso(){
        String expectedName = ObjetoUtil.salvarCliente().getNome();

        List<Cliente> clienteList = clienteService.buscarClientes();

        Assertions.assertThat(clienteList)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(clienteList.get(0).getNome()).isEqualTo(expectedName);
    }

    @Test
    @DisplayName("Retorna cliente referente ao id buscado")
    void clientePorId_Sucesso(){
        Long expectedId = ObjetoUtil.cliente().getId();

        Cliente cliente = clienteService.buscarClientePorId(1L);

        Assertions.assertThat(cliente).isNotNull();

        Assertions.assertThat(cliente.getId()).isNotNull().isEqualTo(expectedId);
    }

    @Test
    @DisplayName("Retorna o cliente referente ao email")
    void clientePorEmail_Sucesso(){
        String expectedEmail = ObjetoUtil.cliente().getEmail();

        String email = "lorena@email.com";
        Cliente cliente = clienteService.buscarClientePorEmail(email);

        Assertions.assertThat(cliente)
                .isNotNull();

        Assertions.assertThat(cliente.getEmail()).isEqualTo(expectedEmail);
    }

}