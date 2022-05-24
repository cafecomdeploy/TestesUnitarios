package br.com.cafecomdeploy.aplicacao.api;

import br.com.cafecomdeploy.aplicacao.dto.ClienteDTO;
import br.com.cafecomdeploy.aplicacao.model.Cliente;
import br.com.cafecomdeploy.aplicacao.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;


    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public ResponseEntity<Cliente> salvar(@RequestBody @Valid Cliente cliente){
        return new ResponseEntity<>(clienteService.salvar(cliente), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/buscarClientes", method = RequestMethod.GET)
    public ResponseEntity<List<Cliente>> buscarClientes(){
        return new ResponseEntity<>(clienteService.buscarClientes(), HttpStatus.OK);
    }
    @RequestMapping(value = "/buscarClientesPorEmail", method = RequestMethod.GET)
    public ResponseEntity<Cliente> buscarClientesPorEmail( @RequestParam(required = false)  String email){
        return new ResponseEntity<>(clienteService.buscarClientePorEmail(email), HttpStatus.OK);
    }

    @RequestMapping(value = "/buscarCliente/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable  Long id){
        return new ResponseEntity<>(clienteService.buscarClientePorId(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/deletarCliente/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Cliente> deletarCliente(@PathVariable  Long id){
        return new ResponseEntity<>(clienteService.deletarCliente(id), HttpStatus.NO_CONTENT);
    }
    @RequestMapping(value = "/alterarStatusCliente/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Cliente> alterarStatusCliente (@PathVariable Long id){
        return new ResponseEntity<>(clienteService.alterarStatusCliente(id), HttpStatus.ACCEPTED);
    }
}
