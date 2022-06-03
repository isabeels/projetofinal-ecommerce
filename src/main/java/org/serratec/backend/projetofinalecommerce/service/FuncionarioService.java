package org.serratec.backend.projetofinalecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.projetofinalecommerce.dto.FuncionarioDTO;
import org.serratec.backend.projetofinalecommerce.entity.Funcionario;
import org.serratec.backend.projetofinalecommerce.exceptions.FuncionarioException;
import org.serratec.backend.projetofinalecommerce.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

	@Autowired
	FuncionarioRepository funcionarioRepository;
	

	public Funcionario transformarDtoEmEntity (Funcionario funcionario, FuncionarioDTO funcionarioDTO) {
		
		funcionario.setNomeFuncionario(funcionarioDTO.getNomeFuncionario());
		funcionario.setCpfFuncionario(funcionarioDTO.getCpfFuncionario());
		
		return funcionario;
	}
	
	public FuncionarioDTO transformarEntityEmDto(Funcionario funcionario, FuncionarioDTO funcionarioDTO) {
		
		funcionarioDTO.setNomeFuncionario(funcionario.getNomeFuncionario());
		funcionarioDTO.setCpfFuncionario(funcionario.getCpfFuncionario());
		
		return funcionarioDTO;
	}
	
	public String salvarFuncionario(FuncionarioDTO funcionarioDTO) {
		Funcionario funcionario = new Funcionario();
		transformarDtoEmEntity(funcionario, funcionarioDTO);
		funcionarioRepository.save(funcionario);
		return "O funcionário id: " + funcionario.getIdFuncionario() + " foi criado com sucesso!";
	}
	
	
	public void salvarListaFuncionario(List<FuncionarioDTO> listaFuncionarioDTO) {

		for (FuncionarioDTO funcionarioDTO : listaFuncionarioDTO) {
			Funcionario funcionario = new Funcionario();
			transformarDtoEmEntity(funcionario, funcionarioDTO);
			funcionarioRepository.save(funcionario);
		}
	}
	
	public FuncionarioDTO buscarPorId(Integer idFuncionario) throws FuncionarioException {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(idFuncionario);
		Funcionario funcionarioNoBanco = new Funcionario();
		FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
		if (funcionario.isPresent()) {
			funcionarioNoBanco = funcionario.get();
			transformarEntityEmDto(funcionarioNoBanco, funcionarioDTO);

			return funcionarioDTO;
		}
		throw new FuncionarioException("O id informado não foi encontrado!");
	}
	
	public List<FuncionarioDTO> buscarTodos() {
		List<Funcionario> listaFuncionario = funcionarioRepository.findAll();
		List<FuncionarioDTO> listaFuncionarioDTO = new ArrayList<>();

		for (Funcionario funcionario : listaFuncionario) {
			FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
			transformarEntityEmDto(funcionario, funcionarioDTO);
			listaFuncionarioDTO.add(funcionarioDTO);
		}
		return listaFuncionarioDTO;
	}
	
	public String deletarPorId(Integer idFuncionario) throws FuncionarioException {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(idFuncionario);
		if (funcionario.isPresent()) {
			funcionarioRepository.deleteById(idFuncionario);
		return "O funcionário id: " + funcionario.get() + " foi deletado com sucesso!";
		}
		throw new FuncionarioException("O id informado não foi encontrado!");
	}
	
	public String atualizarFuncionario(Integer idFuncionario, FuncionarioDTO funcionarioDTO) throws FuncionarioException {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(idFuncionario);
		Funcionario funcionarioNoBanco = new Funcionario();
		if (funcionario.isPresent()) {
			funcionarioNoBanco = funcionario.get();

			if (funcionarioDTO.getNomeFuncionario() != null) {
				funcionarioNoBanco.setNomeFuncionario(funcionarioDTO.getNomeFuncionario());
			}
			
			if (funcionarioDTO.getCpfFuncionario() != null) {
				funcionarioNoBanco.setCpfFuncionario(funcionarioDTO.getCpfFuncionario());
			}
			
			funcionarioRepository.save(funcionarioNoBanco);
			return "O funcionário com o id " + funcionarioNoBanco.getIdFuncionario() + " foi atualizado!";
		}
		throw new FuncionarioException("O funcionário não foi atualizado.");
	}
}
