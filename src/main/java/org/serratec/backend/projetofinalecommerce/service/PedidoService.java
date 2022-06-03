package org.serratec.backend.projetofinalecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.projetofinalecommerce.dto.PedidoDTO;
import org.serratec.backend.projetofinalecommerce.entity.Pedido;
import org.serratec.backend.projetofinalecommerce.exceptions.EmailException;
import org.serratec.backend.projetofinalecommerce.exceptions.PedidoException;
import org.serratec.backend.projetofinalecommerce.repository.ClienteRepository;
import org.serratec.backend.projetofinalecommerce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	EmailService emailService;

	@Autowired
	ClienteRepository clienteRepository;

	public PedidoDTO transformarEntityEmDTO(Pedido pedido, PedidoDTO pedidoDTO) {
		pedidoDTO.setIdPedido(pedido.getIdPedido());
		pedidoDTO.setDataPedido(pedido.getDataPedido());
		pedidoDTO.setValorTotalPedido(pedido.getValorTotalPedido());

		return pedidoDTO;
	}

	public Pedido transformarDtoEmEntity(Pedido pedido, PedidoDTO pedidoDTO) {
		pedido.setIdPedido(pedidoDTO.getIdPedido());
		pedido.setDataPedido(pedidoDTO.getDataPedido());
		pedido.setValorTotalPedido(pedidoDTO.getValorTotalPedido());

		if (pedidoDTO.getIdCliente() != null) {
			pedido.setCliente(clienteRepository.findById(pedidoDTO.getIdCliente()).get());
		}
		return pedido;
	}

	public String salvar(PedidoDTO pedidoDTO) throws EmailException {
		Pedido pedido = new Pedido();
		transformarDtoEmEntity(pedido, pedidoDTO);
		try {
			pedidoRepository.save(pedido);
			emailService.emailPedido(pedido);
		} catch (Exception e) {
			System.out.println("Ocorreu um erro: " + e);
		}
		return "Foi criado o pedido com id: " + pedido.getIdPedido();
	}

	public void salvarListaPedido(List<PedidoDTO> listaPedidoDTO) {

		for (PedidoDTO pedidoDTO : listaPedidoDTO) {
			Pedido pedido = new Pedido();
			transformarDtoEmEntity(pedido, pedidoDTO);
			pedidoRepository.save(pedido);
		}
	}

	public PedidoDTO buscarPorId(Integer idPedido) {
		return pedidoRepository.findById(idPedido).map(pedido -> transformarEntityEmDTO(pedido, new PedidoDTO()))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));
	}

	public List<PedidoDTO> listarTodos() {
		List<Pedido> listaClienteEntity = pedidoRepository.findAll();
		List<PedidoDTO> listaPedidoDTO = new ArrayList<>();

		for (Pedido pedido : listaClienteEntity) {
			PedidoDTO pedidoDto = new PedidoDTO();
			transformarEntityEmDTO(pedido, pedidoDto);
			listaPedidoDTO.add(pedidoDto);
		}
		return listaPedidoDTO;
	}

	public String atualizar(Integer idPedido, PedidoDTO pedidoDTO) throws PedidoException {
		Optional<Pedido> pedido = pedidoRepository.findById(idPedido);
		Pedido pedidoBanco = new Pedido();
		if (pedido.isPresent()) {
			pedidoBanco = pedido.get();
			if (pedidoDTO.getDataPedido() != null) {
				pedidoBanco.setDataPedido(pedidoDTO.getDataPedido());
			}
			if (pedidoDTO.getValorTotalPedido() != null) {
				pedidoBanco.setValorTotalPedido(pedidoDTO.getValorTotalPedido());

			}

			pedidoRepository.save(pedidoBanco);
			return "O cartao com id " + pedidoBanco.getIdPedido() + " foi atualizado";
		}
		throw new PedidoException("Não foi possível atualizar o pedido");
	}

	public String deletarPorId(Integer idPedido) throws PedidoException {
		Optional<Pedido> pedido = pedidoRepository.findById(idPedido);
		if (pedido.isPresent()) {
		pedidoRepository.deleteById(idPedido);
		return "O pedido id: " + pedido.get() + " foi deletado com sucesso!";
		}
		throw new PedidoException("O id informado não foi encontrado!");
	}

}
