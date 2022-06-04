package org.serratec.backend.projetofinalecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.serratec.backend.projetofinalecommerce.dto.PedidoDTO;
import org.serratec.backend.projetofinalecommerce.dto.ProdutoPedidoDTO;
import org.serratec.backend.projetofinalecommerce.entity.Pedido;
import org.serratec.backend.projetofinalecommerce.entity.Produto;
import org.serratec.backend.projetofinalecommerce.exceptions.EmailException;
import org.serratec.backend.projetofinalecommerce.exceptions.PedidoException;
import org.serratec.backend.projetofinalecommerce.repository.ClienteRepository;
import org.serratec.backend.projetofinalecommerce.repository.PedidoRepository;
import org.serratec.backend.projetofinalecommerce.repository.ProdutoRepository;
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

	@Autowired
	ProdutoRepository produtoRepository;

	public PedidoDTO transformarEntityEmDTO(Pedido pedido, PedidoDTO pedidoDTO) {
		pedidoDTO.setOperacao(pedido.getOperacao());
		pedidoDTO.setPedidoNotaFiscal(pedido.getPedidoNotaFiscal());
		pedidoDTO.setDataPedido(pedido.getDataPedido());
		pedido.getCliente().getNomeCliente();

		return pedidoDTO;
	}

	private Pedido transformarDtoEmEntity(PedidoDTO pedidoDTO, ProdutoPedidoDTO produtoPedido, Pedido pedido,
			Produto produto) {
		pedido.setProduto(produto);
		pedido.setQuantidadeProduto(produtoPedido.getQuantidadeProduto());
		pedido.setValorUnitarioProduto(produtoPedido.getValorUnitario());
		pedido.setOperacao(pedidoDTO.getOperacao());
		pedido.setPedidoNotaFiscal(pedidoDTO.getPedidoNotaFiscal());
		pedido.setDataPedido(pedidoDTO.getDataPedido());

		if (null != pedidoDTO.getIdCliente()) {
			pedido.setCliente(clienteRepository.findById(pedidoDTO.getIdCliente()).get());
		}
		return pedido;
	}

	public String salvar(PedidoDTO pedidoDTO) throws Exception {

		String emailCliente = "";
		String nomeCliente = "";

		for (ProdutoPedidoDTO produtoPedido : pedidoDTO.getListaProdutoPedido()) {
			Pedido pedido = new Pedido();

			Produto produto = produtoRepository.findById(produtoPedido.getIdProduto()).get();
			produtoPedido.setNomeProduto(produto.getNomeProduto());
			
			if (pedidoDTO.getOperacao().equals("venda")) {
				if(produto.getQtdEstoque() >= produtoPedido.getQuantidadeProduto()) {
					produto.setQtdEstoque(produto.getQtdEstoque() - produtoPedido.getQuantidadeProduto());
				}else {
					throw new Exception("Não foi possível efetuar este pedido. Quantidade em estoque insuficiente");
				}
			}
			if (pedidoDTO.getOperacao().equals("compra")) {
				produto.setQtdEstoque(produto.getQtdEstoque() + produtoPedido.getQuantidadeProduto());
			}
			transformarDtoEmEntity(pedidoDTO, produtoPedido, pedido, produto);
			pedidoRepository.save(pedido);

			emailCliente = pedido.getCliente().getEmailCliente();
			nomeCliente = pedido.getCliente().getNomeCliente();

			if (produto.getQtdEstoque() <= 5) {
				emailService.emailEsqtoque(pedido);
			}
		}

		if (pedidoDTO.getOperacao().equals("venda")) {
			emailService.emailPedido(pedidoDTO, emailCliente, nomeCliente);
		}

		return "O pedido foi emitido e salvo";
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

	public String deletarPorId(Integer idPedido) throws PedidoException {
		Optional<Pedido> pedido = pedidoRepository.findById(idPedido);
		if (pedido.isPresent()) {
			pedidoRepository.deleteById(idPedido);
			return "O pedido id: " + pedido.get() + " foi deletado com sucesso!";
		}
		throw new PedidoException("O id informado não foi encontrado!");
	}

}
