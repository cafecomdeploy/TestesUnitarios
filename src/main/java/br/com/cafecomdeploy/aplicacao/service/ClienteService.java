package br.com.cafecomdeploy.aplicacao.service;

import br.com.cafecomdeploy.aplicacao.dto.ClienteDTO;
import br.com.cafecomdeploy.aplicacao.exceptions.ObjectNotFoundException;
import br.com.cafecomdeploy.aplicacao.model.Cliente;
import br.com.cafecomdeploy.aplicacao.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;
    private ModelMapper modelMapper;

    public ClienteService(ClienteRepository clienteRepository, ModelMapper modelMapper) {
        this.clienteRepository = clienteRepository;
        this.modelMapper = modelMapper;
    }
// Salvar Cliente

    public Cliente salvar(Cliente cliente){
     //   Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        return clienteRepository.save(cliente);
    }

    // Buscar todos os Cliente

    public List<Cliente> buscarClientes(){
        return clienteRepository.findAll();
    }

    // Buscar Cliente Id

    public Cliente buscarClientePorId(Long id){
        Cliente cliente= clienteRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Cliente "+ id + " não encontrado"));
        return cliente;
    }

    // Buscar cliente por email
    public Cliente buscarClientePorEmail(String email){
        Cliente clientes= clienteRepository.findByEmail(email);

        if(clientes == null){
            throw new ObjectNotFoundException("Cliente não encontrado");
        }
        return clientes;
    }

    // deletar cliente

    public Cliente deletarCliente(Long id){
        Cliente cliente = buscarClientePorId(id);
        clienteRepository.delete(cliente);
        return cliente;
    }

    // Alterar status cliente
    public Cliente alterarStatusCliente(Long id){
        Cliente cliente = buscarClientePorId(id);
        cliente.setStatus(false);
        clienteRepository.save(cliente);
        return cliente;
    }


}
