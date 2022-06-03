package org.serratec.backend.projetofinalecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.projetofinalecommerce.dto.ProdutoDTO;
import org.serratec.backend.projetofinalecommerce.entity.Produto;
import org.serratec.backend.projetofinalecommerce.exceptions.ProdutoException;
import org.serratec.backend.projetofinalecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;
	
	
	public Produto transformarDtoEmEntity (Produto produto, ProdutoDTO produtoDTO) {
		
		produto.setNomeProduto(produtoDTO.getNomeProduto());
		produto.setQtdEstoque(produtoDTO.getQtdEstoque());
		produto.setDataFabricacao(produtoDTO.getDataFabricacao());
		produto.setValorUnitario(produtoDTO.getValorUnitario());
		produto.setDescricaoProduto(produtoDTO.getDescricaoProduto());
		
		return produto;
	}
	
	public ProdutoDTO transformarEntityEmDto(Produto produto, ProdutoDTO produtoDTO) {
		
		produtoDTO.setNomeProduto(produto.getNomeProduto());
		produtoDTO.setQtdEstoque(produto.getQtdEstoque());
		produtoDTO.setDataFabricacao(produto.getDataFabricacao());
		produtoDTO.setValorUnitario(produto.getValorUnitario());
		produtoDTO.setDescricaoProduto(produto.getDescricaoProduto());
		
		return produtoDTO;
	}
	
	public String salvarProduto(ProdutoDTO produtoDTO) {
		Produto produto = new Produto();
		transformarDtoEmEntity(produto,produtoDTO);
		produtoRepository.save(produto);
		return "O produto id: " + produto.getIdProduto() + " foi criado com sucesso!";
	}
	
	
	public void salvarListaProduto(List<ProdutoDTO> listaProdutoDTO) {

		for (ProdutoDTO produtoDTO : listaProdutoDTO) {
			Produto produto = new Produto();
			transformarDtoEmEntity(produto, produtoDTO);
			produtoRepository.save(produto);
		}
	}
	
	public ProdutoDTO buscarPorId(Integer idProduto) throws ProdutoException {
		Optional<Produto> produto = produtoRepository.findById(idProduto);
		Produto produtoNoBanco = new Produto();
		ProdutoDTO produtoDTO = new ProdutoDTO();
		if (produto.isPresent()) {
			produtoNoBanco = produto.get();
			transformarEntityEmDto(produtoNoBanco, produtoDTO);

			return produtoDTO;
		}
		throw new ProdutoException("O id informado não foi encontrado!");
	}
	
	public List<ProdutoDTO> buscarTodos() {
		List<Produto> listaProduto = produtoRepository.findAll();
		List<ProdutoDTO> listaProdutoDTO = new ArrayList<>();

		for (Produto produto : listaProduto) {
			ProdutoDTO produtoDTO = new ProdutoDTO();
			transformarEntityEmDto(produto, produtoDTO);
			listaProdutoDTO.add(produtoDTO);
		}
		return listaProdutoDTO;
	}
	
	public String deletarPorId(Integer idProduto) throws ProdutoException {
		Optional<Produto> produto = produtoRepository.findById(idProduto);
		if (produto.isPresent()) {
		produtoRepository.deleteById(idProduto);
		return "O produto id: " + produto.get() + " foi deletado com sucesso!";
		}
		throw new ProdutoException("O id informado não foi encontrado!");
	}
	
	public String atualizarProduto(Integer idProduto, ProdutoDTO produtoDTO) throws ProdutoException {
		Optional<Produto> produto = produtoRepository.findById(idProduto);
		Produto produtoNoBanco = new Produto();
		if (produto.isPresent()) {
			produtoNoBanco = produto.get();

			if (produtoDTO.getNomeProduto() != null) {
				produtoNoBanco.setNomeProduto(produtoDTO.getNomeProduto());
			}
			
			if (produtoDTO.getDescricaoProduto() != null) {
				produtoNoBanco.setDescricaoProduto(produtoDTO.getDescricaoProduto());
			}
			
			if (produtoDTO.getDataFabricacao() != null) {
				produtoNoBanco.setDataFabricacao(produtoDTO.getDataFabricacao());
			}
			
			if (produtoDTO.getQtdEstoque() != null) {
				produtoNoBanco.setQtdEstoque(produtoDTO.getQtdEstoque());
			}
			
			if (produtoDTO.getValorUnitario() != null) {
				produtoNoBanco.setValorUnitario(produtoDTO.getValorUnitario());
			}
			
			
			produtoRepository.save(produtoNoBanco);
			return "O produto com o id " + produtoNoBanco.getIdProduto() + " foi atualizado!";
		}
		throw new ProdutoException("O produto não foi atualizado.");
	}
	
}
