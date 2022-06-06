package org.serratec.backend.projetofinalecommerce.repository;

import java.util.List;

import org.serratec.backend.projetofinalecommerce.dto.RelatorioDTO;
import org.serratec.backend.projetofinalecommerce.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{


	@Query (value="select\r\n"
			+"p2.PRODUTO_TX_NOME  as nomeProduto,\r\n"
			+"ID_PRODUTO, sum(PEDIDO_NU_QUANTIDADE ) as quantidadePedido , sum(PEDIDO_NU_VALOR ) as valorUnitario,\r\n"
			+ "from PEDIDO p \r\n"
			+"join PRODUTO  p2 on(p2.PRODUTO_CD_ID =p.ID_PRODUTO)\r\n"
			+"group by ID_PRODUTO\r\n"
			+"order by sum(PEDIDO_NU_QUANTIDADE )\r\n"
			+"desc limit 5\r\n", nativeQuery=true)
			
	List<RelatorioDTO> relatorioProdutosMaisVendidos();
}
