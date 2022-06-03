package org.serratec.backend.projetofinalecommerce.controller;

import org.serratec.backend.projetofinalecommerce.dto.EnderecoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ViaCepController {
        @GetMapping(value = "/getCep/{cep}")
        public ResponseEntity<EnderecoDTO> dtoObterCep(@PathVariable(name = "cep") String cep) {

            RestTemplate restTemplate = new RestTemplate();

            String uri = "http://viacep.com.br/ws/{cep}/json/";

            Map<String, String> params = new HashMap<String, String>();
            params.put("cep", cep);

            EnderecoDTO enderecoTO = restTemplate.getForObject(uri, EnderecoDTO.class, params);

            return new ResponseEntity<EnderecoDTO>(enderecoTO, HttpStatus.OK);
        }

}
