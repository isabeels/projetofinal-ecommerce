package org.serratec.backend.projetofinalecommerce.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.projetofinalecommerce.dto.CategoriaDTO;
import org.serratec.backend.projetofinalecommerce.entity.Categoria;
import org.serratec.backend.projetofinalecommerce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;

	public Categoria transformarDtoEmEntity(CategoriaDTO categoriaDto, Categoria categoria) {
		categoria.setDescricaoCategoria(categoriaDto.getDescricaoCategoria());
		categoria.setNomeCategoria(categoriaDto.getNomeCategoria());
		return categoria;
	}

	public CategoriaDTO transformarEntityEmDto(Categoria categoria, CategoriaDTO categoriaDto) {
		categoriaDto.setDescricaoCategoria(categoria.getDescricaoCategoria());
		categoriaDto.setNomeCategoria(categoria.getNomeCategoria());
		return categoriaDto;
	}

	public Categoria salvar(CategoriaDTO categoriaDto) {
		Categoria categoria = new Categoria();
		transformarDtoEmEntity(categoriaDto, categoria);
		return categoriaRepository.save(categoria);
	}

	public void salvarListaCategoria(List<CategoriaDTO> listCategoriaDto) {
		for (CategoriaDTO categoriaDto : listCategoriaDto) {
			Categoria categoria = new Categoria();
			transformarDtoEmEntity(categoriaDto, categoria);
			categoriaRepository.save(categoria);
		}
	}

	public Optional<Categoria> buscarPorId(Integer idCategoria) {
		return categoriaRepository.findById(idCategoria);
	}

	public List<Categoria> buscarTodos() {
		return categoriaRepository.findAll();
	}

	public void atualizarCategoria(Integer idCategoria, CategoriaDTO categoriaDto) {
		Optional<Categoria> categoriaOptional = categoriaRepository.findById(idCategoria);

		if (categoriaOptional.isPresent()) {
			Categoria categoria = new Categoria();

			if (categoriaDto.getDescricaoCategoria() != null) {
				categoria.setDescricaoCategoria(categoriaDto.getDescricaoCategoria());
			}

			if (categoriaDto.getNomeCategoria() != null) {
				categoria.setNomeCategoria(categoriaDto.getNomeCategoria());
			}

			categoriaRepository.save(categoria);
		}
	}

	public void deletarPorId(Integer idCategoria) {
		categoriaRepository.deleteById(idCategoria);
	}
}
