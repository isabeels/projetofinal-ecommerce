package org.serratec.backend.projetofinalecommerce.service;


import org.serratec.backend.projetofinalecommerce.dto.ClienteDTO;
import org.serratec.backend.projetofinalecommerce.entity.Cliente;
import org.serratec.backend.projetofinalecommerce.exceptions.ClienteException;
import org.serratec.backend.projetofinalecommerce.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

	@Autowired
    ClienteRepository clienteRepository;

    public Cliente transformarDtoEmEntity (Cliente cliente, ClienteDTO clienteDTO){
        cliente.setCpfCliente(clienteDTO.getCpfCliente());
        cliente.setTelefoneCliente(clienteDTO.getTelefoneCliente());
        cliente.setEnderecoCliente(clienteDTO.getEnderecoCliente());
        cliente.setLoginCliente(clienteDTO.getLoginCliente());
        cliente.setEmailCliente(clienteDTO.getEmailCliente());
        cliente.setNomeCliente(clienteDTO.getNomeCliente());
        cliente.setDataNasciCliente(clienteDTO.getDataNasciCliente());
        cliente.setSenhaCliente(clienteDTO.getSenhaCliente());
        return cliente;
    }

    public ClienteDTO transformarEntityEmDto (Cliente cliente ,ClienteDTO clienteDTO){
        clienteDTO.setCpfCliente(cliente.getCpfCliente());
        clienteDTO.setEmailCliente(cliente.getEmailCliente());
        clienteDTO.setNomeCliente(cliente.getNomeCliente());
        clienteDTO.setEnderecoCliente(cliente.getEnderecoCliente());
        clienteDTO.setLoginCliente(cliente.getLoginCliente());
        clienteDTO.setDataNasciCliente(cliente.getDataNasciCliente());
        clienteDTO.setSenhaCliente(cliente.getSenhaCliente());
        clienteDTO.setTelefoneCliente(cliente.getTelefoneCliente());
        return clienteDTO;
    }

    public String salvar (ClienteDTO clienteDTO){
        Cliente cliente = new Cliente();
        transformarDtoEmEntity(cliente, clienteDTO);
        clienteRepository.save(cliente);
        return "O cliente id: " + cliente.getIdCliente() + " foi criado com sucesso";
    }

    public void salvarLista (List<ClienteDTO> listaClienteDTO){
        for(ClienteDTO clienteDTO : listaClienteDTO) {
            Cliente cliente = new Cliente();
            transformarDtoEmEntity(cliente, clienteDTO);
            clienteRepository.save(cliente);
        }
    }

    public ClienteDTO buscarPorId(Integer idCliente) throws ClienteException{
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);
        Cliente clienteNoBanco = new Cliente();
        ClienteDTO clienteDTO = new ClienteDTO();
        if(cliente.isPresent()) {
            clienteNoBanco = cliente.get();
            transformarEntityEmDto(clienteNoBanco, clienteDTO);
            return clienteDTO;
        }
        throw new ClienteException("O cliente não foi encontrado.");
    }



    public List<ClienteDTO> buscarTodos(){
        List<Cliente> listCliente = clienteRepository.findAll();
        List<ClienteDTO> listClienteDTO = new ArrayList<>();
        for(Cliente cliente : listCliente){
            ClienteDTO clienteDTO = new ClienteDTO();
            transformarEntityEmDto(cliente, clienteDTO);
            listClienteDTO.add(clienteDTO);
        }
        return listClienteDTO;
    }

    public String atualizar(Integer idCliente, ClienteDTO clienteDTO) throws ClienteException {
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);
        Cliente clienteNoBanco = new Cliente();
        if(cliente.isPresent()) {

        clienteNoBanco = cliente.get();
        if(clienteDTO.getCpfCliente() != null){
            clienteNoBanco.setCpfCliente(clienteDTO.getCpfCliente());
        }
        if(clienteDTO.getEmailCliente() != null){
            clienteNoBanco.setEmailCliente(clienteDTO.getEmailCliente());
        }
        if(clienteDTO.getNomeCliente() != null){
            clienteNoBanco.setNomeCliente(clienteDTO.getNomeCliente());
        }
        if(clienteDTO.getTelefoneCliente() != null){
            clienteNoBanco.setTelefoneCliente(clienteDTO.getTelefoneCliente());
        }
        if(clienteDTO.getDataNasciCliente() != null){
            clienteNoBanco.setTelefoneCliente(clienteDTO.getTelefoneCliente());
        }
        if(clienteDTO.getEmailCliente() != null){
            clienteNoBanco.setEmailCliente(clienteDTO.getEmailCliente());
        }
        if(clienteDTO.getLoginCliente() != null){
            clienteNoBanco.setLoginCliente(clienteDTO.getLoginCliente());
        }
        if(clienteDTO.getSenhaCliente() != null){
            clienteNoBanco.setSenhaCliente(clienteDTO.getSenhaCliente());
        }

        clienteRepository.save(clienteNoBanco);
        return "O cliente com id " + clienteNoBanco.getIdCliente() + " foi atualizado!";

        }
        throw new ClienteException("O cliente não foi atualizado.");
    }

    public String deletar(Integer idCliente) throws ClienteException {
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);
        if(cliente.isPresent()){
            clienteRepository.deleteById(idCliente);
            return "O cliente id: " + cliente.get() + " foi deletado com sucesso!";
        }
        throw new ClienteException("O cliente não foi deletado.");
    }


}
