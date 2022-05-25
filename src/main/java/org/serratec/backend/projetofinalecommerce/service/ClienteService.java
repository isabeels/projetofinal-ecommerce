package org.serratec.backend.projetofinalecommerce.service;


import org.serratec.backend.projetofinalecommerce.entity.Cliente;
import org.serratec.backend.projetofinalecommerce.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired
    ClienteRepository clienteRepository;

    public void salvar (Cliente cliente){
        
    }
}
